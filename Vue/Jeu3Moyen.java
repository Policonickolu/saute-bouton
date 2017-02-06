package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Controleur.ControleurSauteBouton;
import Modele.MeilleursScores;

/**
* Jeu "Bouton Filant" Moyen.
* Hérite de "Jeu".
*
* @author COULIDIATI Donald
* @author BEN YAHIA Heidy
*/
public class Jeu3Moyen extends Jeu{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nom;
	private JButton b;
	
	public Jeu3Moyen(ControleurSauteBouton controleur, MeilleursScores score) {
		
		super(controleur,score.getJeu3().getScoreMoyen().getTemps());
		
		this.nom = this.getClass().getName().substring(4);

		this.b = new JButton("Démarrer");
		this.b.setFocusable(false);
		this.b.addActionListener(new ClickListener());
		
		this.jeu.setLayout(null);
		this.jeu.add(this.b);
		this.b.setBounds(250, 275, 100, 50);
		
	}
	
	/**
	 * Ecouteur de clic de bouton.
	 * Au premier clic, le jeu est lancé.
	 * Un thread permet de faire tourner le chronomètre.
	 * Un thread permet de faire bouger le bouton.
	 * Chaque clic fait changer le bouton de position. 
	 *	
	 */
	public class ClickListener extends Thread implements ActionListener{

		private int compteur = 16;
		private int temps = 0;
		private int tempsParClic = 0;
		private int directionX = 1;
		private int directionY = 1;
		private int destinationX = 275;
		private int destinationY = 275;
		Thread defilement = new Thread(){
			// Le bouton défile sur l'écran.
			// Il se dirigie vers les coodonnées de destination
			public void run(){
				while(temps!=999 && compteur!=0){
					try {
						sleep(3);
					} catch (InterruptedException e) {}
					directionX = (int) Math.signum(destinationX-b.getX());
					directionY = (int) Math.signum(destinationY-b.getY());
					b.setBounds(b.getX()+directionX, b.getY()+directionY, b.getWidth(), b.getHeight());	
					if(directionX == 0 && directionY == 0){
						destinationX = (int) (Math.random() * (550));
						destinationY = (int) (Math.random() * (550));
					}
				}
			}		
		};
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			tempsParClic = temps;
			
			// Premier clic
			if(this.compteur==16){
				start();
				b.setText("");
				b.setBounds(275, 275, 50, 50);
				defilement.start();
			}
			// Le compteur diminue
			this.compteur--;
			getScore().setText("" + compteur);
			
			// Le bouton saute.
			int width = b.getWidth();
			int height = b.getHeight();
			int x = (int) (Math.random() * (600 - width));
			int y = (int) (Math.random() * (600 - height));
				
			b.setBounds(x, y, width, height);
			
			
			// La destination du bouton change.
			destinationX = (int) (Math.random() * (600 - width));
			destinationY = (int) (Math.random() * (600 - height));
			
			// A la fin s'il y a un nouveau record, il est envoyé au controleur.
			if(compteur==0){
				b.setEnabled(false);
				b.setText("Terminé");
				b.setBounds(250, 275, 100, 50);
				if(tempsParClic < getRecordABattre()){
					String s = "" + JOptionPane.showInputDialog(null, "Vous avez fait un des meilleurs temps de ce niveau.\n Entrez votre nom.","", JOptionPane.QUESTION_MESSAGE);
					if(!s.equals("null")){
						if(s.length()>10)s = s.substring(0, 10);
						getControleur().control(s,tempsParClic,nom);
					}
				}
			}
			
			
		}
		
		// Thread du chronomètre.
		public void run(){
			try {
				sleep(800);
			} catch (InterruptedException e) {}
			while(temps!=999 && compteur!=0){
				temps++;
				getTemps().setText("" + temps);
				try {
					sleep(1000);
				} catch (InterruptedException e) {}
			}
			temps = 0;
			compteur = 16;
		}
		
		
		
	}

}

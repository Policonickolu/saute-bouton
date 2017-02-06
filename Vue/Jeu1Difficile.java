package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import Controleur.ControleurSauteBouton;
import Modele.MeilleursScores;

/**
 * Jeu "Saute Bouton" Difficile.
 * Hérite de "Jeu".
*
* @author COULIDIATI Donald
* @author BEN YAHIA Heidy
*/
public class Jeu1Difficile extends Jeu{
	
	private static final long serialVersionUID = 1L;
	
	private String nom;
	private JButton b;
	
	
	public Jeu1Difficile(ControleurSauteBouton controleur, MeilleursScores score){
		
		super(controleur,score.getJeu1().getScoreDifficile().getTemps());
		
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
	 * Chaque clic fait changer le bouton de position et le fait rétrécir. 
	 * Chaque clic à coté fait changer le bouton de position mais sans gagner de point.
	 */
	public class ClickListener extends Thread implements ActionListener, MouseListener{

		private int compteur = 16;
		private int temps = 0;
		private int tempsParClic = 0;
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			tempsParClic = temps;
			
			// Premier clic
			if(this.compteur==16){
				start();
				b.setText("");
				b.setBounds(275, 275, 50, 50);
				jeu.addMouseListener(new ClickListener());
			}
			// Le compteur diminue
			this.compteur--;
			getScore().setText("" + compteur);
			
			// Le bouton saute et rétrécit.
 
			int width = (int) (b.getWidth() * 0.90);
			int height = (int) (b.getHeight() * 0.90);
			int x = (int) (Math.random() * (600 - width));
			int y = (int) (Math.random() * (600 - height));
				
			b.setBounds(x, y, width, height);
			
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
		
		// En cas de clic à coté du bouton, le bouton saute sans rapporter de point.
		public void mousePressed(MouseEvent arg0) {
			int width = b.getWidth();
			int height = b.getHeight();
			int x = (int) (Math.random() * (600 - width));
			int y = (int) (Math.random() * (600 - height));
			b.setBounds(x, y, width, height);
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


		public void mouseClicked(MouseEvent arg0) {}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}		
		public void mouseReleased(MouseEvent arg0) {}		
		
	}
	

}

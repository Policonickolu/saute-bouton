package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Controleur.ControleurSauteBouton;
import Modele.MeilleursScores;

/**
 * Jeu "Bon Bouton" Facile.
 * Hérite de "Jeu".
*
* @author COULIDIATI Donald
* @author BEN YAHIA Heidy
*/
public class Jeu2Facile extends Jeu{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nom;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	
	public Jeu2Facile(ControleurSauteBouton controleur, MeilleursScores score) {
		
		super(controleur,score.getJeu2().getScoreFacile().getTemps());
		
		this.nom = this.getClass().getName().substring(4);

		this.b1 = new JButton("Démarrer");
		this.b1.setFocusable(false);
		this.b1.addActionListener(new ClickListener());
		
		this.jeu.setLayout(null);
		this.jeu.add(this.b1);
		this.b1.setBounds(250, 275, 100, 50);
		
		
		b2 = new JButton("b2");
		b2.setFocusable(false);
		
		b3 = new JButton("b3");
		b3.setFocusable(false);
		
		b4 = new JButton("b4");
		b4.setFocusable(false);

	}
	
	/**
	 * 
	 * Ecouteur de clic de bouton.
	 * Au premier clic, le jeu est lancé.
	 * Un thread permet de faire tourner le chronomètre.
	 * 4 boutons avec des équations. Seule une est juste.
	 * Chaque clic sur le bon bouton fait changer les boutons de position. 
	 *
	 */
	public class ClickListener extends Thread implements ActionListener{

		private int compteur = 16;
		private int temps = 0;
		private int tempsParClic = 0;
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			tempsParClic = temps;
			
			// Premier clic
			if(this.compteur==16){
				start();
				b1.setText("b1");
				b1.setBounds(275, 275, 100, 50);
				jeu.add(b2);
				b2.setBounds(275, 275, 100, 50);
				jeu.add(b3);
				b3.setBounds(275, 275, 100, 50);
				jeu.add(b4);
				b4.setBounds(275, 275, 100, 50);
			}
			// Le compteur diminue
			this.compteur--;
			getScore().setText("" + compteur);
			
			//Selon le compteur, l'équation présente un opérande " + - * /" différent.
			if(compteur == 15 || compteur == 11 || compteur == 7 || compteur == 3){
				int a = (int) (Math.random()* 10);
				int b = (int) (Math.random()* 10);
				b1.setText(a + "+" + b + "=" + (a+b));
				
				int c = (int) (Math.random()* 10);
				int d = (int) (Math.random()* 10);
				int e = (int) (Math.random()* 20);
				while(e == (c+d)){
					e = (int) (Math.random()* 20);
				}
				b2.setText(c + " + " + d + " = " + e);
				
				int f = (int) (Math.random()* 10);
				int g = (int) (Math.random()* 10);
				int h = (int) (Math.random()* 20);
				while(h == (f+g)){
					h = (int) (Math.random()* 20);
				}
				b3.setText(f + " + " + g + " = " + h);
				
				int i = (int) (Math.random()* 10);
				int j = (int) (Math.random()* 10);
				int k = (int) (Math.random()* 20);
				while(k == (i+j)){
					k = (int) (Math.random()* 20);
				}
				b4.setText(i + " + " + j + " = " + k);
			}
			else if(compteur == 14 || compteur == 10 || compteur == 6 || compteur == 2){
				int a = (int) (Math.random()* 10);
				int b = (int) (Math.random()* 10);
				b1.setText(a + "-" + b + "=" + (a-b));
				
				int c = (int) (Math.random()* 10);
				int d = (int) (Math.random()* 10);
				while(c<d){
					c = (int) (Math.random()* 10);
					d = (int) (Math.random()* 10);
				}
				int e = (int) (Math.random()* 10);
				while(e == (c-d)){
					e = (int) (Math.random()* 10);
				}
				b2.setText(c + " - " + d + " = " + e);
				
				int f = (int) (Math.random()* 10);
				int g = (int) (Math.random()* 10);
				while(f<g){
					f = (int) (Math.random()* 10);
					g = (int) (Math.random()* 10);
				}
				int h = (int) (Math.random()* 10);
				while(h == (f-g)){
					h = (int) (Math.random()* 10);
				}
				b3.setText(f + " - " + g + " = " + h);
				
				int i = (int) (Math.random()* 10);
				int j = (int) (Math.random()* 10);
				while(i<j){
					i = (int) (Math.random()* 10);
					j = (int) (Math.random()* 10);
				}
				int k = (int) (Math.random()* 10);
				while(k == (i-j)){
					k = (int) (Math.random()* 10);
				}
				b4.setText(i + " - " + j + " = " + k);
			}
			else if(compteur == 13 || compteur == 9 || compteur == 5 || compteur == 1){
				int a = (int) (Math.random()* 10);
				int b = (int) (Math.random()* 10);
				b1.setText(a + "*" + b + "=" + (a*b));
				
				int c = (int) (Math.random()* 10);
				int d = (int) (Math.random()* 10);
				int e = (int) (Math.random()* 100);
				while(e == (c*d)){
					e = (int) (Math.random()* 100);
				}
				b2.setText(c + " * " + d + " = " + e);
				
				int f = (int) (Math.random()* 10);
				int g = (int) (Math.random()* 10);
				int h = (int) (Math.random()* 100);
				while(h == (f*g)){
					h = (int) (Math.random()* 100);
				}
				b3.setText(f + " * " + g + " = " + h);
				
				int i = (int) (Math.random()* 10);
				int j = (int) (Math.random()* 10);
				int k = (int) (Math.random()* 100);
				while(k == (i*j)){
					k = (int) (Math.random()* 100);
				}
				b4.setText(i + " * " + j + " = " + k);
			}
			else if(compteur == 12 || compteur == 8 || compteur == 4){
				int a = (int) (Math.random()* 10);
				int b = (int) (Math.random()* 9)+1;
				while(a%b != 0){
					a = (int) (Math.random()* 10);
					b = (int) (Math.random()* 9)+1;
				}
				b1.setText(a + "/" + b + "=" + (a/b));
				
				int c = (int) (Math.random()* 10);
				int d = (int) (Math.random()* 9)+1;
				int e = (int) (Math.random()* 10);
				while(e == (c/d)){
					e = (int) (Math.random()* 10);
				}
				b2.setText(c + " / " + d + " = " + e);
				
				int f = (int) (Math.random()* 10);
				int g = (int) (Math.random()* 9)+1;
				int h = (int) (Math.random()* 10);
				while(h == (f/g)){
					h = (int) (Math.random()* 10);
				}
				b3.setText(f + " / " + g + " = " + h);
				
				int i = (int) (Math.random()* 10);
				int j = (int) (Math.random()* 9)+1;
				int k = (int) (Math.random()* 10);
				while(k == (i/j)){
					k = (int) (Math.random()* 10);
				}
				b4.setText(i + " / " + j + " = " + k);
			}
			
			int width1 = b1.getWidth();
			int height1 = b1.getHeight();
			int x1 = (int) (Math.random() * (600 - width1));
			int y1 = (int) (Math.random() * (600 - height1));
			
			
			int width2 = b2.getWidth();
			int height2 = b2.getHeight();
			int x2 = (int) (Math.random() * (600 - width2));
			int y2 = (int) (Math.random() * (600 - height2));			
			
			
			int width3 = b3.getWidth();
			int height3 = b3.getHeight();
			int x3 = (int) (Math.random() * (600 - width3));
			int y3 = (int) (Math.random() * (600 - height3));		
			
			
			int width4 = b4.getWidth();
			int height4 = b4.getHeight();
			int x4 = (int) (Math.random() * (600 - width4));
			int y4 = (int) (Math.random() * (600 - height4));
			
			
			
			// Procédure empêchant les boutons de se superposer.
			
			double x1Xx2 = Math.signum((x1-(x2+width2))*((x1+width1)-x2));
			double y1Xy2 = Math.signum((y1-(y2+height2))*((y1+height1)-y2));
			boolean b1xb2 = (x1Xx2 == y1Xy2 && x1Xx2  == -1.0 && y1Xy2 == -1.0);
			
			double x1Xx3 = Math.signum((x1-(x3+width3))*((x1+width1)-x3));
			double y1Xy3 = Math.signum((y1-(y3+height3))*((y1+height1)-y3));
			boolean b1xb3 = (x1Xx3 == y1Xy3 && x1Xx3  == -1.0 && y1Xy3 == -1.0);	
			
			double x1Xx4 = Math.signum((x1-(x4+width4))*((x1+width1)-x4));
			double y1Xy4 = Math.signum((y1-(y4+height4))*((y1+height1)-y4));
			boolean b1xb4 = (x1Xx4 == y1Xy4 && x1Xx4  == -1.0 && y1Xy4 == -1.0);			
			
			double x2Xx3 = Math.signum((x2-(x3+width3))*((x2+width2)-x3));
			double y2Xy3 = Math.signum((y2-(y3+height3))*((y2+height2)-y3));
			boolean b2xb3 = (x2Xx3 == y2Xy3 && x2Xx3  == -1.0 && y2Xy3 == -1.0);
			
			double x2Xx4 = Math.signum((x2-(x4+width4))*((x2+width2)-x4));
			double y2Xy4 = Math.signum((y2-(y4+height4))*((y2+height2)-y4));
			boolean b2xb4 = (x2Xx4 == y2Xy4 && x2Xx4  == -1.0 && y2Xy4 == -1.0);
			
			double x3Xx4 = Math.signum((x3-(x4+width4))*((x3+width3)-x4));
			double y3Xy4 = Math.signum((y3-(y4+height4))*((y3+height3)-y4));
			boolean b3xb4 = (x3Xx4 == y3Xy4 && x3Xx4  == -1.0 && y3Xy4 == -1.0);
				
			while(b1xb2 || b1xb3 || b1xb4 || b2xb3 || b2xb4 || b3xb4){
								
				x1 = (int) (Math.random() * (600 - width1));
				y1 = (int) (Math.random() * (600 - height1));
				x2 = (int) (Math.random() * (600 - width2));
				y2 = (int) (Math.random() * (600 - height2));	
				x3 = (int) (Math.random() * (600 - width3));
				y3 = (int) (Math.random() * (600 - height3));
				x4 = (int) (Math.random() * (600 - width4));
				y4 = (int) (Math.random() * (600 - height4));
				
				x1Xx2 = Math.signum((x1-(x2+width2))*((x1+width1)-x2));
				y1Xy2 = Math.signum((y1-(y2+height2))*((y1+height1)-y2));
				b1xb2 = (x1Xx2 == y1Xy2 && x1Xx2  == -1.0 && y1Xy2 == -1.0);
				
				x1Xx3 = Math.signum((x1-(x3+width3))*((x1+width1)-x3));
				y1Xy3 = Math.signum((y1-(y3+height3))*((y1+height1)-y3));
				b1xb3 = (x1Xx3 == y1Xy3 && x1Xx3  == -1.0 && y1Xy3 == -1.0);	
				
				x1Xx4 = Math.signum((x1-(x4+width4))*((x1+width1)-x4));
				y1Xy4 = Math.signum((y1-(y4+height4))*((y1+height1)-y4));
				b1xb4 = (x1Xx4 == y1Xy4 && x1Xx4  == -1.0 && y1Xy4 == -1.0);			
				
				x2Xx3 = Math.signum((x2-(x3+width3))*((x2+width2)-x3));
				y2Xy3 = Math.signum((y2-(y3+height3))*((y2+height2)-y3));
				b2xb3 = (x2Xx3 == y2Xy3 && x2Xx3  == -1.0 && y2Xy3 == -1.0);
				
				x2Xx4 = Math.signum((x2-(x4+width4))*((x2+width2)-x4));
				y2Xy4 = Math.signum((y2-(y4+height4))*((y2+height2)-y4));
				b2xb4 = (x2Xx4 == y2Xy4 && x2Xx4  == -1.0 && y2Xy4 == -1.0);
				
				x3Xx4 = Math.signum((x3-(x4+width4))*((x3+width3)-x4));
				y3Xy4 = Math.signum((y3-(y4+height4))*((y3+height3)-y4));
				b3xb4 = (x3Xx4 == y3Xy4 && x3Xx4  == -1.0 && y3Xy4 == -1.0);
				
			}
			
			// Les boutons sautent.
			
			b1.setBounds(x1, y1, width1, height1);
			b2.setBounds(x2, y2, width2, height2);
			b3.setBounds(x3, y3, width3, height3);
			b4.setBounds(x4, y4, width4, height4);


			
			
			// A la fin s'il y a un nouveau record, il est envoyé au controleur.
			if(compteur==0){
				jeu.remove(b2);
				jeu.remove(b3);
				jeu.remove(b4);
				b1.setEnabled(false);
				b1.setText("Terminé");
				b1.setBounds(250, 275, 100, 50);
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

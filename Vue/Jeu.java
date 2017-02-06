package Vue;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controleur.ControleurSauteBouton;

/**
 * Classe abstraite comportant les attributs communs à tous les jeux.
 * Contient le Cadre de jeu, les cadres affichant le chrono et le compteur.
 *
 * @author COULIDIATI Donald
 * @author BEN YAHIA Heidy
 */
public abstract class Jeu extends JPanel{
	
	private static final long serialVersionUID = 1L;

	private ControleurSauteBouton controleur;
	private int recordABattre;
	private JTextField score;
	private JTextField temps;
	protected JPanel jeu;
	
	public Jeu(ControleurSauteBouton controleur, int record){
		
		this.setControleur(controleur);
		this.setRecordABattre(record);
		
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.LIGHT_GRAY);
		
		// Création du cadre de jeu.
		
		this.jeu = new JPanel();
		this.jeu.setBackground(Color.GRAY);
		this.jeu.setMinimumSize(new Dimension(600,600));
		this.jeu.setPreferredSize(new Dimension(600,600));
		this.jeu.setBorder(BorderFactory.createLoweredBevelBorder());
		
		// Création du cadre affichant le score (compteur).
		
		this.setScore(new JTextField("15"));
		this.getScore().setMinimumSize(new Dimension(60,50));
		this.getScore().setPreferredSize(new Dimension(60,50));
		this.getScore().setHorizontalAlignment(JTextField.RIGHT);
		this.getScore().setBackground(Color.GRAY);
		this.getScore().setForeground(Color.WHITE);
		this.getScore().setBorder(BorderFactory.createLoweredBevelBorder());
		this.getScore().setFocusable(false);
		this.getScore().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		this.getScore().setFont(new Font("SansSerif", Font.BOLD, 30));
		
		//Création du cadre affichant le temps.
		
		this.setTemps(new JTextField("0"));
		this.getTemps().setMinimumSize(new Dimension(60,50));
		this.getTemps().setPreferredSize(new Dimension(60,50));
		this.getTemps().setHorizontalAlignment(JTextField.RIGHT);
		this.getTemps().setBackground(Color.GRAY);
		this.getTemps().setForeground(Color.WHITE);
		this.getTemps().setBorder(BorderFactory.createLoweredBevelBorder());
		this.getTemps().setFocusable(false);
		this.getTemps().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		this.getTemps().setFont(new Font("SansSerif", Font.BOLD, 30));
		
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(25,100,0,0);
		this.add(this.getTemps(),c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.anchor = GridBagConstraints.EAST;
		c.insets = new Insets(25,0,0,100);
		this.add(this.getScore(),c);		
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 2;
		c.anchor = GridBagConstraints.SOUTH;
		c.insets = new Insets(25, 50, 50, 50);
		this.add(this.jeu,c);
		
	}

	public void setTemps(JTextField temps) {
		this.temps = temps;
	}

	public JTextField getTemps() {
		return temps;
	}

	public void setScore(JTextField score) {
		this.score = score;
	}

	public JTextField getScore() {
		return score;
	}

	public void setRecordABattre(int recordABattre) {
		this.recordABattre = recordABattre;
	}

	public int getRecordABattre() {
		return recordABattre;
	}

	public void setControleur(ControleurSauteBouton controleur) {
		this.controleur = controleur;
	}

	public ControleurSauteBouton getControleur() {
		return controleur;
	}
	
}





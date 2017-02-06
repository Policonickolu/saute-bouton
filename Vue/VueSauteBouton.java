package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import Controleur.ControleurSauteBouton;
import Modele.MeilleursScores;
import Observateur.Observateur;

/**
 * Vue du programme.
 * Fenêtre principale.
 * Composé principalement d'un JPanel "Jeu".
 * Contient un Menu horizontal permettant de changer de "Jeu" et d'afficher les meilleurs temps.
 *
 * @author COULIDIATI Donald
 * @author BEN YAHIA Heidy
 */
public class VueSauteBouton extends JFrame implements Observateur{
	
	private static final long serialVersionUID = 1L;

	private ControleurSauteBouton controleur;
	private MeilleursScores meilleursScores = new MeilleursScores();
 
	private JMenuBar menu;
	JMenuItem m1 = new JMenuItem("Nouveau");
    JRadioButtonMenuItem m2 = new JRadioButtonMenuItem("Facile");
    JRadioButtonMenuItem m3 = new JRadioButtonMenuItem("Moyen");
    JRadioButtonMenuItem m4 = new JRadioButtonMenuItem("Difficile");
    JRadioButtonMenuItem m5 = new JRadioButtonMenuItem("Facile");
    JRadioButtonMenuItem m6 = new JRadioButtonMenuItem("Moyen");
    JRadioButtonMenuItem m7 = new JRadioButtonMenuItem("Difficile");
    JRadioButtonMenuItem m8 = new JRadioButtonMenuItem("Facile");
    JRadioButtonMenuItem m9 = new JRadioButtonMenuItem("Moyen");
    JRadioButtonMenuItem m10 = new JRadioButtonMenuItem("Difficile");
    JMenuItem m11 = new JMenuItem("Meilleurs temps...");
    JMenuItem m12 = new JMenuItem("Quitter");
	private Jeu jeu;
	
	public VueSauteBouton(ControleurSauteBouton c){		

		this.setSize(706, 805);
		this.setTitle("Saute Bouton");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);  
        this.controleur = c;      
        
        // Création du menu.
        
        this.m1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setNouvellePartie();
			}
		});
        this.m2.setSelected(true);
        this.m2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setNouvellePartie();	
			}
		});
        this.m3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setNouvellePartie();			
			}
		});
        this.m4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setNouvellePartie();			
			}
		});
        this.m5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setNouvellePartie();	
			}
		});
        this.m6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setNouvellePartie();			
			}
		});
        this.m7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setNouvellePartie();			
			}
		});
        this.m8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setNouvellePartie();	
			}
		});
        this.m9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setNouvellePartie();			
			}
		});
        this.m10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setNouvellePartie();			
			}
		});        
        this.m11.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new AffichageScore(meilleursScores,controleur,jeu);		
			}
		});
        this.m12.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);			
			}
		});
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(m2);
        bg.add(m3);
        bg.add(m4);
        bg.add(m5);
        bg.add(m6);
        bg.add(m7);
        bg.add(m8);
        bg.add(m9);
        bg.add(m10);
        
        JMenu m = new JMenu("Partie");
        m.add(m1);
        m.addSeparator();
        JMenu m1 = new JMenu("Saute Bouton");
        m1.add(m2);
        m1.add(m3);
        m1.add(m4);
        m.add(m1);
        JMenu m2 = new JMenu("Bon Bouton");
        m2.add(m5);
        m2.add(m6);
        m2.add(m7);
        m.add(m2);
        JMenu m3 = new JMenu("Bouton Filant");
        m3.add(m8);
        m3.add(m9);
        m3.add(m10);
        m.add(m3);
        m.addSeparator();
        m.add(m11);
        m.addSeparator();
        m.add(m12);
        
        this.menu = new JMenuBar();
        this.menu.add(m);   
    
        // Création du Jeu.
        
        this.jeu = new Jeu1Facile(this.controleur,this.meilleursScores);
        
        
        this.setJMenuBar(this.menu);
        this.add(this.jeu);
		
        this.setVisible(true);
		
	}
	
	/**
	 * Créer une nouvelle partie du Jeu sélectionné.
	 */
	public void setNouvellePartie(){
		if(this.m2.isSelected()){
			this.jeu.setVisible(false);
			this.remove(this.jeu);
			this.jeu = new Jeu1Facile(this.controleur,this.meilleursScores);
			this.add(this.jeu);
			this.jeu.setVisible(true);
		}
		if(this.m3.isSelected()){
			this.jeu.setVisible(false);
			this.remove(this.jeu);
			this.jeu = new Jeu1Moyen(this.controleur,this.meilleursScores);
			this.add(this.jeu);
			this.jeu.setVisible(true);
		}
		if(this.m4.isSelected()){
			this.jeu.setVisible(false);
			this.remove(this.jeu);
			this.jeu = new Jeu1Difficile(this.controleur,this.meilleursScores);
			this.add(this.jeu);
			this.jeu.setVisible(true);
		}
		if(this.m5.isSelected()){
			this.jeu.setVisible(false);
			this.remove(this.jeu);
			this.jeu = new Jeu2Facile(this.controleur,this.meilleursScores);
			this.add(this.jeu);
			this.jeu.setVisible(true);
		}
		if(this.m6.isSelected()){
			this.jeu.setVisible(false);
			this.remove(this.jeu);
			this.jeu = new Jeu2Moyen(this.controleur,this.meilleursScores);
			this.add(this.jeu);
			this.jeu.setVisible(true);
		}
		if(this.m7.isSelected()){
			this.jeu.setVisible(false);
			this.remove(this.jeu);
			this.jeu = new Jeu2Difficile(this.controleur,this.meilleursScores);
			this.add(this.jeu);
			this.jeu.setVisible(true);
		}
		if(this.m8.isSelected()){
			this.jeu.setVisible(false);
			this.remove(this.jeu);
			this.jeu = new Jeu3Facile(this.controleur,this.meilleursScores);
			this.add(this.jeu);
			this.jeu.setVisible(true);
		}
		if(this.m9.isSelected()){
			this.jeu.setVisible(false);
			this.remove(this.jeu);
			this.jeu = new Jeu3Moyen(this.controleur,this.meilleursScores);
			this.add(this.jeu);
			this.jeu.setVisible(true);
		}
		if(this.m10.isSelected()){
			this.jeu.setVisible(false);
			this.remove(this.jeu);
			this.jeu = new Jeu3Difficile(this.controleur,this.meilleursScores);
			this.add(this.jeu);
			this.jeu.setVisible(true);
		}
		
	}

	/**
	 * Mise à jour des données du modèle.
	 */
	public void miseAJour(MeilleursScores ms) {
		this.meilleursScores = new MeilleursScores(ms);
	}

}

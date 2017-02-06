package Vue;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controleur.ControleurSauteBouton;
import Modele.MeilleursScores;

/**
 * Panneau affichant les meilleurs scores de chaque jeu et de chaque niveau de difficulté.
 * Il contient des JLabel affichant les noms et temps
 * ainsi qu'un bouton permettant de réinitialiser les scores.
 *
 * @author COULIDIATI Donald
 * @author BEN YAHIA Heidy
 */
public class AffichageScore extends JDialog{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private MeilleursScores meilleursScores;
	private ControleurSauteBouton controleur;
	private Component composantParent;
	
	/**
	 * Constructeur.
	 * 
	 * @param ms
	 * @param csb
	 * @param c
	 */
	public AffichageScore(MeilleursScores ms,ControleurSauteBouton csb,Component c){
	
		this.meilleursScores = ms;
		this.controleur = csb;
		this.composantParent = c;
		this.setSize(350, 400);
		this.setTitle("Meilleurs Temps");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setModal(true);
        this.setLocationRelativeTo(c);
        this.setResizable(false); 
        
        // Créations des JLabel placés dans des boxes.
        
        Box panneau = Box.createVerticalBox();
        
        Box jeu1 = Box.createHorizontalBox();
        jeu1.setBorder(BorderFactory.createTitledBorder("Saute Bouton"));
        	Box difficulte1 = Box.createVerticalBox();
        	difficulte1.setMinimumSize(new Dimension(0,60));
        	difficulte1.setMaximumSize(new Dimension(0,60));
        		JLabel facile1 = new JLabel("Facile : ");
        		JLabel moyen1 = new JLabel("Moyen : ");
        		JLabel difficile1 = new JLabel("Difficile : ");
        	Box temps1 = Box.createVerticalBox();
        	temps1.setMinimumSize(new Dimension(0,60));
        	temps1.setMaximumSize(new Dimension(0,60));
	        	JLabel tempsFacile1 = new JLabel("" + meilleursScores.getJeu1().getScoreFacile().getTemps() + " secondes ");
	        	JLabel tempsMoyen1 = new JLabel("" + meilleursScores.getJeu1().getScoreMoyen().getTemps() + " secondes ");
	        	JLabel tempsDifficile1 = new JLabel("" + meilleursScores.getJeu1().getScoreDifficile().getTemps() + " secondes ");
	        Box nom1 = Box.createVerticalBox();
	        nom1.setMinimumSize(new Dimension(0,60));
	        nom1.setMaximumSize(new Dimension(0,60));
	        	JLabel nomFacile1 = new JLabel("" + meilleursScores.getJeu1().getScoreFacile().getNom());
	        	JLabel nomMoyen1 = new JLabel("" + meilleursScores.getJeu1().getScoreMoyen().getNom());
	        	JLabel nomDifficile1 = new JLabel("" + meilleursScores.getJeu1().getScoreDifficile().getNom());
        ;
        difficulte1.add(facile1);
        difficulte1.add(Box.createVerticalStrut(5));
        difficulte1.add(moyen1);
        difficulte1.add(Box.createVerticalStrut(5));
        difficulte1.add(difficile1);
        difficulte1.add(Box.createVerticalStrut(5));
        temps1.add(tempsFacile1);
        temps1.add(Box.createVerticalStrut(5));
        temps1.add(tempsMoyen1);
        temps1.add(Box.createVerticalStrut(5));
        temps1.add(tempsDifficile1);
        temps1.add(Box.createVerticalStrut(5));
        nom1.add(nomFacile1);
        nom1.add(Box.createVerticalStrut(5));
        nom1.add(nomMoyen1);
        nom1.add(Box.createVerticalStrut(5));
        nom1.add(nomDifficile1);
        nom1.add(Box.createVerticalStrut(5));
	    jeu1.add(difficulte1);
	    jeu1.add(Box.createHorizontalStrut(20));
	    jeu1.add(temps1);
	    jeu1.add(Box.createHorizontalStrut(20));
	    jeu1.add(nom1);
	    jeu1.add(Box.createHorizontalGlue());
	    
	    
	    Box jeu2 = Box.createHorizontalBox();
        jeu2.setBorder(BorderFactory.createTitledBorder("Bon Bouton"));
        	Box difficulte2 = Box.createVerticalBox();
        	difficulte2.setMinimumSize(new Dimension(0,60));
        	difficulte2.setMaximumSize(new Dimension(0,60));
        		JLabel facile2 = new JLabel("Facile : ");
        		JLabel moyen2 = new JLabel("Moyen : ");
        		JLabel difficile2 = new JLabel("Difficile : ");
        	Box temps2 = Box.createVerticalBox();
        	temps2.setMinimumSize(new Dimension(0,60));
        	temps2.setMaximumSize(new Dimension(0,60));
	        	JLabel tempsFacile2 = new JLabel("" + meilleursScores.getJeu2().getScoreFacile().getTemps() + " secondes ");
	        	JLabel tempsMoyen2 = new JLabel("" + meilleursScores.getJeu2().getScoreMoyen().getTemps() + " secondes ");
	        	JLabel tempsDifficile2 = new JLabel("" + meilleursScores.getJeu2().getScoreDifficile().getTemps() + " secondes ");
	        Box nom2 = Box.createVerticalBox();
	        nom2.setMinimumSize(new Dimension(0,60));
	        nom2.setMaximumSize(new Dimension(0,60));
	        	JLabel nomFacile2 = new JLabel("" + meilleursScores.getJeu2().getScoreFacile().getNom());
	        	JLabel nomMoyen2 = new JLabel("" + meilleursScores.getJeu2().getScoreMoyen().getNom());
	        	JLabel nomDifficile2 = new JLabel("" + meilleursScores.getJeu2().getScoreDifficile().getNom());
        ;
        difficulte2.add(facile2);
        difficulte2.add(Box.createVerticalStrut(5));
        difficulte2.add(moyen2);
        difficulte2.add(Box.createVerticalStrut(5));
        difficulte2.add(difficile2);
        difficulte2.add(Box.createVerticalStrut(5));
        temps2.add(tempsFacile2);
        temps2.add(Box.createVerticalStrut(5));
        temps2.add(tempsMoyen2);
        temps2.add(Box.createVerticalStrut(5));
        temps2.add(tempsDifficile2);
        temps2.add(Box.createVerticalStrut(5));
        nom2.add(nomFacile2);
        nom2.add(Box.createVerticalStrut(5));
        nom2.add(nomMoyen2);
        nom2.add(Box.createVerticalStrut(5));
        nom2.add(nomDifficile2);
        nom2.add(Box.createVerticalStrut(5));
        jeu2.add(difficulte2);
	    jeu2.add(Box.createHorizontalStrut(20));
	    jeu2.add(temps2);
	    jeu2.add(Box.createHorizontalStrut(20));
	    jeu2.add(nom2);
	    jeu2.add(Box.createHorizontalGlue());	
	    
	    
	    Box jeu3 = Box.createHorizontalBox();
        jeu3.setBorder(BorderFactory.createTitledBorder("Bouton Filant"));
        	Box difficulte3 = Box.createVerticalBox();
        	difficulte3.setMinimumSize(new Dimension(0,60));
        	difficulte3.setMaximumSize(new Dimension(0,60));
        		JLabel facile3 = new JLabel("Facile : ");
        		JLabel moyen3 = new JLabel("Moyen : ");
        		JLabel difficile3 = new JLabel("Difficile : ");
        	Box temps3 = Box.createVerticalBox();
        	temps3.setMinimumSize(new Dimension(0,60));
        	temps3.setMaximumSize(new Dimension(0,60));
	        	JLabel tempsFacile3 = new JLabel("" + meilleursScores.getJeu3().getScoreFacile().getTemps() + " secondes ");
	        	JLabel tempsMoyen3 = new JLabel("" + meilleursScores.getJeu3().getScoreMoyen().getTemps() + " secondes ");
	        	JLabel tempsDifficile3 = new JLabel("" + meilleursScores.getJeu3().getScoreDifficile().getTemps() + " secondes ");
	        Box nom3 = Box.createVerticalBox();
	        nom3.setMinimumSize(new Dimension(0,60));
	        nom3.setMaximumSize(new Dimension(0,60));
	        	JLabel nomFacile3 = new JLabel("" + meilleursScores.getJeu3().getScoreFacile().getNom());
	        	JLabel nomMoyen3 = new JLabel("" + meilleursScores.getJeu3().getScoreMoyen().getNom());
	        	JLabel nomDifficile3 = new JLabel("" + meilleursScores.getJeu3().getScoreDifficile().getNom());
	        	
        difficulte3.add(facile3);
        difficulte3.add(Box.createVerticalStrut(5));
        difficulte3.add(moyen3);
        difficulte3.add(Box.createVerticalStrut(5));
        difficulte3.add(difficile3);
        difficulte3.add(Box.createVerticalStrut(5));
        temps3.add(tempsFacile3);
        temps3.add(Box.createVerticalStrut(5));
        temps3.add(tempsMoyen3);
        temps3.add(Box.createVerticalStrut(5));
        temps3.add(tempsDifficile3);
        temps3.add(Box.createVerticalStrut(5));
        nom3.add(nomFacile3);
        nom3.add(Box.createVerticalStrut(5));
        nom3.add(nomMoyen3);
        nom3.add(Box.createVerticalStrut(5));
        nom3.add(nomDifficile3);
        nom3.add(Box.createVerticalStrut(5));
        jeu3.add(difficulte3);
	    jeu3.add(Box.createHorizontalStrut(20));
	    jeu3.add(temps3);
	    jeu3.add(Box.createHorizontalStrut(20));
	    jeu3.add(nom3);
	    jeu3.add(Box.createHorizontalGlue()); 	
	    
 
        
        panneau.add(jeu1);
        panneau.add(jeu2);
        panneau.add(jeu3);
        
        // Création des boutons Effacer et OK.
        
        JPanel boutons = new JPanel();
        JButton effacer = new JButton("Effacer les scores");
        effacer.setPreferredSize(new Dimension(150,30));
        JButton ok = new JButton("OK");
        ok.setPreferredSize(new Dimension(150,30));
        
        effacer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controleur.effacerScore();				
				new AffichageScore(new MeilleursScores(),controleur,composantParent);
				dispose();
			}
		});
        ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
        
        boutons.add(effacer);
        boutons.add(ok);
        
    	this.add(panneau, BorderLayout.CENTER);
        this.add(boutons, BorderLayout.SOUTH);
        
        // Affichage du panneau.
        
        this.setVisible(true);
        
	}
	
}

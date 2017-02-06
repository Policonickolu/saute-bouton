package Modele;

import java.io.Serializable;

/**
 *	Tous les scores de tous les jeux. 
 *
 * @author COULIDIATI Donald
 * @author BEN YAHIA Heidy
 */
public class MeilleursScores implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Scores du jeu "Saute Bouton".
	 */
	private ScoreParDifficulte jeu1;
	/**
	 * Scores du jeu "Bon Bouton".
	 */
	private ScoreParDifficulte jeu2;
	/**
	 * Scores du jeu "Bouton filant".
	 */
	private ScoreParDifficulte jeu3;
	
	/**
	 * Constructeur.
	 */
	public MeilleursScores(){
		
		this.jeu1 = new ScoreParDifficulte();
		this.jeu2 = new ScoreParDifficulte();
		this.jeu3 = new ScoreParDifficulte();
		
	}

	/**
	 * 
	 * Constructeur.
	 *
	 * @param ms
	 */
	public MeilleursScores(MeilleursScores ms) {
		
		this.jeu1 = new ScoreParDifficulte(ms.jeu1);
		this.jeu2 = new ScoreParDifficulte(ms.jeu2);
		this.jeu3 = new ScoreParDifficulte(ms.jeu3);
		
	}
	
	/**
	 * Récupère les scores de "Saute Bouton".
	 * @return les scores de "Saute Bouton"
	 */
	public ScoreParDifficulte getJeu1() {
		return jeu1;
	}
	
	/**
	 * Remplace les scores de "Saute Bouton" par de nouveaux.
	 * @param jeu1
	 */
	public void setJeu1(ScoreParDifficulte jeu1) {
		this.jeu1 = jeu1;
	}

	/**
	 * Récupère les scores de "Bon Bouton".
	 * @return les scores de "Bon Bouton".
	 */
	public ScoreParDifficulte getJeu2() {
		return jeu2;
	}

	/**
	 * Remplace les scores de "Bon Bouton" par de nouveaux.
	 * @param jeu2
	 */
	public void setJeu2(ScoreParDifficulte jeu2) {
		this.jeu2 = jeu2;
	}
	
	/**
	 * Récupère les scores de "Bouton Filant".
	 * @return les scores de "Bouton Filant".
	 */
	public ScoreParDifficulte getJeu3() {
		return jeu3;
	}

	/**
	 * Remplace les scores de "Bouton Filant" par de nouveaux.
	 * @param jeu3
	 */
	public void setJeu3(ScoreParDifficulte jeu3) {
		this.jeu3 = jeu3;
	}	

}

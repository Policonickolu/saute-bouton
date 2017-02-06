package Modele;

import java.io.Serializable;

/**
 * Tous les scores d'un seul jeu. 
 *
 * @author COULIDIATI Donald
 * @author BEN YAHIA Heidy
 */
public class ScoreParDifficulte implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Score du niveau facile.
	 */
	private Score scoreFacile;
	/**
	 * Score du niveau moyen.
	 */
	private Score scoreMoyen;
	/**
	 * Score du niveau difficile.
	 */
	private Score scoreDifficile;
	
	/**
	 * Constructeur.
	 */
	public ScoreParDifficulte() {
		
		this.scoreFacile = new Score();
		this.scoreMoyen = new Score();
		this.scoreDifficile = new Score();
		
	}
	
	/**
	 * Constructeur.
	 * @param jeu
	 */
	public ScoreParDifficulte(ScoreParDifficulte jeu) {
		
		this.scoreFacile = new Score(jeu.scoreFacile);
		this.scoreMoyen = new Score(jeu.scoreMoyen);
		this.scoreDifficile = new Score(jeu.scoreDifficile);
		
	}
	
	
	
	/**
	 * Récupère le score du niveau facile.
	 * @return le score du niveau facile.
	 */
	public Score getScoreFacile() {
		return scoreFacile;
	}

	/**
	 * Remplace le score du niveau facile.
	 * @param scoreFacile
	 */
	public void setScoreFacile(Score scoreFacile) {
		this.scoreFacile = scoreFacile;
	}
	
	/**
	 * Récupère le score du niveau moyen.
	 * @return le score du niveau moyen.
	 */
	public Score getScoreMoyen() {
		return scoreMoyen;
	}
	
	/**
	 * Remplace le score du niveau moyen.
	 * @param scoreMoyen
	 */
	public void setScoreMoyen(Score scoreMoyen) {
		this.scoreMoyen = scoreMoyen;
	}

	/**
	 * Récupère le score du niveau difficile.
	 * @return le score du niveau difficile.
	 */
	public Score getScoreDifficile() {
		return scoreDifficile;
	}

	/**
	 * Remplace le score du niveau difficile.
	 * @param scoreDifficile
	 */
	public void setScoreDifficile(Score scoreDifficile) {
		this.scoreDifficile = scoreDifficile;
	}
	
}

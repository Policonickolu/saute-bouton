package Modele;

import java.io.Serializable;

/**
 * Un score constitué d'un nom et d'un temps.
 *
 * @author COULIDIATI Donald
 * @author BEN YAHIA Heidy
 */
public class Score implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * nom du joueur.
	 */
	private String nom;
	/**
	 * temps réalisé.
	 */
	private int temps;
	
	/**
	 * Constructeur.
	 */
	public Score(){
		
		this.nom = "Anonyme";
		this.temps = 999;
		
	}

	/**
	 * Constructeur.
	 * @param score
	 */
	public Score(Score score) {
		
		this.nom = score.nom;
		this.temps = score.temps;
		
	}

	/**
	 * Remplace le score actuel par un nouveau score.
	 * 
	 * @param s
	 * @param i
	 */
	public void setScore(String s, int i){
		
		this.nom = (s.equals("") ? "Anonyme" : s);
		this.temps = i;
		
	}
	
	/**
	 * Récupère le nom.
	 * @return le nom.
	 */
	public String getNom() {
		
		return nom;
		
	}
	
	/**
	 * Remplace le nom.
	 * @param nom
	 */
	public void setNom(String nom) {
		
		this.nom = nom;
		
	}
	
	/**
	 * récupère le temps.
	 * @return le temps.
	 */
	public int getTemps() {
		
		return temps;
		
	}
	
	/**
	 * Remplace le temps.
	 * @param temps
	 */
	public void setTemps(int temps) {
		
		this.temps = temps;
		
	}
   
}
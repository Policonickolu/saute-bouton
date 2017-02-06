package Controleur;

import Modele.ModeleSauteBouton;


/**
 * Contrôleur du programme
 * Il examine de quel jeu et de quel niveau de difficulté provient le nouveau score
 * pour le placer dans le programme.
 * 
 * @author COULIDIATI Donald
 * @author BEN YAHIA Heidy
 */
public class ControleurSauteBouton {

	/**
	 * Le modele du programme.
	 */
	private ModeleSauteBouton modele;
	
	
	/**
	 * Constructeur du contrôleur.
	 * 
	 * @param m
	 */
	public ControleurSauteBouton(ModeleSauteBouton m){
		this.modele = m;
	}
	
	/**
	 * Contrôle le bouton de réinitialisation des scores.
	 */
	public void effacerScore(){
		this.modele.effacerScore();
		this.modele.serializer();
	}	
	
	/**
	 * Contrôle les nouveaux records par jeu et par niveau de difficulté
	 * pour les envoyer au modèle aux bons endroits.
	 * 
	 * @param nom
	 * @param temps
	 * @param jeu
	 */
	public void control(String nom, int temps, String jeu){
		if(jeu.equals("Jeu1Facile")){
			this.modele.getMeilleursScores().getJeu1().getScoreFacile().setScore(nom,temps);
		}
		if(jeu.equals("Jeu1Moyen")){
			this.modele.getMeilleursScores().getJeu1().getScoreMoyen().setScore(nom,temps);
		}
		if(jeu.equals("Jeu1Difficile")){
			this.modele.getMeilleursScores().getJeu1().getScoreDifficile().setScore(nom,temps);
		}
		if(jeu.equals("Jeu2Facile")){
			this.modele.getMeilleursScores().getJeu2().getScoreFacile().setScore(nom,temps);
		}
		if(jeu.equals("Jeu2Moyen")){
			this.modele.getMeilleursScores().getJeu2().getScoreMoyen().setScore(nom,temps);
		}
		if(jeu.equals("Jeu2Difficile")){
			this.modele.getMeilleursScores().getJeu2().getScoreDifficile().setScore(nom,temps);
		}
		if(jeu.equals("Jeu3Facile")){
			this.modele.getMeilleursScores().getJeu3().getScoreFacile().setScore(nom,temps);
		}
		if(jeu.equals("Jeu3Moyen")){
			this.modele.getMeilleursScores().getJeu3().getScoreMoyen().setScore(nom,temps);
		}
		if(jeu.equals("Jeu3Difficile")){
			this.modele.getMeilleursScores().getJeu3().getScoreDifficile().setScore(nom,temps);
		}
		// Avertir un changement du modèle.
		this.modele.notifyObservateur();
		// Persistance des données.
		this.modele.serializer();
	}
	
}

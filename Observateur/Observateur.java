package Observateur;

import Modele.MeilleursScores;

/**
 * Interface Observateur du modèle Observable.
 * Avertir les observateurs d'un changement de l'observable pour effectuer une mise à jour.
 *
 * @author COULIDIATI Donald
 * @author BEN YAHIA Heidy
 */
public interface Observateur {
	
	public void miseAJour(MeilleursScores meilleursScores);

}

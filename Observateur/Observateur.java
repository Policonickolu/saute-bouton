package Observateur;

import Modele.MeilleursScores;

/**
 * Interface Observateur du mod�le Observable.
 * Avertir les observateurs d'un changement de l'observable pour effectuer une mise � jour.
 *
 * @author COULIDIATI Donald
 * @author BEN YAHIA Heidy
 */
public interface Observateur {
	
	public void miseAJour(MeilleursScores meilleursScores);

}

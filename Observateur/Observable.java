package Observateur;

/**
 * Interface Observable du modèle Observable.
 * Avertir les observateurs d'un changement de l'observable pour effectuer une mise à jour.
 *
 * @author COULIDIATI Donald
 * @author BEN YAHIA Heidy
 */
public interface Observable {
	
	public void notifyObservateur();
	public void addObservateur(Observateur o);
	public void removeObservateur();

}

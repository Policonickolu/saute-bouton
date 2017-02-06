package Modele;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Observateur.Observable;
import Observateur.Observateur;

/**
 * Modèle du programme.
 * Gestion des scores réalisés par joueurs.
 *
 * @author COULIDIATI Donald
 * @author BEN YAHIA Heidy
 */
public class ModeleSauteBouton implements Observable, Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Tous les scores de tous les jeux. 
	 */
	private MeilleursScores meilleursScores;
	
	/**
	 * Liste des Observateurs (comme la vue).
	 */
	private ArrayList<Observateur> listeObservateur = new ArrayList<Observateur>();
	
	/**
	 * Constructeur.
	 */
	public ModeleSauteBouton(){
		
		this.meilleursScores = new MeilleursScores();
		
	}
	
	/**
	 * Récupère les scores de tous les jeux. 
	 * @return les scores de tous les jeux. 
	 */
	public MeilleursScores getMeilleursScores() {
		return meilleursScores;
	}
	
	/**
	 * remplace les scores de tous les jeux.
	 * @param meilleursScores
	 */
	public void setMeilleursScores(MeilleursScores meilleursScores) {
		this.meilleursScores = meilleursScores;
	}
	
	/**
	 * Efface tous les scores.
	 */
	public void effacerScore() {
		this.meilleursScores = new MeilleursScores();
		this.notifyObservateur();
	}

	/**
	 * Avertir les observateurs que le modèle a changé et qu'ils doivent se mettre à jour.
	 */
	public void notifyObservateur() {
		for(Observateur o : listeObservateur)
			o.miseAJour(this.meilleursScores);		
	}

	/**
	 * Ajouter un observateur de la liste.
	 */
	public void addObservateur(Observateur o) {
		this.listeObservateur.add(o);		
	}

	/**
	 * Retirer un observateur de la liste.
	 */
	public void removeObservateur() {
		listeObservateur = new ArrayList<Observateur>();		
	}
	
	/**
	 * Sérialise les données dans un fichier.
	 */
	public void serializer(){
		
		try {
			FileOutputStream fos = new FileOutputStream("sautebouton.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.meilleursScores);
			oos.flush();
			oos.close();
		}
		catch (java.io.IOException e) {}
		
	}
	
	/**
	 * Désérialise les données d'un fichier dans un objet MeilleursScores.
	 */
	public void deserializer(){
		
		try {
			FileInputStream fis = new FileInputStream("sautebouton.ser");

		    ObjectInputStream ois = new ObjectInputStream(fis);
		    MeilleursScores msb = (MeilleursScores) ois.readObject();
		    
		    this.meilleursScores = msb;
		} 
		catch (java.io.IOException e) {}
		catch (ClassNotFoundException e) {}
		this.notifyObservateur();
	}
	
	
}
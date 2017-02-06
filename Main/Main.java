package Main;

import Controleur.ControleurSauteBouton;
import Modele.ModeleSauteBouton;
import Vue.VueSauteBouton;

/**
 * Classe main pour lancer le programme.
 *
 * @author COULIDIATI Donald
 * @author BEN YAHIA Heidy
 */
public class Main {
	
	 

	/**
	 * Méthode main pour lancer le programme.
	 * @param args
	 */
	public static void main(String[] args){
		
		// Création du modèle.
		ModeleSauteBouton msb = new ModeleSauteBouton();
		// Création du contrôleur. Relie le modèle.
		ControleurSauteBouton csba = new ControleurSauteBouton(msb);
		// Création de la vue. Relie le contrôleur.
		VueSauteBouton vsb = new VueSauteBouton(csba);
		// Relie le modèle à la vue.
		msb.addObservateur(vsb);
		// Persistance des données. Récupération des données au démarrage. 
		msb.deserializer();
		
	}
	

	
}

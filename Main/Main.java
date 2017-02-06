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
	 * M�thode main pour lancer le programme.
	 * @param args
	 */
	public static void main(String[] args){
		
		// Cr�ation du mod�le.
		ModeleSauteBouton msb = new ModeleSauteBouton();
		// Cr�ation du contr�leur. Relie le mod�le.
		ControleurSauteBouton csba = new ControleurSauteBouton(msb);
		// Cr�ation de la vue. Relie le contr�leur.
		VueSauteBouton vsb = new VueSauteBouton(csba);
		// Relie le mod�le � la vue.
		msb.addObservateur(vsb);
		// Persistance des donn�es. R�cup�ration des donn�es au d�marrage. 
		msb.deserializer();
		
	}
	

	
}

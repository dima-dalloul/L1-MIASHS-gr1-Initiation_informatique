package paquetagePrincipal;

import java.util.Scanner;

public class ClassePrincipale {

	public static void main(String[] args) {
		int resultat = 10;
		int[] tableau = {1,2,3,4,5,6,7};
		String hello = "Coucou ici";
		String[] tableau_mots = {"Hello", "World"};
		double decimal = 2.5;
		boolean assertion = true;
		float f = 1234559875;
		
		// J'affiche = J'imprime dans la console vers l'extérieur
		System.out.println(hello);
		
		// Je reçois uene entrée
		Scanner toto = new Scanner (System.in);
		hello = toto.nextLine();
		
		// J'affiche le résultat de la saisie de l'utilisateur		
		System.out.println("Vous avez écrit : " + hello);
	}
}
 

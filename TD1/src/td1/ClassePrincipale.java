package td1;

import java.util.Scanner;

public class ClassePrincipale {
	
	public static void main(String[] args) {
		//exercice1();
		
		//exercice2();
		
		exercice3();
		
		//exercice4();
		
		//exercice5();
	}
	
	/*
	 * Ecrire un programme Java qui lit un entier (int) et qui affiche son carré. Exemple (ce qui est en gras a été saisi par l'utilisateur). :
	 * Entrez un entier : 5
	 * Le carré de 5 est 25.
	 */
	public static void exercice1() {
		// Étape 1 : déclaration des variables
		int nombreUtilisateur, resultat;
		
		// Étape 2 : récupération des données de la part de l'utilisateur
		Scanner toto = new Scanner(System.in);
		
		System.out.println("Entrez un entier :");
		
		nombreUtilisateur = toto.nextInt();
		
		// Étape 3 : réalisation du calcul demandé dans l'énoncé
		resultat = nombreUtilisateur * nombreUtilisateur;
		
		// Étape 4 : Affichage du résultat pour l'utilisateur
		System.out.println("Le carré de " + nombreUtilisateur + " est " + resultat);
	}
	
	/**
	 * Écrire un programme Java qui lit la largeur et la hauteur d’un mur ainsi que la surface que couvre un pot de peinture
	 * et qui indique le nombre entier de pots à prévoir pour peindre le mur. Vous pouvez utiliser la fonction Math.ceil()
	 * qui arrondit à l’entier supérieur. Exemple (ce qui est en gras a été saisi par l’utilisateur) :
	 * Largeur en m :5.5 (ou 5,5 selon la configuration de votre ordinateur)
	 * Hauteur en m : 2.4
	 * Surface couverte par un pot en m² : 6
	 * Vous devez prévoir 3 pots pour couvrir les 13.2 m².
	 */
	public static void exercice2() {
		// Étape 1 : déclaration des variables
		double largeur, hauteur, surfaceParPot, surfaceTotale, resultat, nombrePots;

		// Étape 2 : récupération des données de la part de l'utilisateur
		Scanner s = new Scanner(System.in);
		
		System.out.print("Largeur en m : ");
		largeur = s.nextDouble();
		
		System.out.print("Hauteur en m : ");
		hauteur = s.nextDouble();
		
		System.out.print("Surface couverte par un pot en m² : ");
		surfaceParPot = s.nextDouble();

		// Étape 3 : réalisation du calcul demandé dans l'énoncé
		surfaceTotale = largeur * hauteur;
		resultat = surfaceTotale / surfaceParPot;
		nombrePots = Math.ceil(resultat);

		// Étape 4 : Affichage du résultat pour l'utilisateur
		System.out.print("Vous devez prévoir " + nombrePots + " pots pour couvrir les " +  surfaceTotale + " m²");;
	}
	
	/**
	 * Écrire un programme Java qui lit 5 nombres et qui affiche leur moyenne et leur écart-type (rappel ici). Ce
	 * programme doit fonctionner avec n'importe quelles valeurs ! Ce qui est ci-dessous est juste un exemple, il ne
	 * faut pas utiliser ces valeurs particulières (ce qui est en gras a été saisi par l'utilisateur). La racine carrée
	 * s'écrit Math.sqrt(…).
	 * Valeur 1 : 3
	 * Valeur 2 : 2
	 * Valeur 3 : 5
	 * Valeur 4 : 9
	 * Valeur 5 : 2
	 * La moyenne est 4.2, l'écart-type est 2.638.
	 */
	public static void exercice3() {
		// Étape 1 : déclaration des variables
		float nombre1, nombre2, nombre3, nombre4, nombre5;
		double moyenne, ecartType;

		// Étape 2 : récupération des données de la part de l'utilisateur
		System.out.println("Valeur 1 : ");
		Scanner s = new Scanner(System.in);
		nombre1 = Math.abs(s.nextFloat());
		
		System.out.println("Valeur 2 : ");
		nombre2 = Math.abs(s.nextFloat());
		
		System.out.println("Valeur 3 : ");
		nombre3 = Math.abs(s.nextFloat());
		
		System.out.println("Valeur 4 : ");
		nombre4 = Math.abs(s.nextFloat());
		
		System.out.println("Valeur 5 : ");
		nombre5 = Math.abs(s.nextFloat());

		// Étape 3 : réalisation du calcul demandé dans l'énoncé
		moyenne = (nombre1 + nombre2 + nombre3 + nombre4 + nombre5) / 5;
		ecartType = Math.sqrt(
				(		((nombre1 - moyenne) * (nombre1 - moyenne)) + 
						((nombre2 - moyenne) * (nombre2 - moyenne)) + 
						((nombre3 - moyenne) * (nombre3 - moyenne)) + 
						((nombre4 - moyenne) * (nombre4 - moyenne)) + 
						((nombre5 - moyenne) * (nombre5 - moyenne))
						) / 5
				);


		// Étape 4 : Affichage du résultat pour l'utilisateur
		System.out.println("La moyenne est "+moyenne+" et l'écart-type est "+ecartType+".");
	}

	/**
	 * Écrire un programme Java qui convertit en entier un nombre binaire sur 4 bits dont on donne séparément les
	 * 4 chiffres. Exemple :
	 * Conversion en entier d'un nombre binaire de 4 bits.
	 * Entrez le premier chiffre binaire (le plus à gauche) : 1
	 * Entrez le second chiffre binaire : 1
	 * Entrez le troisième chiffre binaire : 0
	 * Entrez le quatrième chiffre binaire : 1
	 * Le nombre 1101 correspond à l'entier 13.
	 */
	public static void exercice4() {
		// Étape 1 : déclaration des variables
		int b1, b2, b3, b4, resultat;

		// Étape 2 : récupération des données de la part de l'utilisateur
		System.out.print("Entrez le premier chiffre binaire (le plus à gauche) : ");
		Scanner scanner = new Scanner(System.in);
		b1 = scanner.nextInt();
		
		System.out.print("Entrez le deuxième chiffre binaire : ");
		b2 = scanner.nextInt();
		
		System.out.print("Entrez le troisième chiffre binaire : ");
		b3 = scanner.nextInt();
		
		System.out.print("Entrez le quatrième chiffre binaire : ");
		b4 = scanner.nextInt();

		// Étape 3 : réalisation du calcul demandé dans l'énoncé
		resultat = b1*8 + b2*4 + b3*2 + b4;

		// Étape 4 : Affichage du résultat pour l'utilisateur
		System.out.println("Le nombre " + b1 + b2 + b3 + b4 + " correspond à l'entier " + resultat + ".");
	}
	
	/**
	 * Écrire un programme Java qui lit en une fois un entier de 4 chiffres et qui affiche séparément chacun de ses
	 * chiffres. Exemple :
	 * Entrez un entier de 4 chiffres : 8409
	 * Les chiffres sont 8, 4, 0 et 9.
	 */
	public static void exercice5() {
		// Étape 1 : déclaration des variables
		int entierUtilisateur, chiffre1, chiffre2, chiffre3, chiffre4;

		// Étape 2 : récupération des données de la part de l'utilisateur
		System.out.print("Entrez un entier : ");
		Scanner s = new Scanner(System.in);
		entierUtilisateur = s.nextInt();

		// Étape 3 : réalisation du calcul demandé dans l'énoncé
		chiffre1 = entierUtilisateur/1000;
		chiffre2 = (entierUtilisateur/100) %10;
		chiffre3 = (entierUtilisateur/10) %10;
		chiffre4 = entierUtilisateur % 10;

		// Étape 4 : Affichage du résultat pour l'utilisateur
		System.out.println("Les chiffres sont " + chiffre1 + ", " + chiffre2 + ", " + chiffre3 + ", " + chiffre4 + ".");
	}
}

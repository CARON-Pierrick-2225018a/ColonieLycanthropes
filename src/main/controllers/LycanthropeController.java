package main.controllers;

import main.models.Lycanthrope;

import java.util.Scanner;

public class LycanthropeController {
    private static Lycanthrope lycanthrope; // L'instance de la classe Lycanthrope
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialisation d'un lycanthrope (vous pouvez ajouter votre propre logique ici)
        lycanthrope = new Lycanthrope("GardeNuit", "Mâle", "Adulte", 80, 5, 2, 7, "MeuteAlpha");

        // Affichage du menu
        afficherMenu();
    }

    private static void afficherMenu() {
        int choix;
        do {
            System.out.println("\nMenu Lycanthrope");
            System.out.println("1. Afficher les informations du lycanthrope");
            System.out.println("2. Quitter");

            System.out.print("Faites votre choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    afficherInformationsLycanthrope();
                    break;
                case 2:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 2);
    }

    private static void afficherInformationsLycanthrope() {
        System.out.println(lycanthrope.toString());
    }
}

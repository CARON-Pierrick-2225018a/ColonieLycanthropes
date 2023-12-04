package main.controllers;

import main.models.Lycanthrope;

import java.util.Scanner;

public class LycanthropeController {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        afficherMenu();
    }

    private static void afficherMenu() {
        int choix;
        do {
            System.out.println("\nMenu Lycanthrope");
            System.out.println("1. Afficher les informations du lycanthrope");
            System.out.println("2. Ajouter un nouveau loup-garou");
            System.out.println("3. Choisir un loup-garou");
            System.out.println("4. Afficher le menu d'action");
            System.out.println("0. Quitter");

            System.out.print("Faites votre choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    Lycanthrope.afficherInformationsLycanthropes();
                    break;
                case 2:
                    Lycanthrope.ajouterLoupGarou();
                    break;
                case 3:
                    Lycanthrope.choisirLoupGarou();
                    break;
                case 4:
                    //Lycanthrope.afficherMenuActions(lycanthrope);
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 0);
    }

}

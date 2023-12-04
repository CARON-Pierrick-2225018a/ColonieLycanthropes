package main.views;

import main.initialize.InitializeData;
import main.models.Lycanthrope;

import java.util.Objects;
import java.util.Scanner;

public class MenuView {
    public static void menuView() {
        System.out.println("\nMenu Lycanthrope");
        System.out.println("1. Afficher la liste des lycanthropes");
        System.out.println("2. Afficher les informations d'un lycanthrope");
        System.out.println("3. Ajouter un nouveau loup-garou");
        System.out.println("4. Choisir un loup-garou");
        System.out.println("5. Afficher le menu d'action");
        System.out.println("6. Afficher la liste des meutes");
        System.out.println("0. Quitter");

        System.out.print("Faites votre choix : ");
    }

    public static void afficherMenuAction(Lycanthrope lycanthrope) {
        System.out.println("\nMenu d'actions pour " + lycanthrope.getNom());
        System.out.println("1. Hurler pour communiquer ");
        System.out.println("2. Entendre un hurlement");
        System.out.println("3. Afficher les données du loup ");
        System.out.println("4. Séparer de la meute ");
        System.out.println("5. Se transformer en humain ");
        System.out.println("6. Se transformer en loup  ");
        System.out.println("7. Choisir un autre Loup ");
        System.out.println("0. Retour au menu principal");

        System.out.print("Faites votre choix : ");
    }

    public static void affichierChoixInitAuto() {
        System.out.print("Voulez-vous initialiser le jeu automatiquement (o/n): ");
        if (!Objects.equals(new Scanner(System.in).nextLine(), "n")) {
            InitializeData.initialisationDesLycanthropes();
        }
    }
}

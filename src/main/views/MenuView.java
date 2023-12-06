package main.views;

import main.initialize.InitializeData;
import main.models.Lycanthrope;
import main.models.Meute;
import main.models.Temps;

import java.util.Objects;
import java.util.Scanner;

public class MenuView {
    public static void menuView() {
        System.out.println("\nMenu Lycanthrope");
        Temps.getDate();
        System.out.println("1. Afficher la liste des lycanthropes");
        System.out.println("2. Afficher les informations d'un lycanthrope");
        System.out.println("3. Ajouter un nouveau lycanthrope");
        System.out.println("4. Choisir un lycanthrope");
        System.out.println("5. Afficher la liste des meutes");
        System.out.println("6. Afficher les informations d'une meute");
        System.out.println("7. Ajouter une nouvelle meute");
        System.out.println("8. Choisir une meute");
        System.out.println("0. Quitter");

        System.out.print("Faites votre choix : ");
    }

    public static void afficherMenuActionPourLycanthropes(Lycanthrope lycanthrope) {
        System.out.println("\nMenu d'actions pour " + lycanthrope.getNom());
        Temps.getDate();
        System.out.println("1. Hurler pour communiquer ");
        System.out.println("2. Entendre un hurlement");
        System.out.println("3. Afficher les informations du lycanthrope ");
        System.out.println("4. Séparer de la meute ");
        System.out.println("5. Se transformer en humain ");
        System.out.println("6. Se transformer en lycanthrope  ");
        System.out.println("7. Choisir un autre lycanthrope ");
        System.out.println("0. Retour au menu principal");

        System.out.print("Faites votre choix : ");
    }

    public static void afficherMenuActionPourMeutes(Meute meute) {
        System.out.println("\nMenu d'actions pour meute " + meute.getNom());
        Temps.getDate();
        System.out.println("1. Afficher les informations de la meute ");
        System.out.println("2. Ajouter un lycanthrope ");
        System.out.println("3. Enlever un lycanthrope ");
        System.out.println("4. Mettre un lycanthrope au rang ω ");
        System.out.println("5. Choisir une autre meute ");
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

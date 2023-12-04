package main.views;

import main.models.Lycanthrope;

public class MenuView {
    public static void menuView() {
        System.out.println("\nMenu Lycanthrope");
        System.out.println("1. Afficher les informations du lycanthrope");
        System.out.println("2. Ajouter un nouveau loup-garou");
        System.out.println("3. Choisir un loup-garou");
        System.out.println("4. Afficher le menu d'action");
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
}

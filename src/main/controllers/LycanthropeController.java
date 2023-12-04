package main.controllers;

import main.commun.Check;
import main.models.Lycanthrope;
import main.views.MenuView;

public class LycanthropeController {

    public static void afficherMenu() {
        int choix;
        do {
            MenuView.menuView();
            choix = Check.checkIfEntreeIsInt();
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

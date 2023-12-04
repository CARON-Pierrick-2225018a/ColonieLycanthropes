package main.controllers;

import main.common.Check;
import main.models.Lycanthrope;
import main.views.LycanthropeView;
import main.views.MenuView;

public class MenuViewController {
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

    // Méthode pour afficher un menu d'actions pour un loup-garou choisi
    public static void afficherMenuActions(Lycanthrope lycanthrope) {
        int choix;
        do {
            MenuView.afficherMenuAction(lycanthrope);
            choix = Check.checkIfEntreeIsInt();
            switch (choix) {
                case 1:
                    lycanthrope.hurlerPourCommuniquer(); // Appeler la méthode d'action spécifique du loup-garou
                    break;
                case 2:
                    lycanthrope.entendreHurlement(); // Appeler une autre méthode d'action spécifique du loup-garou
                    break;
                case 3:
                    LycanthropeView.afficherDonner(lycanthrope); // Appeler une autre méthode d'action spécifique du loup-garou
                    break;
                case 4:
                    lycanthrope.seSeparerDeMeute();
                    break;
                case 5:
                    lycanthrope.seTransformerEnHumain();
                    break;
                case 6:
                    lycanthrope.seTransformerEnLoup();
                    break;
                case 7:
                    System.out.println("Retour au menu principal.");
                    break;
                case 8:
                    lycanthrope.choisirLoupGarou();
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 8);
    }
}

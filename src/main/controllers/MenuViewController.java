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
            Lycanthrope lycanthropeChoisi;
            switch (choix) {
                case 1:
                    LycanthropeView.afficherListeLycanthropes();
                    break;
                case 2:
                    lycanthropeChoisi = LycanthropeView.choisirLoupGarou();
                    LycanthropeView.afficherDonner(lycanthropeChoisi);
                    break;
                case 3:
                    Lycanthrope.ajouterLoupGarou();
                    break;
                case 4:
                    lycanthropeChoisi = LycanthropeView.choisirLoupGarou();
                    if (lycanthropeChoisi!=null){
                        MenuViewController.afficherMenuDUnLycanthrope(lycanthropeChoisi);
                    } else {
                        System.out.println("Il n'y a pas de lycanthropes");
                    }
                    break;
                case 5:
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
    public static void afficherMenuDUnLycanthrope(Lycanthrope lycanthrope) {
        int choix;
        do {
            MenuView.afficherMenuAction(lycanthrope);
            choix = Check.checkIfEntreeIsInt();
            switch (choix) {
                case 0:
                    System.out.println("Retour au menu principal.");
                    break;
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
                    LycanthropeView.choisirLoupGarou();
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 0);
    }
}

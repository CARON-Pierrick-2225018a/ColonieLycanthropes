package main.controllers;

import main.common.Check;
import main.models.Lycanthrope;
import main.models.Meute;
import main.models.Temps;
import main.views.LycanthropeView;
import main.views.MenuView;
import main.views.MeuteView;
import java.util.Objects;

public class MenuViewController {
    public static void afficherMenu() {
        int choix;
        do {
            MenuView.menuView();
            choix = Check.checkIfEntreeIsInt();
            Lycanthrope lycanthropeChoisi;
            Meute meuteChoisi;
            switch (choix) {
                // Afficher la liste des lycanthropes
                case 1:
                    LycanthropeView.afficherListeLycanthropes(Lycanthrope.getInstancesLycanthropes());
                    break;
                // Affiche les informations d'un Lycanthrope
                case 2:
                    lycanthropeChoisi = LycanthropeView.choisirLoupGarou();
                    if (lycanthropeChoisi!=null) {
                        System.out.println(lycanthropeChoisi);
                    }
                    break;
                // Ajouter un lycanthrope
                case 3:
                    Lycanthrope.ajouterLoupGarou();
                    Temps.passerUnJour();
                    break;
                // Choisir un lycanthrope
                case 4:
                    lycanthropeChoisi = LycanthropeView.choisirLoupGarou();
                    if (lycanthropeChoisi!=null){
                        MenuViewController.afficherMenuDUnLycanthrope(lycanthropeChoisi);
                    }
                    break;
                // Afficher la liste des meutes
                case 5:
                    MeuteView.afficherListeMeutes();
                    break;
                // Afficher les informations d'une meute
                case 6:
                    meuteChoisi = MeuteView.choisirMeute();
                    if (!Objects.equals(meuteChoisi,null)){
                        System.out.println(meuteChoisi);
                    }
                    break;
                // Ajouter une nouvelle meute
                case 7:
                    Meute.ajouterMeute();
                    Temps.passerDuTemps(2);
                    break;
                // Choisir une meute
                case 8:
                    Meute meute = MeuteView.choisirMeute();
                    if (!Objects.equals(meute, null)){
                        afficherMenuDUneMeute(meute);
                    }
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
            MenuView.afficherMenuActionPourLycanthropes(lycanthrope);
            choix = Check.checkIfEntreeIsInt();
            switch (choix) {
                case 0:
                    System.out.println("Retour au menu principal.");
                    break;
                case 1:
                    lycanthrope.hurlerPourCommuniquer(); // Appeler la méthode d'action spécifique du loup-garou
                    Temps.passerUnJour();
                    break;
                case 2:
                    lycanthrope.entendreHurlement(); // Appeler une autre méthode d'action spécifique du loup-garou
                    Temps.passerUnJour();
                    break;
                case 3:
                    System.out.println(lycanthrope);
                    break;
                case 4:
                    lycanthrope.seSeparerDeMeute();
                    Temps.passerUnJour();
                    break;
                case 5:
                    lycanthrope.seTransformerEnHumain();
                    Temps.passerUnJour();
                    break;
                case 6:
                    lycanthrope.seTransformerEnLoup();
                    Temps.passerUnJour();
                    break;
                case 7:
                    Lycanthrope lycanthropeChoisi = LycanthropeView.choisirLoupGarou();
                    if (!Objects.equals(lycanthropeChoisi, null)) {
                        choix=0;
                        afficherMenuDUnLycanthrope(lycanthropeChoisi);
                    }
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 0);
    }

    // Méthode pour afficher un menu d'actions pour un loup-garou choisi
    public static void afficherMenuDUneMeute(Meute meute) {
        int choix;
        do {
            MenuView.afficherMenuActionPourMeutes(meute);
            choix = Check.checkIfEntreeIsInt();
            switch (choix) {
                case 0:
                    System.out.println("Retour au menu principal.");
                    break;
                // Afficher les informations de la meute
                case 1:
                    System.out.println(meute); // Appeler la méthode d'action spécifique du loup-garou
                    break;
                // Ajouter un lycanthrope à la meute
                case 2:
                    meute.ajouterUnLycanthropeALaMeute(Objects.requireNonNull(LycanthropeView.choisirLoupGarouSansMeute()));
                    Temps.passerUnJour();
                    break;
                // Enlever un lycanthrope à la meute
                case 3:
                    meute.enleverUnLycanthropeALaMeute(Objects.requireNonNull(LycanthropeView.choisirLoupGarouDeLaListe(meute.getTousLesLycanthropesDeLaMeute())));
                    Temps.passerUnJour();
                    break;
                // Mettre un lycanthrope au rang ω
                case 4:
                    System.out.println("Quel lycanthrope voulez-vous mettre au rang ω :");
                    Lycanthrope lycanthropeChoisi = LycanthropeView.choisirLoupGarouDeLaListe(meute.getLycanthropesDeLaMeute());
                    if (!Objects.equals(lycanthropeChoisi, null)){
                        Objects.requireNonNull(lycanthropeChoisi).setRangDomination(Lycanthrope.typesRangDomination.size()-1);
                        System.out.println(lycanthropeChoisi.getNom()+" a été mis au rang ω");
                    }
                    break;
                // Choisir une autre meute
                case 5:
                    Meute meuteChoisi = MeuteView.choisirMeute();
                    if (!Objects.equals(meuteChoisi, null)){
                        choix=0;
                        afficherMenuDUneMeute(meuteChoisi);
                    }
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 0);
    }
}

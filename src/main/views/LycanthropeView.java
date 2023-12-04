package main.views;

import main.models.Lycanthrope;

public class LycanthropeView {
    // Méthode d'action spécifique du loup-garou (exemple)
    public static void afficherDonner(Lycanthrope lycanthropeChoisi) {
        if (lycanthropeChoisi != null) {
            System.out.println(lycanthropeChoisi.toString());
        } else {
            System.out.println("Aucun loup-garou choisi.");
        }
    }
}

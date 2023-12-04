package main.views;

import main.common.Check;
import main.controllers.MenuViewController;
import main.models.Lycanthrope;

import java.util.List;

public class LycanthropeView {
    // Méthode d'action spécifique du loup-garou (exemple)
    public static void afficherDonner(Lycanthrope lycanthropeChoisi) {
        if (lycanthropeChoisi != null) {
            System.out.println(lycanthropeChoisi);
        } else {
            System.out.println("Aucun loup-garou choisi.");
        }
    }

    public static void afficherInformationsLycanthropes() {
        if (Lycanthrope.getInstancesLycanthropes().isEmpty()) {
            System.out.println("Aucun loup-garou à afficher.");
        } else {
            System.out.println("Liste des loup-garous :");
            Lycanthrope lycanthrope;
            for (int i = 0; i < Lycanthrope.getInstancesLycanthropes().size(); i++) {
                lycanthrope = Lycanthrope.getInstancesLycanthropes().get(i);
                System.out.println(i + 1 + ". " + lycanthrope.getNom() + " (" + lycanthrope.getSexe() + ")");
            }
        }
    }

    public static void choisirLoupGarou() {
        LycanthropeView.afficherInformationsLycanthropes();
        List<Lycanthrope> instancesLycanthropes = Lycanthrope.getInstancesLycanthropes();

        if (!instancesLycanthropes.isEmpty()) {
            int choixLoupGarou;

            if (instancesLycanthropes.size() == 1) {
                // S'il n'y a qu'un loup-garou, le choisissez automatiquement
                choixLoupGarou = 1;
                System.out.println("Il n'y a qu'un loup-garou disponible. Choix automatique.");
            } else {
                System.out.print("Choisissez le numéro du loup-garou que vous souhaitez : ");
                choixLoupGarou = Check.checkIfEntreeIsInt();
            }

            if (choixLoupGarou >= 1 && choixLoupGarou <= instancesLycanthropes.size()) {
                // L'utilisateur a choisi un loup-garou valide
                Lycanthrope lycanthropeChoisi = instancesLycanthropes.get(choixLoupGarou - 1);
                // Ajoutez ici le code pour effectuer d'autres actions avec le loup-garou choisi
                System.out.println("Le loup-garou choisit est : " + lycanthropeChoisi.getNom());
                MenuViewController.afficherMenuDUnLycanthrope(lycanthropeChoisi);
            } else {
                System.out.println("Numéro invalide. Veuillez réessayer.");
            }
        } else {
            System.out.println("Aucun loup-garou disponible.");
        }
    }
}

package main.views;

import main.common.Check;
import main.models.Lycanthrope;

import java.util.List;

public class LycanthropeView {
    // Méthode d'action spécifique du lycanthrope (exemple)
    public static void afficherDonner(Lycanthrope lycanthropeChoisi) {
        if (lycanthropeChoisi != null) {
            System.out.println(lycanthropeChoisi);
        } else {
            System.out.println("Aucun lycanthrope choisi.");
        }
    }

    public static void afficherListeLycanthropes() {
        if (Lycanthrope.getInstancesLycanthropes().isEmpty()) {
            System.out.println("Aucun lycanthrope à afficher.");
        } else {
            System.out.println("Liste des lycanthropes :");
            Lycanthrope lycanthrope;
            for (int i = 0; i < Lycanthrope.getInstancesLycanthropes().size(); i++) {
                lycanthrope = Lycanthrope.getInstancesLycanthropes().get(i);
                System.out.println(i + 1 + ". " + lycanthrope.getNom() + " (" + lycanthrope.getSexe() + ")");
            }
        }
    }

    public static Lycanthrope choisirLoupGarou() {
        List<Lycanthrope> instancesLycanthropes = Lycanthrope.getInstancesLycanthropes();
        if (!instancesLycanthropes.isEmpty()) {
            LycanthropeView.afficherListeLycanthropes();

            int choixLoupGarou;

            if (instancesLycanthropes.size() == 1) {
                // S'il n'y a qu'un lycanthrope, le choisissez automatiquement
                choixLoupGarou = 1;
                System.out.println("Il n'y a qu'un lycanthrope disponible. Choix automatique.");
            } else {
                System.out.print("Choisissez le numéro du lycanthrope que vous souhaitez : ");
                choixLoupGarou = Check.checkIfEntreeIsInt();
            }

            if (choixLoupGarou >= 1 && choixLoupGarou <= instancesLycanthropes.size()) {
                // L'utilisateur a choisi un lycanthrope valide
                Lycanthrope lycanthropeChoisi = instancesLycanthropes.get(choixLoupGarou - 1);
                // Ajoutez ici le code pour effectuer d'autres actions avec le lycanthrope choisi
                System.out.println("Le lycanthrope choisit est : " + lycanthropeChoisi.getNom());
                return lycanthropeChoisi;
            } else {
                System.out.println("Numéro invalide. Veuillez réessayer.");
            }
        } else {
            System.out.println("Aucun lycanthrope disponible.");
        }
        return null;
    }
}

package main.views;

import main.common.Check;
import main.models.Lycanthrope;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LycanthropeView {
    public static void afficherListeLycanthropes(List<Lycanthrope> listLycanthrope) {
        if (listLycanthrope.isEmpty()) {
            System.out.println("Aucun lycanthrope à afficher.");
        } else {
            System.out.println("Liste des lycanthropes :");
            for (int i = 0; i < listLycanthrope.size(); i++) {
                System.out.println("\t"+ (i + 1) + ". " + listLycanthrope.get(i).getNom() + " (" + listLycanthrope.get(i).getSexe() + ")" +
                        "(" + listLycanthrope.get(i).getRangDomination() + ")");
            }
        }
    }

    public static Lycanthrope choisirLoupGarou() {
        List<Lycanthrope> listLycanthropes = Lycanthrope.getInstancesLycanthropes();
        return choisirLoupGarouDeLaListe(listLycanthropes);
    }

    public static Lycanthrope choisirLoupGarouSansMeute() {
        List<Lycanthrope> listLycanthropes = new ArrayList<>();
        for (Lycanthrope lycanthrope : Lycanthrope.getInstancesLycanthropes()) {
            if (Objects.equals(lycanthrope.getMeute(), null)){
                listLycanthropes.add(lycanthrope);
            }
        }
        return choisirLoupGarouDeLaListe(listLycanthropes);
    }

    public static Lycanthrope choisirLoupGarouSelonSonSex(String sexe) {
        List<Lycanthrope> listLycanthropes = new ArrayList<>();
        for (Lycanthrope lycanthrope : Lycanthrope.getInstancesLycanthropes()) {
            if (Objects.equals(lycanthrope.getMeute(), null) && Objects.equals(lycanthrope.getSexe(), sexe)){
                listLycanthropes.add(lycanthrope);
            }
        }
        return choisirLoupGarouDeLaListe(listLycanthropes);
    }

    public static Lycanthrope choisirLoupGarouDeLaListe(List<Lycanthrope> listLycanthropes) {
        if (!listLycanthropes.isEmpty()) {
            LycanthropeView.afficherListeLycanthropes(listLycanthropes);

            int choixLoupGarou;

            if (listLycanthropes.size() == 1) {
                // S'il n'y a qu'un lycanthrope, le choisissez automatiquement
                choixLoupGarou = 1;
                System.out.println("Il n'y a qu'un lycanthrope disponible. Choix automatique.");
            } else {
                System.out.print("Choisissez le numéro du lycanthrope que vous souhaitez : ");
                choixLoupGarou = Check.checkIfEntreeIsInt();
            }

            if (choixLoupGarou >= 1 && choixLoupGarou <= listLycanthropes.size()) {
                // L'utilisateur a choisi un lycanthrope valide
                Lycanthrope lycanthropeChoisi = listLycanthropes.get(choixLoupGarou - 1);
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

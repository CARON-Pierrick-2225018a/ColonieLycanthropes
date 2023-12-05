package main.views;

import main.common.Check;
import main.models.Lycanthrope;
import main.models.Meute;

import java.util.List;
import java.util.Objects;

public class MeuteView {
    public static void afficherListeMeutes() {
        if (Meute.getInstancesMeutes().isEmpty()) {
            System.out.println("Aucun lycanthrope à afficher.");
        } else {
            System.out.println("Liste des meutes :");
            List<Meute> listMeutes = Meute.getInstancesMeutes();
            for (int i = 0; i < listMeutes.size(); i++) {
                System.out.println("\t"+ (i + 1) + ". " + listMeutes.get(i).getNom() + " (" + listMeutes.get(i).getTousLesLycanthropesDeLaMeute().size() + ")");
            }
        }
    }
    public static String afficherCoupleAlphaDeLaMeute(Meute meute) {
        StringBuilder afficheDesLycanthropes = new StringBuilder();
        int index = 1;
        for (Lycanthrope lycanthrope : meute.getCoupleAlpha()){
            afficheDesLycanthropes.append("\n\t").append(index == 1 ? "Le mâle α : " : "La femelle α : ")
                    .append(lycanthrope.getNom()).append(" (").append(lycanthrope.getSexe()).append(")");
            index++;
        }
        return afficheDesLycanthropes.toString();
    }
    public static String afficherLycanthropesDeLaMeute(Meute meute) {
        StringBuilder afficheDesLycanthropes = new StringBuilder();
        List<Lycanthrope> listLycanthropes = meute.getLycanthropesDeLaMeute();
        if (!Objects.equals(listLycanthropes, null)){
            for (Lycanthrope lycanthrope : listLycanthropes){
                afficheDesLycanthropes.append("\n\t").append(lycanthrope.getNom()).append(" (").append(lycanthrope.getSexe()).append(")");
            }
            return afficheDesLycanthropes.toString();
        } else {
            return "Pas de lycanthropes dans cette meute";
        }
    }

    public static Meute choisirMeute() {
        List<Meute> instancesMeutes = Meute.getInstancesMeutes();
        if (!instancesMeutes.isEmpty()) {
            MeuteView.afficherListeMeutes();

            int choixMeute;

            if (instancesMeutes.size() == 1) {
                // S'il n'y a qu'une meute, le choisissez automatiquement
                choixMeute = 1;
                System.out.println("Il n'y a qu'une meute disponible. Choix automatique.");
            } else {
                System.out.print("Choisissez le numéro de la meute que vous souhaitez : ");
                choixMeute = Check.checkIfEntreeIsInt();
            }

            if (choixMeute >= 1 && choixMeute <= instancesMeutes.size()) {
                // L'utilisateur a choisi un lycanthrope valide
                Meute meuteChoisi = instancesMeutes.get(choixMeute - 1);
                // Ajoutez ici le code pour effectuer d'autres actions avec le lycanthrope choisi
                System.out.println("La meute choisit est : " + meuteChoisi.getNom());
                return meuteChoisi;
            } else {
                System.out.println("Numéro invalide. Veuillez réessayer.");
            }
        } else {
            System.out.println("Aucune meute disponible.");
        }
        return null;
    }
}

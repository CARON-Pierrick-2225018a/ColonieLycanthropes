package main.views;

import main.models.Lycanthrope;
import main.models.Meute;

import java.util.List;
import java.util.Objects;

public class MeuteView {
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
}

package main.models;

import main.views.MeuteView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Meute {
    private String nom;
    private List<Lycanthrope> coupleAlpha = new ArrayList<>();
    private List<Lycanthrope> lycanthropesDeLaMeute = new ArrayList<>();
    private int forceDeMeute = 0;

    private static List<Meute> instancesMeutes = new ArrayList<>();

    public Meute(String nom, List<Lycanthrope> coupleAlpha, List<Lycanthrope> lycanthropesDeLaMeute) {
        if (Objects.equals(coupleAlpha.get(0).getSexe(), "M") && Objects.equals(coupleAlpha.get(1).getSexe(), "F")) {
            this.nom = nom;
            this.coupleAlpha = coupleAlpha;
            if (Objects.equals(lycanthropesDeLaMeute, null)) {
                this.lycanthropesDeLaMeute = new ArrayList<>();
            } else {
                this.lycanthropesDeLaMeute = lycanthropesDeLaMeute;
            }
            this.forceDeMeute = calculTotalForceMeute();
            instancesMeutes.add(this);
            ajoutDeLaMeutePourLesLycanthropes();
        }
    }

    private void ajoutDeLaMeutePourLesLycanthropes() {
        coupleAlpha.get(0).setMeute(this);
        coupleAlpha.get(1).setMeute(this);
        if (!Objects.equals(lycanthropesDeLaMeute, null)){
            for (Lycanthrope lycanthrope : lycanthropesDeLaMeute) {
                lycanthrope.setMeute(this);
            }
        }
    }

    public String getNom() {
        return nom;
    }

    public List<Lycanthrope> getCoupleAlpha() {
        return coupleAlpha;
    }

    public List<Lycanthrope> getLycanthropesDeLaMeute() {
        return lycanthropesDeLaMeute;
    }

    public int getForceDeMeute() {
        return forceDeMeute;
    }

    public List<Lycanthrope> getTousLesLycanthropesDeLaMeute() {
        List<Lycanthrope> listDeTousLesLycanthropesDeLaMeute = new ArrayList<>(List.of(coupleAlpha.get(0), coupleAlpha.get(1)));
        listDeTousLesLycanthropesDeLaMeute.addAll(lycanthropesDeLaMeute);
        return listDeTousLesLycanthropesDeLaMeute;
    }
    public static List<Meute> getInstancesMeutes() {
        return instancesMeutes;
    }

    private int calculTotalForceMeute() {
        int resultat=coupleAlpha.get(0).getForce()+coupleAlpha.get(1).getForce();
        if (!Objects.equals(lycanthropesDeLaMeute, null)){
            for (Lycanthrope lycanthrope : lycanthropesDeLaMeute) {
                resultat+=lycanthrope.getForce();
            }
        }

        return resultat;
    }

    public void ajouterUnLycanthropeALaMeute(Lycanthrope lycanthrope) {
        lycanthropesDeLaMeute.add(lycanthrope);
        lycanthrope.setMeute(this);
        this.forceDeMeute = calculTotalForceMeute();
    }

    //TODO :   d'afficher les caractéristiques des lycanthropes qu'elle contient
    // de créer une nouvelle hiérarchie de meute avec un ensemble de lycanthropes
    // de constituer un couple α en fonction d’un mâle α (et de déchoir l’éventuel ancien couple)
    // de lancer une reproduction de lycanthropes
    // de décroitre les rangs de domination des lycanthropes de la meute naturellement
    // de déclarer les lycanthropes ω
    // d’ajouter et d’enlever des lycanthropes

    @Override
    public String toString() {
        return "==========Meute===========" +
                "\nNom : " + nom +
                "\nCouple d'alpha : " + MeuteView.afficherCoupleAlphaDeLaMeute(this) +
                "\nListe des lycanthropes de la meute : " + MeuteView.afficherLycanthropesDeLaMeute(this) +
                "\nForce de meute : " + forceDeMeute +
                "\n=============================";
    }
}

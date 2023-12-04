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

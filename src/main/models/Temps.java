package main.models;

public class Temps {
    public static int jour = 1;
    public static int mois = 1;
    public static int annee = 2023;

    public static int getJour() {
        return jour;
    }

    public static void setJour(int jour) {
        Temps.jour = jour;
    }

    public static int getMois() {
        return mois;
    }

    public static void setMois(int mois) {
        Temps.mois = mois;
    }

    public static int getAnnee() {
        return annee;
    }

    public static void setAnnee(int annee) {
        Temps.annee = annee;
    }

    public static void passerDuTemps(int jours) {
        for (int i = 0; i<jour; i++){
            passerUnJour();
        }
    }

    public static void passer9Mois() {
        passerDuTemps(279);
    }

    public static void getDate() {
        System.out.println("Jour: "+jour+" Mois: "+mois+" Année: "+annee);
    }

    public static void passerUnJour() {
        if (jour < 31) {
            jour += 1;
        } else {
            jour = 1;
            if (mois < 12) {
                mois += 1;
            } else {
                mois = 1;
                annee += 1;
            }
        }
    }
}

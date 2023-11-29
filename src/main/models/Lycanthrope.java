package main.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lycanthrope {
    private static List<Lycanthrope> lycanthropes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private String nom;
    private String sexe;
    private String categorieAge;
    private int force;
    private int facteurDomination;
    private int rangDomination;
    private int niveau;
    private int facteurImpetuosite;
    private String meute;

    // Constructeur
    public Lycanthrope(String nom, String sexe, String categorieAge, int force, int facteurDomination, int rangDomination, int facteurImpetuosite, String meute) {
        this.nom = nom;
        this.sexe = sexe;
        this.categorieAge = categorieAge;
        this.force = force;
        this.facteurDomination = facteurDomination;
        this.rangDomination = rangDomination;
        this.niveau = calculerNiveau(); // Calcul du niveau en fonction des caractéristiques
        this.facteurImpetuosite = facteurImpetuosite;
        this.meute = meute;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getCategorieAge() {
        return categorieAge;
    }

    public void setCategorieAge(String categorieAge) {
        this.categorieAge = categorieAge;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getFacteurDomination() {
        return facteurDomination;
    }

    public void setFacteurDomination(int facteurDomination) {
        this.facteurDomination = facteurDomination;
    }

    public int getRangDomination() {
        return rangDomination;
    }

    public void setRangDomination(int rangDomination) {
        this.rangDomination = rangDomination;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getFacteurImpetuosite() {
        return facteurImpetuosite;
    }

    public void setFacteurImpetuosite(int facteurImpetuosite) {
        this.facteurImpetuosite = facteurImpetuosite;
    }

    public String getMeute() {
        return meute;
    }

    public void setMeute(String meute) {
        this.meute = meute;
    }
    // Méthode pour calculer le niveau en fonction des caractéristiques
    private int calculerNiveau() {
        // Exemple de calcul simple
        return force * rangDomination;
    }

    @Override
    public String toString() {
        return "==========Lycanthrope===========\n" +
                "\n\t nom='" + nom + '\'' +
                "\n\t sexe='" + sexe + '\'' +
                "\n\t categorieAge='" + categorieAge + '\'' +
                "\n\t force=" + force +
                "\n\t facteurDomination=" + facteurDomination +
                "\n\t rangDomination=" + rangDomination +
                "\n\t niveau=" + niveau +
                "\n\t facteurImpetuosite=" + facteurImpetuosite +
                "\n\t meute='" + meute + '\'' +
                "\n}\n" +
                "================================";
    }

}

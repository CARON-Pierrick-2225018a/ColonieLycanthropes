package main.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lycanthrope {
    private static List<Lycanthrope> instancesLycanthropes = new ArrayList<>();
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
    private boolean estEnTrainDeDormir;
    private boolean estMalade;
    private boolean aHurler;
    private String statut;

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
        this.estMalade = false;//Pas malade par default
        this.estEnTrainDeDormir = false;//Ne dors pas par default
        this.aHurler = false; // Par défault aucun loup n'a hurlé
        this.statut = "humain"; //Par défault, il est humain
        // Ajouter le nouveau loup-garou à la liste
        instancesLycanthropes.add(this);
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

    public static List<Lycanthrope> getInstancesLycanthropes() {
        return instancesLycanthropes;
    }

    // Méthode pour calculer le niveau en fonction des caractéristiques
    private int calculerNiveau() {
        // Exemple de calcul simple
        return force * rangDomination;
    }
    public boolean aHurle() {
        return aHurler;
    }
    // Méthode statique pour afficher les informations de tous les instancesLycanthropes


    // Méthode statique pour ajouter un nouveau loup-garou
    public static void ajouterLoupGarou() {
        System.out.print("Entrez le prénom du loup-garou : ");
        String nom = scanner.next();

        System.out.print("Entrez le sexe du loup-garou (M/F) : ");
        String sexe = scanner.next();

        // Validation de la saisie pour s'assurer que le sexe est M, m, F ou f
        while (!sexe.matches("[MmFf]")) {
            System.out.println("Saisie invalide. Veuillez entrer M, m, F ou f.");
            System.out.print("Entrez le sexe du loup-garou (M/F) : ");
            sexe = scanner.next();
        }

        // Vous pouvez ajouter d'autres saisies utilisateur pour les autres caractéristiques du loup-garou

        new Lycanthrope(nom, sexe, "Adulte", 0, 0, 0, 0, "Solitaire");

        System.out.println("Loup-garou ajouté avec succès !");
    }


    // Méthode d'action spécifique du loup-garou (exemple)
    public void hurlerPourCommuniquer() {
        System.out.println("Le loup-garou " + this.nom + " émet un hurlement pour communiquer avec d'autres instancesLycanthropes.");
        this.aHurler = true;
    }

    // Méthode d'action spécifique du loup-garou (exemple)
    public void entendreHurlement() {
        // Vérifier si au moins un loup a hurlé
        boolean auMoinsUnHurlement = false;
        for (Lycanthrope loup : instancesLycanthropes) {
            if (loup != this && loup.aHurle()) {
                auMoinsUnHurlement = true;
                break;
            }
        }

        if (!estEnTrainDeDormir && !estMalade && auMoinsUnHurlement) {
            System.out.println("Le loup-garou " + this.nom + " entend un hurlement.");

            // Exclure le loup-garou actuel de la liste des loup-garous à entendre
            List<Lycanthrope> loupGarousAEntendre = new ArrayList<>(instancesLycanthropes);
            loupGarousAEntendre.remove(this);

            // Simuler la réponse au hurlement pour chaque loup-garou à entendre
            for (Lycanthrope loupAGarder : loupGarousAEntendre) {
                System.out.println("Le loup-garou " + this.nom + " répond au hurlement de " + loupAGarder.getNom());
                this.aHurler=true;
            }
        } else {
            System.out.println("Le loup-garou " + this.nom + " ne peut pas entendre le hurlement car il dort, est malade ou aucun loup n'a hurlé.");
        }
    }

    public void seSeparerDeMeute() {
        if (this.meute != null) {
            System.out.println("Le loup-garou " + this.nom + " se sépare de sa meute.");
            this.meute = null;
        } else {
            System.out.println("Le loup-garou " + this.nom + " n'appartient actuellement à aucune meute.");
        }
    }
    public void seTransformerEnHumain() {
        if (!estHumain()) {
            System.out.println("Le loup-garou " + this.nom + " se transforme en humain.");
            this.statut = "humain"; // Mettez à jour le statut en humain
            // Ajoutez ici le code pour gérer la transformation en humain
        } else {
            System.out.println("Le loup-garou " + this.nom + " est déjà un humain.");
        }
    }

    public void seTransformerEnLoup() {
        if (!estLoup()) {
            System.out.println("Le loup-garou " + this.nom + " se transforme en loup.");
            this.statut = "loup"; // Mettez à jour le statut en loup
            // Ajoutez ici le code pour gérer la transformation en loup
        } else {
            System.out.println("Le loup-garou " + this.nom + " est déjà un loup.");
        }
    }

    // Méthode auxiliaire pour vérifier si le loup-garou est déjà un humain
    private boolean estHumain() {
        return this.statut.equals("humain");
    }

    // Méthode auxiliaire pour vérifier si le loup-garou est déjà un loup
    private boolean estLoup() {
        return this.statut.equals("loup");
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
                "\n\t Statut='" + statut + '\'' +
                "\n================================";
    }

}

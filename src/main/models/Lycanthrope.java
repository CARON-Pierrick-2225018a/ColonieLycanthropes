package main.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Lycanthrope {
    private static List<Lycanthrope> instancesLycanthropes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private String nom;
    private String sexe;
    private String categorieAge;
    private int force;
    private int facteurDomination;
    private Character rangDomination;
    private int niveau;
    private int facteurImpetuosite;
    private Meute meute;
    private boolean estEnTrainDeDormir;
    private boolean estMalade;
    private boolean aHurler;
    private String statut;
    public static final List<Character> typesRangDomination = new ArrayList<>(List.of(
            'α','β','γ','δ','ε','ζ','η','θ','ι','κ','λ','μ','ν','ξ','ο','π','ρ','σ','τ','υ','φ','χ','ψ','ω'
    ));
    public List<Lycanthrope> parents = new ArrayList<>(2);
    public List<Lycanthrope> enfants = new ArrayList<>();

    // Constructeur
    public Lycanthrope(String nom, String sexe, String categorieAge, int force, int facteurDomination, int rangDomination, int facteurImpetuosite) {
        this.nom = nom;
        this.sexe = sexe;
        this.categorieAge = categorieAge;
        this.force = force;
        this.facteurDomination = facteurDomination;
        this.rangDomination = typesRangDomination.get(rangDomination);
        this.niveau = calculerNiveau(); // Calcul du niveau en fonction des caractéristiques
        this.facteurImpetuosite = facteurImpetuosite;
        this.estMalade = false;//Pas malade par default
        this.estEnTrainDeDormir = false;//Ne dors pas par default
        this.aHurler = false; // Par défault aucun loup n'a hurlé
        this.statut = "humain"; //Par défault, il est humain
        // Ajouter le nouveau lycanthrope à la liste
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

    public Character getRangDomination() {
        return rangDomination;
    }

    public void setRangDomination(Character rangDomination) {
        this.rangDomination = rangDomination;
    }

    public void setRangDomination(int rangDomination) {
        this.rangDomination = typesRangDomination.get(rangDomination);
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

    public List<Lycanthrope> getParents() {
        return parents;
    }

    public void setParents(List<Lycanthrope> parents) {
        this.parents = parents;
    }

    public List<Lycanthrope> getEnfants() {
        return enfants;
    }

    public void ajoutEnfants(Lycanthrope enfants) {
        this.enfants.add(enfants);
    }

    public Meute getMeute() {
        return meute;
    }
    public String getMeuteToString() {
        if (!Objects.equals(meute, null)) {
            return "Meute n°"+Meute.getInstancesMeutes().indexOf(meute)+1+ " : " + meute.getNom();
        } else {
            return "Pas de meute";
        }
    }

    public void setMeute(Meute meute) {
        this.meute = meute;
    }

    public static List<Lycanthrope> getInstancesLycanthropes() {
        return instancesLycanthropes;
    }

    // Méthode pour calculer le niveau en fonction des caractéristiques
    private int calculerNiveau() {
        List<Character> listRangDominationInverse = typesRangDomination.reversed();
        // Exemple de calcul simple
        return force * facteurDomination + listRangDominationInverse.indexOf(rangDomination);
    }
    public boolean aHurle() {
        return aHurler;
    }
    // Méthode statique pour afficher les informations de tous les instancesLycanthropes


    public static void ajouterLoupGarou() {
        ajouterLoupGarouAvecParametre("Adulte");
    }

    public static void ajouterLoupGarouBeBe() {
        ajouterLoupGarouAvecParametre("Bébé");
    }

    // Méthode statique pour ajouter un nouveau lycanthrope
    public static void ajouterLoupGarouAvecParametre(String categorieAge) {
        System.out.print("Entrez le prénom du lycanthrope : ");
        String nom = scanner.next();

        System.out.print("Entrez le sexe du lycanthrope (M/F) : ");
        String sexe = scanner.next();

        // Validation de la saisie pour s'assurer que le sexe est M, m, F ou f
        while (!sexe.matches("[MmFf]")) {
            System.out.println("Saisie invalide. Veuillez entrer M, m, F ou f.");
            System.out.print("Entrez le sexe du lycanthrope (M/F) : ");
            sexe = scanner.next();
        }

        // Vous pouvez ajouter d'autres saisies utilisateur pour les autres caractéristiques du lycanthrope

        new Lycanthrope(nom, sexe, categorieAge, 0, 0, 0, 0);

        System.out.println("Lycanthrope ajouté avec succès !");
    }


    // Méthode d'action spécifique du lycanthrope (exemple)
    public void hurlerPourCommuniquer() {
        System.out.println("Le lycanthrope " + this.nom + " émet un hurlement pour communiquer avec d'autres lycanthropes.");
        this.aHurler = true;
    }

    // Méthode d'action spécifique du lycanthrope (exemple)
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
            System.out.println("Le lycanthrope " + this.nom + " entend un hurlement.");

            // Exclure le lycanthrope actuel de la liste des lycanthropes à entendre
            List<Lycanthrope> loupGarousAEntendre = new ArrayList<>(instancesLycanthropes);
            loupGarousAEntendre.remove(this);

            // Simuler la réponse au hurlement pour chaque lycanthrope à entendre
            for (Lycanthrope loupAGarder : loupGarousAEntendre) {
                System.out.println("Le lycanthrope " + this.nom + " répond au hurlement de " + loupAGarder.getNom());
                this.aHurler=true;
            }
        } else {
            System.out.println("Le lycanthrope " + this.nom + " ne peut pas entendre le hurlement car il dort, est malade ou aucun loup n'a hurlé.");
        }
    }

    public void seSeparerDeMeute() {
        if (this.meute != null) {
            System.out.println("Le lycanthrope " + this.nom + " se sépare de sa meute.");
            this.meute = null;
        } else {
            System.out.println("Le lycanthrope " + this.nom + " n'appartient actuellement à aucune meute.");
        }
    }
    public void seTransformerEnHumain() {
        if (!estHumain()) {
            System.out.println("Le lycanthrope " + this.nom + " se transforme en humain.");
            this.statut = "humain"; // Mettez à jour le statut en humain
            // Ajoutez ici le code pour gérer la transformation en humain
        } else {
            System.out.println("Le lycanthrope " + this.nom + " est déjà un humain.");
        }
    }

    public void seTransformerEnLoup() {
        if (!estLoup()) {
            System.out.println("Le lycanthrope " + this.nom + " se transforme en loup.");
            this.statut = "loup"; // Mettez à jour le statut en loup
            // Ajoutez ici le code pour gérer la transformation en loup
        } else {
            System.out.println("Le lycanthrope " + this.nom + " est déjà un loup.");
        }
    }

    // Méthode auxiliaire pour vérifier si le lycanthrope est déjà un humain
    private boolean estHumain() {
        return this.statut.equals("humain");
    }

    // Méthode auxiliaire pour vérifier si le lycanthrope est déjà un loup
    private boolean estLoup() {
        return this.statut.equals("loup");
    }


    @Override
    public String toString() {
        return "==========Lycanthrope===========" +
                "\n\tNom : " + nom +
                "\n\tSexe : " + sexe +
                "\n\tCategories d'âge : " + categorieAge +
                "\n\tForce : " + force +
                "\n\tFacteur de domination : " + facteurDomination +
                "\n\tRang de domination : " + rangDomination +
                "\n\tNiveau : " + niveau +
                "\n\tFacteur d'impétuosité : " + facteurImpetuosite +
                "\n\t" + getMeuteToString() +
                "\n\tStatut : " + statut +
                "\n=============================";
    }

}

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

        // Ajouter le nouveau loup-garou à la liste
        lycanthropes.add(this);
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
    // Méthode statique pour afficher les informations de tous les lycanthropes
    public static void afficherInformationsLycanthropes() {
        if (lycanthropes.isEmpty()) {
            System.out.println("Aucun loup-garou à afficher.");
        } else {
            for (Lycanthrope lycanthrope : lycanthropes) {
                System.out.println(lycanthrope.toString());
            }
        }
    }

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
    public static void choisirLoupGarou() {
        System.out.println("Liste des loup-garous :");
        Lycanthrope.afficherInformationsLycanthropes();

        if (!lycanthropes.isEmpty()) {
            System.out.print("Choisissez le numéro du loup-garou que vous souhaitez : ");
            int choixLoupGarou = scanner.nextInt();

            if (choixLoupGarou >= 1 && choixLoupGarou <= lycanthropes.size()) {
                // L'utilisateur a choisi un loup-garou valide
                Lycanthrope lycanthropeChoisi = lycanthropes.get(choixLoupGarou - 1);
                // Ajoutez ici le code pour effectuer d'autres actions avec le loup-garou choisi
                System.out.println("Vous avez choisi le loup-garou : " + lycanthropeChoisi.getNom());
                afficherMenuActions(lycanthropeChoisi);
            } else {
                System.out.println("Numéro invalide. Veuillez réessayer.");
            }
        } else {
            System.out.println("Aucun loup-garou disponible.");
        }

    }
    // Méthode pour afficher un menu d'actions pour un loup-garou choisi
    public static void afficherMenuActions(Lycanthrope lycanthrope) {
        int choix;
        do {
            System.out.println("\nMenu d'actions pour " + lycanthrope.getNom());
            System.out.println("1. Action 1");
            System.out.println("2. Action 2");
            System.out.println("3. Action 3");
            System.out.println("4. Retour au menu principal");

            System.out.print("Faites votre choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    lycanthrope.hurlerPourCommuniquer(); // Appeler la méthode d'action spécifique du loup-garou
                    break;
                case 2:
                    lycanthrope.action2(); // Appeler une autre méthode d'action spécifique du loup-garou
                    break;
                case 3:
                    lycanthrope.action3(); // Appeler une autre méthode d'action spécifique du loup-garou
                    break;
                case 4:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 4);
    }

    // Méthode d'action spécifique du loup-garou (exemple)
    private void hurlerPourCommuniquer() {
        System.out.println("Le loup-garou " + this.nom + " émet un hurlement pour communiquer avec d'autres lycanthropes.");
    }

    // Méthode d'action spécifique du loup-garou (exemple)
    private void action2() {
        System.out.println("Le loup-garou effectue l'action 2.");
    }

    // Méthode d'action spécifique du loup-garou (exemple)
    private void action3() {
        System.out.println("Le loup-garou effectue l'action 3.");
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

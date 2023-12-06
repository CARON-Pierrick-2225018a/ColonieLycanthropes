package main.models;

import main.views.LycanthropeView;
import main.views.MeuteView;

import java.util.*;

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
        if (!Objects.equals(lycanthropesDeLaMeute, null)){
            listDeTousLesLycanthropesDeLaMeute.addAll(lycanthropesDeLaMeute);
        }
        return listDeTousLesLycanthropesDeLaMeute;
    }
    public static List<Meute> getInstancesMeutes() {
        return instancesMeutes;
    }

    private int calculTotalForceMeute() {
        int resultat=coupleAlpha.get(0).getNiveau()+coupleAlpha.get(1).getNiveau();
        if (!Objects.equals(lycanthropesDeLaMeute, null)){
            for (Lycanthrope lycanthrope : lycanthropesDeLaMeute) {
                resultat+=lycanthrope.getNiveau();
            }
        }

        return resultat;
    }


    public void ajouterUnLycanthropeALaMeute(Lycanthrope lycanthrope) {
        if (Objects.equals(lycanthrope.getMeute(), null)){
            lycanthropesDeLaMeute.add(lycanthrope);
            lycanthrope.setMeute(this);
            this.forceDeMeute = calculTotalForceMeute();
            System.out.println(lycanthrope.getNom()+" ajouté a la meute "+nom);
        } else {
            System.out.println("Ce lycanthrope est déjà dans une meute");
        }
    }

    public void enleverUnLycanthropeALaMeute(Lycanthrope lycanthrope) {
        if (!Objects.equals(lycanthrope.getMeute(), null)){
            lycanthropesDeLaMeute.remove(lycanthrope);
            lycanthrope.setMeute(null);
            this.forceDeMeute = calculTotalForceMeute();
            System.out.println(lycanthrope.getNom()+" ajouté a la meute "+nom);
        } else {
            System.out.println("Ce lycanthrope n'a pas de meute");
        }
    }

    public void afficherCaracteristiqueMembreDeLaMeute() {
        LycanthropeView.afficherListeLycanthropes(getTousLesLycanthropesDeLaMeute());
    }

    // Méthode statique pour ajouter un nouveau lycanthrope
    public static void ajouterMeute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom de la meute : ");
        String nom = scanner.next();

        System.out.println("Entrez le couple alpha : ");
        new Meute(nom, new ArrayList<>(List.of(LycanthropeView.choisirLoupGarouSelonSonSex("M"),LycanthropeView.choisirLoupGarouSelonSonSex("F"))), null);
        System.out.println("meute ajouté avec succès !");
    }

    public void repoductionDesAlphas() {
        // TODO: vérification de la saison
        Random random = new Random();
        for (int i = 0; i < random.nextInt(8); i++) {
            Lycanthrope.ajouterLoupGarouBeBe();
            Lycanthrope lycanthropeBebe = Lycanthrope.getInstancesLycanthropes().get(Lycanthrope.getInstancesLycanthropes().size()-1);
            lycanthropeBebe.setParents(coupleAlpha);
            coupleAlpha.get(0).ajoutEnfants(lycanthropeBebe);
            coupleAlpha.get(1).ajoutEnfants(lycanthropeBebe);
        }
        Temps.passer9Mois();
    }

    //TODO : de créer une nouvelle hiérarchie de meute avec un ensemble de lycanthropes
    // de constituer un couple α en fonction d’un mâle α (et de déchoir l’éventuel ancien couple)
    // de lancer une reproduction de lycanthropes
    // de décroitre les rangs de domination des lycanthropes de la meute naturellement

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

package main;
import main.models.Lycanthrope;

public class Main {
        public static void main(String[] args) {
            // Création d'un lycanthrope
            Lycanthrope lycanthrope1 = new Lycanthrope("GardeNuit", "Mâle", "Adulte", 80, 5, 2, 7, "MeuteAlpha");

            // Affichage des informations du lycanthrope
            System.out.println(lycanthrope1.toString());

            // Modification de quelques caractéristiques du lycanthrope
            lycanthrope1.setForce(90);
            lycanthrope1.setRangDomination(3);

            // Affichage des nouvelles informations du lycanthrope
            System.out.println("\nAprès modification :\n" + lycanthrope1.toString());
        }
    }

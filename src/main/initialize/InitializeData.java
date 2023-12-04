package main.initialize;

import main.models.Lycanthrope;

public class InitializeData {
    public static void initialisationDesLycanthropes() {
        new Lycanthrope("Pierrick", "M", "Adulte", 0, 0, 0, 0, "Solitaire");
        new Lycanthrope("Killian", "M", "Adulte", 0, 0, 0, 0, "Solitaire");
        System.out.println("Lycanthropes initialisés\n");
    }
}

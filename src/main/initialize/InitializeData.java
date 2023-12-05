package main.initialize;

import main.models.Lycanthrope;
import main.models.Meute;

import java.util.ArrayList;
import java.util.List;

public class InitializeData {
    public static void initialisationDesLycanthropes() {
        new Lycanthrope("Pierrick", "M", "Adulte", 0, 0, 0, 0);
        new Lycanthrope("Mona", "F", "Adulte", 0, 0, 0, 0);
        new Lycanthrope("Killian", "M", "Adulte", 0, 0, 1, 0);
        new Lycanthrope("Vanessa", "F", "Adulte", 0, 0, 0, 0);
        new Lycanthrope("Tom", "M", "Adulte", 0, 0, 0, 0);
        new Lycanthrope("Fabio", "M", "Adulte", 0, 0, 0, 0);

        List<Lycanthrope> coupleAlpha = new ArrayList<>(List.of(Lycanthrope.getInstancesLycanthropes().get(0),Lycanthrope.getInstancesLycanthropes().get(1)));

        new Meute("Meute des devs", coupleAlpha, null);

        Meute.getInstancesMeutes().get(0).ajouterUnLycanthropeALaMeute(Lycanthrope.getInstancesLycanthropes().get(2));

        System.out.println("Lycanthropes initialisés");
    }
}

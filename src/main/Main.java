package main;

import main.controllers.MenuViewController;
import main.views.MenuView;

public class Main {
    public static void main(String[] args) {
        MenuView.affichierChoixInitAuto();
        // Appel de la méthode principale du contrôleur
        MenuViewController.afficherMenu();
    }
}

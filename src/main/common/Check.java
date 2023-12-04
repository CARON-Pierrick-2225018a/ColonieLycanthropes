package main.common;

import main.views.MenuView;

import java.util.Scanner;

public class Check {
    static Scanner sc = new Scanner(System.in);
    /**
     * Vérifie si l'entrée utilisateur est un entier.
     *
     * @return L'entier saisi par l'utilisateur.
     */
    public static int checkIfEntreeIsInt() {
        int entree;
        while (true) {
            try {
                String input = sc.nextLine();
                entree = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                // Si la conversion échoue, afficher un message d'erreur et afficher à nouveau le menu en boucle
                System.out.println("Numéro entré invalide");
                MenuView.menuView();
            }
        }
        return entree;
    }
}

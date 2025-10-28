/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet;

/**
 *
 * @author sarah
 */
public class Main {
    public static void main(String[] args) {
        // Création de tuiles avec les mêmes chiffres sur les côtés correspondants
        Tuile tuile1 = new Tuile(new int[]{1, 2, 3}, new int[]{3, 5, 0}, new int[]{3, 2, 1}, new int[]{1, 2, 3});
        Tuile tuile2 = new Tuile(new int[]{3, 2, 1}, new int[]{1, 2, 3}, new int[]{1, 2, 3}, new int[]{3, 2, 1});


        // Test de compatibilité
        afficherTuile(tuile1);

        afficherTuile(tuile2);
        System.out.println("Compatibilité (tuile1 bas avec tuile2 haut):");
        System.out.println(tuile1.estCompatible(tuile2, 2)); // Devrait renvoyer true car les côtés sont les mêmes

        // Rotation de tuile1 et nouveau test
        tuile1.rotation();
        afficherTuile(tuile1);

        afficherTuile(tuile2);
        System.out.println("Compatibilité après une rotation (tuile1 gauche avec tuile2 droite):");
        System.out.println(tuile1.estCompatible(tuile2, 3)); // Devrait renvoyer false après rotation
    }

    public static void afficherTuile(Tuile tuile) {
        System.out.println("Haut: " + arrayToString(tuile.getCote(0)) + ", Droit: " + arrayToString(tuile.getCote(1)) +
                           ", Bas: " + arrayToString(tuile.getCote(2)) + ", Gauche: " + arrayToString(tuile.getCote(3)));
    }

    public static String arrayToString(int[] array) {
        return "[" + array[0] + ", " + array[1] + ", " + array[2] + "]";
    }
}

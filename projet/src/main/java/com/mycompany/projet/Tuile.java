/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet;

/**
 *
 * @author sarah
 */
import java.util.Arrays;
public class Tuile {
    private int[][] chiffres = new int[4][3]; // 4 côtés, 3 chiffres par côté

    public Tuile(int[] haut, int[] droit, int[] bas, int[] gauche) {
        chiffres[0] = haut;
        chiffres[1] = droit;
        chiffres[2] = bas;
        chiffres[3] = gauche;
    }

    // Méthode de rotation dans le sens horaire
    public void rotation() {
        int[] temp = chiffres[3];
        for (int i = 3; i > 0; i--) {
            chiffres[i] = chiffres[i-1];
        }
        chiffres[0] = temp;
    }



    // Cette méthode vérifie si un côté de cette tuile est l'inverse d'un côté de l'autre tuile,
    // ou si les trois chiffres sont les mêmes.
    public boolean estCompatible(Tuile autre, int position) {
        int coteOppose = (position + 2)%4;

        // Vérifie si les côtés sont inversés
        boolean sontInverses = chiffres[position][0] == autre.chiffres[coteOppose][2] &&
                               chiffres[position][1] == autre.chiffres[coteOppose][1] &&
                               chiffres[position][2] == autre.chiffres[coteOppose][0];

        // Vérifie si les trois chiffres sont les mêmes
        boolean sontEgaux = chiffres[position][0] == autre.chiffres[coteOppose][0] &&
                            chiffres[position][1] == autre.chiffres[coteOppose][1] &&
                            chiffres[position][2] == autre.chiffres[coteOppose][2];

        return sontInverses || sontEgaux;
    }
    

    

    public int[] getCote(int index) {
        return chiffres[index].clone();
    }
}

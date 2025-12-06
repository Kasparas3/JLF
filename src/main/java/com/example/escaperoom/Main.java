package com.example.escaperoom;

/**
 * INF-01: Projekto karkasas + "CI" simuliacija.
 *
 * Čia tik paprastas Java main – universiteto užduočiai užteks.
 * Jei darytum Maven/Gradle, šią klasę laikytum kaip pagrindinį
 * `main` entry point.
 */
public class Main {
    public static void main(String[] args) {
        SceneManager manager = new SceneManager();
        manager.start();
    }
}

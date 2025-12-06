package com.example.escaperoom;

import java.util.Scanner;

/**
 * Pagrindinė žaidimo scena.
 * Čia įgyvendiname:
 *  - PZ-02: 4 skaitmenų kodinė spyna.
 *  - PZ-03: tekstinis rebusas (žodis/frazė).
 */
public class GameScene implements Scene {

    // PZ-02: teisingas 4 skaitmenų kodas
    private static final String CORRECT_CODE = "1234";

    // PZ-03: teisingas atsakymas į rebusą
    private static final String CORRECT_ANSWER = "uoga";

    @Override
    public void run(SceneManager manager, Scanner scanner) {
        System.out.println("\n=== Žaidimas prasideda ===");
        System.out.println("Tu užrakintas kambaryje. Norėdamas pabėgti, " +
                "turi atrakinti kodinę spyną ir išspręsti tekstinį rebusą.");
        System.out.println("Norėdamas bet kada pasiduoti, įvesk 'quit'.\n");

        // 1) Kodinė spyna
        if (!runCodeLockPuzzle(scanner)) {
            manager.changeScene(GameSceneType.LOSE);
            return;
        }

        // 2) Tekstinis rebusas
        if (!runTextRiddlePuzzle(scanner)) {
            manager.changeScene(GameSceneType.LOSE);
            return;
        }

        // Jei abu galvosūkiai išspręsti – laimėjome
        manager.changeScene(GameSceneType.WIN);
    }

    /**
     * PZ-02 – 4 skaitmenų kodinė spyna.
     * Leidžiame iki 3 bandymų.
     */
    private boolean runCodeLockPuzzle(Scanner scanner) {
        System.out.println("=== PZ-02: Kodinė spyna ===");
        System.out.println("Prie durų matai 4 skaitmenų kodinę spyną.");
        System.out.println("Patarimas: pabandyk kodą 1234 :)");
        int attemptsLeft = 3;

        while (attemptsLeft > 0) {
            System.out.print("Įvesk 4 skaitmenų kodą: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Pasidavei. Spyna liko užrakinta...");
                return false;
            }

            if (!input.matches("\\d{4}")) {
                System.out.println("Kodą turi sudaryti 4 skaitmenys (pvz. 0000).");
                continue;
            }

            if (input.equals(CORRECT_CODE)) {
                System.out.println("Spyna spragteli ir atrakina mechanizmą! (PZ-02 įvykdyta)\n");
                return true;
            } else {
                attemptsLeft--;
                if (attemptsLeft > 0) {
                    System.out.println("Neteisingas kodas. Liko bandymų: " + attemptsLeft);
                } else {
                    System.out.println("Baigėsi bandymai. Signalizacija įsijungė.");
                }
            }
        }
        return false;
    }

    /**
     * PZ-03 – tekstinis rebusas.
     */
    private boolean runTextRiddlePuzzle(Scanner scanner) {
        System.out.println("=== PZ-03: Tekstinis rebusas ===");
        System.out.println("Už spynos randi užrašą su mįsle:");
        System.out.println("\"Aš raudona, aš saldi, aš ant krūmo, ne ant medžio. Kas aš?\"");
        System.out.println("Įvesk žodį ar frazę (atsakymas: 'uoga').");

        while (true) {
            System.out.print("Tavo atsakymas: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("quit")) {
                System.out.println("Pasidavei. Mįslė liko neišspręsta...");
                return false;
            }

            if (input.isEmpty()) {
                System.out.println("Įvesk bent vieną žodį.");
                continue;
            }

            if (input.equals(CORRECT_ANSWER)) {
                System.out.println("Teisingai! Užrašas nušvinta žaliai ir durys atsidaro.\n");
                return true;
            } else {
                System.out.println("Neteisingas atsakymas. Bandyk dar kartą arba rašyk 'quit' pasiduoti.");
            }
        }
    }
}
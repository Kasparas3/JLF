package com.example.escaperoom;

import java.util.Scanner;

/**
 * UI-01: pagrindinis meniu – Start / Load / Exit.
 */
public class MenuScene implements Scene {

    @Override
    public void run(SceneManager manager, Scanner scanner) {
        boolean valid = false;

        while (!valid) {
            System.out.println("\n=== Pagrindinis meniu ===");
            System.out.println("1) Start – pradėti naują žaidimą");
            System.out.println("2) Load – užkrauti žaidimą (demo, tik parodo žinutę)");
            System.out.println("3) Exit – išeiti iš programos");
            System.out.print("Pasirink (1-3): ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    valid = true;
                    manager.changeScene(GameSceneType.GAME);
                    break;
                case "2":
                    // UI-01: Load mygtukas (čia tik demonstracija, be realaus išsaugojimo)
                    System.out.println("\n[Load] Šiuo metu išsaugojimai nepalaikomi. " +
                            "Pradėkime naują žaidimą.");
                    valid = true;
                    manager.changeScene(GameSceneType.GAME);
                    break;
                case "3":
                    valid = true;
                    manager.changeScene(GameSceneType.EXIT);
                    break;
                default:
                    System.out.println("Neteisingas pasirinkimas. Bandyk dar kartą.");
            }
        }
    }
}

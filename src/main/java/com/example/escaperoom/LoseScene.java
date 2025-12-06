package com.example.escaperoom;

import java.util.Scanner;

/**
 * Lose scena – žaidėjas pralaimėjo (neteisingas kodas,
 * pasidavė ir pan.).
 */
public class LoseScene implements Scene {

    @Override
    public void run(SceneManager manager, Scanner scanner) {
        System.out.println("\n=== GAME OVER ===");
        System.out.println("Šįkart nepavyko pabėgti iš kambario.");
        System.out.println("Gal kitą kartą pasiseks labiau...\n");

        boolean valid = false;
        while (!valid) {
            System.out.println("1) Bandyt dar kartą (grįžti į meniu)");
            System.out.println("2) Išeiti iš žaidimo");
            System.out.print("Pasirink (1-2): ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    valid = true;
                    manager.changeScene(GameSceneType.MENU);
                    break;
                case "2":
                    valid = true;
                    manager.changeScene(GameSceneType.EXIT);
                    break;
                default:
                    System.out.println("Neteisingas pasirinkimas.");
            }
        }
    }
}

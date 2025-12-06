package com.example.escaperoom;

import java.util.Scanner;

/**
 * Win scena – žaidėjas pabėgo iš kambario.
 * DOC-01: „You escaped!“ scenarijus.
 */
public class WinScene implements Scene {

    @Override
    public void run(SceneManager manager, Scanner scanner) {
        System.out.println("\n=== YOU ESCAPED! ===");
        System.out.println("Durys atsiveria, šaltas nakties oras plūsteli į vidų.");
        System.out.println("Tu išeini iš kambario ir pagaliau esi laisvas.");
        System.out.println("Sveikiname – išsprendei visus galvosūkius!\n");

        boolean valid = false;
        while (!valid) {
            System.out.println("1) Grįžti į meniu");
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

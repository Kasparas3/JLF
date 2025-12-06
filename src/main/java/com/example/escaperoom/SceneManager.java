package com.example.escaperoom;

import java.util.Scanner;

/**
 * CORE-01: SceneManager klasė – vienoje vietoje valdo perėjimus
 * tarp Menu, Game, Win ir Lose scenų.
 */
public class SceneManager {

    private GameSceneType currentScene = GameSceneType.MENU;
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("=== Konsolinis 'You Escaped!' žaidimas ===");
        System.out.println("Sveikas atvykęs į pabėgimo kambarį.\n");

        while (currentScene != GameSceneType.EXIT) {
            Scene scene = createScene(currentScene);
            scene.run(this, scanner);
        }

        System.out.println("Programa baigė darbą. Iki!");
    }

    /**
     * Nustato naują sceną.
     */
    public void changeScene(GameSceneType nextScene) {
        this.currentScene = nextScene;
    }

    /**
     * Pagal enum reikšmę sukuria atitinkamą scenos objektą.
     */
    private Scene createScene(GameSceneType sceneType) {
        switch (sceneType) {
            case MENU:
                return new MenuScene();
            case GAME:
                return new GameScene();
            case WIN:
                return new WinScene();
            case LOSE:
                return new LoseScene();
            default:
                // Jei kažkas labai blogai – išeinam
                return (m, s) -> changeScene(GameSceneType.EXIT);
        }
    }
}


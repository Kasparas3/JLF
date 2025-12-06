package com.example.escaperoom;

import java.util.Scanner;

/**
 * Bendra sąsaja visoms scenoms.
 */
public interface Scene {
    /**
     * Paleidžia scenos logiką.
     *
     * @param manager SceneManager, kuriam scena praneša apie perėjimus.
     * @param scanner Bendra Scanner instancija darbui su konsole.
     */
    void run(SceneManager manager, Scanner scanner);
}

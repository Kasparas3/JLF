# JLF – Escape Room (Java / Maven)

Trumpas „Escape Room“ tipo žaidimo projektas. Šiuo metu realizuota konsolinė (terminalo) prototipo versija su paprasta scenų sistema (Menu → Game → Win/Lose) ir keliais galvosūkiais. Projekte taip pat yra JavaFX šablono failai (`FXML + HelloController`) ir JavaFX priklausomybės – tai gali būti naudojama vėlesniam UI.

---

## Funkcionalumas

- Scenų valdymas (SceneManager):
    - `MENU` → `GAME` → `WIN` / `LOSE` → `MENU` arba `EXIT`
- Galvosūkiai (GameScene):
    - 4 skaitmenų kodinė spyna (ribotas bandymų skaičius)
    - tekstinė mįslė / atsakymo įvedimas
    - komanda `quit` – pasiduoti
- Demo „Load“ (jei pasirinkta meniu) / testinis režimas (pagal implementaciją)

---

## Technologijos

- Java 21
- Maven (+ Maven Wrapper `mvnw`, `mvnw.cmd`)
- Priklausomybės (pom.xml):
    - JavaFX 21 (`javafx-controls`, `javafx-fxml`)
    - ControlsFX, Ikonli, BootstrapFX
    - JUnit 5 (testams)

---

## Projekto struktūra

```text
src/
 └─ main/
    ├─ java/
    │  ├─ module-info.java
    │  └─ com/example/escaperoom/
    │     ├─ Main.java
    │     ├─ SceneManager.java
    │     ├─ Scene.java
    │     ├─ GameScene.java
    │     ├─ MenuScene.java
    │     ├─ WinScene.java
    │     ├─ LoseScene.java
    │     ├─ GameSceneType.java
    │     └─ HelloController.java        (JavaFX šablonas)
    └─ resources/
       └─ com/example/escaperoom/
          └─ hello-view.fxml             (JavaFX šablonas)
```

---

## Paleidimas

### 1) IntelliJ IDEA (rekomenduojama)

1. Atidaryk projektą IntelliJ (kaip **Maven** projektą).
2. Patikrink nustatymus:
   - **File → Project Structure → Project**
     - **Project SDK:** `21`
     - **Language level:** atitinkantis Java 21
3. Paleisk pagrindinę klasę:
   - `src/main/java/com/example/escaperoom/Main.java`
   - arba per **Run** pasirink `com.example.escaperoom.Main`

> Jei paleidžiant meta klaidą `Module com.example.escaperoom not found`, žr. skyrių *Troubleshooting* žemiau.

---

### 2) Windows (PowerShell)

Build:
```powershell
.\mvnw.cmd clean package

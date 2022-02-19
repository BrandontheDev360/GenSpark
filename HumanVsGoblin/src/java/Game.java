import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Game {
    // variables
    private static String playerMovement;
    private static boolean toggleWinOrLose = true;
    private static Scanner playerInput = new Scanner(System.in);
    private static Human human1 = new Human(10);
    private static Goblin goblin1 = new Goblin(10);

    public static void main(String[] args) {
        prologueToGame();
            Land.row1[2] = human1.getHumanIcon();
            Land.row3[2] = goblin1.getGoblinIcon();
            Land.printLand(Land.land);
            System.out.println("\nPlease press WASD to move.");
            try {
                while (toggleWinOrLose) {
                    playerMovement = String.valueOf(playerInput.nextLine().charAt(0));
                    // Row 1 check for H
                    row1Check();
                    checkRange();
                    // Checks Row 2
                    row2Check();
                    if (human1.getHealth() > 0 && goblin1.getHealth() > 0) {
                        checkRange();
                    }
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }

    // use To uppercase at charAt(0) to grab first character and uppercase it to always equal the uppercase value
    // this will help with player input for movement
    public static void prologueToGame() {
        System.out.println("Welcome to Human Vs Goblins\nYou will spawn in a maze as a human.\n" +
                "To walk please use the WASD.\nW = Up\nA = Left\nS = Down\nD = Right\n" +
                "Also to initiate combat with the goblin press attack once near goblin.");
    }

    public static void checkRange() {
        while (Land.row2[2].equals("H") || Land.row3[0].equals("H") || Land.row3[4].equals("H") && human1.getHealth() > 0 && goblin1.getHealth() > 0) {
            if (Land.row2[2].equals("H") || Land.row3[0].equals("H") || Land.row3[2].equals("H") || Land.row3[4].equals("H")) {
                System.out.println("You're in range to attack the goblin");
                System.out.println("Type out attack to attack");
                if (playerInput.next().equalsIgnoreCase("attack")) {
                    human1.humanAttack(goblin1);
                    if (human1.getHealth() <= 0) {
                        System.out.println("You have died.\nGame Over.");
                        break;
                    }
                    if (goblin1.getHealth() <= 0) {
                        System.out.println("You have slain the goblin.\nYou win!");
                        break;
                    }
                }
            }
        }
    }

    public static void row1Check() {
        for (int i = 0; i < Land.row1.length; i++) {
            if (Land.row1[i].contains("H")) {
                // Down
                if (playerMovement.equalsIgnoreCase("S")) {
                    Land.row2[i] = human1.getHumanIcon();
                    Land.row1[i] = " ";
                    playerMovement = "";
                    Land.printLand(Land.land);
                    break;
                }
                // Left
                if (playerMovement.equalsIgnoreCase("A")) {
                    Land.row1[i - 2] = human1.getHumanIcon();
                    Land.row1[i] = " ";
                    playerMovement = "";
                    Land.printLand(Land.land);
                    break;
                }
                // Right
                if (playerMovement.equalsIgnoreCase("D")) {
                    Land.row1[i + 2] = human1.getHumanIcon();
                    Land.row1[i] = " ";
                    playerMovement = "";
                    Land.printLand(Land.land);
                    break;
                }
            }
        }
    }

    public static void row2Check() {
        for (int i = 0; i < Land.row2.length; i++) {
            if (Land.row2[i].contains("H")) {
                if (playerMovement.equalsIgnoreCase("W")) {
                    Land.row1[i] = human1.getHumanIcon();
                    Land.row2[i] = " ";
                    playerMovement = "";
                    Land.printLand(Land.land);
                    break;
                }
                if (playerMovement.equalsIgnoreCase("S") && Land.row2[i].equals(" ")) {
                    Land.row2[i] = human1.getHumanIcon();
                    Land.row1[i] = " ";
                    playerMovement = "";
                    Land.printLand(Land.land);
                    break;
                }
                if (playerMovement.equalsIgnoreCase("A")) {
                    Land.row2[i - 2] = human1.getHumanIcon();
                    Land.row2[i] = " ";
                    playerMovement = "";
                    Land.printLand(Land.land);
                    break;
                }
                if (playerMovement.equalsIgnoreCase("D")) {
                    Land.row2[i + 2] = human1.getHumanIcon();
                    Land.row2[i] = " ";
                    playerMovement = "";
                    Land.printLand(Land.land);
                    break;
                }
            }
        }
    }

}

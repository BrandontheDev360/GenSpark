
import java.util.Scanner;

public class Game {
    // variables
    private static boolean toggleWinOrLose = true;
    private static final Scanner playerInput = new Scanner(System.in);
    private static String playerMovement;
    public static final Human human1 = new Human(10);
    public static final Goblin goblin1 = new Goblin(10);

    public static void main(String[] args) {
            try {
                prologueToGame();
                Land.printLand(Land.land);
                System.out.println("\n\tPlease press WASD to move.");
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
                // playAgain(playerInput.nextLine());
            } catch (Exception e) {
                System.out.println("\tYou exited the maze.");
            }
    }

    // use To uppercase at charAt(0) to grab first character and uppercase it to always equal the uppercase value
    // this will help with player input for movement
    public static void prologueToGame() {
        System.out.println("\tWelcome to Human Vs Goblins\n\tYou will spawn in a maze as a human.\n" +
                "\tTo walk please use the WASD.\n\tW = Up\n\tA = Left\n\tS = Down\n\tD = Right\n" +
                "\tAlso to initiate combat with the goblin press attack once near goblin.\n" +
                "\t**************" +
                "\n\t| H = Human  " +
                "|\n\t| G = Goblin |" +
                "\n\t**************");
    }

    public static void checkRange() {
        while (Land.row2[2].equals("H") || Land.row3[0].equals("H") || Land.row3[4].equals("H")) {
                System.out.println("\tYou're in range to attack the goblin.");
                System.out.println("\tType out \"attack\" to attack.");
                if (playerInput.next().equalsIgnoreCase("attack")) {
                    human1.humanAttack(goblin1);
                    if (human1.getHealth() <= 0) {
                        System.out.println("\tYou have died.\n\tGame Over.");
                        toggleWinOrLose = false;
                        break;
                    }
                    if (goblin1.getHealth() <= 0) {
                        System.out.println("\tYou have slain the goblin.\n\tYou win!");
                        toggleWinOrLose = false;
                        break;
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
                    if (playerMovement.equalsIgnoreCase("S")) {
                        Land.row3[i] = human1.getHumanIcon();
                        Land.row2[i] = " ";
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

        /*
        public static void playAgain(String playAgain) {
            if (human1.getHealth() > 0 && goblin1.getHealth() <= 0) {
                System.out.println("Do you want to play again? (yes or no)");
                if (playAgain.equalsIgnoreCase("yes")) {
                    toggleWinOrLose = true;
                    goblin1.setHealth(10);
                } else {
                    toggleWinOrLose = false;
                }
            }
        }
         */

}

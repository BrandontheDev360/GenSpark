import java.util.Scanner;

public class DragonCave {

    // helps with scope and toggling while loop on and off.
    // SUPER USEFUL
    private static boolean toggle = true;

    public static void main(String[] args) {
        while(toggle){
            Scanner getInput = new Scanner(System.in);
            System.out.println(startGame());
            try {
                System.out.println(playerInput(Integer.parseInt(getInput.nextLine())));
                playAgain(getInput.next());
            } catch(Exception e) {
                System.out.println("You must enter an Integer. GAME OVER.");
                toggle = false;
            }
        }
    }
    public static String startGame() {
        return "You are in a land full of dragons.\nIn front of you, you see two caves.\nIn one cave, the dragon is friendly and will share his treasure with you.\nThe other dragon is greedy and hungry and will eat you on sight.\nWhich Cave will you go in (0 , 1, 2)";
    }

    public static String playerInput(int input) {
        if (input == 1) {
            return "You entered cave 1 and have been eaten by the dragon!\nWould you want to play again? (yes or no)";
        } else if (input == 2) {
            return "You entered cave 2 and have found treasure!\nWould you want to play again? (yes or no)";
        } else {
            return "You exited the cave.\nWould you want to play again? (yes or no)";
        }
    }

    public static void playAgain(String playAgain) {
        if (playAgain.equals("yes")) {
            toggle = true;
        } else {
            toggle = false;
        }
    }
}

import java.util.Scanner;

public class DragonCave {
    // Variables
    // helps with scope and toggling while loop on and off.
    // SUPER USEFUL
    private static boolean toggle = true;

    // While loop to keep the game going until player wants to stop
    // Try catch to catch exception cases where player's input is not an Integer.
    public static void main(String[] args) {
        while(toggle){
            Scanner getInput = new Scanner(System.in);
            System.out.println(startGame());
            try {
                // another cool way of doing it
//                System.out.println(playerInput(Integer.parseInt(getInput.nextLine())));
                System.out.println(playerInput(getInput.nextInt()));
                playAgain(getInput.next());
            } catch(Exception e) {
                System.out.println("You must enter an Integer. GAME OVER.");
                toggle = false;
            }
        }
    }

    // function to start game
    public static String startGame() {
        return "You are in a land full of dragons.\nIn front of you, you see two caves.\nIn one cave, the dragon is friendly and will share his treasure with you.\nThe other dragon is greedy and hungry and will eat you on sight.\nWhich Cave will you go in (0 , 1, 2)";
    }

    // function to getPlayer input and return correct output
    public static String playerInput(int input) {
        if (input == 1) {
            return "You entered cave 1 and have been eaten by the dragon!\nWould you want to play again? (yes or no)";
        } else if (input == 2) {
            return "You entered cave 2 and have found treasure!\nWould you want to play again? (yes or no)";
        } else {
            return "You exited the cave.\nWould you want to play again? (yes or no)";
        }
    }

    // function to determine if player wants to play again
    // also really cool how it can change toggle out of scope with the private static
    public static void playAgain(String playAgain) {
        if (playAgain.equals("yes")) {
            toggle = true;
        } else {
            toggle = false;
        }
    }
}

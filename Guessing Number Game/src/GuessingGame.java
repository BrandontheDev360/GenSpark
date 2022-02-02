import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    private static int guess = 0;
    private static final Random rand = new Random();
    private static int randomNumber = rand.nextInt(20);
    private static int numberOfTries = 0;
    private static boolean toggleWinOrLose = false;
    public static void main (String[] args) {
        String playAgain = "";
        Scanner getInput = new Scanner(System.in);
        System.out.println(startGame());
        String inputName = getInput.nextLine();
        while (!toggleWinOrLose) {
            System.out.printf("Well, %s, I am thinking of a number between 1 and 20.\nTake a guess %s.\n", inputName, inputName);
            try {
                randomNumber = rand.nextInt(20);
                while (guess != randomNumber || numberOfTries >= 10) {
                    guess = getInput.nextInt();
                    if (guess < randomNumber) {
                        System.out.printf("Your guess %d was too low.\n", guess);
                        numberOfTries++;
                    } else if (guess > randomNumber) {
                        System.out.printf("Your guess %d was too high.\n", guess);
                        numberOfTries++;
                    } else {
                        System.out.printf("Good job, %s! You guessed my number in less than 10 guesses!\nWould you like to play again %s? (yes or no)\n", inputName, inputName);
                    }
                    if (numberOfTries >= 10) {
                        System.out.printf("GAME OVER %s you had 10 guesses.\nMWAHAHAHA I have taken your soul %s!\nWould you like to play again %s? (yes or no)\n", inputName, inputName, inputName);
                        break;
                    }
                }
                playAgain(getInput.next());
            } catch (Exception e) {
                System.out.println("Please enter a Guess between 1- 20. GAME OVER!");
                toggleWinOrLose = true;
            }
        }

    }
    public static String startGame() {
        return "Hello! What is your name fellow traveler?\nSign your soul away here...";
    }

    // another function for the while loop

    public static void playAgain(String playAgain) {
        if (!playAgain.equals("yes")) {
            toggleWinOrLose = true;
        } else {
            toggleWinOrLose = false;
            numberOfTries = 0;
        }
    }
}
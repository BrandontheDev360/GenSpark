import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main (String[] args) {
        System.out.println("Hello! What is your name fellow traveler?\nSign your soul away here...");
        Scanner getInput = new Scanner(System.in);
        String inputName = getInput.nextLine();
        int guess = 0;
        Random rand = new Random();
        int randomNumber;
        int numberOfTries = 0;
        boolean toggleWinOrLose = false;
        String playAgain = "";
        while (!toggleWinOrLose) {
            System.out.printf("Well, %s, I am thinking of a number between 1 and 20.\nTake a guess %s.\n", inputName, inputName);
            randomNumber = rand.nextInt(20);
            while (guess != randomNumber) {
                guess = getInput.nextInt();
                if (guess < randomNumber) {
                    System.out.printf("Your guess %d was too low.\n", guess);
                    numberOfTries++;
                } else if (numberOfTries == 10) {
                    System.out.printf("GAME OVER %s you had 10 guesses.\nMWAHAHAHA I have taken your soul %s!", inputName, inputName);
                    toggleWinOrLose = true;
                } else if (guess > randomNumber) {
                    System.out.printf("Your guess %d was too high.\n", guess);
                    numberOfTries++;
                } else {
                    System.out.printf("Good job, %s! You guessed my number in less than 10 guesses!\nWould you like to play again %s? (yes or no)\n", inputName, inputName);
                }
            }
            playAgain = getInput.next();
            if (!playAgain.equals("yes")) {
                toggleWinOrLose = true;
            } else {
                toggleWinOrLose = false;
                numberOfTries = 0;
            }

        }
    }
}

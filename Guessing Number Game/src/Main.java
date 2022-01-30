import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main (String[] args) {
<<<<<<< HEAD
        System.out.println("Hello! What is your name fellow traveler?\nSign your soul away here...");
        Scanner getInput = new Scanner(System.in);
        String inputName = getInput.nextLine();
=======
        System.out.println("Hello! What is your name fellow traveler?");
        Scanner getInput = new Scanner(System.in);
        String answer = getInput.nextLine();
>>>>>>> 0d6326b8004e93c1ccbe5feaf7d378044a84f0de
        int guess = 0;
        Random rand = new Random();
        int randomNumber;
        int numberOfTries = 0;
        boolean toggleWinOrLose = false;
        String playAgain = "";
        while (!toggleWinOrLose) {
<<<<<<< HEAD
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
=======
                System.out.printf("Well, %s, I am thinking of a number between 1 and 20.\nTake a guess %s.\n", answer, answer);
                randomNumber = rand.nextInt(20);
                while (guess != randomNumber) {
                    guess = getInput.nextInt();
                    if (guess < randomNumber) {
                        System.out.printf("Your guess was too low. %d\n", guess);
                        numberOfTries++;
                    } else if (numberOfTries >= 10) {
                        System.out.printf("GAME OVER %s", answer);
                        toggleWinOrLose = true;
                    } else if (guess > randomNumber) {
                        System.out.printf("Your guess was too high. %d\n", guess);
                        numberOfTries++;
                    } else {
                        System.out.printf("Good job, %s! You guessed my number in less than 10 guesses!\nWould you like to play again %s? (yes or no)\n", answer, answer);
                    }
                }
                playAgain = getInput.next();
                if (!playAgain.equals("yes")) {
                toggleWinOrLose = true;
>>>>>>> 0d6326b8004e93c1ccbe5feaf7d378044a84f0de
            }

        }
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private static int wrongGuess = 0;
    public static void main (String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:/GenSpark/Hangman Game/supersecretword.txt"));
        Scanner getInput = new Scanner(System.in);
        ArrayList<String> wordList = new ArrayList<>();
        while (scanner.hasNext()) {
            wordList.add(scanner.nextLine());
        }
        Random rand = new Random();
        String hangManWord = wordList.get(rand.nextInt(wordList.size()));
        // System.out.println(hangManWord);
        ArrayList<Character> guesses = new ArrayList<>();
        boolean toggleWinOrLose = true;
        try {
            while (toggleWinOrLose || wrongGuess == 6) {
                System.out.println("        HANGMAN\n+----------+\n           |\n           |\n          ===");
                if (wrongGuess >= 1) {
                    System.out.println("           O");
                }
                if (wrongGuess >= 2) {
                    System.out.print("         \\ ");
                    if (wrongGuess >= 3) {
                        System.out.println("  /");
                    } else {
                        System.out.println("");
                    }
                }
                if (wrongGuess >= 4) {
                    System.out.println("           |");
                }
                if (wrongGuess >= 5) {
                    System.out.print("         / ");
                    if (wrongGuess >= 6) {
                        System.out.print("  \\\n");
                        System.out.println("You lose!");
                        break;
                    } else {
                        System.out.println("");
                    }
                }
                if (!playerGuess(getInput, hangManWord, guesses)) {
                    wrongGuess++;
                }
                if (currentLetter(hangManWord, guesses)) {
                    System.out.println("Winner Winner Chicken Dinner!\nThe word was " + hangManWord);
                    toggleWinOrLose = false;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static boolean currentLetter(String hangManWord, ArrayList<Character> guesses) {
        int correctGuess = 0;
        for (int i = 0; i < hangManWord.length(); i++) {
            if (guesses.contains(hangManWord.charAt(i))) {
                System.out.print(hangManWord.charAt(i));
                correctGuess++;
            } else {
                System.out.print('_');
            }
        }
        System.out.println();
        return (hangManWord.length() == correctGuess);
    }

    public static boolean playerGuess(Scanner getInput, String hangManWord, ArrayList<Character> guesses) {
        System.out.println("Please guess a letter.");
        String letterGuess = getInput.nextLine();
        guesses.add(letterGuess.charAt(0));
        return hangManWord.contains(letterGuess);
    }

}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main (String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:/GenSpark/Hangman Game/supersecretword.txt"));
        Scanner getInput = new Scanner(System.in);
        List<String> wordList = new ArrayList<>();
        while(scanner.hasNext()) {
            wordList.add(scanner.nextLine());
        }
        Random rand = new Random();
        String hangManWord = wordList.get(rand.nextInt(wordList.size()));
        System.out.println(hangManWord);
        List<Character> guesses = new ArrayList<>();
        boolean toggleWinOrLose = true;
        while (toggleWinOrLose) {
            playerGuess(getInput, hangManWord, guesses);
            printWordState(hangManWord, guesses);

        }
    }

    public static boolean printWordState(String hangManWord, List<Character> guesses) {
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

    public static void playerGuess(Scanner getInput, String hangManWord, List<Character> guesses) {
        System.out.println("Please guess a letter.");
        String letterGuess = getInput.nextLine();
        guesses.add(letterGuess.charAt(0));
    }

}

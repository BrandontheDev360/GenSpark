import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        System.out.println("You are in a land full of dragons. " +
                "In front of you, you see two caves. " +
                "In one cave, the dragon is friendly and will share his treasure with you. " +
                "The other dragon is greedy and hungry and will eat you on sight. Which Cave will you go in (0 , 1, 2)");
        Scanner getInput = new Scanner(System.in);
        int input = Integer.parseInt(getInput.nextLine());
        if (input == 1) {
            System.out.println("You entered cave 1 and have been eaten by the dragon");
        } else if (input == 2) {
            System.out.println("You entered cave 2 and have found treasure!");
        } else if (input == 0) {
            System.out.println("You exited the cave.");
        }

    }
}

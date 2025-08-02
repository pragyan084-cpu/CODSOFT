import java.util.Scanner;
import java.util.Random;

public class NumberGame {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int score = 0;
        boolean keepPlaying = true;
        System.out.println("=== Welcome to the Number Guessing Game ===");

        while (keepPlaying) {
            int secretNumber = rand.nextInt(100) + 1;  // 1 to 100
            int chances = 5;
            boolean guessedRight = false;

            System.out.println("\nI'm thinking of a number between 1 and 100.");
            System.out.println("You have " + chances + " chances to guess it right.");

            for (int attempt = 1; attempt <= chances; attempt++) {
                System.out.print("Guess " + attempt + ": ");
                int guess = input.nextInt();

                if (guess == secretNumber) {
                    System.out.println("Nice! You got it 🎉");
                    guessedRight = true;
                    score += 10;  // basic scoring
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Nope, it's higher ⬆️");
                } else {
                    System.out.println("Nope, it's lower ⬇️");
                }
            }

            if (!guessedRight) {
                System.out.println("Out of tries! The number was: " + secretNumber);
            }

            System.out.print("\nPlay again? (y/n): ");
            String choice = input.next().trim().toLowerCase();

            if (!choice.equals("y")) {
                keepPlaying = false;
            }
        }

        System.out.println("\nThanks for playing! Your final score: " + score);
        input.close();
    }
}

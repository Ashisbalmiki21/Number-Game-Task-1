import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxRange = 100; // Change this if you want to adjust the range
        int attemptsLimit = 5; // Change this to set the limit of attempts
        int totalAttempts = 0;
        int totalRounds = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            totalRounds++;
            int secretNumber = random.nextInt(maxRange) + 1;
            System.out.println("I've picked a number between 1 and " + maxRange + ". Try to guess it!");

            int attempts = 0;
            boolean guessedCorrectly = false;
            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    System.out.println("Congratulations! You've guessed the number " + secretNumber + " in " + attempts + " attempts!");
                    guessedCorrectly = true;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            totalAttempts += attempts;

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + secretNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next().toLowerCase();
            if (!playChoice.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Game Over! You completed " + totalRounds + " rounds with a total of " + totalAttempts + " attempts.");
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}

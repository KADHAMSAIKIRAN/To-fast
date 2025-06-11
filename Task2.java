import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        final int MIN = 1;
        final int MAX = 100;
        final int MAX_ATTEMPTS = 10;
        final int ROUNDS = 3;
        int totalScore = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("NUMBER GUESSING GAME");

        for (int round = 1; round <= ROUNDS; round++) {
            int numberToGuess = random.nextInt(MAX - MIN + 1) + MIN;
            int attempts = 0;
            boolean isGuessed = false;

            System.out.println("\nRound " + round + ": Guess a number between " + MIN + " and " + MAX);

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int guess;

                if (scanner.hasNextInt()) {
                    guess = scanner.nextInt();
                } else {
                    System.out.println("Please enter a valid number.");
                    scanner.next(); // clear invalid input
                    continue;
                }

                attempts++;

                if (guess == numberToGuess) {
                    int score = MAX_ATTEMPTS - attempts;
                    totalScore += score;
                    System.out.println("Correct! Attempts: " + attempts + ", Round Score: " + score);
                    isGuessed = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Attempts left: " + (MAX_ATTEMPTS - attempts));
                } else {
                    System.out.println("Too high! Attempts left: " + (MAX_ATTEMPTS - attempts));
                }
            }

            if (!isGuessed) {
                System.out.println("You failed! The number was: " + numberToGuess);
            }
        }

        System.out.println("\nGame Over. Total Score = " + totalScore);
        scanner.close();
    }
}

import java.util.Scanner;
import java.util.Random;

public class prblm10 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        // Generate random number between 1 and 100
        int targetNumber = random.nextInt(100) + 1;
        int guess = 0;

        System.out.println("Guess the number between 1 and 100:");

        // Loop until the user guesses correctly
        while (guess != targetNumber) {
            System.out.print("Enter your guess: ");
            guess = input.nextInt();

            if (guess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number.");
            }
        }

        input.close();
    }
}


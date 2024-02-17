package guessing.game;

import java.util.Scanner;

public class GuessingGame {

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int guess;
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("Guess a number between 1 and 100:");
        guess = scanner.nextInt();
        int attempts = guessing(guess);
        System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
        scanner.close();
    }

    public static int guessing(int guess) {
        int random = (int) (Math.random() * 100) + 1;
        int counter = 0;
        while (guess != random) {
            if (guess < random) {
                System.out.println("The random number is greater than your guess.");
            } else if (guess > random) {
                System.out.println("The random number is less than your guess.");
            }
            System.out.println("Guess again:");
            Scanner scanner = new Scanner(System.in);
            guess = scanner.nextInt();
            counter++;
        }
        return counter;
    }
}

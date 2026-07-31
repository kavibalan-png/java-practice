import java.util.Random;
import java.util.Scanner;
public class GuessNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("GUESS THE NUMBER GAME");
        char playAgain;
        do {
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int guess;
            System.out.println("I have chosen a number between 1 and 100.");
            System.out.println("Can you guess it?");
            while (true) {
                System.out.print("\nEnter your guess: ");
                guess = sc.nextInt();
                attempts++;
                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                } else if (guess < secretNumber) {
                    System.out.println("Too Low! Try a bigger number.");
                } else if (guess > secretNumber) {
                    System.out.println("Too High! Try a smaller number.");
                } else {
                    System.out.println("Congratulations!");
                    System.out.println("You guessed the correct number: " + secretNumber);
                    System.out.println("Attempts: " + attempts);
                    if (attempts <= 5)
                        System.out.println("50Excellent!");
                    else if (attempts <= 10)
                        System.out.println("Good Job!");
                    else
                        System.out.println("Keep Practicing!");
                    break;
                }
            }
            System.out.print("\nDo you want to play again? (Y/N): ");
            playAgain = sc.next().charAt(0);
        } while (playAgain == 'Y' || playAgain == 'y');
        System.out.println("Thanks for playing!");
        sc.close();
    }
}

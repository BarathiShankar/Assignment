/*Program to create a game to guess numbers using menu driven loops*/
import java.util.Random;
import java.util.Scanner;
class TheNumber_guess_game
{
    public static void main(String[] args) {
        int secret, guess, attempts = 0, guesses, ck, totguess = 0;
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        System.out.println("The game is to find the secret number within 10 guesses\nWith provided hint that whether the provided value os higher or lower\nPress -1 to exit the code anytime");
        out:
        while (true)
        {
            secret = r.nextInt(100);
            guesses=0;
            attempts++;
            while (guesses < 10)
            {
                System.out.print("Guess the number : ");
                guess = s.nextInt();
                if (guess == -1) {
                    System.out.println("Program terminated");
                    break out;
                }
                else if (guess >= 0 && guess <= 100) {
                    ++guesses;
                    totguess++;
                    System.out.println("Guesses remaining : " + (10-guesses));
                    if (guess == secret) {
                        System.out.println("MISSION ACCOMPLISHED\nGuesses made in this round " + guesses);
                        break;
                    } else if (guess < secret) {
                        System.out.println("Entered number is smaller ");
                        continue;
                    } else {
                        System.out.println("Entered number is larger ");
                        continue;
                    }
                } else {
                    System.out.println("Invalid number entered, please enter the number within the range ( 0 to 100 )");
                    continue;
                }
            }
            if(guesses ==10)
            {
                System.out.println("You ran out of available guesses pal \nYOU LOST THE GAME");
            }
            System.out.println("Press -\n0 to terminate the program\n1 to print the game stats and terminate\n2 to play again");
            ck=s.nextInt();
            switch(ck)
            {
                case 0 : return ;
                case 1 : System.out.println("\n\nOVERALL STATS-\nGames played : " + attempts + "\nTotal guesses made so far : " + totguess
                        + "\nAverage guesses per game : " + (float)totguess/attempts);
                        return ;
                case 2 : break;
            }
        }
    }
}

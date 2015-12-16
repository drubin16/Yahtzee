import java.util.Scanner;

public class YahtzeeDriver
{
    /*
    1. Creates a new instance of the YahtzeeGame class
    2. Calls the playGame method on the Yahtzee object
    3. Asks user if they would like to play again
    4. When the user is done playing, prints the number of games played, min, max, and average score
    */
    public static void main(String [] args)
    {
        Scanner s1= new Scanner(System.in);
        int games=0;
        int minScore=1576;
        int maxScore=0;
        int totalScore=0;
        do {
            int score;
            YahtzeeGame myGame = new YahtzeeGame();
            System.out.println("Welcome to Danny's APCSA Yahtzee Game!");
            score = myGame.playGame();
            System.out.print("Would You Like To Play Again Yes or No?");
            String s = s1.nextLine();
            games++;
            if (score < minScore){
                minScore = score;
            }
            else if(score>maxScore) {
                maxScore = score;

            }
            totalScore+=score;
        }
        while (s1.equals("yes"));

        double AverageScore= totalScore*1.0/games;
    }
}

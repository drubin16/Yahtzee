
import java.util.Scanner;

public class YahtzeeGame
{
    /* instance data should include the five yahtzee dice, a scoreboard, and a CONSTANT (static final) variable NUM_SIDES
	which should be set to six (the number of sides on a yahtzee die) */
    private YahtzeeDie one;
    private YahtzeeDie two;
    private YahtzeeDie three;
    private YahtzeeDie four;
    private YahtzeeDie five;
    private YahtzeeScorecard scorecard;
    private static final int NUM_SIDES= 6;
    Scanner s= new Scanner(System.in);


    /* initializes the dice and scoreboard */
    public YahtzeeGame()
    {
		 one= new YahtzeeDie(NUM_SIDES);
         two= new YahtzeeDie(NUM_SIDES);
         three= new YahtzeeDie(NUM_SIDES);
         four= new YahtzeeDie(NUM_SIDES);
         five= new YahtzeeDie(NUM_SIDES);
         scorecard= new YahtzeeScorecard();
    }

    /* check to see if the game is over, and while the game is not over call the method takeTurn()
    once the game ends (hint: there are 13 turns in a game of Yahtzee), the method should print a
    final scorecard and return the grand total */
    public int playGame()
    {
        for (int i = 0; i <13 ; i++) {
            takeTurn();
        }
        scorecard.printScoreCard();
        return scorecard.getGrandTotal();
    }

    /* 	1. call rollDice()
        2. call printDice()
        3. Ask the user if they are satisfied with their roll, or if they would like to roll again.
           If they are not satisfied continue, otherwise call markScore()
        4. call chooseFrozen()
        5. call rollDice()
        6. call printDice()
        7. Ask the user if they are satisfied with their roll, or if they would like to roll again.
           If they are not satisfied continue, otherwise call markScore()
        8. call chooseFrozen()
        9. call rollDice()
        10. call printDice()
        11. call markScore()
    */
    private void takeTurn() {
        rollDice();
        printDice();
        System.out.print("Are you satisfied with your roll? Yes to keep the die /No to freeze die and roll again");
        String s2 = s.nextLine();
        int counter= 1;
        while (s2.indexOf("No") > -1 && counter<3) {
            chooseFrozen();
            rollDice();
            printDice();
            System.out.print("Are you satisfied with your roll? Yes to keep the die /No to freeze die and roll again");
            s2=s.nextLine();
            counter ++;
        }
        markScore();
    }
    /* Rolls all unfrozen dice.  Also resets all dice to the unfrozen state after the roll */
    private void rollDice()
    {
		if(!one.isFrozen()) {
            one.rollDie();
        }
        if(!two.isFrozen()) {
            two.rollDie();
        }
        if(!three.isFrozen()) {
            three.rollDie();
        }
        if(!four.isFrozen()) {
            four.rollDie();
        }
        if(!five.isFrozen()) {
            five.rollDie();
        }
    }



    /* Asks the user which dice should be frozen 1-5 (should be read in in one line) */
    private void chooseFrozen()
    {
        System.out.println("Which dice should be frozen 1-5?");
        String s1= s.nextLine();
        if(s1.indexOf("1")>-1) {
            one.freezeDie();
        }
        if(s1.indexOf("2")>-1) {
            two.freezeDie();
        }
        if(s1.indexOf("3")>-1) {
            three.freezeDie();
        }
        if(s1.indexOf("4")>-1) {
            four.freezeDie();
        }
        if(s1.indexOf("5")>-1) {
            five.freezeDie();
        }
    }
    /* Should print the value of all five dice separated by a tab (\t) to the console */
    private void printDice()
    {
		System.out.println(one.getValue()+"\t"+two.getValue()+"\t"+three.getValue()+"\t"+four.getValue()+"\t"+five.getValue()+"\t");
    }

    /* 1. Print a scoreboard
       2. Ask the user where they would like to mark their score.
       3. Call appropriate function
       4. If false is returned the user entered an invalid number, so ask the user to try again	*/
    private void markScore()
    {
		scorecard.printScoreCard();
        System.out.println("Where would you like to mark your score? 1 for 1s \n 2 for 2s \n 3 for 3s \n 4 for 4s \n 5 for 5s \n 6 for 6s \n 7 for Three of a Kind \n 8 for Four of a Kind \n 9 For Full House \n 10 for Sm. Straight \n 11 for Large Straight \n 12 for YAHTZEE \n 13 for Chance");
        int number=s.nextInt();
        s.nextLine();
        boolean successfulMark= false;
        boolean inBetweenOneAndThirteen= number>=1 && number<=13;
        while(!(inBetweenOneAndThirteen&&successfulMark)) {
            switch(number) {
                case 1:
                    successfulMark=scorecard.markOnes(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
                    break;
                case 2:
                    successfulMark=scorecard.markTwos(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
                    break;
                case 3:
                    successfulMark=scorecard.markThrees(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
                    break;
                case 4:
                    successfulMark=scorecard.markFours(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
                    break;
                case 5:
                    successfulMark=scorecard.markFives(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
                    break;
                case 6:
                    successfulMark=scorecard.markSixes(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
                    break;
                case 7:
                    successfulMark=scorecard.markThreeOfAKind(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
                    break;
                case 8:
                    successfulMark= scorecard.markFourOfAKind(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
                    break;
                case 9:
                    successfulMark=scorecard.markFullHouse(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
                    break;
                case 10:
                    successfulMark=scorecard.markSmallStraight(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
                    break;
                case 11:
                    successfulMark=scorecard.markLargeStraight(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
                    break;
                case 12:
                    successfulMark=scorecard.markYahtzee(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
                    break;
                case 13:
                    successfulMark=scorecard.markChance(one.getValue(), two.getValue(), three.getValue(), four.getValue(), five.getValue());
                    break;
                default:
                    number =s.nextInt();
                    s.nextLine();
                    System.out.println("Please Try Again");

            }

        if (!successfulMark){
            System.out.println("Please Try Again");
            number=s.nextInt();
            s.nextLine();
        }
        }

    }
}

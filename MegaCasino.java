/**
* Mega Casino
* A multi game casino simulation featuring five interactive gambling games.
* Includes Craps, Heads or Tails, Over/Under, Higher/Lower, and The Vault. 
* @author Shahmeer Khan
* @date 11 03 2026
*/


import java.util.Scanner;

public class MegaCasino {

    static Scanner s = new Scanner(System.in);


    /**
     * 
     *                                                          Utility Methods
     * 
    */



    /**
    * Displays the main Casino menu and returns the user's game selection.
    *
    * @param name The player's name
    * @param remainingBalance The current total money available
    * @return An integer representing the chosen game or exit option
    */

    public static int programTitle(String name, int remainingBalance) {
        
        
        // header
        System.out.println("  _      _      _      _      _      _      _  ");
        System.out.println(" / \\    / \\    / \\    / \\    / \\    / \\    / \\ ");
        System.out.println("( C )  ( A )  ( S )  ( I )  ( N )  ( O )  ( ! )");
        System.out.println(" \\_/    \\_/    \\_/    \\_/    \\_/    \\_/    \\_/ ");
        System.out.println("================================================");
        System.out.println("  Welcome to the high-stakes world, " + name + "!");
        System.out.println("  Your Bankroll: $" + remainingBalance);
        System.out.println("================================================");    

        // Display Menu
        while (true) {
            System.out.println("\n╔════════════ SELECT YOUR DESTINY ════════════╗");
            System.out.println("║                                             ║");
            System.out.println("║  (1)  [::]  C R A P S                       ║");
            System.out.println("║  (2)  ($)   H E A D S / T A I L S           ║");
            System.out.println("║  (3)  -7+   O V E R / U N D E R / 7         ║");
            System.out.println("║  (4)  ^v^   H I G H E R / L O W E R         ║");
            System.out.println("║  (5)  [!]   T H E   V A U L T               ║");
            System.out.println("║  (6)  [->   E X I T                         ║");
            System.out.println("║                                             ║");
            System.out.println("╚═════════════════════════════════════════════╝");

            // Display remaining balance
            System.out.println("Your remaining balance is: $" + remainingBalance);
            
            // Ask for option
            int choice = validVal(6,1);
            return choice;

        } // end while

    } // programTitle (String, int)

    /**
     * Handles the betting logic and ensures user has sufficient funds.
     *
     * @param moneyLeft The user's current bankroll balance
     * @return The amount the user has chosen to wager
     */
    // method to ask for bet
    public static int getBet(int moneyLeft) {
        while (true) {
            System.out.print("Please enter your bet (0 to quit): ");
            
            // check if the input is actually a number
            if (!s.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                System.out.println();
                s.nextLine(); 
                continue;
            } // end if

            int bet = s.nextInt();
            s.nextLine(); 

            if (bet < 0) {
                System.out.println("You can't bet negative money!");
                System.out.println();
            } // end if
            else if (bet > moneyLeft) {
                System.out.println("You only have $" + moneyLeft + ". Please enter a valid bet.");
                System.out.println();
            } // end else if 
            else {
                return bet; 
            } // end else
        } // end while
    } // getBet (int)



    /**
     * Prompts the user to decide whether to continue playing.
     *
     * @param moneyLeft The user's current bankroll
     * @return True if player enters 'Y', false if 'N' or out of money
     */

    // Get YorN
    public static boolean getYorN(int moneyLeft) {
            // runs out of money check and play again option
            if (moneyLeft <= 0) {
                System.out.println("You have run out of money! Game over.");
                System.out.println();
                return false;
            }
            // ask if they want to play again
            while (true) {
                System.out.print("Do you want to play again? (Y/N): ");
                String playAgainInput = s.nextLine();
                System.out.println();

                if (playAgainInput.equalsIgnoreCase("Y")) {
                    return true;
                } // end if
                else if (playAgainInput.equalsIgnoreCase("N")) {
                    System.out.println("Thank you for playing! Your final balance is: $" + moneyLeft);
                    System.out.println();
                    return false;

                } // end else if
                else {
                    System.out.println("Invalid input. Please enter Y or N.");
                    System.out.println();
                } // end else

            } // end while
    } // getYorN (int)  


    /**
     * Validates user input to ensure it falls within a specific range.
     *
     * @param max The maximum allowable integer choice
     * @param min The minimum allowable integer choice
     * @return The validated integer choice
     */

    // Valid Val
    public static int validVal(int max, int min) {

        while (true) {
        System.out.print("Enter your choice: ");
        int choice = s.nextInt();
        s.nextLine();

        if (choice >= min && choice <= max) {
            System.out.println("You selected: " + choice);
            System.out.println();
            return choice;

        } // end if
        
        System.out.println("Invalid input. Please enter a number between " + min + " and " + max);
        System.out.println();

        } // end while
    } // validVal (int, int)



    /**
     * Prompts the user to press Enter to acknowledge a result, 
     * preventing the console text from scrolling too quickly.
     */

    // method to pause the program and wait for user input
    public static void pause() {
        System.out.print("\nPress Enter to continue: ");
        s.nextLine();
        System.out.println();
    } // end pause



    /**
     * 
     *                                                          Game Methods
     * 
     */


    /**
     * Predicts if a secret number is higher or lower than a face card.
     *
     * @param moneyLeft Current bankroll
     * @param name Player's name
     * @return Updated bankroll after winning or losing
     */

    public static int higherLower(int moneyLeft, String name) {
        // header
        System.out.println("\n.-------------------------------------------.");
        System.out.println("|  [ Higher ]    [  OR  ]    [ Lower  ]     |");
        System.out.println("|      ♠             ♥             ♣        |");
        System.out.println("'-------------------------------------------'");
        System.out.println("  Gamble your $" + moneyLeft + ", " + name + "!");
        System.out.println("---------------------------------------------");
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║  HOW TO PLAY: A number (1-10) is shown.              ║");
        System.out.println("║  - Guess if the NEXT secret number is Higher/Lower.  ║");
        System.out.println("║  - Win: Double your bet.                             ║");
        System.out.println("║  - Ties: The house wins all matching numbers!        ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");

        // Start a while loop
        while (moneyLeft > 0) {
            // get bet
            int bet = getBet(moneyLeft);

            if (bet == 0 ) {
                return moneyLeft;
            } // end if

            // Generate starting number
            int num1 = (int)(Math.random() * 10) + 1;
            System.out.println("Your current number is: " + num1);
            System.out.println();

            // Ask for prediction
            System.out.println("Will the next number be (1) Higher (2) Or lower?");
            int prediction = validVal(2,1);

            // Generate 2nd num
            int num2 = (int)(Math.random() * 10) + 1;
            System.out.println("Your next number is...");
            pause();
            System.out.println("...its " + num2);
            System.out.println();

            // Find results
            if (num2 > num1 && prediction  == 1) {
                System.out.println("You were Right! It was higher!");
                moneyLeft += bet;
                pause();
            } // end if
            else if (num2 < num1 && prediction == 2) {
                System.out.println("You were Right! It was lower!");
                moneyLeft += bet;
                pause();
            } // end else if
            else if (num2 == num1) {
                System.out.println("Ahh! A tie! The house always wins ties. You lose!");
                moneyLeft -= bet;
                pause();
            } // end else if
            else {
                System.out.println("Oops! Wrong Guess! You lose...");
                moneyLeft -= bet;
                pause();
            } // end else 

            System.out.println("Your current Balance is: " + moneyLeft);
            System.out.println();

            // Ask to play again
            if (getYorN(moneyLeft) == false) {
                break;
            }
        } // end while

        return moneyLeft;
    } // higherLower (int, String)


    /**
     * Dice sum prediction game with a 2:1 jackpot for rolling a 7.
     *
     * @param moneyLeft Current bankroll
     * @param name Player's name
     * @return Updated bankroll after the results
     */

    public static int overUnder(int moneyLeft, String name) {

        // header or display title
        System.out.println("\n#############################################");
        System.out.println("#  <<< [ UNDER 7 ] [ SEVEN ] [ OVER 7 ] >>> #");
        System.out.println("#############################################");
        System.out.println("#  1:1 Payout      2:1 Payout      1:1 Payout  #");
        System.out.println("#############################################");
        System.out.println("  Luck be a lady tonight, " + name + "!");
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║  HOW TO PLAY: Predict the sum of 2 dice.             ║");
        System.out.println("║  - Under/Over 7: Win your bet back (1:1).            ║");
        System.out.println("║  - Exactly 7: The Jackpot! Win DOUBLE (2:1).         ║");
        System.out.println("║  - If the dice don't match your guess, you lose.     ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");

        while (moneyLeft > 0) {
            // get bet
            int bet = getBet(moneyLeft);
            
            // ending if bet is 0
            if (bet == 0) {
                return moneyLeft;
            } // end if

            // Display menu
            System.out.println("Choose your bet!");
            System.out.println("1. Under 7 (Pays 1:1)");
            System.out.println("2. Over 7 (Pays 1:1)");
            System.out.println("3. Exactly 7 (Pays 2:1)");

            // Get choice
            int choice = validVal(3, 1);
            
            // rolling
            int roll1 = (int)(Math.random() * 6) + 1; 
            int roll2 = (int)(Math.random() * 6) + 1;
            int sum = roll1 + roll2;

            System.out.println("Rolling dice...");
            pause();

            // display result
            System.out.printf("You rolled a %d and %d  for a total of %d%n", roll1, roll2, sum);
            pause();

            // finding the outcome
            if (choice == 1 && sum < 7) {
                System.out.println("You WON! Under 7!");
                System.out.println("You chose option 1 and your total is UNDER 7");
                System.out.println();
                moneyLeft += bet;
            } // end if
            else if (choice == 2 && sum > 7) {
                System.out.println("You Won! OVER 7!");
                System.out.println("You chose option 2 and your sum is OVER 7");
                System.out.println();
                moneyLeft += bet;
            } // end else if

            else if (choice == 3 && sum == 7) {
                System.out.println("JACKPOT! Its a 7");
                System.out.println("You chose option 3 and your total is EXACTLY 7!");
                System.out.println();
                moneyLeft = moneyLeft + (bet *2);
            } // end else if
            else {
                System.out.println("Better luck next time, you lost.");
                System.out.println();
                moneyLeft -= bet;
            } // end else
            
            // display new balance
            System.out.println("Your new Balance is: " + moneyLeft);
            System.out.println();
            
            // get YorN to repeat the game again
            if (getYorN(moneyLeft) == false) {
                    break;
            } // end if 

        } // end while  

    return moneyLeft;
    } // overUnder (int, String)


    
   /**
     * A multi-stage dice game following street craps rules and points.
     *
     * @param moneyLeft Current bankroll
     * @param name Player's name
     * @return Updated bankroll after the round ends
     */

    // method to play craps
    public static int Craps(int moneyLeft, String name) {
        
        // header or title
        System.out.println("\n  _____________________________________________  ");
        System.out.println(" / \\                                           \\ ");
        System.out.println("|   | ======= STREET CRAPS: HIGH STAKES ======= |");
        System.out.println(" \\_/___________________________________________/ ");
        System.out.println("   |   [ " + name + " ]  Balance: $" + moneyLeft);
        System.out.println("   |   Roll the bones. Don't Seven Out!        |");
        System.out.println("   |___________________________________________|");     
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║  HOW TO PLAY: Roll 2 dice.                           ║");
        System.out.println("║  - Win instantly on 7 or 11.                         ║");
        System.out.println("║  - Lose on 2, 3, or 12.                              ║");
        System.out.println("║  - Anything else? That's your 'Point'. Roll it again ║");
        System.out.println("║    to win before a 7/11 appears!                     ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");

        // Start a main Loop
        while (moneyLeft > 0) {

            // Ask for bet
            int bet = getBet(moneyLeft);

            if (bet == 0) {
                return moneyLeft;
            }

            // First Roll
            int roll1 = (int)(Math.random() * 6) + 1; 
            int roll2 = (int)(Math.random() * 6) + 1;
            int sum = roll1 + roll2;
            System.out.println("You rolled a " + roll1 + " and a " + roll2 + " for a total of " + (roll1 + roll2));
            pause();
            
            // continue with rest of the game
            if (sum == 7 || sum == 11) {
                System.out.println("You win!");
                System.out.printf("The sum of the roll was %d", sum);
                moneyLeft += bet;
                System.out.println("Your new balance is: $" + moneyLeft);
                pause();

            } // end if
            else if (sum == 2 || sum == 3 || sum  == 12) {
                System.out.println("You lose!");
                System.out.printf("The sum was equal to %d", sum);
                moneyLeft -= bet;
                System.out.println("Your new balance is: $" + moneyLeft);
                pause();

            } // end else if
            else {
                int points = sum;
                System.out.println("Since the sum of the roll was not equal to 7 or 11 nor equal to 2, 3 or 12, you may move to the next stage!");
                System.out.println("Your point is: " + points);
                boolean continueLoop = true;
                pause();

                // start another loop to keep rolling until 11 or 7 is rolled
                while (continueLoop == true) {
                    roll1 = (int)(Math.random() * 6) + 1; 
                    roll2 = (int)(Math.random() * 6) + 1;
                    sum = roll1 + roll2;
                    System.out.println("You rolled a " + roll1 + " and a " + roll2 + " for a total of " + (roll1 + roll2));
                    pause();

                    if (sum == points) {
                        System.out.println("You win!");
                        System.out.println("The sum of the roll is equal to the points!");
                        moneyLeft += bet;
                        System.out.println("Your new balance is: $" + moneyLeft);
                        continueLoop = false;

                    } // end if
                    else if (sum == 7 || sum == 11) {
                        System.out.println("You lose!");
                        System.out.println("The sum of the roll is equal to 7 or 11");
                        moneyLeft -= bet;
                        System.out.println("Your new balance is: $" + moneyLeft);
                        continueLoop = false;
                    } // end else if
                    else {
                        System.out.println("Rolling again...");
                    } // end else

                    // pause after each roll
                    pause();

                } // end while
                
            } // end else
            
            // get YorN to repeat the game again
            if (getYorN(moneyLeft) == false) {
                break;
            } 
        } // end while
    
    return moneyLeft;

    } // Craps (int, String)


    /**
     * A 50/50 probability coin flip simulation.
     *
     * @param moneyLeft Current bankroll
     * @param name Player's name
     * @return Updated bankroll based on the outcome
     */

    public static int HeadOrTails(int moneyLeft, String name) {

        // set variable
        String side = "";

        // Greeting
        System.out.println("\n          .-------.-------.          ");
        System.out.println("         /   _     _   \\         ");
        System.out.println("        |   (H) OR (T)   |        ");
        System.out.println("         \\   ^     ^   /         ");
        System.out.println("   ------'---'-----'---'------   ");
        System.out.println("      GOLDEN FLIP - CHOOSE WISELY");
        System.out.println("   ---------------------------   ");
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║  HOW TO PLAY: The ultimate 50/50 test.               ║");
        System.out.println("║  - Predict if the coin lands on Heads (H) or Tails(T)║");
        System.out.println("║  - Correct guess doubles your bet (1:1 payout).      ║");
        System.out.println("║  - Wrong guess? The House keeps the gold.            ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        // start a loop
        while (moneyLeft > 0) {

            // Ask for bet
            int bet = getBet(moneyLeft);

            if (bet == 0) {
                return moneyLeft;
            }


            // ask for heads or tails
            System.out.print("Please enter your choice (H for heads, T for tails): ");
            String choice = s.nextLine().toUpperCase();
            System.out.println();

            // flip coin
            int coinResult = (int)(Math.random() * 2);
            if (coinResult == 0) {
                side = "H";
            }
            else {
                side = "T";
            }

            // tell the user about the process, coin flipping
            System.out.println("Flipping the coin...");
            pause();
            System.out.println("The coin landed on: " + side);
            System.out.println();

            // Determine if user won or lost
            if (choice.equals(side)) {
                moneyLeft += bet;
                System.out.println("You WON!");
                System.out.println("Your new balance is: $" + (moneyLeft));
                pause();
            } // end if
            else {
                moneyLeft -= bet;
                System.out.println("You LOST!");
                System.out.println("Your new balance is: $" + (moneyLeft));
                pause();
            } // end else

            // check to see for sufficient balance and ask if they want to play again

            // get YorN to repeat the game again
                if (getYorN(moneyLeft) == false) {
                    break; 
                } // end if
            
        } // end while

        return moneyLeft;

    } // HeadOrTails (int, String)



    /**
     * Logic-based guessing game with tiered payouts based on attempts.
     *
     * @param moneyLeft Current bankroll
     * @param name Player's name
     * @return Updated bankroll after the game result
     */

    public static int  theVault(int moneyLeft, String name) {

        // Header
        System.out.println("\n  _____________________________________________  ");
        System.out.println(" / \\                                           \\ ");
        System.out.println("|   | ======= THE VAULT: CODEBREAKER =======    |");
        System.out.println(" \\_/___________________________________________/ ");
        System.out.println("   |   [ " + name + " ]  Balance: $" + moneyLeft);
        System.out.println("   |   Crack the 4-digit pin to win the pot!   |");
        System.out.println("   |___________________________________________|");     

        // Fancy Instruction Box
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║  HOW TO PLAY: Guess the code (1-20).         ║");
        System.out.println("║  - Guess 1: 3:1 PAYOUT (TRIPLE!)             ║");
        System.out.println("║  - Guess 2-3: 2:1 PAYOUT (DOUBLE!)           ║");
        System.out.println("║  - Guess 4-5: 1:1 PAYOUT (EVEN)              ║");
        System.out.println("╚══════════════════════════════════════════════╝");


        while (moneyLeft > 0) {
            int bet = getBet(moneyLeft);
            if (bet == 0) {
                return moneyLeft;
            } // end if

            int secretCode = (int)(Math.random() * 20) + 1;
            int attempts = 0;
            boolean hasWon = false;

            // start loop that runs until 5 attempts complete
            while (attempts < 5) {

                // increase attempts
                attempts += 1;

                // Ask for guess
                System.out.printf("Attempts %d: Enter your guess(1-20): %n", attempts);
                int guess = validVal(20,1);

                // Checking to see if user is correct
                if (guess == secretCode) {
                    hasWon = true;
                    break;
                } // end if
                else if (guess < secretCode) {
                    System.out.println("The code is higher");
                    System.out.println();
                } // end else if
                else if (guess > secretCode) {
                    System.out.println("The code is lower");
                    System.out.println();
                } // end else if

            } // end while
            
            int winnings = 0;
            if (hasWon == true) {
                if (attempts == 1) {
                    winnings = bet * 3;
                    System.out.printf("INSTANTLY CRACKED! You Won! $%d%n" , winnings); 
                } // end if

                else if (attempts <= 3) {
                    winnings = bet * 2; 
                    System.out.println();
                    System.out.printf("Nice Work! You won! $%d%n" , winnings);
                } // end else if
                else {
                    winnings = bet * 1;
                    System.out.println();
                    System.out.printf("Just in time pft! You won $%d%n", winnings ); 
                }
                
                // adding winnings to money left
                moneyLeft += winnings;
            } // end if 

            else{
                    System.out.println();
                    System.out.printf("Vault remained locked. The code was %d%n" , secretCode);
                    moneyLeft -= bet;
                } // end else
                
            // show balance
            System.out.println();
            System.out.println("Your new balance is: " + moneyLeft);

            // call YorN for playing again
            if (getYorN(moneyLeft) == false) {
                break;
            } // end if 
        } // end while 


        return moneyLeft;

    } // theVault (int, String)



     /**
     * 
     *                                                          MAIN
     * 
     */


     /**
     * Entry point of the program. Manages the high-level game loop and balance.
     *
     * @param args Command line arguments
     */

    // Main Method 
    public static void main(String [] args) {

        // Main Area of the Program


        // Welcome Message
        System.out.println("Welcome to the Mega Casino! We hope you have a great time here!");
        System.out.print("Enter your name: ");
        String name = s.nextLine();

        // declare variable for money
        int remainingBalance = 500;


        // start a loop that doesnt end unless you run out of money
        while (remainingBalance > 0) {
        int choice = programTitle(name, remainingBalance);

            // call method based on choice
            if (choice == 1) {
                remainingBalance = Craps(remainingBalance, name);
            } // end if
            else if (choice == 2) {
                remainingBalance = HeadOrTails(remainingBalance, name);
            } // end else if
            else if (choice == 3) {
                remainingBalance = overUnder(remainingBalance, name);
            }
            else if (choice == 4) {
                remainingBalance = higherLower(remainingBalance, name);
            }
            else if (choice == 5) {
                remainingBalance = theVault(remainingBalance, name);
            }
            else if (choice == 6) {
            System.out.println("\n\t  ___________________________________");
            System.out.println("\t /                                   \\");
            System.out.println("\t|           CASINO RECEIPT            |");
            System.out.println("\t|    -----------------------------    |");
            System.out.println("\t|  PLAYER: " + String.format("%-18s", name.toUpperCase()) + " |");
            System.out.println("\t|  CASH OUT: $" + String.format("%-16d", remainingBalance) + " |");
            System.out.println("\t|    -----------------------------    |");
            System.out.println("\t|   THANK YOU FOR GAMBLING WITH US!   |");
            System.out.println("\t \\___________________________________/");

            break;
            } // end else if

        if (remainingBalance <= 0) {
            System.out.printf("[!] SECURITY: You're broke, %s! Get out of my casino!" , name);
        }
            
        } // end while
    
} // main (String[])

} // MegaCasino class


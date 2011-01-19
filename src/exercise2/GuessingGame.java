package exercise2;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class GuessingGame {
	private static final double MAX_NUMBER = 10.0;
	private int score = 0;
	
	/**
	 * Plays a guessing game. Should loop if user wants to play again.
	 * Returns true if the user won the last game.
	 */
	public boolean play() {
		int value = pickANumber();
		println("I have chosen a number between 1 and 10 try to guess it.");
		
		boolean theyGuessedIt = false;

		//ACTION: Need to add a loop here that will loop up to three times if theyGuessed it is still false.
		int guess = readGuess(1);
		theyGuessedIt = checkGuess(guess, value);
		
		
		//ACTION: Use the method playAgain() it will ask the user for an input and return true if they
		//ACTION: want to play again. When that happens you will need to loop here.
		
		println("Your final score is: " + score);
		
		//ACTION:Return true if the user won
		return false;
	}
	
	/**
	 * Compares guess with value and determines if the user has won. 
	 * When the user wins we return true and add one to their score. When they loose we return false
	 * 
	 * @param guess
	 * @param value
	 * @return
	 */
	protected boolean checkGuess(int guess, int value) {
		if(guess == value) {
			// ACTION: add one to the variable 'score'
			println("Good job, you got it - your score is now: " + score);
			return true;
		} else if (guess > value) {
			println("Sorry too high");
		} else {
			println("Sorry too low");
		}
		return false;
	}

	/**
	 * Asks the user if they want to play again. Returns true if they do.
	 * 
	 * 
	 * @return
	 */
	protected boolean playAgain() {
		print("Would you like to play again (y/n)? ");
		String playAgainString = readLine();
		if(playAgainString.equalsIgnoreCase("y")) {
			//QU: What do you think the method 'equalsIgnoreCase' does. Hint: double click on it 
			//QU: and hover over the highlighted word and a box pops up with a description!
			return true;
		} else if(playAgainString.equalsIgnoreCase("n")){
			return false;
		} else {
			return playAgain(); //QU: What's this call do?
		}
	}

	/**
	 * Reads the users guess and converts it into a number. Takes as input which guess the user is on.
	 * Notice the try{}catch block can you guess what it does?
	 * 
	 * @param tryNumber
	 * @return
	 */
	protected int readGuess(int tryNumber) {
		try { //QU: can you guess what this try{ ... } catch {...} block does?
			print("guess " + tryNumber + ": ");
			String guessString = readLine();
			return Integer.parseInt(guessString);
		} catch (NumberFormatException e) {
			println("Error - Please try again!");
			return readGuess(tryNumber); //QU: what's this call for?
		}
	}
	
	////////////////////////////////////////////////
	//
	// Utility classes
	//
	/////////////////////////////////////////////////
	
	public int getScore(){
		return score;
	}
	
	public int pickANumber() {
		return (int)(Math.ceil(Math.random() * MAX_NUMBER));
	}

	protected String readLine() {
		try {
			return new LineNumberReader(new InputStreamReader(System.in)).readLine();
		} catch (Exception e) {
			return "";
		}
	}

	
	
	/**
	 * Print out a string with a new line added
	 * Made a method to make testing easier
	 * 
	 * @param string
	 */
	protected void println(String string) {
		print(string);
		print("\n");
	}

	/**
	 * Print out a string without a new line
	 * Made a method to make testing easier
	 * 
	 * @param string
	 */
	protected void print(String string) {
		System.out.print(string);
	}


}

package exercise2;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

public class TestGuessingGame extends TestCase {
	public class MockGame extends GuessingGame {
		private List<String>  readData = new ArrayList<String>();
		private int readIndex;
		private int numberToGuess = 5;
		private List<String> output = new ArrayList<String>();

		public void addInput(String string) {
			readData.add(string);
		}

		public List<String> getOutput() {
			List<String> result = new ArrayList<String>(output.size());
			for (String out : output) {
				result.add(out);
			}
			return result;
		}

		@Override
		protected String readLine() {
			if(readIndex >= readData.size() ) {
				throw new RuntimeException("Ran out of input data, please fix the test!");
			} else {
				return readData.get(readIndex++);
			}
		}

		@Override
		protected void print(String string) {
			output.add(string);
			System.out.print(string);
		}

		@Override
		public int pickANumber() {
			return numberToGuess;
		}

		public void setNumberToGuess(int val) {
			numberToGuess = val;
		}

	}

	@Test
	public void testPickANumberAndGuessIt(){
		MockGame game = new MockGame();
		game.setNumberToGuess(3);
		game.addInput("3");
		game.addInput("n");
		assertEquals("You need to fix the code so that if the user gets the right answer the method 'play()' returns true",true,game.play());

		game = new MockGame();
		game.setNumberToGuess(3);
		game.addInput("4");
		game.addInput("4");
		game.addInput("4");
		game.addInput("4");
		game.addInput("4");
		game.addInput("n");
		assertEquals("You need to fix the code so that if the user gets the wrong answer the method 'play()' returns false",false,game.play());
	}

	@Test
	public void testGet3Guesses(){
		// 2 guesses
		MockGame game = new MockGame();
		game.setNumberToGuess(3);
		game.addInput("2");
		game.addInput("3");
		game.addInput("n");
		assertEquals("Didn't get more than one guess - need to let us have 3",true,game.play());

		// 3 guesses
		game = new MockGame();
		game.setNumberToGuess(3);
		game.addInput("2");
		game.addInput("2");
		game.addInput("3");
		game.addInput("n");
		assertEquals("Only got 2 guesses - need to let us have 3",true,game.play());

		// 4 guesses should fail
		game = new MockGame();
		game.setNumberToGuess(3);
		game.addInput("2");
		game.addInput("2");
		game.addInput("2");
		game.addInput("3");
		game.addInput("n");
		assertEquals("Hmmm...I got four guesses that time should only be allowed 3",false,game.play());
	}
	
	@Test
	public void testOptionToPlayAgain() {
		//1 game
		MockGame game = new MockGame();
		game.setNumberToGuess(3);
		game.addInput("3");
		game.addInput("n");
		assertEquals("You need to fix the code so that if the user gets the right answer the method 'play()' returns true",true,game.play());

		//2 games
		game = new MockGame();
		game.setNumberToGuess(3);
		game.addInput("2");
		game.addInput("2");
		game.addInput("2");
		game.addInput("y");
		game.addInput("3");
		game.addInput("n");
		assertEquals("You need to fix the code so that if the user gets the right answer the method 'play()' returns true",true,game.play());

		//2 games with caps input 'Y'
		game = new MockGame();
		game.setNumberToGuess(3);
		game.addInput("2");
		game.addInput("2");
		game.addInput("2");
		game.addInput("Y");
		game.addInput("3");
		game.addInput("n");
		assertEquals("You need to fix the code so that if the user gets the right answer the method 'play()' returns true",true,game.play());

		//1 game with caps input 'N'
		game = new MockGame();
		game.setNumberToGuess(3);
		game.addInput("2");
		game.addInput("2");
		game.addInput("2");
		game.addInput("N");
		game.addInput("3");
		game.addInput("n");
		assertEquals("You need to fix the code so that if the user gets the right answer the method 'play()' returns true",false,game.play());


		//3 games
		game = new MockGame();
		game.setNumberToGuess(3);
		game.addInput("2");
		game.addInput("2");
		game.addInput("2");
		game.addInput("y");
		game.addInput("2");
		game.addInput("2");
		game.addInput("2");
		game.addInput("y");
		game.addInput("3");
		game.addInput("n");
		assertEquals("You need to fix the code so that if the user gets the right answer the method 'play()' returns true",true,game.play());

	}
	
	@Test
	public void testScore() {
		//1 game
		MockGame game = new MockGame();
		game.setNumberToGuess(3);
		game.addInput("3");
		game.addInput("n");
		game.play();
		assertEquals("Fix the scoring so that when the user wins they get 1 added to their score.",1,game.getScore());

		//2 games
		game = new MockGame();
		game.setNumberToGuess(3);
		game.addInput("3");
		game.addInput("y");
		game.addInput("3");
		game.addInput("n");
		game.play();
		assertEquals("Won twice but don't see a score of 2? Fix the scoring so that every time the user wins they get 1 added to their score.",2,game.getScore());

		//3 games
		game = new MockGame();
		game.setNumberToGuess(3);
		game.addInput("3");
		game.addInput("y");
		game.addInput("3");
		game.addInput("y");
		game.addInput("3");
		game.addInput("n");
		game.play();
		assertEquals("Won three times but don't see a score of 3? Fix the scoring so that every time the user wins they get 1 added to their score.",3,game.getScore());

	}

}

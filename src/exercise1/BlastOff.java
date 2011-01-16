package exercise1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class BlastOff {

	public static void main(String[] args) throws IOException {
		System.out.print("Please type your name: ");
		System.out.flush();
		String name = readInput();
		countdown(10);
		System.out.println("Blast off - " + name + "!");

	}

	private static void countdown(int i) {
		while(  i > 0 ) {
			System.out.println(i);
			i = i - 1;
		}
	}

	private static String readInput() throws IOException {
		return new LineNumberReader(new InputStreamReader(System.in)).readLine();
	}

}

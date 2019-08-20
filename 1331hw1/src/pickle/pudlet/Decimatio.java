package pickle.pudlet;

import java.util.Scanner;

public class Decimatio {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int rand = (int) (Math.random() * 10);
		rand++;
		
		boolean match = false;
		
		System.out.println("Ples enter random number bw 1 and 10 bitch u die? I KILL YOU. Decimatio: ");		
		
		do {

			int guess = Integer.parseInt(s.nextLine());
			
			if(guess == rand) {
				System.out.println("YOU ARE BIG WINNER!");
				System.exit(0);
			} else {
				System.out.println("Guess again ASSHOLE:");
			}
		} while (!match);
	}

}

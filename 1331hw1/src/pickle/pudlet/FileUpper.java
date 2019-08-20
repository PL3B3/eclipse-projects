package pickle.pudlet;

import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;
import java.io.IOException;

public class FileUpper {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in)
;		String fileName = null;
		if (args.length < 1) {
			System.out.println("Please provide a file");
			fileName = s.nextLine();
		} else {
			fileName = args[0];
		}
		
		int periodIndex = fileName.lastIndexOf('.');
		String newFileName = fileName.substring(0, periodIndex) + "-upper" + fileName.substring(periodIndex);
		
		try (Scanner in = new Scanner(new File(fileName)); PrintStream out = new PrintStream(new File(newFileName))) {
			while (in.hasNextLine()) {
				out.println(in.nextLine().toUpperCase());
			}
		} catch (IOException e) {
			System.err.printf("IOException: %s%n", e);
		}
		
	}

}

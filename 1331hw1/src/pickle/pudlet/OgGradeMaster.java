package pickle.pudlet;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;


public class OgGradeMaster {
	public static void main(String args[]) throws IOException{
		int bucketNum = 0;
		Scanner s = new Scanner(System.in);
		if (args.length < 1) {
			System.err.print("GODDAMMIT NO ARGS PROVIDED. ABORTING NOW");
			System.exit(-1);
		} else if (args.length < 2) {
			do {
				System.out.println("YOU MUST PROVIDE ME THE BUCKETNUM:");
			} while (!s.hasNextInt());
			
			bucketNum = s.nextInt();
		} else {
			bucketNum = Integer.parseInt(args[1]);
		}
		
		int[] cutoffs = generateCutoffs(bucketNum);
		
		int[] buckets = organizeCSV(args[0], cutoffs);
		
		for (int i = 0; i < bucketNum; i++) {
			System.out.printf("%-02d - %-02d : ", (i == 0 ? 0 : cutoffs[i - 1]), cutoffs[i]);
		}
	}
	
	static int[] organizeCSV(String fileName, int[] cutoffs) throws IOException {
		Scanner csvScanner = null;
		
		int bucketNum = cutoffs.length;
		
		int[] buckets = new int[bucketNum];
		
		try {
			csvScanner = new Scanner(new File(fileName));
			
			while (csvScanner.hasNextInt()) {
				for(int i = 0; i < bucketNum; i++) {
					int nextInt = csvScanner.nextInt();
					if (nextInt < cutoffs[i]) {
						buckets[i] += 1;
						break;
					}
					
					int quot = nextInt / (101 / bucketNum);
					int rem = nextInt % (101 / bucketNum);
					
					//buckets[quot + (rem > (101 % bucketNum) ? 1 : 0)] += 1; 
				}
				
			}

		} finally {
			if (csvScanner != null) {
				csvScanner.close();
			}
		}
		
		return buckets;
	}
	
	static int[] generateCutoffs(int bucketNum) {
		int remainder = 101 % bucketNum;
		int quotient = 101 / bucketNum;
		
		int[] cutoffs = new int[bucketNum];
		
		for(int i = 0; i < bucketNum; i++) {
			cutoffs[i] = (quotient * i) + (i < remainder ? i : 0);
		}
		
		return cutoffs;
	}
} 
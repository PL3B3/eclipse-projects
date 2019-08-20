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
		
		if (bucketNum < 1 || bucketNum > 101) {
			System.err.println("Invalid Bucket Number");
			System.exit(-1);
		}
		
//		System.out.println(bucketNum);
		
		int[] cutoffs = generateCutoffs(bucketNum);
		
		int[] buckets = organizeCSV(args[0], cutoffs);
		
		for (int i = bucketNum - 1; i >= 0; i--) {
			System.out.printf("%3d - %-3d : ", i == 0 ? 0 : cutoffs[i - 1], (cutoffs[i]) - 1);
			//System.out.println(cutoffs[i]);
			for (int j = 0; j < buckets[i]; j++) {
				System.out.print("[] ");
			}
			System.out.println();
		}
		

	}
	
	static int[] organizeCSV(String fileName, int[] cutoffs) throws IOException {
		Scanner csvScanner = null;
		
		int bucketNum = cutoffs.length;
		
		int[] buckets = new int[bucketNum];
		
		try {
			csvScanner = new Scanner(new File(fileName));
			
			//this uses spaces, commas, or line separators as delims
			csvScanner.useDelimiter(",| |\\r?\\n");
			
			while (csvScanner.hasNext()) {
				System.out.println("hasnext");
				if (csvScanner.hasNextInt()) {
					System.out.println("hasnextint");
					int nextInt = csvScanner.nextInt();
					/*
					for(int i = 0; i < bucketNum; i++) {
						if (nextInt < cutoffs[i]) {
							buckets[i] += 1;
							break;
						}
						
						int quot = nextInt / (101 / bucketNum);
						int rem = nextInt % (101 / bucketNum);
						
						buckets[quot + (rem > (101 % bucketNum) ? 1 : 0)] += 1; 
					}
					*/
					int quot = nextInt / (101 / bucketNum);
					int rem = nextInt % (101 / bucketNum);
					
					buckets[quot + (rem >= quot || rem >= (101 % bucketNum) ? 0 : -1)] += 1; 
				} else {
					csvScanner.next();
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
			cutoffs[i] = (quotient * (i + 1)) + (i < remainder ? i + 1 : remainder);
		}
		
		return cutoffs;
	}
} 

package pickle.pudlet;

public class ArrayMod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] o = new int[20];
		
		for(int a = 0; a < o.length; a++) {
			o[a] = a;
		}
		
		int[] g = take(5, o);
		
		
		System.out.println(toString(g));
		
		System.out.println(toString(drop(5, o)));
		
		int[] z = concat(o, g);
		
		printArr(z);
		
		System.out.println(toString(identity(16)));
		
	}
	
	public static void printArr(int[] xs) {
		System.out.println(toString(xs));
	}

	public static int[] take(int n, int[] xs) {
		//which returns a new array containing the first n elements of xs
		/*
		int[] v2 = new int[n];
		
		if (n > xs.length) {
			System.out.println("Warning, length is greater than length of array");
			for (int i = 0; i < xs.length; i++) {
				v2[i] = xs[i];
			}
		} else {
			for (int i = 0; i < n; i++) {
				v2[i] = xs[i];
			}
		}
		
		return v2;
		*/
		
		return java.util.Arrays.copyOfRange(xs, 0, n);
	}
	
	public static int[] drop(int n, int[] xs) {
		//which returns a new array containing the last n elements of xs
			return (java.util.Arrays.copyOfRange(xs, xs.length - n, xs.length));
	}
	
	public static String toString(int[] xs) {
		String stringified = "{ ";
		for (int i = 0; i < xs.length; i++) {
			stringified += xs[i] + (i != xs.length - 1 ? ", " : " ");
		}
		return stringified + "}";
	}
	
	public static String toString(int[][] as) {
		String stringified = "{ ";
		
		for(int i = 0; i < as.length; i++) {
			stringified += (i == 0 ? "" : "  ") + toString(as[i]) + (i != as.length - 1 ? "\n" : " }");
		}
		
		return stringified;
	}
	
	public static boolean equals(int[] xs, int[] ys) {
		//which returns true if xs.length == ys.length and xs[i] == ys[i] for 0 <=i < xs.length
		if (xs.length == ys.length) {
			boolean match = true;
			for(int i = 0; i < xs.length; i++) {
				if(!match) {
					return match;
				}
				match = match && (xs[i] == ys[i]);				
			}
			
			return match;
		} 
		
		return false;
	}
	
	public static int[] concat(int[] xs, int[] ys) {
		//which returns a new array containing the elements of ys after the elements of xs
		
		int[] newArr = new int[xs.length + ys.length];
		
		System.arraycopy(xs, 0, newArr, 0, xs.length);
		System.arraycopy(ys, 0, newArr, xs.length, ys.length);
		
		return newArr;
	}
	
	public static int[][] identity(int n) {
		//which returns an n x n identity matrix
		int rowCounter = 0;
		
		int[][] identityMatrix = new int[n][n];
		
		for(int[] row : identityMatrix) {
			row[rowCounter]++;
			rowCounter++;
		}
		
		return identityMatrix;
	}
}

import java.util.Scanner;


public abstract class Get {
	
	private static Scanner sc = new Scanner(System.in);
	
	static int nextInt(){
		int i = sc.nextInt();
		//sc.reset();
		return i;
	}
	
	static String nextLine(){
		String str = sc.nextLine();
		//sc.reset();
		return str;
	}
	
	static double nextDouble(){
		double n=sc.nextDouble();
		return n;
	}
	
}

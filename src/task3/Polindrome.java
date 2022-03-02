package task3;
import java.util.Scanner;

public class Polindrome {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			System.out.print("Enter text:");
			String input = scanner.next();
			boolean polindrome = true;
			
			int length = input.length();

			for (int i = 0; i < length / 2; i++) {
				char left = input.charAt(i);
				char right = input.charAt(length - 1 - i);
				
				if(left != right) {
					polindrome = false;
					break;
				}
				
			}
			
			System.out.println("Polindrome "+polindrome);

		}
	}
}
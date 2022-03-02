package task4;
import java.util.Arrays;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Enter the sentence: ");
			String text = scanner.nextLine();

			StringBuilder word = new StringBuilder();

			// you can store your own language based punctuation mark list to allocating words
			// sorted by ASC|| table to binary searching
			char[] punctuationMarks = { ' ', '!', ',', '-', '.', ':', ';', '?' };

			int wordCounter = 0;

			for (int i = 0; i < text.length(); i++) {

				char c = text.charAt(i);

				int result = Arrays.binarySearch(punctuationMarks, c);

				if (result < 0) {
					word.append(c);
				} else if (word.length() > 0) {
					wordCounter++;
					word.setLength(0);
				}
			}

			if (word.length() > 0) {
				wordCounter++;
			}

			System.out.println("Word count is " + wordCounter);
		}
	}
}

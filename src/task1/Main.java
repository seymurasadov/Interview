package task1;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	private static final Random RANDOM = new Random();

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			System.out.print("Enter the array size: ");
			int arraySize = scanner.nextInt();
			int[] array = generateArrayWithRandomNumbers(arraySize);
			
			sortArray(array);
			
			System.out.println("Sorted array: ");
			printArray(array);
		}
	}
	
	private static void sortArray(int [] array) {
		
		Sorter sorter;
		
		int arraySize = array.length;
		
		if (arraySize < 50) {
			sorter = new InsertionSorter();
		} else if (arraySize < 300) {
			sorter = new QuickSorter();
		} else {
			sorter = new MergeSorter();
		}
		
		sorter.sort(array);
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");

		System.out.println();
	}

	private static int[] generateArrayWithRandomNumbers(int arraySize) {
		
		return RANDOM.ints(arraySize, 1, 300).toArray();
	}


}

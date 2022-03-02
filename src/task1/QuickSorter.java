package task1;

public class QuickSorter implements Sorter {

	@Override
	public void sort(int[] array) {
		this.quickSort(array, 0, array.length - 1);

	}

	private void quickSort(int[] array, int low, int high) {
		if (low < high) {

			int pivot = partition(array, low, high);

			quickSort(array, low, pivot - 1);
			quickSort(array, pivot + 1, high);
		}
	}

	private static int partition(int[] array, int low, int high) {

		int pivot = array[high];
		int i = (low - 1);

		for (int j = low; j <= high - 1; j++) {
			if (array[j] < pivot) {
				i++;
				swapElementsInArray(array, i, j);
			}
		}
		swapElementsInArray(array, i + 1, high);
		return (i + 1);
	}

	private static void swapElementsInArray(int[] array, int oneIndex, int anotherIndex) {
		int temp = array[oneIndex];
		array[oneIndex] = array[anotherIndex];
		array[anotherIndex] = temp;
	}

}

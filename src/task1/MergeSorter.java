package task1;

public class MergeSorter implements Sorter {

	@Override
	public void sort(int[] array) {
		mergeSort(array, 0, array.length - 1);
	}

	private static void mergeSort(int arr[], int left, int right) {
		if (left < right) {
			int middlePoint = left + (right - left) / 2;

			mergeSort(arr, left, middlePoint);
			mergeSort(arr, middlePoint + 1, right);

			merge(arr, left, middlePoint, right);
		}
	}

	private static void merge(int arr[], int left, int middle, int right) {
		int leftArraySize = middle - left + 1;
		int rightArraySize = right - middle;

		int[] leftTempArray = new int[leftArraySize];
		int[] rightTempArray = new int[rightArraySize];

		for (int i = 0; i < leftArraySize; ++i) {
			leftTempArray[i] = arr[left + i];
		}

		for (int j = 0; j < rightArraySize; ++j) {
			rightTempArray[j] = arr[middle + 1 + j];
		}

		int indexLeftArray = 0;
		int indexRightArray = 0;

		int indexMergedArray = left;

		while (indexLeftArray < leftArraySize && indexRightArray < rightArraySize) {

			if (leftTempArray[indexLeftArray] <= rightTempArray[indexRightArray]) {
				arr[indexMergedArray] = leftTempArray[indexLeftArray];
				indexLeftArray++;
			} else {
				arr[indexMergedArray] = rightTempArray[indexRightArray];
				indexRightArray++;
			}
			indexMergedArray++;
		}

		while (indexLeftArray < leftArraySize) {
			arr[indexMergedArray] = leftTempArray[indexLeftArray];
			indexLeftArray++;
			indexMergedArray++;
		}

		while (indexRightArray < rightArraySize) {
			arr[indexMergedArray] = rightTempArray[indexRightArray];
			indexRightArray++;
			indexMergedArray++;
		}
	}

}

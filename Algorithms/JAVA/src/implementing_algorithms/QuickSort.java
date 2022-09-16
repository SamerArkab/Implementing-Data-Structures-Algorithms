package implementing_algorithms;

public class QuickSort {
	public void quickSort(int arr[], int lowP, int highP) {
		if (lowP < highP) {
			// Find pivot element, where elements smaller\greater are to it's left\right
			int pivot = partition(arr, lowP, highP);

			quickSort(arr, lowP, pivot - 1);
			quickSort(arr, pivot + 1, highP);
		}
	}

	public int partition(int arr[], int lowP, int highP) {
		int pivot = arr[highP]; // Choose rightmost element as the pivot
		int i = lowP - 1;

		for (int j = lowP; j < highP; j++) {
			if (arr[j] <= pivot) {
				i++;
				// Swap to the left side of the pivot
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[highP];
		arr[highP] = temp;

		return i + 1;
	}

	public static void main(String[] args) {
		QuickSort myQS = new QuickSort();
		int arr[] = { 5, 4, 9, 8, 44, 0, 100 };

		myQS.quickSort(arr, 0, arr.length - 1);

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

	}
}
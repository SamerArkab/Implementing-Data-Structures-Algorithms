package implementing_algorithms;

public class MergeSort {
	public void mergeSort(int arr[], int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);

			merge(arr, left, mid, right);
		}
	}

	public void merge(int arr[], int left, int mid, int right) {
		int firstHalf = mid - left + 1;
		int secondHalf = right - mid;

		int firstH[] = new int[firstHalf];
		int secondH[] = new int[secondHalf];

		for (int i = 0; i < firstHalf; i++)
			firstH[i] = arr[left + i];
		for (int i = 0; i < secondHalf; i++)
			secondH[i] = arr[mid + i + 1];

		int i = 0, j = 0, k = left;
		while (i < firstHalf && j < secondHalf) { // Pick the larger value from both halves and place it in correct
													// position
			if (firstH[i] <= secondH[j]) {
				arr[k] = firstH[i];
				i++;
			} else {
				arr[k] = secondH[j];
				j++;
			}
			k++;
		}

		// Meaning at least one of the halves was fully iterated through, continue with
		// the other
		while (i < firstHalf) {
			arr[k] = firstH[i];
			i++;
			k++;
		}

		while (j < secondHalf) {
			arr[k] = secondH[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args) {
		MergeSort myMS = new MergeSort();
		int arr[] = { 5, 4, 9, 8, 44, 0, 100 };

		myMS.mergeSort(arr, 0, arr.length - 1); // Send by reference

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}
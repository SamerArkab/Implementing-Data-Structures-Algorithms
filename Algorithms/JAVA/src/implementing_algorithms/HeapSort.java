package implementing_algorithms;

public class HeapSort {
	public void heapSort(int arr[]) {
		int len = arr.length;
		// First build a max heap
		for (int i = len / 2 - 1; i >= 0; i--)
			heapify(arr, len, i);

		// Now activate Heap Sort
		for (int i = len - 1; i >= 0; i--) {
			int temp = arr[0]; // swap
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
	}

	public void heapify(int arr[], int n, int i) {
		// First find the largest element among the root and left\right child
		int largest = i;
		int leftChild = 2 * i + 1;
		int rightChild = 2 * i + 2;
		if (leftChild < n && arr[leftChild] > arr[largest])
			largest = leftChild;
		if (rightChild < n && arr[rightChild] > arr[largest])
			largest = rightChild;

		// Swap and continue with heapify (in case further action is required)
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(arr, n, largest);
		}
	}

	public static void main(String[] args) {
		HeapSort myHS = new HeapSort();
		int arr[] = { 0, 10, 91, 8, 17, 101, 1 };

		myHS.heapSort(arr);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + "  ");
	}
}
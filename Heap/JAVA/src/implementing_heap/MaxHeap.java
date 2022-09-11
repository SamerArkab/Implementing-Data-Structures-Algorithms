package implementing_heap;

import java.util.ArrayList;

public class MaxHeap {
	public void heapify(ArrayList<Integer> arr, int i) {
		int largest = i;
		int size = arr.size();
		int leftChild = 2 * i + 1;
		int rightChild = 2 * i + 2;

		if (leftChild < size && arr.get(leftChild) > arr.get(largest))
			largest = leftChild;
		if (rightChild < size && arr.get(rightChild) > arr.get(largest))
			largest = rightChild;
		if (largest != i) {
			int temp = arr.get(largest);
			arr.set(largest, arr.get(i));
			arr.set(i, temp);
			heapify(arr, largest);
		}
	}

	public void insert(ArrayList<Integer> arr, int num) {
		int size = arr.size();
		if (size == 0)
			arr.add(num);
		else {
			arr.add(num);
			for (int i = size / 2; i >= 0; i--)
				heapify(arr, i);
		}
	}

	public void delete(ArrayList<Integer> arr, int num) {
		int size = arr.size();
		int i;
		for (i = 0; i < size; i++) {
			if (num == arr.get(i))
				break;
		}
		int temp = arr.get(i);
		arr.set(i, arr.get(size - 1));
		arr.set(size - 1, temp);
		arr.remove(size - 1);
		for (int j = size / 2; j >= 0; j--)
			heapify(arr, j);
	}

	public void peek(ArrayList<Integer> arr) {
		System.out.println(arr.get(0));
	}

	public int extract(ArrayList<Integer> arr) {
		int ret = arr.get(0);
		delete(arr, ret);
		return ret;
	}

	public void printHeap(ArrayList<Integer> arr) {
		for (int each : arr)
			System.out.print(each + "   ");
		System.out.println();
	}

	public static void main(String[] args) {
		MaxHeap myHeap = new MaxHeap();
		ArrayList<Integer> arr = new ArrayList<Integer>();

		for (int i = 1; i < 54; i = i + 3)
			myHeap.insert(arr, i);

		myHeap.printHeap(arr);

		for (int i = 10; i < 20; i += 2) {
			try {
				myHeap.delete(arr, i);
			} catch (IndexOutOfBoundsException e) {
				continue;
			}
		}

		myHeap.printHeap(arr);

		myHeap.peek(arr);
		System.out.println(myHeap.extract(arr));
		myHeap.printHeap(arr);
	}
}
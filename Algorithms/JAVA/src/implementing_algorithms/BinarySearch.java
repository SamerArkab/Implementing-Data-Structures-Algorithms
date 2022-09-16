package implementing_algorithms;

public class BinarySearch {

	public int binarySearch(int arr[], int toFind, int lowP, int highP) {
		if (highP >= lowP) {
			int mid = (lowP + highP) / 2;
			if (arr[mid] == toFind)
				return mid;

			if (arr[mid] > toFind)
				return binarySearch(arr, toFind, lowP, mid - 1);
			else
				return binarySearch(arr, toFind, mid + 1, highP);
		}
		return -1; // Not found
	}

	public static void main(String[] args) {
		BinarySearch myBS = new BinarySearch();
		int testArr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int findVal = 3;
		int result = myBS.binarySearch(testArr, findVal, 0, testArr.length - 1);
		if (result == -1)
			System.out.println("The value (" + findVal + ") was not found.");
		else
			System.out.println("The value (" + findVal + ") was found!");
	}
}
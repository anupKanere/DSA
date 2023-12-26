import java.util.Arrays;

public class SortingMain {

	public static void SelecttionSort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	// more optimized bubble sort
	public static void BubbleSort(int arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			boolean swapflag = false;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapflag = true;
				}

			}
			if (swapflag == false)// if array is already sorted then loop will iterate for only one time
				break;
		}
	}

	public static void insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int j, temp = arr[i];

			for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = temp;
		}
	}

	public static void main(String[] args) {

		int[] arr = { 20, 14, 8, 35, 100, 88, 1 };

		// selection sort
//		System.out.println("Before sort : " + Arrays.toString(arr));
//		SelecttionSort(arr);
//		System.out.println("After sort : " + Arrays.toString(arr));

		// bubble sort
//		System.out.println("Before sort : " + Arrays.toString(arr));
//		BubbleSort(arr);
//		System.out.println("After sort : " + Arrays.toString(arr));

		// insertion sort
		System.out.println("Before sort : " + Arrays.toString(arr));
		insertionSort(arr);
		System.out.println("After sort : " + Arrays.toString(arr));
	}

}

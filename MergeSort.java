public class MergeSort {

    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};

        System.out.println("Before sorting:");
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.println("After sorting:");
        printArray(array);
    }

    // Main merge sort function (recursive)
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);        // Sort left half
            mergeSort(arr, mid + 1, right);   // Sort right half

            merge(arr, left, mid, right);     // Merge the two halves
        }
    }

    // Merge two sorted subarrays into a single sorted array
    public static void merge(int[] arr, int left, int mid, int right) {
        // Sizes of the two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArr[j] = arr[mid + 1 + j];

        // Merge the temp arrays back into arr[left..right]
        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // Copy remaining elements of leftArr[]
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        // Copy remaining elements of rightArr[]
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }

    // Utility function to print array
    public static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}

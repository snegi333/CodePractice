public class BinarySearchExample {

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoid overflow

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }

        return -1; // Not found
    }

    public static void main(String[] args) {
        int[] sortedArray = {2, 4, 7, 10, 13, 18, 21};
        int target = 10;

        int index = binarySearch(sortedArray, target);
        System.out.println("Target found at index: " + index); // Output: 3
    }
}

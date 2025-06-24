import java.util.Stack;
import java.util.HashMap;

public class NextGreaterElement {

    public static void findNextGreater(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> resultMap = new HashMap<>();

        // Traverse from end to start
        for (int i = arr.length - 1; i >= 0; i--) {
            // Remove all elements smaller than or equal to arr[i]
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // If stack is empty, no greater element
            int nextGreater = stack.isEmpty() ? -1 : stack.peek();
            resultMap.put(arr[i], nextGreater);

            // Push current element to stack
            stack.push(arr[i]);
        }

        // Print results
        for (int num : arr) {
            System.out.println(num + " -> " + resultMap.get(num));
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        findNextGreater(arr);
    }
}

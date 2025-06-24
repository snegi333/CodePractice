public class PalindromeIterations {

    /*-
    1. Check if a number is a palindrome.
    2. If not, reverse the number and add it to the original.
    3. Repeat until a palindrome is formed.
    4. Return the number of iterations it took to reach a palindrome.

    Example ->
    number = 121
    output = 0

    number is 87
    87 + 78 = 165  -> 1st Iteration
    165 + 561 = 726 -> 2st Iteration
    726 + 627 = 1353 -> 3st Iteration
    1353 + 3531 = 4884 -> 4st Iteration
     */

    // Check if a number is palindrome
    public static boolean isPalindrome(int num) {
        return num == reverse(num);
    }

    // Reverse the digits of the number
    public static int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num = num / 10;
        }
        return rev;
    }

    // Find number of iterations to reach a palindrome
    public static int countPalindromeIterations(int num) {
        int count = 0;

        while (!isPalindrome(num)) {
            int reversed = reverse(num);
            num = num + reversed;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int number = 87;  // Change this to test other values
        int iterations = countPalindromeIterations(number);
        System.out.println("Number of iterations to reach a palindrome: " + iterations);
    }
}

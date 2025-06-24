public class PalindromeChecker {

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return false;

        int n = s.length();
        int left = 0;
        int right = n - 1;

        // Use the same idea as expandAroundCenter
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }

        return left >= right; // If we crossed over, it's a palindrome
    }

    public static void main(String[] args) {
        String s1 = "racecar";
        String s2 = "hello";
        String s3 = "abba";

//        System.out.println(s1 + " → " + isPalindrome(s1)); // true
//        System.out.println(s2 + " → " + isPalindrome(s2)); // false
        System.out.println(s3 + " → " + isPalindrome(s3)); // true
    }
}

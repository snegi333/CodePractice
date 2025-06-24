public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);       // Odd-length palindrome
            int len2 = expandFromCenter(s, i, i + 1);   // Even-length palindrome
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }




//    public static boolean isPalindrome(String s, int i, int j) {
//        while (i < j) {
//            char ch1 = s.charAt(i);
//            char ch2 = s.charAt(j);
//            if (ch1 != ch2)
//                return false;
//            i++;
//            j--;
//        }
//        return true;
//    }
//
//    public static String longestPalindrome(String s) {
//        int n = s.length();
//        int max = 0, start = 0, end = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                if (isPalindrome(s, i, j) == true) {
//                    if ((j - i + 1) > max) {
//                        max = j - i + 1;
//                        start = i;
//                        end = j;
//                    }
//                }
//            }
//        }
//        return s.substring(start, end + 1);
//    }

    public static void main(String[] args) {
        String s = "aba";
        System.out.println("Longest Palindromic Substring: " + longestPalindrome(s));
    }
}

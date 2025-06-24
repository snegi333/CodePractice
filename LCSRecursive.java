public class LCSRecursive {

    public static String lcs(String s1, String s2) {
        return lcsHelper(s1, s2, s1.length(), s2.length());
    }

    private static String lcsHelper(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) return "";

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return lcsHelper(s1, s2, m - 1, n - 1) + s1.charAt(m - 1);
        } else {
            String a = lcsHelper(s1, s2, m - 1, n);
            String b = lcsHelper(s1, s2, m, n - 1);
            return a.length() > b.length() ? a : b;
        }
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";

        String result = lcs(s1, s2);
        System.out.println("LCS: " + result); // Output: ace
    }
}

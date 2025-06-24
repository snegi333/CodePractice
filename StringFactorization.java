public class StringFactorization {

    public static String factorizeStrings(String str1, String str2) {
        int overlap1 = 0;
        int overlap2 = 0;

        // str1 + str2: find overlap at end of str1 and start of str2
        int len = Math.min(str1.length(), str2.length());
        for (int i = 1; i <= len; i++) {
            if (str1.substring(str1.length() - i).equals(str2.substring(0, i))) {
                overlap1 = i;
            }
        }

        // str2 + str1: find overlap at end of str2 and start of str1
        for (int i = 1; i <= len; i++) {
            if (str2.substring(str2.length() - i).equals(str1.substring(0, i))) {
                overlap2 = i;
            }
        }

        // Choose the better overlap
        if (overlap2 > overlap1) {
            return str2 + str1.substring(overlap2);
        } else {
            return str1 + str2.substring(overlap1);
        }
    }

    public static void main(String[] args) {
        String str1 = "1234yyabc";
        String str2 = "abcxxxx1234";

        String result = factorizeStrings(str1, str2);
        System.out.println("Result: " + result);
    }
}

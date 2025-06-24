public class CountConsecutiveCharInString {

    public static String compress(String s) {
        if (s == null || s.length() == 0) return "";

        String result = "";
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                result = result +  s.charAt(i - 1) + count;
                count = 1;
            }
        }

        // Add the last character group
        result = result + s.charAt(s.length() - 1) + count;

        return result;
    }

    public static void main(String[] args) {
        String input = "abb";
        String output = compress(input);
        System.out.println("Output String: " + output);
    }
}

public class AtoiConverter {

    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;

        int index = 0, sign = 1, result = 0;
        int n = s.length();

        // 1. Skip leading whitespaces
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // 2. Handle optional sign
        if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // 3. Convert digits to integer
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // 4. Check for overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));               // 42
        System.out.println(myAtoi("   -42"));           // -42
        System.out.println(myAtoi("4193 with words"));  // 4193
        System.out.println(myAtoi("words and 987"));    // 0
        System.out.println(myAtoi("-91283472332"));     // -2147483648 (clamped)
    }
}
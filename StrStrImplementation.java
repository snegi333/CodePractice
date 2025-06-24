public class StrStrImplementation {

    public static int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();

        if (nLen == 0) return 0;

        for (int i = 0; i < hLen; i++) {
            if (haystack.substring(i, i + nLen).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "hell";
        String needle = "ll";

        int index = strStr(haystack, needle);
        System.out.println("First occurrence at index: " + index);
    }
}
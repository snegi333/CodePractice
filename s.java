import java.util.*;

public class s {

    public static List<Integer> getRemovableIndices(String str1, String str2) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        Collections.sort(result);
        if (str1.length() != str2.length() + 1) {
            result.add(-1);
            return result;
        }
        for (int i = 0; i < str1.length(); i++) {
            String modifiedStr = str1.substring(0, i) + str1.substring(i + 1);
            if (modifiedStr.equals(str2)) {
                result.add(i);
            }
        }
        return result.isEmpty() ? Arrays.asList(-1) : result;

    }

    public static void main(String[] args) {
        String str1 = "abdgdaaaaa";
        String str2 = "abdgdaaaa";

        System.out.println(getRemovableIndices(str1, str2)); // Output: [3, 4, 5]
    }
}

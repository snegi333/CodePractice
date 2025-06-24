import java.util.*;

/*-
Problem Statement: Given a String, find the length of longest substring without any repeating character.
Examples:
Input: s = ”abcabcbb”
Output: 3
Explanation: The answer is abc with length of 3.

Input: s = ”bbbbb”
Output: 1
Explanation: The answer is b with length of 1 units.
 */
public class LongestUniqueSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;  // Left boundary of window

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            // If character is seen again, move start
            if (map.containsKey(current)) {
                start = Math.max(start, map.get(current));
            }

            map.put(current, i); // update latest index
            maxLength = Math.max(maxLength, i - start);
        }

        return maxLength;
    }

//    public static int lengthOfLongestSubstring2(String s) {
//        Set<Character> set = new HashSet<>();
//        int start = 0, max = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            char current = s.charAt(i);
//            while (set.contains(current)) {
//                set.remove(s.charAt(start));
//                start++;
//            }
//            set.add(s.charAt(i));
//            max = Math.max(max, i - start + 1);
//        }
//        return max;
//    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 3
        System.out.println(lengthOfLongestSubstring(""));         // 0
    }
}
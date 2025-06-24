import java.util.*;

public class SortStringArrayByLength {
    public static void main(String[] args) {
        String[] words = { "banana", "apple", "cat", "elephant", "dog", "zebra" };
        List<String> strList = new ArrayList<>();
        for (String str : words){
            strList.add(str);
        }
        Collections.sort(strList, (s1,s2) -> Integer.compare(s1.length(), s2.length()));
        for (String word : strList) {
            System.out.println(word);
        }
    }
}

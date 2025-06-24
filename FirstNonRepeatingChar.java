import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingChar {

    public static Character findFirstNonRepeatingChar(String str) {
        // LinkedHashMap preserves insertion order
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

        // Count occurrences of each character
        for (char c : str.toCharArray()) {
            if (!charCountMap.containsKey(c))
                charCountMap.put(c, 1);
            else
                charCountMap.put(c, charCountMap.get(c) + 1);
        }

        // Find the first character with a count of 1
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();

            }
        }

        return null; // All characters are repeating
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        Character result = findFirstNonRepeatingChar(input);

        if (result != null) {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating characters found.");
        }

        scanner.close();
    }
}
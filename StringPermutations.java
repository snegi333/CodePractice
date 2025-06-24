public class StringPermutations {

    // Recursive function to generate all permutations
    public static void permute(String str, String result) {
        if (str.length() == 0) {
            System.out.println(result);  // Base case: one permutation completed
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            // Fix one character and permute the rest
            char ch = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            permute(remaining, result + ch);
        }
    }

    public static void main(String[] args) {
        String input = "ABC";
        System.out.println("Permutations of " + input + ":");
        permute(input, "");
    }
}

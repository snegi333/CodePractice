import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigValidator {

    // Step 1: Define Validation Function
    public static boolean validateConfigString(String configString) {
        // Step 2: Split the String
        String[] configPairs = configString.split("\\|");

        // Step 3: Check for Missing Delimiters
        if (configPairs.length < 1) {
            return false; // Invalid: No configurations
        }

        // Step 4: Iterate and Validate Each Pair
        Set<Integer> indices = new HashSet<>();
        Set<String> values = new HashSet<>();
        int lastIndex = 0;

        for (String configPair : configPairs) {
            // Pattern: "000N.value" where N is a 4-digit number, value is 10 alphanumeric characters
            Pattern pattern = Pattern.compile("^(\\d{4})\\.([a-zA-Z0-9]{10})$");
            Matcher matcher = pattern.matcher(configPair);

            if (!matcher.matches()) {
                return false; // Invalid format
            }

            int index = Integer.parseInt(matcher.group(1));
            String value = matcher.group(2);

            // Check if index is sequential
            if (index != lastIndex + 1) {
                return false; // Missing index
            }
            // Check for duplicate index or value
            if (indices.contains(index) || values.contains(value)) {
                return false; // Duplicate index or value
            }

            indices.add(index);
            values.add(value);
            lastIndex = index;
        }

        // Step 5: Return Validation Result
        return true;
    }

    // Step 6: Extract Configuration Values (if valid)
    public static String[] extractConfigValues(String configString) {
        String[] configPairs = configString.split("\\|");
        String[] values = new String[configPairs.length];
        int i = 0;

        for (String configPair : configPairs) {
            Pattern pattern = Pattern.compile("^(\\d{4})\\.([a-zA-Z0-9]{10})$");
            Matcher matcher = pattern.matcher(configPair);

            if (matcher.matches()) {
                values[i++] = matcher.group(2);
            }
        }

        return values;
    }

    // Step 7: Example Usage
    public static void main(String[] args) {
        String configString = "0002f7227904 000176a3a4d214 000305d2 9f4a4b";

        boolean isValid = validateConfigString(configString);

        if (isValid) {
            String[] configValues = extractConfigValues(configString);
            System.out.println("Valid configuration:");
            for (String value : configValues) {
                System.out.println(value);
            }
        } else {
            System.out.println("Invalid configuration string");
        }
    }
}

import java.util.*;

public class JsonComparator {

    public static void main(String[] args) {
        String input1 = "{\"a\": [1,2,2], \"b\": null, \"c\": \"hello\"}";
        String input2 = "{\"a\": [1,2,2], \"b\": 10}";

        boolean result = compareJson(input1, input2);
        System.out.println("Are JSONs equal? " + result);
    }

    public static boolean compareJson(String json1, String json2) {
        Map<String, Object> map1 = parseJson(json1);
        Map<String, Object> map2 = parseJson(json2);
        return Objects.equals(map1, map2);
    }

    private static Map<String, Object> parseJson(String json) {
        Map<String, Object> result = new HashMap<>();
        json = json.trim().substring(1, json.length() - 1); // remove {}
        String[] tokens = splitTopLevel(json);

        for (String token : tokens) {
            String[] pair = token.split(":", 2);
            if (pair.length < 2) continue;

            String key = pair[0].trim().replaceAll("^\"|\"$", "");
            String value = pair[1].trim();

            result.put(key, parseValue(value));
        }

        return result;
    }

    private static String[] splitTopLevel(String json) {
        List<String> result = new ArrayList<>();
        int depth = 0;
        int start = 0;

        for (int i = 0; i < json.length(); i++) {
            char ch = json.charAt(i);
            if (ch == '[' || ch == '{') depth++;
            if (ch == ']' || ch == '}') depth--;
            if (ch == ',' && depth == 0) {
                result.add(json.substring(start, i));
                start = i + 1;
            }
        }
        result.add(json.substring(start));
        return result.toArray(new String[0]);
    }

    private static Object parseValue(String value) {
        if (value.equals("null")) return null;

        if (value.startsWith("\"") && value.endsWith("\"")) {
            return value.substring(1, value.length() - 1);
        }

        if (value.startsWith("[") && value.endsWith("]")) {
            String arrayContent = value.substring(1, value.length() - 1).trim();
            if (arrayContent.isEmpty()) return new ArrayList<>();

            String[] elements = arrayContent.split(",");
            List<String> list = new ArrayList<>();
            for (String element : elements) {
                list.add(element.trim());
            }
            return list;
        }

        // Try parsing as number
        try {
            if (value.contains(".")) return Double.parseDouble(value);
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return value;
        }
    }
}

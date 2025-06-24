import java.util.regex.Pattern;

public class DeploymentCounter {

    public int[] deployments(String[] jsonReqs) {
        int[] result = new int[3];
        Pattern p = Pattern.compile("[^a-zA-Z0-9]");

        for (String json : jsonReqs) {
            String[] keyValuePairs = json.substring(1, json.length() - 1).split(", ");
            for (String pair : keyValuePairs) {
                String deploymentId = null;
                String status = null;
                String[] keyValue = pair.split(": ");
                String key = keyValue[0].replaceAll("\"", "").trim();
                String value = keyValue[1].replaceAll("\"", "").trim();

                if (key.equals("deployment_id")) {
                    deploymentId = value;
                    if (!deploymentId.startsWith("d-")) {
                        result[2]++;
                        break;
                    }
                    String identifier = deploymentId.substring(2);
                    if (identifier.length() != 10) {
                        result[2]++;
                        break;
                    }
                    boolean hasSpecialChar = p.matcher(identifier).find();
                    if (hasSpecialChar) {
                        result[2]++;
                        break;
                    }
                } else if (key.equals("status")) {
                    status = value;
                    if (status.equals("Success")) {
                        result[0]++;
                    } else if (status.equals("Fail")) {
                        result[1]++;
                    } else {
                        result[2]++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DeploymentCounter counter = new DeploymentCounter();
        String[] jsonReqs = {
                "{\"deployment_id\": \"d-12345678ab\", \"status\": \"Success\"}",
                "{\"deployment_id\": \"d-12345678ab\", \"status\": \"ABCDE\"}"
        };

        int[] result = counter.deployments(jsonReqs);

        System.out.println("Success: " + result[0]);
        System.out.println("Fail: " + result[1]);
        System.out.println("Invalid: " + result[2]);
    }
}

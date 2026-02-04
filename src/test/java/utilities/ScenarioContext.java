package utilities;

import java.util.HashMap;
import java.util.Map;

/**
 * ScenarioContext - Shared data storage for Cucumber scenarios
 *
 * This class allows different step definition classes to share data during a scenario execution.
 *
 * QA Learning:
 * - Acts as a temporary storage (like a HashMap) for scenario data
 * - Data is stored with a KEY-VALUE pair
 * - Any step definition can store data using setContext(key, value)
 * - Any step definition can retrieve data using getContext(key)
 * - Data is automatically cleared after each scenario
 *
 * Example Usage:
 *
 * Step 1 (Store data):
 *   ScenarioContext.setContext("BATCH_NAME", "test_batch_12345");
 *
 * Step 2 (Retrieve data):
 *   String batchName = (String) ScenarioContext.getContext("BATCH_NAME");
 *   // batchName = "test_batch_12345"
 *
 * Common Keys to Use:
 * - "BATCH_NAME" - For batch names created during upload
 * - "NOTICE_ID" - For notice IDs
 * - "USER_NAME" - For user names
 * - "TEMPLATE_NAME" - For template names
 */
public class ScenarioContext {

    // HashMap to store scenario data as key-value pairs
    private static Map<String, Object> scenarioContext = new HashMap<>();

    /**
     * Store data in ScenarioContext
     * @param key The key to identify the data (e.g., "BATCH_NAME")
     * @param value The value to store (can be any Object type)
     */
    public static void setContext(String key, Object value) {
        scenarioContext.put(key, value);
        System.out.println("[ScenarioContext] Stored: " + key + " = " + value);
    }

    /**
     * Retrieve data from ScenarioContext
     * @param key The key to identify the data
     * @return The stored value, or null if key doesn't exist
     */
    public static Object getContext(String key) {
        Object value = scenarioContext.get(key);
        System.out.println("[ScenarioContext] Retrieved: " + key + " = " + value);
        return value;
    }

    /**
     * Check if a key exists in ScenarioContext
     * @param key The key to check
     * @return true if key exists, false otherwise
     */
    public static boolean containsKey(String key) {
        return scenarioContext.containsKey(key);
    }

    /**
     * Clear all data from ScenarioContext
     * This should be called after each scenario completes
     */
    public static void clearContext() {
        System.out.println("[ScenarioContext] Clearing all stored data");
        scenarioContext.clear();
    }
}

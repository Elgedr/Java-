package ee.taltech.iti0202.mysticorbs.storage;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ResourceStorage {

    public HashMap<String, Integer> resources = new LinkedHashMap<>();

    /**
     * Constructor.
     */
    public ResourceStorage() {
    }

    /**
     *
     * @return boolean.
     */
    public boolean isEmpty() {
        if (resources.size() == 0) {
            return true;
        }
        for (String key : resources.keySet()) {
            if (resources.get(key) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param resource resource.
     * @param amount amount.
     */
    public void addResource(String resource, int amount) {
        if (!resource.isBlank() && amount > 0) {
            if (!resources.containsKey(resource.toLowerCase())) {
                resources.put(resource.toLowerCase(), amount);
            } else if (resources.containsKey(resource.toLowerCase())) {
                int newValue = resources.get(resource.toLowerCase()) + amount;
                System.out.println(newValue);
                resources.put(resource.toLowerCase(), newValue);
            }
        }
    }

    /**
     *
     * @param resource resource.
     * @return string.
     */
    public int getResourceAmount(String resource) {
        if (resources.containsKey(resource.toLowerCase())) {
            return resources.get(resource.toLowerCase());
        }
        return 0;
    }

    /**
     *
     * @param resource resource.
     * @param amount amount.
     * @return boolean.
     */
    public boolean hasEnoughResource(String resource, int amount) {
        if (amount < 1) {
            return false;
        }
        if (resources.size() == 0 || !resources.containsKey(resource.toLowerCase())) {
            return false;
        }
        if (resources.get(resource.toLowerCase()) >= amount) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param resource resource.
     * @param amount amount.
     * @return boolean.
     */
    public boolean takeResource(String resource, int amount) {
        if (hasEnoughResource(resource.toLowerCase(), amount)) {
            resources.put(resource.toLowerCase(), resources.get(resource.toLowerCase()) - amount);
            return true;
        }
        return false;
    }

}

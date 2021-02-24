package ee.taltech.iti0202.mysticorbs.storage;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ResourceStorage {

    public HashMap<String, Integer> resources = new LinkedHashMap<>();

    public ResourceStorage() {
    }

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

    public void addResource(String resource, int amount) {
        if (!resource.equals("")) {
            if (resources.containsKey(resource)) {
                resources.put(resource, resources.get(resource) + amount);
            }
            resources.put(resource, amount);
        }
    }

    public int getResourceAmount(String resource) {
        if (resources.containsKey(resource)) {
            return resources.get(resource);
        }
        return 0;
    }

    public boolean hasEnoughResource(String resource, int amount) {
        if (amount < 1) {
            return false;
        }
        if (resources.get(resource) >= amount) {
            return true;
        }
        return false;
    }

    public boolean takeResource(String resource, int amount) {
        if (hasEnoughResource(resource, amount)) {
            resources.put(resource, resources.get(resource) - amount);
            return true;
        }
        return false;
    }
}

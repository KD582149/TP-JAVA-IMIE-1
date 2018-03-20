package imie.java.tp.utils;

import java.util.HashMap;
import java.util.Map;

public class PropertyBuilder {

    private Map<String, Object> properties;

    private PropertyBuilder() {
        properties = new HashMap<>();
    }

    public static PropertyBuilder instance() {
        return new PropertyBuilder();
    }

    public PropertyBuilder put(String key, Object value) {
        properties.put(key, value);
        return this;
    }

    public Map<String, Object> build() {
        return new HashMap<>(properties);
    }
}

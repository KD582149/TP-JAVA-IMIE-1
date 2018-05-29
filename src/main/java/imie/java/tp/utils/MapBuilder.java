package imie.java.tp.utils;

import java.util.HashMap;
import java.util.Map;

public class MapBuilder<K, V> {

    private Map<K, V> properties;

    protected MapBuilder() {
        properties = new HashMap<>();
    }

    public static <K, V> MapBuilder<K, V> instance() {
        return new MapBuilder<>();
    }

    public MapBuilder<K, V> put(K key, V value) {
        properties.put(key, value);
        return this;
    }

    public Map<K, V> build() {
        return new HashMap<>(properties);
    }
}
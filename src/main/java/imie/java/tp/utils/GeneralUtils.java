package imie.java.tp.utils;

import java.util.Map;
import java.util.Optional;

public class GeneralUtils {

    public static boolean isEmpty(Object o) {
        if (o == null) return true;

        if (o instanceof String)
            return ((String) o).trim().length() == 0;

        if (o instanceof Iterable)
            return !((Iterable) o).iterator().hasNext();

        try {
            if (o instanceof Object[])
                return ((Object[]) o).length == 0;
        } catch (ClassCastException ignored) {}

        if (o instanceof Optional)
            return !((Optional) o).isPresent();

        if (o instanceof Map)
            return ((Map) o).isEmpty();

        return false;
    }

    public static <V> V valueOrDefault(V value, V defaultVal) {
        return isEmpty(value) ? defaultVal : value;
    }
}

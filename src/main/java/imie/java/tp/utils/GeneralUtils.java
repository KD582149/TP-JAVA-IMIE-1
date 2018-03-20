package imie.java.tp.utils;

import java.util.Collection;
import java.util.function.Supplier;

public class GeneralUtils {

    public static <T, C extends Collection<T>> C fromIterable(Iterable<T> elements,
                                                              Supplier<C> collectionFactory) {
        C results = collectionFactory.get();
        elements.forEach(results::add);
        return results;
    }

    public static boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }
}

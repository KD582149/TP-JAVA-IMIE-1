package imie.java.tp.model.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

public interface Mapper<S, T> {

    T map(S source);

    S reverse(T target);

    default <C extends Collection<T>> C map(Collection<S> source, Supplier<C> factory) {
        C results = factory.get();
        source.stream()
                .map(this::map)
                .forEachOrdered(results::add);
        return results;
    }

    default <C extends Collection<S>> C reverse(Collection<T> source, Supplier<C> factory){
        C results = factory.get();
        source.stream()
                .map(this::reverse)
                .forEachOrdered(results::add);
        return results;
    }

    default List<T> map(Collection<S> source) {
        return map(source, ArrayList::new);
    }

    default List<S> reverse(Collection<T> source) {
        return reverse(source, ArrayList::new);
    }
}


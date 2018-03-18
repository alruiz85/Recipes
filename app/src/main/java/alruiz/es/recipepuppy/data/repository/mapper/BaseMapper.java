package alruiz.es.recipepuppy.data.repository.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Comment.
 */

public abstract class BaseMapper<K, V> {

    public abstract V map(K from);

    List<V> map(List<K> from) {
        if (from == null) return new ArrayList<V>();
        ArrayList<V> to = new ArrayList<V>(from.size());
        for (K item :
                from) {
            to.add(map(item));
        }
        return to;
    }

}

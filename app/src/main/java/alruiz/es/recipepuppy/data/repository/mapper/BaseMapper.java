package alruiz.es.recipepuppy.data.repository.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseMapper.
 */
public abstract class BaseMapper<K, V> {

    public abstract V map(K value);

    public abstract K reverseMap(V value);

    public List<V> map(List<K> values) {
        List<V> returnValues = new ArrayList<>(values.size());
        for (K value : values) {
            returnValues.add(map(value));
        }
        return returnValues;
    }

    public List<K> reverseMap(List<V> values) {
        List<K> returnValues = new ArrayList<>(values.size());
        for (V value : values) {
            returnValues.add(reverseMap(value));
        }
        return returnValues;
    }

}

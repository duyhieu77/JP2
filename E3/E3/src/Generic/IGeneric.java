package Generic;

import java.util.List;
import java.util.Optional;

public interface IGeneric<T> {
    void add(T item);
    Optional<T> get(String id);
    List<T> getAll();
}
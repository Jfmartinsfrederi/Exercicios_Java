package persistence;


import java.util.List;
import java.util.Optional;

public interface Repository <K,T> {
    void save(T e);
    void update(T e);
    void remove(K id);
    List<T> findById(K id);

}

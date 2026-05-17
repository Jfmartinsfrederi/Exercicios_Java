import java.util.Map;
import java.util.Optional;

public interface Repository<K, T> {
    void save(T e);

    void update(T e);

    void remove(K id);

    Optional<T> findById(K id);

    Map<K,T> getEmployees();
}

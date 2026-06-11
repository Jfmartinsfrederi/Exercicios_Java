package repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface RepositoryPaychecks<K,T> {
    void add(K id,T t);

    void update(K id,T t);

    void remove(K id,T t);

    List<T> findByDate(K id,LocalDate localDate);

    List<T> getPaychecksByEmployee(K id);

    List<T> getPaychecks();
}

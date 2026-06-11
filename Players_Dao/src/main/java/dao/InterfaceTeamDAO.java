package dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface InterfaceTeamDAO<K,T> {
    void save(T t);
    void remove(K id);
    void update(T t);
    Optional<T> findByName(K name);
    Map<K,T> getTeams();
}

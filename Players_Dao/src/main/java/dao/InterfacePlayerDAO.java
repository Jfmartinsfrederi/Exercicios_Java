package dao;

import java.util.Map;
import java.util.Optional;

public interface InterfacePlayerDAO<K,T> {
    void save(T t,String team);
    void remove(K id,String team);
    void update(T t,String team);
    Optional<T> findById(K id,String team);
    Map<K,T> getPlayers(String team);
}

package persistence;


import java.util.List;

public interface Repository <K,T> {
    void save(T e);
    void update(T e);
    void remove(K id);
    List<T> findById(K id); // TODO find by id não deveria retornar uma lista, já que é um só. É T apenas ou idealmente Optional<T>
}

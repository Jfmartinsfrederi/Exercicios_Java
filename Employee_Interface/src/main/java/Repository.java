
//TODO use Repository<K,T> to make it generic for any key type, not only Strings.
public interface Repository <T>{
    void saveEntity(T entity);
    T findByID(String id);
}

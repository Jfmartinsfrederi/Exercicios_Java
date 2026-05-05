public interface Repository <T>{
    void saveEntity(T entity);
    T findByID(String id);

}

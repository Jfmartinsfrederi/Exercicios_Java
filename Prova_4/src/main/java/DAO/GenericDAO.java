package DAO;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public abstract class GenericDAO<K, T extends Entidade<K>> {
    private final Map<K, T> repository;

    public GenericDAO() {
        this.repository = new TreeMap<>();
    }

    public void salvar(T entidade) {
        repository.put(entidade.getId(), entidade);
    }

    public void atualizar(T entidade) {
        repository.replace(entidade.getId(), entidade);
    }

    public void remover(T entidade){
        remover(entidade.getId());
    }

    public void remover(K id) {
        repository.remove(id);
    }

    public Optional<T> buscarPorId(K id) {
        return Optional.ofNullable(repository.get(id));
    }

    public Collection<T> listarTodos() {
        return Collections.unmodifiableCollection(repository.values());
    }
}
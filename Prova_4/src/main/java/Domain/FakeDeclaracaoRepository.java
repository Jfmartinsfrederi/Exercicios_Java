package Domain;

import DAO.GenericDAO;
import application.DeclaracaoRepository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class FakeDeclaracaoRepository
        extends GenericDAO<Long, Declaracao>
        implements DeclaracaoRepository {


}
/*private static final Map<Long,Declaracao> repository=new LinkedHashMap<>();

    @Override
    public void salvar(Declaracao declaracao) {
        final long id=declaracao.getId();
        if (repository.containsKey(id)) throw new EntityAlreadyExists("Entidade já cadastrada");
        repository.put(id,declaracao);

    }

    @Override
    public void atualizar(Declaracao declaracao) {
        final long id=declaracao.getId();
        idExists(id);
        repository.replace(id,declaracao);
    }

    private static void idExists(long id) {
        if (!repository.containsKey(id)) throw new NoSuchElementException("Entidade Não Cadastrada");
    }

    @Override
    public void remover(Declaracao declaracao) {
        remover(declaracao.getId());

    }

    @Override
    public void remover(long id) {
        idExists(id);
        repository.remove(id);

    }

    @Override
    public Optional<Declaracao> buscarPorId(long id) {
        return Optional.ofNullable(repository.get(id));
    }



    @Override
    public void salvar(Declaracao declaracao) {
        saveEntity(declaracao);
    }

    @Override
    public void atualizar(Declaracao declaracao) {
        replaceEntity(declaracao);
    }

    @Override
    public void remover(Declaracao declaracao) {
        removeEntity(declaracao.getId());
    }

    @Override
    public void remover(long id) {
        removeEntity(id);
    }

    @Override
    public Optional<Declaracao> buscarPorId(long id) {
        return super.buscarPorId(id);
    }
    */

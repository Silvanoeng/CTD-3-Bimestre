package dao;

import java.util.List;
import java.util.Optional;

public interface IDao <T> {
    public T salvar(T t);
    public T alterar(T t);
    public void excluir(Integer id);
    public Optional<T> buscar(Integer id);
    public List<T> listarTodos();

}

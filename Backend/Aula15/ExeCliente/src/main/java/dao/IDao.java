package dao;

public interface IDao <T> {
    public T salvar(T t);
    public T buscar(Integer id);
    public void deletar(Integer id);
    public T editar(Integer id);
}

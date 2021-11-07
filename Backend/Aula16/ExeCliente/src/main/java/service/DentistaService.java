package service;

import dao.IDao;
import dao.impl.DentistaDaoImpl;
import model.Dentista;
import java.util.List;
import java.util.Optional;

public class DentistaService {
    private IDao<Dentista> dentistaIDao;

    public DentistaService(){this.dentistaIDao = new DentistaDaoImpl(); }

    public Dentista salvarDentista(Dentista dentista){ return dentistaIDao.salvar(dentista); }

    public Dentista alterarDentista(Dentista dentista){ return dentistaIDao.alterar(dentista); }

    public void deletarDentista(int id){ dentistaIDao.excluir(id); }

    public Optional<Dentista> buscarDentista(int id){return dentistaIDao.buscar(id); }

    public List<Dentista> buscarTodosDentistas(){ return dentistaIDao.listarTodos(); }

}

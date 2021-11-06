package service;

import dao.IDao;
import dao.impl.DentistaDaoImpl;
import model.Dentista;

import java.util.List;
import java.util.Optional;

public class DentistaService {
    private IDao<Dentista> dentistaIDao;

    public DentistaService(){this.dentistaIDao = new DentistaDaoImpl();}

    public Dentista salvar(Dentista dentista){
        return dentistaIDao.salvar(dentista);
    }

    public List<Dentista> buscarTodos(){ return dentistaIDao.listarTodos();}

    public Dentista alterar(Dentista dentista){ return dentistaIDao.alterar(dentista);}

    public Optional<Dentista> buscar(int id){return dentistaIDao.buscar(id);}

    public void deletarDentista(int id){ dentistaIDao.excluir(id); }
}

package service;

import dao.IDao;
import dao.impl.DentistaDaoImpl;
import model.Dentista;

import java.util.List;

public class DentistaService {
    private IDao<Dentista> dentistaIDao;

    public DentistaService(){
        this.dentistaIDao = new DentistaDaoImpl();}

    public Dentista salvar(Dentista dentista){
        return dentistaIDao.salvar(dentista);
    }

    public List<Dentista> buscarTodos(){ return dentistaIDao.listarTodos();}

    public Dentista alterar(Dentista dentista){ return dentistaIDao.alterar(dentista);}
}

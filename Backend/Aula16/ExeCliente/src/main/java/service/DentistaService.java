package service;

import dao.IDao;
import model.Dentista;

import java.util.List;

public class DentistaService {
    private IDao<Dentista> dentistaIDao;

    public DentistaService(IDao<Dentista> dentistaIDao){
        this.dentistaIDao = dentistaIDao;
    }

    public Dentista salvar(Dentista paciente){
        return dentistaIDao.salvar(paciente);
    }

    public List<Dentista> buscarTodos(){ return dentistaIDao.listarTodos();}
}

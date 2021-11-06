package service;

import dao.IDao;
import dao.impl.PacienteDaoImpl;
import model.Paciente;

import java.util.List;
import java.util.Optional;

public class PacienteService {
    private IDao<Paciente> pacienteIDao;

    public PacienteService(){
        this.pacienteIDao = new PacienteDaoImpl();
    }

    public Paciente salvar(Paciente p) {
        return pacienteIDao.salvar(p);
    }

    public Optional<Paciente> buscar(Integer id){
        return pacienteIDao.buscar(id);
    }

    public void excluir(Integer id) {
        pacienteIDao.excluir(id);
    }

    public List<Paciente> buscarTodos() {
        return pacienteIDao.buscarTodos();
    }
}

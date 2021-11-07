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

    public Paciente salvarPaciente(Paciente paciente) {
        return pacienteIDao.salvar(paciente);
    }

    public Paciente alterarPaciente(Paciente paciente) { return pacienteIDao.alterar(paciente); }

    public void deletarPaciente(Integer id) {
        pacienteIDao.excluir(id);
    }

    public Optional<Paciente> buscarPaciente(Integer id){
        return pacienteIDao.buscar(id);
    }

    public List<Paciente> buscarTodosPacientes() {
        return pacienteIDao.buscarTodos();
    }
}

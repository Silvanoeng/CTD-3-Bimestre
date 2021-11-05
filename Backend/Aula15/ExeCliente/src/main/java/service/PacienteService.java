package service;


import dao.IDao;
import model.Paciente;

public class PacienteService {
    private IDao<Paciente> pacienteDao;

    public PacienteService( IDao<Paciente> pacienteDao){
        this.pacienteDao = pacienteDao;
    }

    public Paciente salvar(Paciente paciente){
        return pacienteDao.salvar(paciente);
    }



}

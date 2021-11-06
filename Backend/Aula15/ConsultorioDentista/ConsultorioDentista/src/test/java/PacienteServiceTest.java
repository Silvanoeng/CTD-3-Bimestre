import model.Endereco;
import model.Paciente;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.PacienteService;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PacienteServiceTest {
    private static PacienteService pacienteService = new PacienteService();

    @BeforeAll
    public static void carregarTabela(){
        Endereco endereco = new Endereco("Av Augusto de Lima", "444", "Belo Horizonte", "Minas Gerais");
        Paciente p = pacienteService.salvar(new Paciente("Glauber", "Lima", "12345678", new Date(), endereco));
        Endereco endereco1 = new Endereco("Av Paulista", "333", "São Paulo", "São Paulo");
        Paciente p1 = pacienteService.salvar(new Paciente("Marcela", "Souza", "98765432", new Date(), endereco1));
    }

    @Test
    public void salvarPacienteEBuscar() {
        Endereco endereco = new Endereco("Av Vieira Souto", "123", "Rio de Janeiro", "Rio de Janeiro");
        Paciente p = pacienteService.salvar(new Paciente("Thomas", "Pereira", "12309845", new Date(), endereco));

        assertNotNull(pacienteService.buscar(p.getId()));
    }

    @Test
    public void excluirPacienteTest(){
        Endereco endereco = new Endereco("Av Vieira Souto", "123", "Rio de Janeiro", "Rio de Janeiro");
        Paciente p = pacienteService.salvar(new Paciente("Thomas", "Pereira", "12309845", new Date(), endereco));

        assertFalse(pacienteService.buscar(p.getId()).isEmpty());
        pacienteService.excluir(p.getId());
        assertTrue(pacienteService.buscar(p.getId()).isEmpty());
    }

    @Test
    public void buscarTodos() {
        List<Paciente> pacientes = pacienteService.buscarTodos();

        assertFalse(pacientes.isEmpty());
    }
}

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
        Endereco end01 = new Endereco("Rua Independência", "888", "Mostardas", "Rio Grande do Sul");
        Paciente test01 = pacienteService.salvarPaciente(new Paciente("Silvano", "Araujo", "123654789", new Date(), end01));
        Endereco end02 = new Endereco("Rua 11 de abril", "366", "Mostardas", "Rio Grande do Sul");
        Paciente teste02 = pacienteService.salvarPaciente(new Paciente("Marcos", "Paulo", "147852369", new Date(), end02));
    }

    @Test
    public void listarTodos(){
        List<Paciente> pacientes = pacienteService.buscarTodosPacientes();
        assertFalse(pacientes.isEmpty());
    }

    @Test
    public void cirarExcluir(){
        Endereco end04 = new Endereco("Rua Bento Gonçalves", "123", "Tavares", "Rio Grande do Sul");
        Paciente teste04 = pacienteService.salvarPaciente(new Paciente("Paulo", "Pereira", "12309845", new Date(), end04));
        assertFalse(pacienteService.buscarPaciente(teste04.getIdPac()).isEmpty());
        pacienteService.deletarPaciente(teste04.getIdPac());
        assertTrue(pacienteService.buscarPaciente(teste04.getIdPac()).isEmpty());
    }

    @Test
    public void alterarPaciente(){
        Endereco end05 = new Endereco("Rua Padre Simão", "123", "Tavares", "Rio Grande do Sul");
        Paciente teste05 = pacienteService.salvarPaciente(new Paciente("Lucas", "Velho", "12309845", new Date(), end05));
        teste05.setNome("Antonio");
        Paciente teste06 = pacienteService.alterarPaciente(teste05);
        assertEquals(teste06.getNome(),"Antonio");
    }

    @Test
    public void buscarPaciente() {
        Endereco end03 = new Endereco("Rua Pinheiro Machado", "588", "Tavares", "Rio Grande do Sul");
        Paciente teste03 = pacienteService.salvarPaciente(new Paciente("Calos", "Silva", "12309845", new Date(), end03));
        assertEquals(pacienteService.buscarPaciente(teste03.getIdPac()).get().getEndereco().getNumero(),"588");
    }




}

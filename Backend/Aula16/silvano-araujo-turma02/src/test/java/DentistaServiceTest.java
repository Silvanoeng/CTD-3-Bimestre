
import model.Dentista;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.DentistaService;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class DentistaServiceTest {
    private static DentistaService dentistaService = new DentistaService();

    @BeforeAll
    public static void carregarDados(){
        Dentista test01 = dentistaService.salvarDentista(new Dentista(125, "Silvano", "Araujo"));
        Dentista test02 = dentistaService.salvarDentista(new Dentista(545, "Paula", "Silva"));
        Dentista test03 = dentistaService.salvarDentista(new Dentista(45, "Paulo", "Ramos"));
    }

    @Test
    public void listarTodos(){
        List<Dentista> dentistas = dentistaService.buscarTodosDentistas();
        assertFalse(dentistas.isEmpty());
    }

    @Test
    public void criarExcluir(){
        Dentista test04 = dentistaService.salvarDentista(new Dentista(596, "Marcos", "Alves"));
        assertFalse(dentistaService.buscarDentista(test04.getIdDen()).isEmpty());
        dentistaService.deletarDentista(test04.getIdDen());
        assertTrue(dentistaService.buscarDentista(test04.getIdDen()).isEmpty());
    }

    @Test
    public void alterarDentista(){
        Dentista test05 = dentistaService.salvarDentista(new Dentista(516, "Mariana", "Souza"));
        test05.setNome("Maria");
        Dentista test06 = dentistaService.alterarDentista(test05);
        assertEquals(test06.getNome(), "Maria");
    }

    @Test
    public void buscarDentista(){
        Dentista test06 = dentistaService.salvarDentista(new Dentista(526, "Helio", "Velho"));
        assertEquals(dentistaService.buscarDentista(test06.getIdDen()).get().getNumeroMatricula(), 526);
    }

}

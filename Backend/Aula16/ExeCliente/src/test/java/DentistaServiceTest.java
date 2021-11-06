
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
        Dentista test01 = dentistaService.salvar(new Dentista(125, "Silvano", "Araujo"));
        Dentista test02 = dentistaService.salvar(new Dentista(545, "Paula", "Silva"));
        Dentista test03 = dentistaService.salvar(new Dentista(45, "Paulo", "Ramos"));
    }

    @Test
    public void listarTodos(){
        List<Dentista> dentistas = dentistaService.buscarTodos();
        assertFalse(dentistas.isEmpty());
    }

    @Test
    public void criarExcluir(){
        Dentista test04 = dentistaService.salvar(new Dentista(596, "Marcos", "Alves"));
        assertFalse(dentistaService.buscar(test04.getId()).isEmpty());
        dentistaService.deletarDentista(test04.getId());
        assertTrue(dentistaService.buscar(test04.getId()).isEmpty());
    }

    @Test
    public void alterarDentista(){
        Dentista test05 = dentistaService.salvar(new Dentista(516, "Mariana", "Souza"));
        test05.setNome("Maria");
        dentistaService.alterar(test05);
        assertEquals(test05.getNome(), "Maria");
    }

    @Test
    public void buscarDentista(){
        Dentista test06 = dentistaService.salvar(new Dentista(526, "Helio", "Velho"));
        assertEquals(dentistaService.buscar(test06.getId()).get().getNumeroMatricula(), 526);
    }

}


import model.Dentista;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.DentistaService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;


public class DentistaServiceTest {
    private static DentistaService dentistaService = new DentistaService();

    @BeforeAll
    public static void carregarDados(){
        Dentista test01 = dentistaService.salvar(new Dentista(125, "Silvano", "Araujo"));
        Dentista test02 = dentistaService.salvar(new Dentista(545, "Paula", "Silva"));
        Dentista test03 = dentistaService.salvar(new Dentista(45, "Paulo", "Ramos"));
        System.out.println(test03);
        test03.setNome("João");
        System.out.println(dentistaService.alterar(test03));
        System.out.println(test03);
    }

    @Test
    public void listarTodos(){
        List<Dentista> dentistas = dentistaService.buscarTodos();
        assertFalse(dentistas.isEmpty());

    }

}

import dao.ConfiguracaoJDBC;
import dao.impl.DentistaDaoImpl;
import model.Dentista;
import org.junit.jupiter.api.Test;
import service.DentistaService;


public class DentistaServiTest {
    private DentistaService dentistaService = new DentistaService(new DentistaDaoImpl(new ConfiguracaoJDBC()));

    @Test
    public void guardaPaciente(){

        Dentista test02 = new Dentista(125, "Silvano", "Araujo");

        Dentista test04 = new Dentista(545, "Paula", "Silva");

        Dentista test06 = new Dentista(589, "Sara", "Pereira");

        System.out.println(dentistaService.salvar(test02));

        System.out.println(dentistaService.salvar(test04));

        System.out.println(dentistaService.salvar(test06));

        System.out.println(dentistaService.buscarTodos());

    }

}

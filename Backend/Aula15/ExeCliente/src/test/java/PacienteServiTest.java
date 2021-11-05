import dao.ConfiguracaoJDBC;
import dao.IDao;
import dao.impl.PacienteDaoImpl;
import model.Endereco;
import model.Paciente;
import org.junit.jupiter.api.Test;
import service.PacienteService;


public class PacienteServiTest{
    private PacienteService pacienteService = new PacienteService(new PacienteDaoImpl(new ConfiguracaoJDBC()));

    @Test
    public void guardaPaciente(){
        Endereco test01 = new Endereco("Rua dois", "123", "Mostards", "Rio Grande do Sul" );
        Paciente test02 = new Paciente("Silvano", "Araujo", "123456789", "04/11/2021",test01);
    }

}

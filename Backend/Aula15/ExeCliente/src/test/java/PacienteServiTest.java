import dao.ConfiguracaoJDBC;
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

        Endereco test03 = new Endereco("Rua um", "1234", "Mostards", "Rio Grande do Sul" );
        Paciente test04 = new Paciente("Paula", "Silva", "123456789", "04/11/2021",test03);

        Endereco test05 = new Endereco("Rua quatro", "12345", "Mostards", "Rio Grande do Sul" );
        Paciente test06 = new Paciente("Sara", "Pereira", "123456789", "04/11/2021",test05);

        pacienteService.salvar(test02);

        pacienteService.salvar(test04);

        pacienteService.salvar(test06);
    }

}

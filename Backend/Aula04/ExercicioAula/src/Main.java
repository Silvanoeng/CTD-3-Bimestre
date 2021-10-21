import com.dh.aula.service.CheckMail;
import com.dh.aula.service.Mail;

public class Main {
    public static void main(String[] args) {
        CheckMail processo = new CheckMail();
        processo.verificar(new Mail("email@email.com", "tecnico@colmeia.com", "Reclamação"));
        processo.verificar(new Mail("email@email.com", "Tecnico", "Reclamação"));
        processo.verificar(new Mail("email@email.com", "tecnico@colmeia.com", "Gerencia"));
        processo.verificar(new Mail("email@email.com", "Tecnico", "Reclamação"));
        processo.verificar(new Mail("email@email.com", "comercial@colmeia.com", "Reclamação"));
        processo.verificar(new Mail("email@email.com", "Tecnico", "Reclamação"));
        processo.verificar(new Mail("email@email.com", "comercial@colmeia.com", "Gerencia"));
        processo.verificar(new Mail("email@email.com", "Tecnico", "Reclamação"));

    }
}

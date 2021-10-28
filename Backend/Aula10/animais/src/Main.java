import org.apache.log4j.Logger;
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Tigre primeiro = new Tigre("Sara", 10);
        Leão segundo = new Leão("Ray", 14, true);
        Leão teceiro = new Leão("Ray", -4, true);

        primeiro.correr();
        segundo.correr();
        try {
            segundo.eMiorQue10();
        } catch (Exception e) {
            logger.error("A idade do leão " + segundo.getNome() + " está incorreta.", e);
        }

        try {
            teceiro.eMiorQue10();
        } catch (Exception e) {
            logger.error("A idade do leão " + teceiro.getNome() + " está incorreta.", e);
        }

    }
}

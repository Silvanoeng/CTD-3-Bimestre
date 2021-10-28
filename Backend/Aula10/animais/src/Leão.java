import org.apache.log4j.Logger;

public class Leão {
    private static final Logger logger = Logger.getLogger(Leão.class);
    private String nome;
    private int idade;
    private boolean eAlfa;

    public Leão(String nome, int idade, boolean eAlfa) {
        this.nome = nome;
        this.idade = idade;
        this.eAlfa = eAlfa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean iseAlfa() {
        return eAlfa;
    }

    public void seteAlfa(boolean eAlfa) {
        this.eAlfa = eAlfa;
    }
    public void correr(){logger.info("O leão " + this.nome + " está correndo"); }

    public void eMiorQue10() throws Exception{
        if(this.idade>10 && this.eAlfa) {
            logger.info("O leão " + this.nome + " é maior de 10 anos e é alfa!");
        }
        if (this.idade < 0){
            logger.error("A idade não pode ser negativa!");
            throw new Exception();
        }

    }
}

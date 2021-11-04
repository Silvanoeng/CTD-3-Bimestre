import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Cachorro> cachorros = new ArrayList<>();

        Cachorro cachorro1 = new Cachorro();
        cachorro1.setIdade(3);
        cachorro1.setNome("Rex");

        Cachorro cachorro2 = new Cachorro();
        cachorro1.setIdade(1);
        cachorro1.setNome("Lady");

        cachorros.add(cachorro1);
        cachorros.add(cachorro2);

        FileOutputStream fo = null;

        try {
            fo = new FileOutputStream("OutputFile.txt");
            ObjectOutputStream object = new ObjectOutputStream(fo);

            object.writeObject(cachorros);

        }catch (FileNotFoundException e){
            System.out.println("ERROR: Erro de arquivo não encontrado!");
        } catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());

        }

        List<Cachorro> cachorros2 = null;
        FileInputStream fi = null;
        try {
            fi = new FileInputStream("OutputFile.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);

            cachorros2 = (ArrayList) oi.readObject();

        }catch (FileNotFoundException e){
            System.out.println("ERROR: Erro de arquivo não encontrado!");
        } catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());

        }
        for (Cachorro cachorro : cachorros2){
            System.out.println(cachorro.getNome() + ": " + cachorro.getIdade());
        }
//        cachorros2.forEach(cachorro -> {
//            System.out.println(cachorro.getNome() + ": " + cachorro.getIdade());
//
//        });

    }
}

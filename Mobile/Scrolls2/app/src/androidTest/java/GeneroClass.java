import java.io.Serializable;

public class GeneroClass implements Serializable {

    int idGenero;
    String Nome;

    public GeneroClass(int id, String nome){

        this.idGenero = id;
        this.Nome = nome;

    }

    public GeneroClass(){
      this.idGenero = 0;
      this.Nome = null;
    }



}

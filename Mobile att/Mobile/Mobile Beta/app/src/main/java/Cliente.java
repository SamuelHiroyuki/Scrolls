public class Cliente {
    public int idCli;
    public String Nome;
    public String Sobrenome;
    public String Senha;
    public String Email;
    public String CPF;



    public Cliente(int id, String nome, String SOBRENOME, String senha,String EMAIL , String cpf){

        this.idCli = id;
        this.Nome = nome;
        this.Sobrenome = SOBRENOME;
        this.Senha = senha;
        this.Email = EMAIL;
        this.CPF = cpf;



    }

    public Cliente(){
        this.idCli = 0;
        this.Nome = null;
        this.Senha = null;
        this.Sobrenome = null;
        this.Email = null;
        this.CPF = null;
    }



}

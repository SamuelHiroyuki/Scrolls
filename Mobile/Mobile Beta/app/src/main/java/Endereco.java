public class Endereco {
    public String CEP;
    public String Pais;
    public String Estado;
    public String Cidade;
    public String Bairro;
    public String Logradouro;
    public int Numero;
    public String Complemento;
    public int IdCliente;
    public Endereco(String cep, String pais, String estado, String cidade,String bairro , String logradouro, int numero, String complemento, int idCli){

        this.CEP = cep;
        this.Pais = pais;
        this.Estado = estado;
        this.Cidade = cidade;
        this.Bairro = bairro;
        this.Logradouro = logradouro;
        this.Numero = numero;
        this.Complemento = complemento;
        this.IdCliente = idCli;



    }

    public Endereco(){
        this.CEP = null;
        this.Pais = null;
        this.Estado = null;
        this.Cidade = null;
        this.Bairro = null;
        this.Logradouro = null;
        this.Numero = 0;
        this.Complemento = null;
        this.IdCliente = 0;
    }



}



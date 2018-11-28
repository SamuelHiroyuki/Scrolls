import java.util.Date;

public class Venda {
    public int idVenda;
    public Date Data;
    public int PkCartao;
    public Cartao Cartao;
    public int IdCliente;
    public Cliente cliente;
    public int IdEndereco;
    public Endereco endereco;
    public int IdCart;
    public Carrinho carrinho;

    public Venda(int id, Date data, int pkcartao ,  int idCliente , int idEndereco , int estoque ,int idCart ,String Complemen, int categoriaId, int genId){

        this.idVenda= id;
        this.Data= data;
        this.PkCartao = pkcartao;
        this.IdCliente = idCliente;
        this.IdEndereco = idEndereco;
        this.IdCart = idCart;


    }

    public Venda(){

        this.idVenda= 0;
        this.Data= null;
        this.PkCartao = 0;
        this.IdCliente = 0;
        this.IdEndereco = 0;
        this.IdCart = 0;
}
}

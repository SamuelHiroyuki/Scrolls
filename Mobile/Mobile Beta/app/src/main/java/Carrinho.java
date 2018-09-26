import java.util.Date;

public class Carrinho {
       public int idCar;
        public int idCliente;
        public int Quantidade;
        public Cliente cliente;
        public int idProduto;
        public Produto produto;


        public Carrinho(int id, int idCli, int idProd, int qtd){

            this.idCar = id;
            this.idCliente= idCli;
            this.idProduto= idProd;
            this.Quantidade = qtd;



        }

        public Carrinho(){
            this.idCar = 0;
            this.idCliente= 0;
            this.idProduto = 0;
            this.Quantidade = 0;

        }
}

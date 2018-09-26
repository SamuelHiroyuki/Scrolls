public class ProdutoClass {
    public int IdProd;
    public String Nome;
    public String Desc;
    public float Preco;
    public int Estoque;
    public String Complemento;
    public String Img;
    public int Promocao;
    public CategoriaClass Categoria;
    public GeneroClass Genero;
    public int CategoriaId;
    public int GenId;

    public ProdutoClass(int id, String nome, String Descricao , float preco , String Imagem , int estoque , int Promo , String Complemen, int categoriaId, int genId){

        this.IdProd = id;
        this.Nome = nome;
        this.Desc = Descricao;
        this.Preco = preco;
        this.Img = Imagem;
        this.Promocao = Promo;
        this.Complemento = Complemen;
        this.Estoque = estoque;
        this.CategoriaId = categoriaId;
        this.GenId = genId;

    }

    public ProdutoClass(){
        this.IdProd = 0;
        this.Nome = null;
        this.Desc = null;
        this.Preco = 0;
        this.Img = null;
        this.Promocao = 0;
        this.Complemento = null;
        this.Estoque = 0;
        this.CategoriaId= 0;
        this.GenId = 0;
        this.Categoria = new CategoriaClass();
        this.Genero = new GeneroClass();
    }



}

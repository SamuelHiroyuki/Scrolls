import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbClass extends SQLiteOpenHelper  {
    private static final String BD = "BdTeste";
    private static int VERSAO = 1;
    public DbClass(Context context){
        super(context, BD, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Genero(_IdGen INTEGER PRIMARY KEY AUTOINCREMENT, Nome TEXT)");
        db.execSQL("CREATE TABLE Categoria(_IdCat INTEGER PRIMARY KEY AUTOINCREMENT, Nome TEXT)");
        db.execSQL("CREATE TABLE Produto(_IdProd INTEGER PRIMARY KEY AUTOINCREMENT, Nome TEXT, Descricao TEXT, Preco FLOAT, Img BLOB, Estoque INTEGER, Promocao INTEGER, Complemento TEXT, FOREIGN KEY (IdCategoria) REFERENCES Categoria(_IdCat), FOREIGN KEY (IdGenero) REFERENCES Genero(_IdGen) )");
        db.execSQL("CREATE TABLE Cliente(_IdCli INTEGER PRIMARY KEY AUTOINCREMENT, Nome TEXT, Sobrenome TEXT, Email TEXT, Img BLOB, CPF TEXT, Senha TEXT)");
        db.execSQL("CREATE TABLE Endereco(_IdEnd INTEGER PRIMARY KEY AUTOINCREMENT, CEP TEXT, Pais TEXT, Estado TEXT, Cidade TEXT, Bairro TEXT, Logradouro TEXT, Numero Integer, Complemento TEXT, FOREIGN KEY (IdCliente) REFERENCES Cliente(_IdCli))");
        db.execSQL("CREATE TABLE Cartao(_IdCart INTEGER PRIMARY KEY AUTOINCREMENT, Nome TEXT, Numero TEXT, Validade DATE, FOREIGN KEY (IdCliente) REFERENCES Cliente(_IdCli))");
        db.execSQL("CREATE TABLE Venda(_IdVenda INTEGER PRIMARY KEY AUTOINCREMENT, Data DATE, FOREIGN KEY (PkCartao) REFERENCES Cartao(_IdCart), FOREIGN KEY (IdCliente) REFERENCES Cliente(_IdCli),FOREIGN KEY (IdEndereco) REFERENCES Endereco(_IdEndereco))");
        db.execSQL("CREATE TABLE Carrinho(_IdCar INTEGER PRIMARY KEY AUTOINCREMENT, FOREIGN KEY (IdCliente) REFERENCES Cliente(IdCli),FOREIGN KEY (IdProduto) REFERENCES Produto(IdProd))");








    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

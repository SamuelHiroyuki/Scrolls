namespace Scrolls.Database.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class First : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Avaliacao",
                c => new
                    {
                        ClienteId = c.Int(nullable: false),
                        ProdutoId = c.Int(nullable: false),
                        Data = c.DateTime(nullable: false),
                        Nota = c.Int(nullable: false),
                        Comentario = c.String(),
                    })
                .PrimaryKey(t => new { t.ClienteId, t.ProdutoId })
                .ForeignKey("dbo.Cliente", t => t.ClienteId, cascadeDelete: true)
                .ForeignKey("dbo.Produto", t => t.ProdutoId, cascadeDelete: true)
                .Index(t => t.ClienteId)
                .Index(t => t.ProdutoId);
            
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 15),
                        Sobrenome = c.String(nullable: false, maxLength: 50),
                        Email = c.String(maxLength: 320),
                        Imagem = c.String(),
                        CPF = c.String(nullable: false, maxLength: 14),
                        User = c.String(nullable: false, maxLength: 15),
                        Senha = c.String(nullable: false, maxLength: 128),
                        Cartao_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cartao", t => t.Cartao_Id)
                .Index(t => t.Email, unique: true)
                .Index(t => t.CPF, unique: true)
                .Index(t => t.Cartao_Id);
            
            CreateTable(
                "dbo.Carrinho",
                c => new
                    {
                        ClienteId = c.Int(nullable: false),
                        ProdutoId = c.Int(nullable: false),
                        Quantidade = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.ClienteId, t.ProdutoId })
                .ForeignKey("dbo.Cliente", t => t.ClienteId, cascadeDelete: true)
                .ForeignKey("dbo.Produto", t => t.ProdutoId, cascadeDelete: true)
                .Index(t => t.ClienteId)
                .Index(t => t.ProdutoId);
            
            CreateTable(
                "dbo.Produto",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Descricao = c.String(),
                        Preco = c.Double(nullable: false),
                        Quantidade = c.Int(nullable: false),
                        Promocao = c.Double(),
                        Complemento = c.String(),
                        Reposto = c.DateTime(),
                        GeneroId = c.Int(nullable: false),
                        Imagem1 = c.String(),
                        Imagem2 = c.String(),
                        Imagem3 = c.String(),
                        Imagem4 = c.String(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Genero", t => t.GeneroId, cascadeDelete: true)
                .Index(t => t.GeneroId);
            
            CreateTable(
                "dbo.Genero",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 50),
                        CategoriaId = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Categoria", t => t.CategoriaId, cascadeDelete: true)
                .Index(t => t.CategoriaId);
            
            CreateTable(
                "dbo.Categoria",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 50),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.ProdutoVenda",
                c => new
                    {
                        ProdutoId = c.Int(nullable: false),
                        VendaId = c.Int(nullable: false),
                        Quantidade = c.Int(nullable: false),
                        PrecoVenda = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => new { t.ProdutoId, t.VendaId })
                .ForeignKey("dbo.Produto", t => t.ProdutoId, cascadeDelete: true)
                .ForeignKey("dbo.Venda", t => t.VendaId, cascadeDelete: true)
                .Index(t => t.ProdutoId)
                .Index(t => t.VendaId);
            
            CreateTable(
                "dbo.Venda",
                c => new
                    {
                        Id = c.Int(nullable: false),
                        Data = c.DateTime(nullable: false),
                        CartaoId = c.Int(nullable: false),
                        ClienteId = c.Int(nullable: false),
                        EnderecoId = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cartao", t => t.CartaoId, cascadeDelete: true)
                .ForeignKey("dbo.Cliente", t => t.ClienteId, cascadeDelete: true)
                .ForeignKey("dbo.Endereco", t => t.EnderecoId, cascadeDelete: true)
                .Index(t => t.CartaoId)
                .Index(t => t.ClienteId)
                .Index(t => t.EnderecoId);
            
            CreateTable(
                "dbo.Cartao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Numero = c.String(nullable: false, maxLength: 19),
                        Nome = c.String(nullable: false, maxLength: 50),
                        Validade = c.String(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .Index(t => t.Numero, unique: true);
            
            CreateTable(
                "dbo.Endereco",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        CEP = c.String(nullable: false),
                        Pais = c.String(nullable: false),
                        Estado = c.String(nullable: false),
                        Cidade = c.String(nullable: false),
                        Bairro = c.String(nullable: false),
                        Logradouro = c.String(nullable: false),
                        Complemento = c.String(maxLength: 100),
                        Numero = c.Int(nullable: false),
                        ClienteId = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.ClienteId)
                .Index(t => t.ClienteId);
            
            CreateTable(
                "dbo.Banner",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Ativo = c.Boolean(nullable: false),
                        Latitude = c.String(),
                        Longitude = c.String(),
                        Imagem = c.String(),
                        Endereco_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Endereco", t => t.Endereco_Id)
                .Index(t => t.Endereco_Id);
            
            CreateTable(
                "dbo.Funcionario",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 15),
                        Sobrenome = c.String(nullable: false, maxLength: 50),
                        CPF = c.String(nullable: false, maxLength: 14),
                        Email = c.String(nullable: false, maxLength: 320),
                        Imagem = c.String(nullable: false),
                        Senha = c.String(nullable: false, maxLength: 128),
                        Gerente = c.Boolean(nullable: false),
                        EnderecoId = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Endereco", t => t.EnderecoId, cascadeDelete: true)
                .Index(t => t.CPF, unique: true)
                .Index(t => t.Email, unique: true)
                .Index(t => t.EnderecoId);
            
            CreateTable(
                "dbo.ClienteCartao",
                c => new
                    {
                        ClienteId = c.Int(nullable: false),
                        CartaoId = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.ClienteId, t.CartaoId })
                .ForeignKey("dbo.Cartao", t => t.CartaoId, cascadeDelete: true)
                .ForeignKey("dbo.Cliente", t => t.ClienteId, cascadeDelete: true)
                .Index(t => t.ClienteId)
                .Index(t => t.CartaoId);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Avaliacao", "ProdutoId", "dbo.Produto");
            DropForeignKey("dbo.Avaliacao", "ClienteId", "dbo.Cliente");
            DropForeignKey("dbo.ClienteCartao", "ClienteId", "dbo.Cliente");
            DropForeignKey("dbo.ClienteCartao", "CartaoId", "dbo.Cartao");
            DropForeignKey("dbo.Carrinho", "ProdutoId", "dbo.Produto");
            DropForeignKey("dbo.ProdutoVenda", "VendaId", "dbo.Venda");
            DropForeignKey("dbo.Venda", "EnderecoId", "dbo.Endereco");
            DropForeignKey("dbo.Funcionario", "EnderecoId", "dbo.Endereco");
            DropForeignKey("dbo.Endereco", "ClienteId", "dbo.Cliente");
            DropForeignKey("dbo.Banner", "Endereco_Id", "dbo.Endereco");
            DropForeignKey("dbo.Venda", "ClienteId", "dbo.Cliente");
            DropForeignKey("dbo.Venda", "CartaoId", "dbo.Cartao");
            DropForeignKey("dbo.Cliente", "Cartao_Id", "dbo.Cartao");
            DropForeignKey("dbo.ProdutoVenda", "ProdutoId", "dbo.Produto");
            DropForeignKey("dbo.Produto", "GeneroId", "dbo.Genero");
            DropForeignKey("dbo.Genero", "CategoriaId", "dbo.Categoria");
            DropForeignKey("dbo.Carrinho", "ClienteId", "dbo.Cliente");
            DropIndex("dbo.ClienteCartao", new[] { "CartaoId" });
            DropIndex("dbo.ClienteCartao", new[] { "ClienteId" });
            DropIndex("dbo.Funcionario", new[] { "EnderecoId" });
            DropIndex("dbo.Funcionario", new[] { "Email" });
            DropIndex("dbo.Funcionario", new[] { "CPF" });
            DropIndex("dbo.Banner", new[] { "Endereco_Id" });
            DropIndex("dbo.Endereco", new[] { "ClienteId" });
            DropIndex("dbo.Cartao", new[] { "Numero" });
            DropIndex("dbo.Venda", new[] { "EnderecoId" });
            DropIndex("dbo.Venda", new[] { "ClienteId" });
            DropIndex("dbo.Venda", new[] { "CartaoId" });
            DropIndex("dbo.ProdutoVenda", new[] { "VendaId" });
            DropIndex("dbo.ProdutoVenda", new[] { "ProdutoId" });
            DropIndex("dbo.Genero", new[] { "CategoriaId" });
            DropIndex("dbo.Produto", new[] { "GeneroId" });
            DropIndex("dbo.Carrinho", new[] { "ProdutoId" });
            DropIndex("dbo.Carrinho", new[] { "ClienteId" });
            DropIndex("dbo.Cliente", new[] { "Cartao_Id" });
            DropIndex("dbo.Cliente", new[] { "CPF" });
            DropIndex("dbo.Cliente", new[] { "Email" });
            DropIndex("dbo.Avaliacao", new[] { "ProdutoId" });
            DropIndex("dbo.Avaliacao", new[] { "ClienteId" });
            DropTable("dbo.ClienteCartao");
            DropTable("dbo.Funcionario");
            DropTable("dbo.Banner");
            DropTable("dbo.Endereco");
            DropTable("dbo.Cartao");
            DropTable("dbo.Venda");
            DropTable("dbo.ProdutoVenda");
            DropTable("dbo.Categoria");
            DropTable("dbo.Genero");
            DropTable("dbo.Produto");
            DropTable("dbo.Carrinho");
            DropTable("dbo.Cliente");
            DropTable("dbo.Avaliacao");
        }
    }
}

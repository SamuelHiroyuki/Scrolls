using Scrolls.Entities;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.Database {
    public class EntitiesContext : DbContext
    {
        public EntitiesContext() : base("connString") { }

        public DbSet<Avaliacao> Avaliacoes { get; set; }
        public DbSet<Banner> Banners { get; set; }
        public DbSet<Carrinho> Carrinhos { get; set; }
        public DbSet<Cartao> Cartoes { get; set; }
        public DbSet<Categoria> Categorias { get; set; }
        public DbSet<Cliente> Clientes { get; set; }
        public DbSet<ClienteCartao> ClienteCartoes { get; set; }
        public DbSet<Endereco> Enderecos { get; set; }
        public DbSet<Funcionario> Funcionarios { get; set; }
        public DbSet<Genero> Generos { get; set; }
        public DbSet<Produto> Produtos { get; set; }
        public DbSet<ProdutoVenda> ProdutosVenda { get; set; }
        public DbSet<Venda> Vendas { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();

            modelBuilder.Entity<Carrinho>().HasKey(c => new { c.ClienteId, c.ProdutoId });

            modelBuilder.Entity<ClienteCartao>().HasKey(cc => new { cc.ClienteId, cc.CartaoId});

            modelBuilder.Entity<Avaliacao>().HasKey(a => new { a.ClienteId, a.ProdutoId});

            modelBuilder.Entity<ProdutoVenda>().HasKey(pv => new { pv.ProdutoId, pv.VendaId });

            modelBuilder.Entity<Cliente>().HasIndex(u => u.CPF).IsUnique();

            modelBuilder.Entity<Cliente>().HasIndex(u => u.Email).IsUnique();

            modelBuilder.Entity<Funcionario>().HasIndex(u => u.CPF).IsUnique();

            modelBuilder.Entity<Funcionario>().HasIndex(u => u.Email).IsUnique();

            modelBuilder.Entity<Cartao>().HasIndex(u => u.Numero).IsUnique();

            base.OnModelCreating(modelBuilder);
        }
    }
}

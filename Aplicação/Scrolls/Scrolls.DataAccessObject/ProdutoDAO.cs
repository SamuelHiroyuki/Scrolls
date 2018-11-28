using Scrolls.Database;
using Scrolls.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.DataAccessObject
{
    public class ProdutoDAO
    {
        private EntitiesContext context;

        public ProdutoDAO()
        {
            context = new EntitiesContext();
        }

        public void Cadastrar(Produto p)
        {
            context.Produtos.Add(p);
            context.SaveChanges();
        }

        public Produto BuscaId(int id) {
            return context.Produtos.FirstOrDefault(c => c.Id == id);
        }

        public IList<Produto> Listar() {
            return context.Produtos.ToList();
        }

        public void Atualizar() {
            context.SaveChanges();
        }

        public string CountIsZero() {
            return context.Produtos.Where(p => p.Quantidade == 0).Count().ToString();
        }

        public IList<Produto> IsZero()
        {
            return context.Produtos.Where(p => p.Quantidade == 0).ToList();
        }

        public IList<Produto> HasPromo()
        {
            return context.Produtos.Where(p => !(p.Promocao == null || p.Promocao == 0)).ToList();
        }

        public IList<Produto> NoPromo()
        {
            return context.Produtos.Where(p => p.Promocao == null || p.Promocao == 0).ToList();
        }
    }
}

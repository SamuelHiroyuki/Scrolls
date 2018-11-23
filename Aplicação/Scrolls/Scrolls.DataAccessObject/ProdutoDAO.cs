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

        public IList<Produto> Listar() {
            return context.Produtos.ToList();
        }
    }
}

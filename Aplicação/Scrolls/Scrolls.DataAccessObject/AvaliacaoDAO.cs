using Scrolls.Database;
using Scrolls.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.DataAccessObject
{
    public class AvaliacaoDAO
    {
        private EntitiesContext context;
        public AvaliacaoDAO()
        {
            context = new EntitiesContext();
        }

        public void Cadastrar(Avaliacao a)
        {
            context.Avaliacoes.Add(a);
            context.SaveChanges();
        }

        public Avaliacao BuscaByProd(int id)
        {
            return context.Avaliacoes.FirstOrDefault(p => p.ProdutoId == id);
        }
    }
}

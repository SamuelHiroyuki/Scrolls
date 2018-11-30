using Scrolls.Database;
using Scrolls.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.DataAccessObject
{
    public class VendaDAO
    {
        private EntitiesContext context;

        public VendaDAO()
        {
            context = new EntitiesContext();
        }
        
        public void Atualizar()
        {
            context.SaveChanges();
        }

        public IList<Venda> Listar()
        {
            return context.Vendas.ToList();
        }
    }
}

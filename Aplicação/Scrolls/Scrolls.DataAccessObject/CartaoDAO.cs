using Scrolls.Database;
using Scrolls.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.DataAccessObject
{
    public class CartaoDAO
    {
        private EntitiesContext context;
        public CartaoDAO()
        {
            context = new EntitiesContext();
        }

        public void Cadastrar(Cartao card)
        {
            context.Cartoes.Add(card);
            context.SaveChanges();
        }
    }
}

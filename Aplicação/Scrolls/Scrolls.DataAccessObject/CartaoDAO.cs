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

        public IList<Cartao> Listar()
        {
            return context.Cartoes.ToList();
        }

		
		public void Deletar(Cartao e)
        {
            context.Cartoes.Remove(e);
            context.SaveChanges();
        }
		
        public Cartao BuscarId(int id)
        {
            return context.Cartoes.FirstOrDefault(c => c.Id == id);
        }

        public Cartao BuscaByCli(int id)
        {
            return context.Cartoes.FirstOrDefault(c => c.ClienteId == id);
        }
    }
}

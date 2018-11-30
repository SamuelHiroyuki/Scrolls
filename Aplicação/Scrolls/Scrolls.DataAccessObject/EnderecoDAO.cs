using Scrolls.Database;
using Scrolls.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.DataAccessObject
{
    public class EnderecoDAO
    {
        private EntitiesContext context;
        public EnderecoDAO()
        {
            context = new EntitiesContext();
        }

        public void Cadastrar(Endereco e)
        {
            context.Enderecos.Add(e);
            context.SaveChanges();
        }

        public IList<Endereco> Listar()
        {
            return context.Enderecos.ToList();
        }

		
		public void Deletar(Endereco e)
        {
            context.Enderecos.Remove(e);
            context.SaveChanges();
        }
		
        public Endereco BuscarId(int id)
        {
            return context.Enderecos.FirstOrDefault(e => e.Id == id);
        }

        public Endereco BuscaByCli(int id)
        {
            return context.Enderecos.FirstOrDefault(c => c.ClienteId == id);
        }
    }
}

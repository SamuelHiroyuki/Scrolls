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
        
        public Endereco Listar (Cliente c)
        {
            return context.Enderecos.FirstOrDefault(e => e.ClienteId == c.Id);
        }

        public void Deletar(Endereco e)
        {
            context.Enderecos.Remove(e);
            context.SaveChanges();
        }
    }
}

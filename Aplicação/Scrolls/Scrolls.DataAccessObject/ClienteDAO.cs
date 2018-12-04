using Scrolls.Database;
using Scrolls.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.DataAccessObject
{
    public class ClienteDAO
    {
        private EntitiesContext context;
         public ClienteDAO()
        {
            context = new EntitiesContext();
        }

        public void Cadastrar(Cliente c)
        {
            context.Clientes.Add(c);
            context.SaveChanges();
        }

        public Cliente BuscarId(int id)
        {
            return context.Clientes.FirstOrDefault(c => c.Id == id);
        }

        public void Atualizar()
        {
            context.SaveChanges();
        }


        public IList<Cliente> Listar()
        {
            return context.Clientes.ToList();
        }

        public int Count()
        {
            return context.Clientes.Count();
        }

        public Cliente BuscarEmail(string e) {
            Cliente cliente = context.Clientes.FirstOrDefault(c => c.Email.Equals(e));
            if (cliente != null)
            {
                return cliente;
            }
            else
            {
                return null;
            }
        }

        public Cliente Login(string pass, string ema)
        {

            Cliente cliente = context.Clientes.FirstOrDefault(c => c.Email.Equals(ema) && c.Senha.Equals(pass));
            if (cliente != null)
            {
                return cliente;
            }
            else
            {
                return null;
            }
        }
    }
}

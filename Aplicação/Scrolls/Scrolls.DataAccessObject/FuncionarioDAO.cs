using Scrolls.Database;
using Scrolls.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.DataAccessObject
{
    public class FuncionarioDAO
    {
        private EntitiesContext context;

        public FuncionarioDAO()
        {
            context = new EntitiesContext();
        }

        public Funcionario Login(string pass, string e )
        {

            Funcionario funcionario = context.Funcionarios.FirstOrDefault(f => f.Email.Equals(e) && f.Senha.Equals(pass));
            if (funcionario != null)
            {
                return funcionario;
            }
            else
            {
                return null;
            }
        }
    }
}

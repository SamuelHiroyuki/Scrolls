using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.Entities.DAO
{
    public class FuncionarioDAO
    {
        private EntitiesContext context;

        public FuncionarioDAO()
        {
            context = new EntitiesContext();
        }

        public Funcionario Login(string pass, string emnome )
        {

            Funcionario funcionario = context.Funcionarios.FirstOrDefault(f => (f.User.Equals(emnome) || f.Email.Equals(emnome)) && f.Senha.Equals(pass));
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

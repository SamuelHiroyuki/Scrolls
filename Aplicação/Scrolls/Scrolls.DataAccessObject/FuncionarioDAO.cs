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

        public void Excluir(Funcionario f)
        {
            context.Funcionarios.Remove(f);
            context.SaveChanges();
        }

        public bool Existe(string e) {
            Funcionario f = context.Funcionarios.FirstOrDefault(c => c.Email.Equals(e));
            if (f != null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public IList<Funcionario> Listar()
        {
            return context.Funcionarios.ToList();
        }

        public Funcionario BuscaId(int id) {
            return context.Funcionarios.FirstOrDefault(f => f.Id == id);
        }

        public void Cadastro(Funcionario f) {
            context.Funcionarios.Add(f);
            context.SaveChanges();
        }

        public void Atualizar() {
            context.SaveChanges();
        }
    }
}

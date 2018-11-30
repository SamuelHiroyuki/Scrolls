using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.Entities
{
    public class Funcionario
    {
        public int Id { get; set; }

        public string Nome { get; set; }

        public string Sobrenome { get; set; }

        public string CPF { get; set; }

        public string RG { get; set; }

        public string Email { get; set; }

        public string Imagem { get; set; }

        public DateTime Nascimento { get; set; }

        public string CEP { get; set; }

        public string Complemento { get; set; }

        public string Numero { get; set; }

        public string Senha { get; set; }
        
        public bool Gerente { get; set; }
    }
}

using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.Entities
{
    public class Cliente
    {
        [Key]
        public int Id { get; set; }
        
        public string Nome { get; set; }

        public string Sobrenome { get; set; }
        [RegularExpression(@"^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$", ErrorMessage = "Formato de email inválido."), MaxLength(320)]
        public string Email { get; set; } 

        public string Imagem { get; set; }
        [Required(ErrorMessage = "O campo CPF não pode estar vazio."), RegularExpression(@"(^\d{3}\x2E\d{3}\x2E\d{3}\x2D\d{2}$)", ErrorMessage = "Somente números são aceitos."), MaxLength(14)]
        public string CPF { get; set; }
                
        public string Senha { get; set; }

        public virtual IList<ClienteCartao> Cartoes { get; set; }
        public virtual IList<Endereco> Enderecos { get; set; }
        public virtual IList<Venda> Compras { get; set; }
        public virtual IList<Carrinho> Carrinho { get; set; }
    }
}

using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.Entities
{
    public class Endereco
    {
        public int Id { get; set; }

        [Required, RegularExpression(@"^\d{5}(\-)(\d{3})?$")]
        public string CEP { get; set; }
        
        [Required]
        public string Pais { get; set; }

        [Required]
        public string Estado { get; set; }

        [Required]
        public string Cidade { get; set; }

        [Required]
        public string Bairro { get; set; }

        [Required]
        public string Logradouro { get; set; }
        
        [MaxLength(100, ErrorMessage ="O campo deve ter apenas 100 caracteres.")]
        public string Complemento { get; set; }

        [Required(ErrorMessage = "O campo número não pode estar vazio.")]
        public int Numero { get; set; }

        public virtual Cliente Cliente { get; set; }
        public int? ClienteId { get; set; }

        public virtual IList<Venda> Vendas { get; set; }
    }
}

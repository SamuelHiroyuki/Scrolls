using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.Entities
{
    public class Cartao
    {
        public int Id { get; set; }

        [Required(ErrorMessage = "O campo número não pode estar vazio."), RegularExpression(@"\d{4}-?\d{4}-?\d{4}-?\d{4}", ErrorMessage = "Somente números são aceitos."), MaxLength(19)]
        public string Numero { get; set; }

        [Required(ErrorMessage = "O campo nome não pode estar vazio."), MaxLength(50, ErrorMessage = "O nome deve conter apenas 50 caracteres.")]
        public string Nome { get; set; }

        public int Cvv { get; set; }

        [Required(ErrorMessage = "O campo validade não pode estar vazio."), RegularExpression(@"^\d{1,2}\/\d{1,2}\$", ErrorMessage = "Somente números são aceitos.")]
        public string Validade { get; set; }

        public virtual Cliente Cliente { get; set; }
        public int? ClienteId { get; set; }
    }
}

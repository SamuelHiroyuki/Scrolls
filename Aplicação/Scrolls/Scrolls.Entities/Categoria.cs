using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.Entities
{
    public class Categoria
    {
        public int Id { get; set; }

        [Required(ErrorMessage = "O campo nome não pode estar vazio."), MaxLength(50, ErrorMessage = "O nome deve conter apenas 50 caracteres.")]
        public string Nome { get; set; }

        public virtual IList<Produto> Produtos { get; set; }
    }
}

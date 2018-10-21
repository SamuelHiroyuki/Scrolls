using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.Entities
{
    public class Carrinho
    {
        [Required, RegularExpression("^[^ -][0 - 9]$", ErrorMessage = "Somente números inteiros são aceitos."), Range(1, 50, ErrorMessage = "A quantidade máxima deve ser 50 unidades.")]
        public int Quantidade { get; set; }

        public virtual Cliente Cliente { get; set; }
        public int ClienteId { get; set; }
        public virtual Produto Produto { get; set; }
        public int ProdutoId { get; set; }
    }
}

using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.Entities
{
    public class ProdutoVenda
    {
        public virtual Venda Venda { get; set; }
        public int VendaId { get; set; }
        public virtual Produto Produto { get; set; }
        public int ProdutoId { get; set; }

        [Required, RegularExpression("^[^ -][0 - 9]$", ErrorMessage = "Somente números inteiros são aceitos."), Range(1, 50, ErrorMessage = "A quantidade deve ser de 1-50 unidades.")]
        public int Quantidade { get; set; }

        [Required]
        public decimal PrecoVenda { get; set; }
    }
}

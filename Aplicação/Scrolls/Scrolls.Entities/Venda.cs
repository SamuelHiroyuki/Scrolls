using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.Entities
{
    public class Venda
    {
        public int Id { get; set; }

        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public DateTime Data { get; set; } = DateTime.Now;

        public virtual Cartao Cartao { get; set; }
        [Required(ErrorMessage = "É necessário escolher um cartão para finalizar compra.")]
        public int CartaoId { get; set; }

        public virtual Cliente Cliente { get; set; }
        [Required(ErrorMessage = "É necessário estar logado para finalizar compra.")]
        public int ClienteId { get; set; }

        public virtual Endereco Endereco { get; set; }
        [Required(ErrorMessage = "É necessário escolher um endereço de entrega para finalizar compra.")]
        public int EnderecoId { get; set; }

        public virtual IList<ProdutoVenda> Produtos { get; set; }
    }
}

using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.Entities
{
    public class Produto
    {
        public int Id { get; set; }
        
        public string Nome { get; set; }
        
        public string Descricao { get; set; }
        
        public double Preco { get; set; }
        
        public int Quantidade { get; set; }
        
        public double? Promocao { get; set; }
        
        public string Complemento { get; set; }
        
        public DateTime? Reposto { get; set; }

        public virtual Genero Genero { get; set; }
        public int GeneroId { get; set; }

        public virtual IList<ProdutoVenda> ProdutoVendas { get; set; }
        public virtual IList<Imagem> Imagens { get; set; }
    }
}

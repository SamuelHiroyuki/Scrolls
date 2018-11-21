using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.Entities
{
    public class Imagem
    {
        public int Id { get; set; }
        public string Caminho { get; set; }


        public virtual Produto Produto { get; set; }
        public int ProdutoId { get; set; }
    }
}

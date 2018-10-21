using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.Entities
{
    public class Avaliacao
    {
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public DateTime Data { get; set; } = DateTime.Now;

        [Range(0, 5)]
        public int Nota { get; set; }
    
        public string Comentario { get; set; }

        public virtual Cliente Cliente { get; set; }
        public int ClienteId { get; set; }
        public virtual Produto Produto { get; set; }
        public int ProdutoId { get; set; }
    }
}

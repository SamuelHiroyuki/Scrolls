using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.Entities
{
    public class ClienteCartao
    {
        public virtual Cliente Cliente { get; set; }
        public int ClienteId { get; set; }
        public virtual Cartao Cartao { get; set; }
        public int CartaoId { get; set; }
    }
}

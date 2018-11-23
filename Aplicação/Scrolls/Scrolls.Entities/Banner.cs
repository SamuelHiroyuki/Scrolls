using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.Entities
{
    public class Banner
    {
        public int Id { get; set; }

        [Required(ErrorMessage ="É necessário informar a situação do banner.")]
        public bool Ativo { get; set; }

        public string Latitude { get; set; }

        public string Longitude { get; set; }

        public string Imagem { get; set; }
    }
}

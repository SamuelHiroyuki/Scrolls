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

        [Required(ErrorMessage = "O campo nome não pode estar vazio."), MaxLength(100, ErrorMessage = "O nome deve conter apenas 100 caracteres.")]
        public string Nome { get; set; }

        [Required(ErrorMessage = "O campo descrição não pode estar vazio.")]
        public string Descricao { get; set; }

        [Required(ErrorMessage = "O campo preço não pode estar vazio."), RegularExpression("^[^ -][0 - 9]$", ErrorMessage = "Somente números são aceitos."), Range(2.00, Double.MaxValue, ErrorMessage = "O preço mínimo é de R$2.00")]
        public double Preco { get; set; }
        
        [Required]
        public string Imagem { get; set; }

        [Required(ErrorMessage = "O campo quantidade não pode estar vazio"), RegularExpression("^[^ -][0 - 9]$", ErrorMessage = "Somente números inteiros são aceitos.")]
        public int Quantidade { get; set; }
        
        public double? Promocao { get; set; }

        [Required(ErrorMessage = "O campo complemento não pode estar vazio")]
        public string Complemento { get; set; }
        
        public DateTime Reposto { get; set; }

        public virtual Genero Genero { get; set; }
        public int? GeneroId { get; set; }

        public virtual Categoria Categoria { get; set; }
        [Required(ErrorMessage = "É necessário atribuir uma categoria ao produto.")]
        public int CategoriaId { get; set; }

        public virtual IList<ProdutoVenda> ProdutoVendas { get; set; }
    }
}

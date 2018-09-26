using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.Entities
{
    public class Funcionario
    {
        public int Id { get; set; }

        [Required(ErrorMessage = "O campo nome não pode estar vazio."), MaxLength(50, ErrorMessage = "O nome deve conter apenas 50 caracteres.")]
        public string Nome { get; set; }

        [Required(ErrorMessage = "O campo CPF não pode estar vazio."), RegularExpression(@"(^\d{3}\x2E\d{3}\x2E\d{3}\x2D\d{2}$)", ErrorMessage = "Somente números são aceitos."), MaxLength(14)]
        public string CPF { get; set; }

        [Required(ErrorMessage = "O campo email não pode estar vazio."), RegularExpression(@"^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$", ErrorMessage = "Formato de email inválido."), MaxLength(320)]
        public string Email { get; set; }

        public string Imagem { get; set; }

        [Required(ErrorMessage = "O campo nome de usuário não pode estar vazio."), MaxLength(15, ErrorMessage = "O nome deve conter apenas 15 caracteres.")]
        public string User { get; set; }

        [Required(ErrorMessage = "O campo nome não pode estar vazio."), MinLength(8, ErrorMessage = "A senha deve conter no mínimo 8 caracteres."), MaxLength(128, ErrorMessage = "A senha deve ter no máximo 128 caracteres.")]
        public string Senha { get; set; }

        [Required(ErrorMessage ="É necessario definir o tipo de funcionário.")]
        public bool Gerente { get; set; }

        public virtual Endereco Endereco { get; set; }
        [Required(ErrorMessage = "É necessário vincular um endereço a conta.")]
        public int EnderecoId { get; set; }
    }
}

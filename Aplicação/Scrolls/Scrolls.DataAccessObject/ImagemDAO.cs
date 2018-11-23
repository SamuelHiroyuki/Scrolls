using Scrolls.Database;
using Scrolls.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.DataAccessObject
{
    public class ImagemDAO
    {
        private EntitiesContext context;

        public ImagemDAO()
        {
            context = new EntitiesContext();
        }

        public void Cadastrar(Imagem i)
        {
            context.Imagens.Add(i);
            context.SaveChanges();
        }

        public IList<Imagem> Listar() {
            return context.Imagens.ToList();
        }
    }
}

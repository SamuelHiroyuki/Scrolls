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
            context.Imagnes.Add(i);
            context.SaveChanges();
        }
    }
}

using Scrolls.Database;
using Scrolls.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.DataAccessObject
{
    public class CategoriaDAO
    {
        private EntitiesContext context;

        public CategoriaDAO()
        {
            context = new EntitiesContext();
        }

        public IList<Categoria> Listar()
        {
            return context.Categorias.ToList();
        }
    }
}

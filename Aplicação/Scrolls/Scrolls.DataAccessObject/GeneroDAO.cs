using Scrolls.Database;
using Scrolls.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.DataAccessObject
{
    public class GeneroDAO
    {
        private EntitiesContext context;

        public GeneroDAO()
        {
            context = new EntitiesContext();
        }

        public IList<Genero> Listar()
        {
            return context.Generos.ToList();
        }

        public int BuscaIdCat(int g)
        {
            return context.Generos.FirstOrDefault(c => c.Id == g).CategoriaId;
        }
    }
}

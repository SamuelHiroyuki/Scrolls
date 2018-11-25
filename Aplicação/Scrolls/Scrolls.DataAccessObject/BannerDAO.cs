using Scrolls.Database;
using Scrolls.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scrolls.DataAccessObject
{
    public class BannerDAO
    {
        private EntitiesContext context;

        public BannerDAO()
        {
            context = new EntitiesContext();
        }

        public void Cadastrar(Banner b)
        {
            context.Banners.Add(b);
            context.SaveChanges();
        }

        public void Atualizar()
        {
            context.SaveChanges();
        }

        public string IsZero()
        {
            return context.Banners.Where(b => b.Ativo == true).Count().ToString();
        }
    }
}

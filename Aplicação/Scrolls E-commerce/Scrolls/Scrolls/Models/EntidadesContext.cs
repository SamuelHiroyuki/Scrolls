using MySql.Data.Entity;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Linq;
using System.Web;

namespace Scrolls.Models
{
    [DbConfigurationType(typeof(MySqlEFConfiguration))]
    public class EntidadesContext : DbContext
    {
        public EntidadesContext() : base("connString") { }

        //public DbSet<>  { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
            base.OnModelCreating(modelBuilder);
        }
    }
}
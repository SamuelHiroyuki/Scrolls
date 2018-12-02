using Scrolls.DataAccessObject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Scrolls.Web.Controllers
{
    public class ProdutoController : Controller
    {
        // GET: Produto
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult VProduto(int id)
        {
            ViewBag.P = new ProdutoDAO().BuscaId(id);
            ViewBag.D = new ProdutoDAO().BuscaId(id).Complemento;
            return View();
        }
    }
}
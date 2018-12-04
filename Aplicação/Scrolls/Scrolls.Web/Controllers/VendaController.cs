using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Scrolls.Web.Controllers
{
    public class VendaController : Controller
    {
        // GET: Venda
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult Checkout()
        {

            ViewBag.Tot = 0;
            foreach (var p in Scrolls.Web.Models.MeuCarrinho.Cesta)
            {
                if (p.Promocao != null)
                {
                    ViewBag.Tot += Math.Round(Convert.ToDouble(((p.Preco * p.Promocao) / 100) - p.Preco), 2);
                }
                else
                {
                    ViewBag.Tot += p.Preco;
                }
                if (!p.Imagem1.Contains("https://manager-scrolls.azurewebsites.net"))
                {

                    p.Imagem1 = "https://manager-scrolls.azurewebsites.net" + p.Imagem1;
                }
            }
            return View();
        }
    }
}
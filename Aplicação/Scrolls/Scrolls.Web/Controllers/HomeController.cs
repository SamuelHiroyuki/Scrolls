using Scrolls.DataAccessObject;
using Scrolls.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Scrolls.Web.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        public ActionResult Index()
        {
            var n = new ProdutoDAO().IsNew();
            var r = new ProdutoDAO().IsRep();
            foreach (Produto p in n)
            {
                p.Imagem1 = "https://manager-scrolls.azurewebsites.net" + p.Imagem1;
            }
            ViewBag.New = n;
            foreach (Produto p in r)
            {
                p.Imagem1 = "https://manager-scrolls.azurewebsites.net" + p.Imagem1;
            }
            ViewBag.Rep = r;
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
            }
            return View();
        }

        public ActionResult LoginPage(string email, string senha)
        {
            ViewBag.Nome = email;
            ViewBag.S = senha;
            return View();
        }

        public ActionResult Logar(string s, string nr)
        {
            Cliente c = new ClienteDAO().Login(s, nr);
            if (c != null)
            {
                Session["_Id"] = c.Id;
                Session["_Nome"] = c.Nome;
                ViewBag.LoginE = string.Empty;
                ViewBag.V = string.Empty;
                return RedirectToAction("Index","Home");
            }
            else
            {
                ViewBag.V = "border-danger";
                ViewBag.LoginE = "display: block; !important";
                ViewBag.Nome = nr;
                return View("LoginPage");
            }
        }

        public ActionResult Logout()
        {
            ViewBag.Nome = string.Empty;
            ViewBag.S = string.Empty;
            ViewBag.LoginE = string.Empty;
            ViewBag.V = string.Empty;
            Session["_Id"] = 0;
            Session["_Nome"] = string.Empty;
            return RedirectToAction("Index");
        }

        public ActionResult AddCart(int id)
        {
            Produto p = new ProdutoDAO().BuscaId(id);
            Scrolls.Web.Models.MeuCarrinho.Cesta.Add(p);

            return RedirectToAction("Index");
        }

        public ActionResult RemoveCart(int id)
        {
            try
            {
                foreach (var c in Scrolls.Web.Models.MeuCarrinho.Cesta)
                {
                    if (id == c.Id)
                    {
                        Scrolls.Web.Models.MeuCarrinho.Cesta.Remove(c);
                    }
                }
            }
            catch (Exception)
            {

                return RedirectToAction("Index");
            }
            return RedirectToAction("Index");
        }
    }
}
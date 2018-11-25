using Scrolls.DataAccessObject;
using Scrolls.Entities;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Scrolls.Manager.Controllers
{
    public class BannerController : Controller
    {
        // GET: Banner
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult CBanner()
        {
            ViewData["Falta"] = new ProdutoDAO().IsZero();
            ViewData["Ativo"] = new BannerDAO().IsZero();
            return View();
        }

        [HttpPost]
        public ActionResult Cadastro(string end, string lat, string lon, HttpPostedFileBase i1) {
            BannerDAO bdao = new BannerDAO();
            Banner b = new Banner { Ativo = true, Latitude = lat, Longitude = lon, Endereco = end, };
            bdao.Cadastrar(b);

            string ex = Path.GetExtension(i1.FileName);
            string fn = b.Id + ex;
            b.Imagem = "/Imagens/Banners/" + fn;
            fn = Path.Combine(Server.MapPath("~/Imagens/Banners/"), fn);
            i1.SaveAs(fn);
            bdao.Atualizar();

            TempData["Sucesso"] = "Sucesso!";
            return RedirectToAction("CBanner");
        }
    }
}
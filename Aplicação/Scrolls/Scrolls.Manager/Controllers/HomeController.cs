using Scrolls.DataAccessObject;
using Scrolls.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Scrolls.Manager.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        public ActionResult Index()
        {
            ViewBag.Nome = string.Empty;
            ViewBag.LoginE = string.Empty;
            ViewBag.V = string.Empty;
            ViewBag.Date = DateTime.Now.Day + " de " + DateTime.Now.ToString("MMMM, yyyy");
            ViewData["Falta"] = new ProdutoDAO().CountIsZero();
            ViewData["Ativo"] = new BannerDAO().CountAtivo();
            return View();
        }

        public JsonResult ConsultaCEP(string cep) {
            return Json(null, JsonRequestBehavior.AllowGet);
        }

        public ActionResult Perfil() {
            ViewData["Falta"] = new ProdutoDAO().CountIsZero();
            ViewData["Ativo"] = new BannerDAO().CountAtivo();
            return View();
        }
        
        public ActionResult LoginPage()
        {
            return View();
        }

        [HttpPostAttribute]
        public ActionResult Login(string s, string n)
        {
            Funcionario f = new FuncionarioDAO().Login(s, n);
            if (f != null)
            {
                Session["_Id"] = f.Id;
                Session["_Nome"] = f.Nome;
                Session["_Imagem"] = f.Imagem;
                if (f.Gerente == true)
                {
                    Session["_Tipo"] = "Administrador";
                }
                else
                {
                    Session["_Tipo"] = "Funcionário";
                }

                ViewBag.LoginE = string.Empty;
                ViewBag.V = string.Empty;
                return RedirectToAction("Index");
            }
            else
            {
                ViewBag.V = "validate-has-error";
                ViewBag.LoginE = "display: block; !important";
                ViewBag.Nome = n;
                return View("LoginPage");
            }
        }

        public ActionResult Logout()
        {
            ViewBag.Nome = string.Empty;
            ViewBag.LoginE = string.Empty;
            ViewBag.V = string.Empty;
            Session["_Id"] = 0;
            Session["_Nome"] = string.Empty;
            Session["_Tipo"] = string.Empty;
            Session["_Imagem"] = string.Empty;
            return RedirectToAction("LoginPage");
        }
    }
}
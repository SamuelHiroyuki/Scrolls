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
            return View();
        }

        public ActionResult LoginPage()
        {
            return View();
        }

        [HttpPostAttribute]
        public ActionResult Login(string s, string n)
        {
            Cliente c = new ClienteDAO().Login(s, n);
            if (c != null)
            {
                Session["_Id"] = c.Id;
                Session["_Nome"] = c.Nome;
                //Session["_Imagem"] = c.Imagem;
                ViewBag.LoginE = string.Empty;
                ViewBag.V = string.Empty;
                return RedirectToAction("Index");
            }
            else
            {
                ViewBag.V = "border-danger";
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
            //Session["_Imagem"] = string.Empty;
            return RedirectToAction("LoginPage");
        }
    }
}
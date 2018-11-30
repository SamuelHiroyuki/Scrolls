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
            ViewBag.LoginE = string.Empty;
            ViewBag.V = string.Empty;
            Session["_Id"] = 0;
            Session["_Nome"] = string.Empty;
            return RedirectToAction("Index");
        }
    }
}
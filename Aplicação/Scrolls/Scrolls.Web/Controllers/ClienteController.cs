using Scrolls.DataAccessObject;
using Scrolls.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Scrolls.Web.Controllers
{
    public class ClienteController : Controller
    {
        // GET: Usuario
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult JoinPage(Cliente cliente)
        {
            return View();
        }

        public ActionResult CadaCli(Cliente cliente)
        {
            ClienteDAO cdao = new ClienteDAO();
            cdao.Cadastrar(cliente);
            return RedirectToAction("LoginPage", "Home");
        }

        public ActionResult AtuaCli(Cliente cliente)
        {
            ClienteDAO cdao = new ClienteDAO();
            Cliente cli = cdao.BuscarId(Convert.ToInt32(Session["_Id"]));
            cdao.Atualizar();
            return View();
        }

        public ActionResult ClientePage()
        {
            if (Session["_Id"] != null)
            {
                ClienteDAO cdao = new ClienteDAO();
                Cliente cli = cdao.BuscarId(Convert.ToInt32(Session["_Id"]));
                ViewBag.cliente = cli;                
            }
            else
            {
                return RedirectToAction("LoginPage","Home");
            }
            return View();
        }

        public ActionResult AtualizarCli()
        {
            return View();
        }
    }
}
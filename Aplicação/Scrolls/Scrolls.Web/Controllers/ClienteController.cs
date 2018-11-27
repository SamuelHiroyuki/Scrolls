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
            ClienteDAO cdao = new ClienteDAO();
            cdao.Cadastrar(cliente);
            return View();
        }
    }
}
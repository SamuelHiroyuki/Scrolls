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

        public ActionResult CadaCli(string nome, string sobrenome, string email, string cpf, string senha)
        {
            cpf.Replace(".", "").Replace("-", "");
            Cliente cliente = new Cliente()
            {
                Nome = nome,
                Sobrenome = sobrenome,
                CPF = cpf,
                Email = email,
                Senha = senha
            };
            ClienteDAO cdao = new ClienteDAO();
            cdao.Cadastrar(cliente);
            return RedirectToAction("LoginPage", "Home", new { email = email, senha = senha });
        }

        public ActionResult AtuaCli(Cliente cliente)
        {
            ClienteDAO cdao = new ClienteDAO();
            Cliente cli = cdao.BuscarId(Convert.ToInt32(Session["_Id"]));
            cdao.Atualizar();
            return RedirectToAction("ClientePage","Cliente");
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

        public JsonResult Verificar(string email, string cpf)
        {
            bool[] result = new bool[3];
            if (cpf.Replace("_", "").Replace(".", "").Replace("-", "").Length == 11)
            {
                result[0] = true;
            }
            else
            {
                result[0] = false;
            }

            if (new ClienteDAO().BuscarEmail(email) == null)
            {
                result[1] = false;
            }
            else
            {
                result[1] = true;
            }

            if (!email.Contains('.'))
            {
                result[2] = false;
            }
            else
            {
                result[2] = true;
            }
            return Json(result, JsonRequestBehavior.AllowGet);
        }

        public ActionResult CadEnd(string cep, string endereco, int num, string comp, string bairro, string cidade, string uf)
        {
            if (Session["_Id"] != null)
            {
                EnderecoDAO edao = new EnderecoDAO();
                Endereco ce = new Endereco()
                {
                    ClienteId = Convert.ToInt32(Session["_Id"]),
                    CEP = cep,
                    Estado = uf,
                    Cidade = cidade,
                    Bairro = bairro,
                    Logradouro = endereco,
                    Complemento = comp,
                    Numero = num
                };
                edao.Cadastrar(ce);
            }
            else
            {
                return RedirectToAction("LoginPage", "Home");
            }

            return RedirectToAction("ClientePage","Cliente");
        }
        
        public ActionResult CadCard(string numcard, string ano, string mes, string nome)
        {
            numcard.Replace(" ","");
            if (Session["_Id"] != null)
            {
                Cartao cc = new Cartao()
                {
                    ClienteId = Convert.ToInt32(Session["_Id"]),
                    Numero = numcard,
                    Validade= mes+"/"+ano,
                    Nome= nome,
                };
                CartaoDAO cadao = new CartaoDAO();
                cadao.Cadastrar(cc);
            }
            return RedirectToAction("ClientePage","Cliente");
        }
    }
}
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

        public ActionResult CFuncionario()
        {
            ViewData["Falta"] = new ProdutoDAO().CountIsZero();
            ViewData["Ativo"] = new BannerDAO().CountAtivo();
            return View();
        }

        public ActionResult QFuncionario()
        {
            ViewData["Falta"] = new ProdutoDAO().CountIsZero();
            ViewData["Ativo"] = new BannerDAO().CountAtivo();
            ViewBag.Func = new FuncionarioDAO().Listar();
            return View();
        }

        public ActionResult QVenda()
        {
            ViewData["Falta"] = new ProdutoDAO().CountIsZero();
            ViewData["Ativo"] = new BannerDAO().CountAtivo();
            ViewBag.Vendas = new VendaDAO().Listar();
            ViewBag.Cli = new ClienteDAO().Listar();
            ViewBag.End = new EnderecoDAO().Listar();
            return View();
        }

        public ActionResult Perfil()
        {
            ViewData["Falta"] = new ProdutoDAO().CountIsZero();
            ViewData["Ativo"] = new BannerDAO().CountAtivo();
            ViewBag.Func = new FuncionarioDAO().BuscaId(Convert.ToInt32(Session["_Id"]));
            ClienteDAO cdao = new ClienteDAO();
            if ((cdao.BuscarEmail(Session["_Email"].ToString())) != null)
            {
                ViewBag.End = new EnderecoDAO().BuscaByCli(cdao.BuscarEmail(Session["_Email"].ToString()).Id);
            }
            if ((cdao.BuscarEmail(Session["_Email"].ToString())) != null)
            {
                ViewBag.Card = new CartaoDAO().BuscaByCli(cdao.BuscarEmail(Session["_Email"].ToString()).Id);
            }
            return View();
        }

        public ActionResult LoginPage()
        {
            return View();
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
            Session["_Email"] = string.Empty;
            return RedirectToAction("LoginPage");
        }

        public ActionResult Excluir(int? id) {
            if (id == null)
            {
                return RedirectToAction("LoginPage", "Home");
            }
            else
            {
                if (Session["_Id"] == null)
                {
                    return RedirectToAction("LoginPage", "Home");
                }
                else
                {
                    FuncionarioDAO fdao = new FuncionarioDAO();
                    fdao.Excluir(fdao.BuscaId((int)id));
                    TempData["SucessoR"] = "Sucesso!";
                    return RedirectToAction("QFuncionario");
                }
            }
        }

        [HttpPost]
        public ActionResult Cadastro(HttpPostedFileBase i1, string pass,string nome, string sobre, string adm, string email, string cpf, string nasc, string rg, string cep, string complemento, string num) {
            bool gerente = false;
            if (adm != null)
            {
                gerente = true;
            }
            Funcionario f = new Funcionario() { Nome = nome, Sobrenome = sobre, Senha = pass, Gerente = gerente, CPF = cpf, Email = email, Nascimento = Convert.ToDateTime(nasc), RG = rg, CEP = cep, Complemento = complemento, Numero = num };
            FuncionarioDAO fdao = new FuncionarioDAO();
            fdao.Cadastro(f);
            if (i1 != null)
            {
                string ex = Path.GetExtension(i1.FileName);
                string fn = f.Id + ex;
                f.Imagem = "/Imagens/Funcionarios/" + fn;
                fn = Path.Combine(Server.MapPath("~/Imagens/Funcionarios/"), fn);
                i1.SaveAs(fn);
                fdao.Atualizar();
            }
            ClienteDAO cdao = new ClienteDAO();
            if (cdao.BuscarEmail(email) == null)
            {
                Cliente c = new Cliente() { Nome = nome, CPF = cpf, Email = email, Senha = pass, Sobrenome = sobre };
                cdao.Cadastrar(c);
            }
            TempData["Sucesso"] = "Sucesso!";
            return RedirectToAction("CFuncionario");
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
                Session["_Email"] = f.Email;
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

        public JsonResult Verificar(string cpf, string rg, string email, string na) {
            bool[] cpfrg = new bool[4];
            if (cpf.Replace("_", "").Replace(".", "").Replace("-", "").Length == 11)
            {
                cpfrg[0] = true;
            }
            else
            {
                cpfrg[0] = false;
            }
            if (rg.Replace("_", "").Replace(".", "").Replace("-", "").Length == 9)
            {
                cpfrg[1] = true;
            }
            else
            {
                cpfrg[1] = false;
            }

            if (new FuncionarioDAO().Existe(email) == true)
            {
                cpfrg[2] = false;
            }
            else
            {
                cpfrg[2] = true;
            }

            if (na.Trim() != "")
            {
                if ((Convert.ToInt32(Convert.ToDateTime(na).Year) + 16) <= Convert.ToInt32(DateTime.Now.Year))
                {
                    cpfrg[3] = true;
                }
                else
                {
                    cpfrg[3] = false;
                }
            }
            else
            {
                cpfrg[3] = false;
            }
            return Json(cpfrg, JsonRequestBehavior.AllowGet);
        }

        public JsonResult ConsultaCEP(string cep)
        {
            wsCEPLoc.AtendeClienteClient ws = new wsCEPLoc.AtendeClienteClient("AtendeClientePort");

            string[] result = new string[5];
            try
            {
                if (Convert.ToInt32(cep.Replace("-", "")) < 8)
                {
                    result[4] = "CEP não encontrado.";
                }
                else
                {
                    var dados = ws.consultaCEP(cep.Replace("-", ""));
                    if (dados != null)
                    {
                        result[0] = dados.end;
                        result[1] = dados.bairro;
                        result[2] = dados.cidade;
                        result[3] = dados.uf;
                    }
                    else
                    {
                        result[4] = "CEP não encontrado.";
                    }
                }
            }
            catch (Exception)
            {
                result[4] = "CEP não encontrado.";
            }
            return Json(result, JsonRequestBehavior.AllowGet);
        }
    }
}
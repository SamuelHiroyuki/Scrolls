using Scrolls.DataAccessObject;
using Scrolls.Database;
using Scrolls.Entities;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Scrolls.Web.Controllers
{
    public class ProdutoController : Controller
    {
        // GET: Produto
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult VProduto(int id)
        {
            EntitiesContext context = new EntitiesContext();
            ViewBag.P = new ProdutoDAO().BuscaId(id);
            ViewBag.D = new ProdutoDAO().BuscaId(id).Complemento;
            ViewBag.Avaliacao = new AvaliacaoDAO().BuscaByProd(id);
            ViewBag.pg = (from p in context.Produtos join pp in context.Produtos on p.GeneroId equals pp.GeneroId select pp.Id);
            ViewBag.notas = (from p in context.Produtos join n in context.Avaliacoes on p.Id equals n.ProdutoId select n.Nota).Average();
            ViewBag.quantnotas = (from p in context.Produtos join n in context.Avaliacoes on p.Id equals n.ProdutoId select n.Nota).Count();
            return View();
        }

        public ActionResult Avaliar(string titulo, string comentario, string rating)
        {
            if (Session["_Id"] != null)
            {
                Avaliacao av = new Avaliacao()
                {
                    ClienteId =Convert.ToInt32(Session["_Id"]),
                    ProdutoId = ViewBag.P.Id,
                    Titulo = titulo,
                    Comentario = comentario,
                    Nota = Convert.ToInt32(rating)
                };
                AvaliacaoDAO adao = new AvaliacaoDAO();
                adao.Cadastrar(av);
            }
            else
            {
                return RedirectToAction("LoginPage","Home");
            }
            return View();
        }

        public ActionResult LProduto(int? categoriaId)
        {
            EntitiesContext context = new EntitiesContext();
            ViewBag.Prod = new ProdutoDAO().Listar();
            IList<Produto> produtcat = new List<Produto>();
            IList<Avaliacao> avaliprod = new List<Avaliacao>();
            if (categoriaId != 0)
            {
                foreach (var g in context.Generos)
                {
                    if (g.CategoriaId == categoriaId)
                    {
                        foreach (var pp in ViewBag.Prod)
                        {
                            if (g.Id == pp.GeneroId)
                            {
                                var avp = new AvaliacaoDAO().BuscaByProd(pp.Id);
                                avaliprod.Add(avp);
                                produtcat.Add(pp);
                            }
                        }
                    }
                }
            }
            else
            {
                var produtall = ViewBag.Prod;
                var allavp = new AvaliacaoDAO().BuscaByProd(produtall.Id);
                avaliprod.Add(allavp);
                produtcat.Add(produtall);
            }
            ViewBag.ListProd = produtcat;
            ViewBag.Listavp = avaliprod;
            return View();
        }
    }
}
using Scrolls.DataAccessObject;
using Scrolls.Database;
using Scrolls.Entities;
using Scrolls.Web.CalcCEP;
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

        public JsonResult CalcCEP(string cep) {
            string nCdEmpresa = string.Empty;
            string sDsSenha = string.Empty;
            string nCdServico = "41106";
            string sCepOrigem = "19940000";
            string sCepDestino = cep.Replace("-", "");
            string nVlPeso = Convert.ToString(1);
            int nCdFormato = 1;
            decimal nVlAltura = 20;
            decimal nVlComprimento = 20;
            decimal nVlLargura = 20;
            decimal nVlDiametro = 0;
            string sCdMaoPropria = "N";
            decimal nVlValorDeclarado = 0;
            string sCdAvisoRecebimento = "N";


            CalcPrecoPrazoWSSoapClient wsCorreios = new CalcPrecoPrazoWSSoapClient();
            cResultado retornoCorreios = wsCorreios.CalcPrecoPrazo(nCdEmpresa, sDsSenha, nCdServico, sCepOrigem, sCepDestino, nVlPeso, nCdFormato, nVlComprimento,
                nVlAltura, nVlLargura, nVlDiametro, sCdMaoPropria, nVlValorDeclarado, sCdAvisoRecebimento);

            string[] result = new string[2];
            result[0] = retornoCorreios.Servicos[0].PrazoEntrega;
            result[1] = retornoCorreios.Servicos[0].Valor;
            return Json(result, JsonRequestBehavior.AllowGet);
        }

        public ActionResult VProduto(int id)
        {
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
                if (!p.Imagem1.Contains("https://manager-scrolls.azurewebsites.net"))
                {

                    p.Imagem1 = "https://manager-scrolls.azurewebsites.net" + p.Imagem1;
                }
            }
            EntitiesContext context = new EntitiesContext();
            ViewBag.P = new ProdutoDAO().BuscaId(id);
            ViewBag.Imagem1 = "https://manager-scrolls.azurewebsites.net" + ViewBag.P.Imagem1;
            ViewBag.Imagem2 = "https://manager-scrolls.azurewebsites.net" + ViewBag.P.Imagem2;
            ViewBag.Imagem3 = "https://manager-scrolls.azurewebsites.net" + ViewBag.P.Imagem3;
            ViewBag.Imagem4 = "https://manager-scrolls.azurewebsites.net" + ViewBag.P.Imagem4;
            ViewBag.C = new ProdutoDAO().BuscaId(id).Complemento;
            ViewBag.Avaliacao = new AvaliacaoDAO().BuscaByProd(id);
            ViewBag.pg = (from p in context.Produtos join pp in context.Produtos on p.GeneroId equals pp.GeneroId select pp.Id);
            try
            {
                ViewBag.notas = (from p in context.Produtos join n in context.Avaliacoes on p.Id equals n.ProdutoId select n.Nota).Average();
            }
            catch (Exception)
            {

                ViewBag.notas = null;
            }
            try
            {

                ViewBag.quantnotas = (from p in context.Produtos join n in context.Avaliacoes on p.Id equals n.ProdutoId select n.Nota).Count();
            }
            catch (Exception)
            {


                ViewBag.quantnotas = null; 
            }
            var r = new ProdutoDAO().IsNew();
            foreach (Produto p in r)
            {
                if (!p.Imagem1.Contains("https://manager-scrolls.azurewebsites.net"))
                {

                    p.Imagem1 = "https://manager-scrolls.azurewebsites.net" + p.Imagem1;
                }
            }
            ViewBag.Rep = r;

            try
            {
                ViewBag.S1 = new ProdutoDAO().BuscaId((int)(ViewBag.P.Id + 1));
                ViewBag.Si1 = "https://manager-scrolls.azurewebsites.net" + new ProdutoDAO().BuscaId((int)(ViewBag.P.Id + 1)).Imagem1;
            }
            catch (Exception)
            {
                ViewBag.S1 = new ProdutoDAO().BuscaId((int)(ViewBag.P.Id - 1));
                ViewBag.Si1 = "https://manager-scrolls.azurewebsites.net" + new ProdutoDAO().BuscaId((int)(ViewBag.P.Id - 1)).Imagem1;
            }
            try
            {
                ViewBag.S2 = new ProdutoDAO().BuscaId((int)(ViewBag.P.Id + 2));
                ViewBag.Si2 = "https://manager-scrolls.azurewebsites.net" + new ProdutoDAO().BuscaId((int)(ViewBag.P.Id + 2)).Imagem1;
            }
            catch (Exception)
            {
                ViewBag.S2 = new ProdutoDAO().BuscaId((int)(ViewBag.P.Id - 2));
                ViewBag.Si2 = "https://manager-scrolls.azurewebsites.net" + new ProdutoDAO().BuscaId((int)(ViewBag.P.Id - 2)).Imagem1;
            }
            try
            {

                ViewBag.S3 = new ProdutoDAO().BuscaId((int)(ViewBag.P.Id + 3));
                ViewBag.Si3 = "https://manager-scrolls.azurewebsites.net" + new ProdutoDAO().BuscaId((int)(ViewBag.P.Id + 3)).Imagem1;
            }
            catch (Exception)
            {

                ViewBag.S3 = new ProdutoDAO().BuscaId((int)(ViewBag.P.Id - 3));
                ViewBag.Si3 = "https://manager-scrolls.azurewebsites.net" + new ProdutoDAO().BuscaId((int)(ViewBag.P.Id - 3)).Imagem1;
            }
            return View();
        }

        public ActionResult CompreJunto(int id, int p1, int p2, int p3) {
            Scrolls.Web.Models.MeuCarrinho.Cesta.Add(new ProdutoDAO().BuscaId(p1));
            Scrolls.Web.Models.MeuCarrinho.Cesta.Add(new ProdutoDAO().BuscaId(p2));
            Scrolls.Web.Models.MeuCarrinho.Cesta.Add(new ProdutoDAO().BuscaId(p3));
            return RedirectToAction("VProduto", new { id });
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
            List<Produto> produtcat = new List<Produto>();
            List<Avaliacao> avaliprod = new List<Avaliacao>();
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
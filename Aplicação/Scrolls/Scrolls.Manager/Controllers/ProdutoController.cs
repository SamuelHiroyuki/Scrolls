using Scrolls.DataAccessObject;
using Scrolls.Entities;
using System;
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Scrolls.Manager.Controllers
{
    public class ProdutoController : Controller
    {
        // GET: Produto
        public ActionResult Index()
        {
            return View();
        }
        
        public ActionResult CProduto() {
            ViewData["Falta"] = new ProdutoDAO().IsZero();
            ViewBag.Categorias = new CategoriaDAO().Listar();
            ViewBag.Generos = new GeneroDAO().Listar();
            return View();
        }
        
        public ActionResult QProduto() {
            ViewData["Falta"] = new ProdutoDAO().IsZero();
            ViewBag.Categorias = new CategoriaDAO().Listar();
            ViewBag.Generos = new GeneroDAO().Listar();
            ViewBag.Produtos = new ProdutoDAO().Listar();
            return View();
        }

        public ActionResult AProduto(int? id)
        {
            if (id == null)
            {
                return RedirectToAction("LoginPage", "Home");
            }
            else
            {
                ViewData["Falta"] = new ProdutoDAO().IsZero();
                ViewBag.Categorias = new CategoriaDAO().Listar();
                ViewBag.Generos = new GeneroDAO().Listar();
                ViewBag.P = new ProdutoDAO().BuscaId((int)id);
                return View();
            }
        }

        [HttpPost]
        [ValidateInput(false)]
        public ActionResult Alterar(HttpPostedFileBase i1, HttpPostedFileBase i2, HttpPostedFileBase i3, HttpPostedFileBase i4, string n, string prec, int qtd, string desc, string comp, int gen, int id) {
            ProdutoDAO pdao = new ProdutoDAO();
            Produto p = pdao.BuscaId(id);
            p.Nome = n;
            p.Preco = Convert.ToDouble(prec, new System.Globalization.CultureInfo("en-US"));
            p.Quantidade = qtd;
            p.Descricao = desc;
            p.Complemento = comp;
            p.GeneroId = gen;
            pdao.Atualizar();
            
            TempData["Sucesso"] = "Sucesso!";
            return RedirectToAction("QProduto");
        }

        [HttpPost]
        [ValidateInput(false)]
        public ActionResult Cadastrar(HttpPostedFileBase i1, HttpPostedFileBase i2, HttpPostedFileBase i3, HttpPostedFileBase i4, string n, string prec, int qtd, string desc, string comp, int gen) {
            ProdutoDAO pdao = new ProdutoDAO();
            Produto p = new Produto() { Nome = n, Descricao = desc, Preco = Convert.ToDouble(prec, new System.Globalization.CultureInfo("en-US")),  Quantidade = qtd, Complemento = comp, GeneroId = gen};
            pdao.Cadastrar(p);
            if (i1 != null)
            {
                string ex = Path.GetExtension(i1.FileName);
                string fn = p.Id + ex;
                p.Imagem1= "/Imagens/Produtos/" + fn;
                fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                i1.SaveAs(fn);
                pdao.Atualizar();
                if (i2 != null)
                {
                    ex = Path.GetExtension(i2.FileName);
                    fn = p.Id + "_2" + ex;
                    p.Imagem2 = "/Imagens/Produtos/" + fn;
                    fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                    i2.SaveAs(fn);
                    pdao.Atualizar();
                    if (i3 != null)
                    {
                        ex = Path.GetExtension(i3.FileName);
                        fn = p.Id + "_3" + ex;
                        p.Imagem3 = "/Imagens/Produtos/" + fn;
                        fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                        i3.SaveAs(fn);
                        pdao.Atualizar();
                        if (i4 != null)
                        {
                            ex = Path.GetExtension(i4.FileName);
                            fn = p.Id + "_4" + ex;
                            p.Imagem4 = "/Imagens/Produtos/" + fn;
                            fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                            i4.SaveAs(fn);
                            pdao.Atualizar();
                        }
                    }
                    else
                    {
                        if (i4 != null)
                        {
                            ex = Path.GetExtension(i4.FileName);
                            fn = p.Id + "_3" + ex;
                            p.Imagem3 = "/Imagens/Produtos/" + fn;
                            fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                            i4.SaveAs(fn);
                            pdao.Atualizar();
                        }
                    }
                }
                else
                {
                    if (i3 != null)
                    {
                        ex = Path.GetExtension(i3.FileName);
                        fn = p.Id + "_2" + ex;
                        p.Imagem2 = "/Imagens/Produtos/" + fn;
                        fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                        i3.SaveAs(fn);
                        pdao.Atualizar();
                        if (i4 != null)
                        {
                            ex = Path.GetExtension(i4.FileName);
                            fn = p.Id + "_3" + ex;
                            p.Imagem3 = "/Imagens/Produtos/" + fn;
                            fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                            i4.SaveAs(fn);
                            pdao.Atualizar();
                        }
                    }
                    else
                    {
                        if (i4 != null)
                        {
                            ex = Path.GetExtension(i4.FileName);
                            fn = p.Id + "_2" + ex;
                            p.Imagem2 = "/Imagens/Produtos/" + fn;
                            fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                            i4.SaveAs(fn);
                            pdao.Atualizar();
                        }
                    }
                }
            }
            else
            {
                if (i2 != null)
                {
                    string ex = Path.GetExtension(i2.FileName);
                    string fn = p.Id + ex;
                    p.Imagem1 = "/Imagens/Produtos/" + fn;
                    fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                    i2.SaveAs(fn);
                    pdao.Atualizar();
                    if (i3 != null)
                    {
                        ex = Path.GetExtension(i3.FileName);
                        fn = p.Id + "_2" + ex;
                        p.Imagem2 = "/Imagens/Produtos/" + fn;
                        fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                        i3.SaveAs(fn);
                        pdao.Atualizar();
                        if (i4 != null)
                        {
                            ex = Path.GetExtension(i4.FileName);
                            fn = p.Id + "_3" + ex;
                            p.Imagem3 = "/Imagens/Produtos/" + fn;
                            fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                            i4.SaveAs(fn);
                            pdao.Atualizar();
                        }
                    }
                    else
                    {
                        if (i4 != null)
                        {
                            ex = Path.GetExtension(i4.FileName);
                            fn = p.Id + "_2" + ex;
                            p.Imagem2 = "/Imagens/Produtos/" + fn;
                            fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                            i4.SaveAs(fn);
                            pdao.Atualizar();
                        }
                    }
                }
                else
                {
                    if (i3 != null)
                    {
                        string ex = Path.GetExtension(i3.FileName);
                        string fn = p.Id + ex;
                        p.Imagem1 = "/Imagens/Produtos/" + fn;
                        fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                        i3.SaveAs(fn);
                        pdao.Atualizar();
                        if (i4 != null)
                        {
                            ex = Path.GetExtension(i4.FileName);
                            fn = p.Id + "_2" + ex;
                            p.Imagem2 = "/Imagens/Produtos/" + fn;
                            fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                            i4.SaveAs(fn);
                            pdao.Atualizar();
                        }
                    }
                    else
                    {
                        if (i4 != null)
                        {
                            string ex = Path.GetExtension(i4.FileName);
                            string fn = p.Id + ex;
                            p.Imagem1 = "/Imagens/Produtos/" + fn;
                            fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                            i4.SaveAs(fn);
                            pdao.Atualizar();
                        }
                    }
                }
            }
            TempData["Sucesso"] = "Sucesso!";
            return RedirectToAction("CProduto");
        }
    }
}
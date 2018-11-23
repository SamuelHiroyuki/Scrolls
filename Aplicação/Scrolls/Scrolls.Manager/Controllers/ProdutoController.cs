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
            ViewBag.Categorias = new CategoriaDAO().Listar();
            ViewBag.Generos = new GeneroDAO().Listar();
            return View();
        }
        
        public ActionResult QProduto() {
            ViewBag.Categorias = new CategoriaDAO().Listar();
            ViewBag.Generos = new GeneroDAO().Listar();
            ViewBag.Produtos = new ProdutoDAO().Listar();
            ViewBag.Imagens = new ImagemDAO().Listar();
            return View();
        }

        [HttpPost]
        [ValidateInput(false)]
        public ActionResult Cadastrar(HttpPostedFileBase i1, HttpPostedFileBase i2, HttpPostedFileBase i3, HttpPostedFileBase i4, string n, string prec, int qtd, string desc, string comp, int gen) {
            ProdutoDAO pdao = new ProdutoDAO();
            Produto p = new Produto() { Nome = n, Descricao = desc, Preco = Convert.ToDouble(prec, new System.Globalization.CultureInfo("en-US")),  Quantidade = qtd, Complemento = comp, GeneroId = gen};
            pdao.Cadastrar(p);
            ImagemDAO idao = new ImagemDAO();
            if (i1 != null)
            {
                string ex = Path.GetExtension(i1.FileName);
                string fn = p.Id + ex;
                Imagem i = new Imagem() { Caminho = "/Imagens/Produtos/" + fn, ProdutoId = p.Id };
                fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                i1.SaveAs(fn);
                idao.Cadastrar(i);
                if (i2 != null)
                {
                    ex = Path.GetExtension(i2.FileName);
                    fn = p.Id + "_2" + ex;
                    i = new Imagem() { Caminho = "/Imagens/Produtos/" + fn, ProdutoId = p.Id };
                    fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                    i2.SaveAs(fn);
                    idao.Cadastrar(i);
                    if (i3 != null)
                    {
                        ex = Path.GetExtension(i3.FileName);
                        fn = p.Id + "_3" + ex;
                        i = new Imagem() { Caminho = "/Imagens/Produtos/" + fn, ProdutoId = p.Id };
                        fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                        i3.SaveAs(fn);
                        idao.Cadastrar(i);
                        if (i4 != null)
                        {
                            ex = Path.GetExtension(i4.FileName);
                            fn = p.Id + "_4" + ex;
                            i = new Imagem() { Caminho = "/Imagens/Produtos/" + fn, ProdutoId = p.Id };
                            fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                            i4.SaveAs(fn);
                            idao.Cadastrar(i);
                        }
                    }
                    else
                    {
                        if (i4 != null)
                        {
                            ex = Path.GetExtension(i4.FileName);
                            fn = p.Id + "_3" + ex;
                            i = new Imagem() { Caminho = "/Imagens/Produtos/" + fn, ProdutoId = p.Id };
                            fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                            i4.SaveAs(fn);
                            idao.Cadastrar(i);
                        }
                    }
                }
                else
                {
                    if (i3 != null)
                    {
                        ex = Path.GetExtension(i3.FileName);
                        fn = p.Id + "_2" + ex;
                        i = new Imagem() { Caminho = "/Imagens/Produtos/" + fn, ProdutoId = p.Id };
                        fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                        i3.SaveAs(fn);
                        idao.Cadastrar(i);
                        if (i4 != null)
                        {
                            ex = Path.GetExtension(i4.FileName);
                            fn = p.Id + "_3" + ex;
                            i = new Imagem() { Caminho = "/Imagens/Produtos/" + fn, ProdutoId = p.Id };
                            fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                            i4.SaveAs(fn);
                            idao.Cadastrar(i);
                        }
                    }
                    else
                    {
                        if (i4 != null)
                        {
                            ex = Path.GetExtension(i4.FileName);
                            fn = p.Id + "_2" + ex;
                            i = new Imagem() { Caminho = "/Imagens/Produtos/" + fn, ProdutoId = p.Id };
                            fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                            i4.SaveAs(fn);
                            idao.Cadastrar(i);
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
                    Imagem i = new Imagem() { Caminho = "/Imagens/Produtos/" + fn, ProdutoId = p.Id };
                    fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                    i2.SaveAs(fn);
                    idao.Cadastrar(i);
                    if (i3 != null)
                    {
                        ex = Path.GetExtension(i3.FileName);
                        fn = p.Id + "_2" + ex;
                        i = new Imagem() { Caminho = "/Imagens/Produtos/" + fn, ProdutoId = p.Id };
                        fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                        i3.SaveAs(fn);
                        idao.Cadastrar(i);
                        if (i4 != null)
                        {
                            ex = Path.GetExtension(i4.FileName);
                            fn = p.Id + "_3" + ex;
                            i = new Imagem() { Caminho = "/Imagens/Produtos/" + fn, ProdutoId = p.Id };
                            fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                            i4.SaveAs(fn);
                            idao.Cadastrar(i);
                        }
                    }
                    else
                    {
                        if (i4 != null)
                        {
                            ex = Path.GetExtension(i4.FileName);
                            fn = p.Id + "_2" + ex;
                            i = new Imagem() { Caminho = "/Imagens/Produtos/" + fn, ProdutoId = p.Id };
                            fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                            i4.SaveAs(fn);
                            idao.Cadastrar(i);
                        }
                    }
                }
                else
                {
                    if (i3 != null)
                    {
                        string ex = Path.GetExtension(i3.FileName);
                        string fn = p.Id + ex;
                        Imagem i = new Imagem() { Caminho = "/Imagens/Produtos/" + fn, ProdutoId = p.Id };
                        fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                        i3.SaveAs(fn);
                        idao.Cadastrar(i);
                        if (i4 != null)
                        {
                            ex = Path.GetExtension(i4.FileName);
                            fn = p.Id + "_2" + ex;
                            i = new Imagem() { Caminho = "/Imagens/Produtos/" + fn, ProdutoId = p.Id };
                            fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                            i4.SaveAs(fn);
                            idao.Cadastrar(i);
                        }
                    }
                    else
                    {
                        if (i4 != null)
                        {
                            string ex = Path.GetExtension(i4.FileName);
                            string fn = p.Id + ex;
                            Imagem i = new Imagem() { Caminho = "/Imagens/Produtos/" + fn, ProdutoId = p.Id };
                            fn = Path.Combine(Server.MapPath("~/Imagens/Produtos/"), fn);
                            i4.SaveAs(fn);
                            idao.Cadastrar(i);
                        }
                    }
                }
            }
            TempData["Sucesso"] = "Sucesso!";
            return RedirectToAction("CProduto");
        }
    }
}
package br.edu.ifce.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifce.DataManager.ProdutoDao;
import br.edu.ifce.DataManager.UsuarioDao;
import br.edu.ifce.ModelBeans.Categoria;
import br.edu.ifce.ModelBeans.Endereco;
import br.edu.ifce.ModelBeans.Produto;
import br.edu.ifce.ModelBeans.Usuario;



/**
 * Servlet implementation class HomeController
 */
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDao usuarioDao;
	private ProdutoDao produtoDao;
	private String forward;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        usuarioDao = new UsuarioDao();
        produtoDao = new ProdutoDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String app = request.getParameter("app");
		String filter = request.getParameter("filter");
		if (app != null) {
			nextRoute(app);
			
		}else {
			if(filter!= null) {
				request.setAttribute("filter", Integer.parseInt(filter));
				request.setAttribute("produtos", getProductWithCategoryID(Integer.parseInt(filter)));
			}else {
				request.setAttribute("filter", 0);
				request.setAttribute("produtos", getProductWithCategoryID(0));
			}
			forward = "views/Home.jsp";
			request.setAttribute("categorias", produtoDao.getAllCategoria());
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
		// TODO Auto-generated method stub
		/*
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 * Endereco endereco = new Endereco(); endereco.setBairro("Castelão");
		 * endereco.setCep(000000); endereco.setCidade("Fortaleza");
		 * endereco.setEstado("Ceará"); endereco.setPais("Brasil");
		 * endereco.setRua("rua caramuru"); endereco.setNumero("tdgete");
		 * endereco.setEnderecoID(29); Usuario usuario = new Usuario();
		 * usuario.setEmail("jucatatu@bb.com"); usuario.setNome("juca tatu");
		 * usuario.setSenha("admin321"); usuario.setTelefone("8888888899");
		 * usuario.setEndereco(endereco); usuario.setClinteID(25);
		 * usuarioDao.deleteCliente(25);
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void nextRoute(String app) {
		switch (app) {
		case "login":
			forward = "view/login.jsp";
			break;
		case "carregar":
			forward = "/MercadoSoOPitel/HomeController?app=carregar";
			break;
		case "cadastro":
			forward = "view/cadastro.jsp";
			break;
		default:
			forward = "/MercadoSoOPitel/HomeController?app=carregar";
			break;
		}
	}
	private List<Produto> getProductWithCategoryID(int index) {
		List<Produto> listaProdutos = produtoDao.getAllProduct();
		List<Produto> filterProdutos = new ArrayList<Produto>();
		
		if (index == 0) {
			return listaProdutos;
		}
		
		for (Produto produto :listaProdutos) {
			if (produto.getCategoriaID() == index) {
				filterProdutos.add(produto);
			}
		}
		
		return listaProdutos;
				
		
	}

}

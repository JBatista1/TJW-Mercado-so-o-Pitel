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
import javax.servlet.http.HttpSession;

import br.edu.ifce.DataManager.ProdutoDao;
import br.edu.ifce.DataManager.UsuarioDao;
import br.edu.ifce.ModelBeans.Categoria;
import br.edu.ifce.ModelBeans.Endereco;
import br.edu.ifce.ModelBeans.Produto;
import br.edu.ifce.ModelBeans.Usuario;
import br.edu.ifce.Utils.BeanUtilities;



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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario usuario = new Usuario();
		HttpSession session = request.getSession();
		if (session.getAttribute("endereco") == null && session.getAttribute("usuario") != null) {
			usuario = (Usuario) session.getAttribute("usuario");
			Endereco endereco  = new Endereco();
			BeanUtilities.populateBean(endereco, request);	
			usuario.setEndereco(endereco);
			usuarioDao.addUsuario(usuario, endereco);
			doGet(request, response);
			System.out.println("##########Passei aqui########");
		}else {
			forward = "views/CadastrarEndereco.jsp";
			BeanUtilities.populateBean(usuario, request);	
			session.setAttribute("usuario", usuario);
			RequestDispatcher view = request.getRequestDispatcher(forward);
			System.out.println("##########Passei aqui########");
			view.forward(request, response);
		}
	}
	
	private void nextRoute(String app) {
		switch (app) {
		case "login":
			forward = "views/Login.jsp";
			break;
		case "carregar":
			forward = "/MercadoSoOPitel/HomeController?app=carregar";
			break;
		case "cadastrar":
			forward = "views/Cadastrar.jsp";
			break;
		case "finish":
			forward = "views/Cadastrar.jsp";
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
			int id = produto.getCategoriaID();
			System.out.println(id);
			System.out.println(index);
			if (id == index) {
				filterProdutos.add(produto);
			}
		}
		
		return filterProdutos;
	}

}

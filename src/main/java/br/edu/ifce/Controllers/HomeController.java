package br.edu.ifce.Controllers;

import java.io.IOException;
import org.json.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.edu.ifce.DataManager.UsuarioDao;
import br.edu.ifce.ModelBeans.Endereco;
import br.edu.ifce.ModelBeans.Usuario;


/**
 * Servlet implementation class HomeController
 */
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDao usuarioDao;
	private String forward;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        usuarioDao = new UsuarioDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Endereco  endereco = new Endereco();
		endereco.setBairro("Itaperi");
		endereco.setCep(60714305);
		endereco.setCidade("Fortaleza");
		endereco.setEstado("Ceará");
		endereco.setPais("Brasil");
		endereco.setRua("rua pupunha");
		endereco.setNumero("125b");
		Usuario usuario = new Usuario();
		usuario.setEmail("joao@bb.com");
		usuario.setNome("joao Batista");
		usuario.setSenha("admin123");
		usuario.setTelefone("999999999");
		usuarioDao.addUsuario(usuario, endereco);
		System.out.println(usuarioDao.getAddressById(8));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

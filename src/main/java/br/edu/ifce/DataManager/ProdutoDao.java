package br.edu.ifce.DataManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifce.ModelBeans.Categoria;
import br.edu.ifce.ModelBeans.Produto;
import br.edu.ifce.ModelBeans.Usuario;
import br.edu.ifce.Utils.DbUtil;

public class ProdutoDao {
	private Connection connection;
	private List<Produto> listaProdutos = new ArrayList<Produto>();
	private List<Categoria> listaCategoria = new ArrayList<Categoria>();
	
	public ProdutoDao() {	
		connection = DbUtil.getConnection();
	}
	
	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public List<Categoria> getListaCategoria() {
		return listaCategoria;
	}

	public List<Produto> getAllProduct () {
		
		String sql = "SELECT * FROM produto";
		if (listaProdutos != null) {
			listaProdutos.clear();
		}
		try {
			PreparedStatement Statement = connection.prepareStatement(sql);
			ResultSet rs = Statement.executeQuery(sql);
			
			while (rs.next()) {
				Produto produto = new Produto();
	            produto.setProdutoID(rs.getInt("produtoID"));
	            produto.setName(rs.getString("nome"));
	            produto.setPreco(rs.getFloat("preco"));
	            produto.setCategoriaID(rs.getInt("categoriaID"));
	            produto.setDescricao(rs.getString("descricao"));
	            produto.setUrl(rs.getString("urlImage"));
	            System.out.println(produto);
	            listaProdutos.add(produto);
	        }
			Statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaProdutos;
	}
	
	public List<Categoria> getAllCategoria () {
		
		String sql = "SELECT * FROM categoria";
		if (listaCategoria != null) {
			listaCategoria.clear();
		}
		try {
			PreparedStatement Statement = connection.prepareStatement(sql);
			ResultSet rs = Statement.executeQuery(sql);
			
			while (rs.next()) {
				Categoria categoria = new Categoria();
	            categoria.setCatgoriaID(rs.getInt("categoriaID")); 
	            categoria.setName(rs.getString("nome"));
	            listaCategoria.add(categoria);
	        }
			Statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaCategoria;
	}
	
}

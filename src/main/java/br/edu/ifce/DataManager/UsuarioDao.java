package br.edu.ifce.DataManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifce.ModelBeans.Endereco;
import br.edu.ifce.ModelBeans.Usuario;
import br.edu.ifce.Utils.DbUtil;

public class UsuarioDao {
	private Connection connection;

	public UsuarioDao() {
		connection = DbUtil.getConnection();
	}

	public void addUsuario(Usuario usuario, Endereco endereco) {

		String sql = "INSERT INTO clientes (nome,endereco,telefone) VALUES (?,?,?)";

	}

	public int addEndereco(Endereco endereco) {
		int idAddress = 0;
		String sql = "INSERT INTO endereco (rua,bairro,cidade,estado,cep,pais,numero) VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, endereco.getRua());
			statement.setString(2, endereco.getBairro());
			statement.setString(3, endereco.getCidade());
			statement.setString(4, endereco.getEstado());
			statement.setInt(5, endereco.getCep());
			statement.setString(6, endereco.getPais());
			statement.setString(7, endereco.getNumero());
			statement.executeUpdate();
			
			ResultSet rs = statement.getGeneratedKeys();
			while (rs.next()) {
				idAddress = rs.getInt(1);
				System.out.println(idAddress);
			 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idAddress;
	}

	public int getIdAddress() {
		int idAddress = 0;
		String sql = "SELECT MAX(categoriaID) FROM categoria";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				idAddress = (rs.getInt("MAX(categoriaID)"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return idAddress;

	}
}

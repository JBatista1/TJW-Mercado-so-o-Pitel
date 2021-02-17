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
	//MARK: - Cliente
	public void addUsuario(Usuario usuario, Endereco endereco) {
		String sql = "INSERT INTO cliente (nome,email,senha,enderecoID,telefone) VALUES (?,?,?,?,?)";
		usuario.setEnderecoID(addAddress(endereco));
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getEmail());
			statement.setString(3, usuario.getSenha());
			statement.setInt(4, usuario.getEnderecoID());
			statement.setString(5, usuario.getTelefone());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Usuario> getAllClientes () {
		List<Usuario> listaDeClientes = new ArrayList<Usuario>();
		String sql = "SELECT * FROM cliente";
		
		
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Usuario cliente = new Usuario();
	            cliente.setClinteID(rs.getInt("clienteID"));
	            cliente.setNome(rs.getString("nome"));
	            cliente.setEmail(rs.getString("email"));
	            cliente.setSenha(rs.getString("senha"));
	            cliente.setTelefone(rs.getString("telefone"));
	            cliente.setCarrinho(rs.getString("carrinho"));
	            cliente.setEnderecoID(rs.getInt("enderecoID"));
	            listaDeClientes.add(cliente);
	        }
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaDeClientes;
	}
	
	public Usuario getClienteById(int id) {
		Usuario cliente = new Usuario();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from cliente where clienteID=?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
 	            cliente.setClinteID(rs.getInt("clienteID"));
 	            cliente.setNome(rs.getString("nome"));
 	            cliente.setEmail(rs.getString("email"));
 	            cliente.setSenha(rs.getString("senha"));
 	            cliente.setTelefone(rs.getString("telefone"));
 	            cliente.setCarrinho(rs.getString("carrinho"));
 	            cliente.setEnderecoID(rs.getInt("enderecoID"));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return cliente;
	}
	
	public void deleteCliente(int id) {
		String sql = "delete from cliente where clienteID=?";
        try {
        
            // Parameters start with 1
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	//MARK: - Endereço
	public List<Endereco> getAllAnddress() {
		List<Endereco> listaDeEndereco = new ArrayList<Endereco>();
		
		String sql = "SELECT * FROM endereco";
			
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
	            Endereco endereco = new Endereco();
	            endereco.setEnderecoID(rs.getInt("enderecoID"));
	            endereco.setRua(rs.getString("rua"));
	            endereco.setBairro(rs.getString("bairro"));
	            endereco.setCidade(rs.getString("cidade"));
	            endereco.setEstado(rs.getString("estado"));
	            endereco.setCep(rs.getInt("cep"));
	            endereco.setPais(rs.getString("pais"));
	            endereco.setNumero(rs.getString("numero"));
	            listaDeEndereco.add(endereco);
	        }
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaDeEndereco;
	}

	private int addAddress(Endereco endereco) {
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
			 }
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idAddress;
	}

	public int getIdAddress() {
		int idAddress = 0;
		String sql = "SELECT MAX(categoriaID) FROM categoria";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				idAddress = (rs.getInt("MAX(categoriaID)"));
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idAddress;
	}
	
	public Endereco getAddressById(int id) {
		Endereco endereco = new Endereco();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from cliente where clienteID=?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
 	            endereco.setEnderecoID(rs.getInt("enderecoID"));
 	            endereco.setRua(rs.getString("rua"));
 	            endereco.setBairro(rs.getString("bairro"));
 	            endereco.setCidade(rs.getString("cidade"));
 	            endereco.setEstado(rs.getString("estado"));
 	            endereco.setCep(rs.getInt("cep"));
 	            endereco.setPais(rs.getString("pais"));
 	            endereco.setNumero(rs.getString("numero"));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
		return endereco;
	}
	
	public void deleteAddress(int id) {
		String sql = "delete from endereco where enderecoID=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

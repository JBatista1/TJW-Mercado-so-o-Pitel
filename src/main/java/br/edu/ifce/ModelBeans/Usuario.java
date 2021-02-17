package br.edu.ifce.ModelBeans;

public class Usuario {
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private String carrinho;
	private int clinteID;
	
	public int getClinteID() {
		return clinteID;
	}
	public void setClinteID(int clinteID) {
		this.clinteID = clinteID;
	}
	public String getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(String carrinho) {
		this.carrinho = carrinho;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	private int enderecoID;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getEnderecoID() {
		return enderecoID;
	}
	public void setEnderecoID(int enderecoID) {
		this.enderecoID = enderecoID;
	}
}

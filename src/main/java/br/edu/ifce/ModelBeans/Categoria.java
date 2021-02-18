package br.edu.ifce.ModelBeans;

public class Categoria {
	private String nome;
	private int catgoriaID;
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCatgoriaID() {
		return catgoriaID;
	}

	public void setCatgoriaID(int catgoriaID) {
		this.catgoriaID = catgoriaID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}

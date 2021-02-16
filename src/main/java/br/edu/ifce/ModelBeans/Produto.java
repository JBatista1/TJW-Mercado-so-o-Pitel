package br.edu.ifce.ModelBeans;

public class Produto {
	private String name;
	private float preco;
	private int categoriaID;
	private String descricao;
	private String url;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public int getCategoriaID() {
		return categoriaID;
	}
	public void setCategoriaID(int categoriaID) {
		this.categoriaID = categoriaID;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}

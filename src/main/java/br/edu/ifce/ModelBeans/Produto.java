package br.edu.ifce.ModelBeans;

public class Produto {
	private String nome;
	private float preco;
	private int categoriaID;
	private String descricao;
	private String urlImage;
	private int produtoID;
	
	public int getProdutoID() {
		return produtoID;
	}
	public void setProdutoID(int produtoID) {
		this.produtoID = produtoID;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
}

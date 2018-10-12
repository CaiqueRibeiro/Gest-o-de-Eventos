package dominio.viewmodels;

import java.util.List;

import dominio.evento.EntidadeDominio;
import dominio.produto.Fornecedor;
import dominio.produto.ItemProduto;
import dominio.produto.Produto;

public class ItemProdutoVM extends EntidadeDominio {

	private List<Fornecedor> itemProduto;
	private List<Produto> produtos;
	private List<Fornecedor> fornecedores;
	
	

	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public List<Fornecedor> getItemProduto() {
		return itemProduto;
	}
	
	public void setItemProduto(List<Fornecedor> itemProduto) {
		this.itemProduto = itemProduto;
	}
	
	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}
	
	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}
	
	
	
	
}

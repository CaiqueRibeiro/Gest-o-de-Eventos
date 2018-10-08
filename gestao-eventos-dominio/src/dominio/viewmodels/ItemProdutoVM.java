package dominio.viewmodels;

import java.util.List;

import dominio.evento.EntidadeDominio;
import dominio.produto.ItemProduto;
import dominio.produto.Produto;

public class ItemProdutoVM extends EntidadeDominio {

	private ItemProduto itemProduto;
	private List<Produto> produtos;
	
	
	public ItemProduto getItemProduto() {
		return itemProduto;
	}
	public void setItemProduto(ItemProduto itemProduto) {
		this.itemProduto = itemProduto;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	
}

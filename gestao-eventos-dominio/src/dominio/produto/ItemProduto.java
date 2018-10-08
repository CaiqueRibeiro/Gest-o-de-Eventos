package dominio.produto;

import dominio.evento.EntidadeDominio;

public class ItemProduto extends EntidadeDominio {
	
	private Produto produto;
	private double quantidade = 0.0;
	private double precoTotal = 0.0;
	Fornecedor fornecedor;
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public double getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(double quantidade) {
		if(quantidade > 0) {
			this.quantidade = quantidade;
		}
		
		this.calcPrecoTotal();
	}
	
 	public double getPrecoTotal() {
 		return this.precoTotal;
 	}
 	
 	private void calcPrecoTotal() {
 		this.precoTotal = this.produto.getPreco() * this.quantidade;
 	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
 	
 	
	
	

}

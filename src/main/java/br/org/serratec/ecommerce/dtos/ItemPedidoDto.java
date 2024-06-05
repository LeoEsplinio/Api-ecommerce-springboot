package br.org.serratec.ecommerce.dtos;

public class ItemPedidoDto {
	
	private ProdutoDto produto;
	private Double precoVenda;
	private Integer quantidade;
	private Double valorBruto;
	private Double percentualDesconto;
	private Double valorLiquido;
	public ProdutoDto getProduto() {
		return produto;
	}
	public void setProduto(ProdutoDto produto) {
		this.produto = produto;
	}
	public Double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValorBruto() {
		return valorBruto;
	}
	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}
	public Double getPercentualDesconto() {
		return percentualDesconto;
	}
	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}
	public Double getValorLiquido() {
		return valorLiquido;
	}
	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}
	
	
	@Override
	public String toString() {
		return String.format("""
				Produto: %s
				Preço do produto: R$ %.2f
				Quantidade: %s
				Valor Bruto: R$ %.2f
				Percentual Desconto: %.2f%%
				Valor de Venda: R$ %.2f
				---------------------------
				""", produto, precoVenda, quantidade, valorBruto, percentualDesconto, valorLiquido);
	}
	
	
}

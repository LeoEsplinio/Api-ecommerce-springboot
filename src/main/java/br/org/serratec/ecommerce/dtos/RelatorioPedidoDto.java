package br.org.serratec.ecommerce.dtos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RelatorioPedidoDto {

	private Integer idPedido;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataPedido;
	
	private Double valorTotal;
	
	private List<ItemPedidoDto> itensPedido;

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<ItemPedidoDto> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedidoDto> itensPedido) {
		this.itensPedido = itensPedido;
	}
	
	public String toStringFormatado() {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return toString() + String.format("""
				
				Relatório de pedido: 
				Número do pedido: %s
				Data do pedido: %s
				Valor total: R$%.2f
				
				Itens do Pedido: %s
				""", idPedido, dataPedido.format(f), valorTotal, itensPedido);
	}

	@Override
	public String toString() {
		return "\n";
	}
	
	
	
	
}

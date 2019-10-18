package modelo.entidades;

public class NotaPagamento {
	
	private Double pagamentoBasic;
	private Double taxa;
	
	public NotaPagamento() {
		
	}

	public NotaPagamento(Double pagamentoBasic, Double taxa) {
		this.pagamentoBasic = pagamentoBasic;
		this.taxa = taxa;
	}

	public Double getPagamentoBasic() {
		return pagamentoBasic;
	}

	public void setPagamentoBasic(Double pagamentoBasic) {
		this.pagamentoBasic = pagamentoBasic;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}
	
	public Double pegarPagamentoTotal() {
		return getPagamentoBasic() + getTaxa(); 	
				
	}
	
	

}

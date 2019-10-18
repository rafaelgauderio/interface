package modelo.servicos;

import modelo.entidades.AluguelCarro;
import modelo.entidades.NotaPagamento;

public class ServicosAluguel {
	
	private Double precoPorDia;
	private Double precoPorHora;
	//associacao com TaxaServico
	
	private TaxaServico taxaServico;

	public ServicosAluguel(Double precoPorDia, Double precoPorHora, TaxaServico taxaServico) {
		super();
		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
		this.taxaServico = taxaServico;
	}
	
	public void processoNotaPagamento(AluguelCarro aluguelCarro) {
		long t2 = aluguelCarro.getFim().getTime();
		long t1 =  aluguelCarro.getInicio().getTime();
		//convertando milisegundo para horas 
		double horas = (double)(t2-t1) /1000 / 60 / 60;
		double pagamentobasico;
		if (horas<=12.0) {
			pagamentobasico = Math.ceil(horas)*precoPorHora;
		}
		else {
			pagamentobasico = Math.ceil(horas/24)*precoPorDia;
		}
		
		double imposto = taxaServico.imposto(pagamentobasico);
		//novo objeto de pagamento, associoado com Nota de pagamento de aluguel
		aluguelCarro.setNotapagamento(new NotaPagamento(pagamentobasico, imposto));
	}
	

}

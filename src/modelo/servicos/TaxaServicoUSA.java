package modelo.servicos;

public class TaxaServicoUSA implements TaxaServico {

	public double imposto(double valor) {
		if (valor <= 100) {
			return valor * 0.3;
		} else {
			return valor * 0.4;

		}
	}

}





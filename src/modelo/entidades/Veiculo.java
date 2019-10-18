package modelo.entidades;

public class Veiculo {
	private String modelo;
	
	//construtora padrao e depois com argumentos

	public Veiculo () {
		
	}
	public Veiculo(String modelo) {
		this.modelo=modelo;
	}

	//getter and setter
	
	public String getModelo () {
		return modelo;
	}
	public void setModelo(String modelito) {
		this.modelo=modelito;
	}
	
}

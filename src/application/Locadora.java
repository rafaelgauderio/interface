package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import modelo.entidades.AluguelCarro;
import modelo.entidades.Veiculo;
import modelo.servicos.ServicosAluguel;
import modelo.servicos.TaxaServicoBrazil;

public class Locadora {
	// função principal
	
	static public void main(String[] args) throws ParseException  {
		Locale.setDefault(Locale.US);
		Scanner sc=new Scanner(System.in);
		SimpleDateFormat data=new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Entre com os dados da locação");
		System.out.print("Informe o modelo do carro: ");
		String modeloCarro=sc.nextLine();
		System.out.print("Informe a data de retirada: (dd/MM/aaaa HH/mm):");
		Date retirada = data.parse(sc.nextLine());
		System.out.print("Informe a data de devolução: (dd/MM/aaaa HH/mm):");
		Date devolucao=data.parse(sc.nextLine());
		
		AluguelCarro carro = new AluguelCarro(retirada, devolucao, new Veiculo(modeloCarro));
		
		System.out.print("Infome o preço por hora: ");
		double precoPorHora=sc.nextDouble();
		System.out.print("Infome o preço por dia: ");
		double precoPorDia=sc.nextDouble();
		
		ServicosAluguel servicoAluguel= new ServicosAluguel(precoPorDia, precoPorHora, new TaxaServicoBrazil());
		
		//acessar o serivo de aluguel ,chamado a operacao notadepagamento com argumento carro
		servicoAluguel.processoNotaPagamento(carro);
		System.out.println("------------------------------------");
		System.out.println("\n**Nota de Pagamento**\n");
		System.out.println("Modelo do carro: "+ modeloCarro);
		System.out.println("Pagamento Básico: "+String.format("R$ %.2f",carro.getNotapagamento().getPagamentoBasic()));
		System.out.println("Imposto: "+String.format("R$ %.2f",carro.getNotapagamento().getTaxa()));
		System.out.println("Valor Total: " + String.format("R$ %.2f",carro.getNotapagamento().pegarPagamentoTotal()) );
				
		sc.close();
	}

}

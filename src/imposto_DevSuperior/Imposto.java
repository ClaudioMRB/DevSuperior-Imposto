package Desafio_Imposto;

import java.util.Locale;
import java.util.Scanner;

public class Imposto {

	
	
	Double impostoSobreSalario(Double quantia) {
	Double rendaMensal = quantia/12;
	if (rendaMensal <= 3000) {
		System.out.println("Isento de imposto");	
	}
	 if (rendaMensal > 3000 && rendaMensal <= 5000) {
			Double imposto = quantia * 0.1;
			System.out.printf("Imposto sobre sálario: R$ %.2f", imposto);
	 }
	 if (rendaMensal > 5000) {

			Double imposto = quantia * 0.2;
			System.out.printf("Imposto sobre sálario: R$ %.2f", imposto);
	 }
	return rendaMensal;
		
	}
Double impostoSobreServiços(Double quantia) {
	
	Double imposto1 = quantia * 0.15;
	System.out.printf("\nImposto sobre serviços: R$ %.2f", imposto1);
	return imposto1;
		
	}
Double impostoSobreGc(Double quantia) {
	
	Double imposto2 = quantia * 0.2;
	System.out.printf("\nImposto sobre Ganho de capital: R$ %.2f", imposto2);
	return imposto2;
}
void impostoBrutoTotal(Double salario, Double servicos, Double gc) {
	Double rendaMensal = salario/12;
	Double impSalario = 0.0;
	Double imposto1 = servicos * 0.15;
	Double imposto2 = gc * 0.2;
	
	
	 if (rendaMensal > 3000 && rendaMensal <= 5000) {
			Double imposto = salario * 0.1;
		impSalario = impSalario + imposto;
	 }
	 if (rendaMensal > 5000) {

			Double imposto = salario * 0.2;
			 impSalario = imposto;
	 }
	 System.out.println();
	System.out.println("\nResumo");
	 System.out.printf("\nImposto bruto total: R$ %.2f", imposto1 + imposto2 + impSalario);
	 
	
}
void abatimento( Double salario, Double servicos, Double gc, Double gastosMedicos, Double gastosEducacionais) {
Double abat = gastosEducacionais+gastosMedicos;	
Double rendaMensal = salario/12;
Double impSalario = 0.0;
Double imposto1 = servicos * 0.15;
Double imposto2 = gc * 0.2;




 if (rendaMensal > 3000 && rendaMensal <= 5000) {
		Double imposto = salario * 0.1;
		
		impSalario = imposto;
		

			}
 
 if (rendaMensal > 5000) {

		Double imposto = salario * 0.2;
		
		impSalario = imposto;
		
		
		
 }
 Double maxdeducao = 0.0;
 Double total = imposto1 + imposto2 + impSalario;

 if (total > abat) {
	
	 maxdeducao = total * 0.3;
	 
	 System.out.printf("\nAbatimento R$ %.2f ", abat);
		System.out.printf("\nImposto devido: R$%.2f", (total - abat));

	} // maximo dedutivel menor que gastos dedutiveis
	if (total < abat) {
		
		maxdeducao = total * 0.3;
		
		 System.out.printf("\nAbatimento R$ %.2f ", maxdeducao);
		System.out.printf("\nImposto devido: R$%.2f", (total - maxdeducao));

	}

	
 
 

 
}
	
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		Imposto cal = new Imposto();

		Double rendaAnual;
		Double prestServicos = 0.0;
		Double ganhoCapital = 0.0;
		Double gastosMedic = 0.0;
		Double gastosEduca = 0.0;
		Double rendaMensal;

		System.out.println("Digite os dados do  contribuinte: ");
		
		System.out.print("Renda anual com salario: ");
		rendaAnual = scan.nextDouble();
		System.out.print("Renda anual com prestação de serviços: ");
		prestServicos = scan.nextDouble();
		System.out.print("Renda anual com ganho de capital: ");
		ganhoCapital = scan.nextDouble();
		System.out.print("Gastos médicos: ");
		gastosMedic = scan.nextDouble();
		System.out.print("Gastos adicionais: ");
		gastosEduca = scan.nextDouble();
		

		rendaMensal = rendaAnual / 12;
		

		System.out.println();
		System.out.println("RELATÓRIO: ");

	
		cal.impostoSobreSalario(rendaAnual);
		cal.impostoSobreServiços(prestServicos);
		cal.impostoSobreGc(ganhoCapital);
		cal.impostoBrutoTotal(rendaAnual, prestServicos, ganhoCapital);
		cal.abatimento(rendaAnual, prestServicos, ganhoCapital, gastosMedic, gastosEduca);
		
	}

}

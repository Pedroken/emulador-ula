package br.com.felipe;

import java.util.Scanner;

public class MainULA {

	private static Registrador registradorA = new Registrador();
	private static Registrador registradorB = new Registrador();
	private static ULA ula = new ULA();
	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String  opcao = "0";
		String  operacao = "0";
		String  valor = "0";
		
		try {

			imprimirMenuPrincipal();

			while(Integer.valueOf(opcao) != 8){

				opcao = input.next();	

				switch (Integer.valueOf(opcao)) {
				case 1:
					System.out.print("Digite o valor do registrador A :");
					valor = input.next();
					registradorA.setValor(valor);
					
					//limpar console;
					
					imprimirMenuPrincipal();
					break;

				case 2:
					System.out.print("Digite o valor do registrador B :");
					valor = input.next();
					registradorB.setValor(valor);
					
					//limpar console;
					
					imprimirMenuPrincipal();
					break;

				case 3:
					System.out.print("Valor do registrador A : "+ registradorA.getValorBinario());
					imprimirMenuPrincipal();
					break;

				case 4:
					System.out.print("Valor do registrador B : "+ registradorB.getValorBinario());
					imprimirMenuPrincipal();
					break;

				case 5:
					System.out.println(5);
					break;

				case 6:
					operacao = "0";
					imprimirMenuOperacoes();
					
					while (true){
						
						operacao = input.next();
						
						if(ula.possuiOperacao(operacao)){

							limparConsole();
							System.out.println("\nOperação invalida. Tente Novamente: ");

						}else{

							break;
						}

					}
					limparConsole();
					imprimirMenuPrincipal();
					break;

				case 7:
					
					ula.executar(operacao, registradorA, registradorB);

					break;

				case 8:
					System.out.println(8);
					break;

				default:
					System.out.print("Opção Invalida, Tente novamente.\nEscolha uma opção: ");
					break;
				}	

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void imprimirMenuPrincipal(){
		
		
		String menu  = "\n\n";
		menu = menu + "1. Definir registrador A	 	\n";
		menu = menu + "2. Definir registrador B 	\n";
		menu = menu + "3. Ler registrador A (Acc)  	\n";
		menu = menu + "4. Ler registrador B 		\n";
		menu = menu + "5. Ler registrador de flags 	\n";
		menu = menu + "6. Definir operação 		 	\n";
		menu = menu + "7. Executar ULA 			 	\n";
		menu = menu + "8. Sair					 	\n";
		menu = menu + "\nEscolha uma opção: ";	

		System.out.print(menu);
	}
	
	public static void imprimirMenuOperacoes (){

		String menu = "\n\n";
		menu = menu + "\n.1 - Soma	 		\n";
		menu = menu + ".2 - Subtração		\n";
		menu = menu + ".3 - Divisão		\n";
		menu = menu + ".4 - Multiplicação	\n";
		menu = menu + "Digite o numero da operação:\n";

		System.out.print(menu);
	}
	
	public static void limparConsole(){
		
		/*
		Runtime run = Runtime.getRuntime();
		run.exec("comados");
		*/
	}
	

	/** 
	 * Converts decimal to binary 
	 * 
	 * @param dec The decimal number to convert 
	 * @return A string containing the binary number. 
	 */  
	public static String decToBinary( int dec ) {  
		String result = "";  

		while( dec > 0 ) {  
			result = (dec & 1) + result;  
			dec >>= 1;  
		}  

		return result;  
	}  

	/** 
	 * Converts binary to decimal 
	 * 
	 * @param bin The binary number to convert 
	 * @return An integer containing the decimal number. 
	 */  
	public static int binaryToDec( String bin ) {  
		int i, result = 0;  

		for( i = 0; i < bin.length(); i++ ) {  
			result <<= 1;  
			if( bin.charAt( i ) == '1' ) result++;  
		}  

		return result;  
	}  
}

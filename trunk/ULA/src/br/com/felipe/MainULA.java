package br.com.felipe;

import java.util.Scanner;

public class MainULA {

	private static Registrador registradorA = new Registrador(10);
	private static Registrador registradorB = new Registrador(5);
	private static ULA ula = new ULA();


	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Integer  opcao 	= 0;
		String  operacao= "0";
		String  valor	= "0";

		imprimirMenuPrincipal();

		while(opcao != 8){


			try {

				Integer opcaoTemp = pegarValorDigitado();
				if(opcaoTemp != null){
					opcao = opcaoTemp;
				}
				
				switch (opcao) {
				case 1:
					System.out.print("Digite o valor do registrador A :");
					valor = input.next();
					registradorA.setValor(valor);

					limparConsole();
					imprimirMenuPrincipal();
					break;

				case 2:
					System.out.print("Digite o valor do registrador B :");
					valor = input.next();
					registradorB.setValor(valor);

					limparConsole();
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
							System.out.println("\nOperação "+ operacao + " escolida.");
							imprimirMenuPrincipal();
							break;

						}else{

							limparConsole();
							System.out.println("\nOperação invalida. Tente Novamente: ");
						}

					}
					break;

				case 7:

					registradorA.setValor(ula.executar(operacao, registradorA, registradorB));

					break;

				case 8:
					System.out.println("Terminando execução...");
					System.exit(0);
					break;

				default:
					System.out.print("Opção Invalida, Tente novamente.\nEscolha uma opção: ");
					break;
				}	

			} catch (Exception e) {
				System.out.println("Ocorreu um erro");
			}
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
		menu = menu + "\nEscolha uma opçãoo: ";	

		System.out.print(menu);
	}

	public static void imprimirMenuOperacoes (){

		/*String menu = "\n\n";
		menu = menu + "\n.1 - Soma	 		\n";
		menu = menu + ".2 - SubtraÃ§Ã£o		\n";
		menu = menu + ".3 - DivisÃ£o		\n";
		menu = menu + ".4 - MultiplicaÃ§Ã£o	\n";
		menu = menu + "Digite o numero da operaÃ§Ã£o:\n";

		System.out.print(menu);*/
	}

	public static void limparConsole(){

		//solução para o console do windows
		/*
		String[] comandos = new String[]{"cmd","cls"};
		Runtime run = Runtime.getRuntime();
		run.exec(comados);
		 */


		//solução para o console do java
		for(int i= 0 ; i<50 ; i++ ){
			System.out.println(" ");
		}
	}

	private static Integer pegarValorDigitado(){
		Integer integer = null;
		Scanner input = new Scanner(System.in);
		
		try {

			String teclado = input.next();
			integer = Integer.valueOf(teclado) ; 
			
		} catch (NumberFormatException e) {
			integer = null;
		}
		return integer;
	}
}

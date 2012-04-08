package br.com.felipe;


public class ULA {

	private int[]    registradorDeFlags;
	private String[] operacoes; 
	private Registrador resultado;

	/**
	 * Instancia uma ULA padrão de 16 operações
	 */
	public ULA() {
		this.resultado = new Registrador();
		this.operacoes = new String[]{"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
		this.registradorDeFlags = new int[16];
	}

	public int[] getRegistradorDeFlags() {
		return registradorDeFlags;
	}

	public void setRegistradorDeFlags(int[] registradorDeFlags) {
		this.registradorDeFlags = registradorDeFlags;
	}

	public String getResultado() {
		return resultado.getValorBinario();
	}

	public boolean possuiOperacao(String operacao){

		boolean possui = false;
		int tempOperacao = binaryToDec(operacao);
		
		for(int i = 0; i < this.operacoes.length ; i++){
			if (binaryToDec(this.operacoes[i]) == tempOperacao){
				possui = true;
				break;
			}
		}
		return possui;
	}

	public String executar(String operacao, Registrador registradorA, Registrador registradorB){

		
		Registrador aTemp = null;
		Registrador bTemp = null;
		
		try {
		
			aTemp = (Registrador) registradorA.clone();
			bTemp = (Registrador) registradorB.clone();
		
		} catch (CloneNotSupportedException e) {
			aTemp = registradorA;
			bTemp = registradorB;
		}
	
	
		String tempOperacao = String.valueOf(binaryToDec(operacao));
		
		if(tempOperacao.equalsIgnoreCase("0")){
			resultado.setValor(operacaoSoma( aTemp, bTemp));
		}
		if(tempOperacao.equalsIgnoreCase("1")){
			resultado.setValor(operacaoInversaoA(aTemp));
		}
		if(tempOperacao.equalsIgnoreCase("2")){
			resultado.setValor(operacaoIncrementarA(aTemp));
		}
		if(tempOperacao.equalsIgnoreCase("3")){
			resultado.setValor(operacaoIncrementarB(bTemp));
		}
		if(tempOperacao.equalsIgnoreCase("4")){
			resultado.setValor(operacaoAisEqualsB(aTemp, bTemp));
		}
		if(tempOperacao.equalsIgnoreCase("5")){
			resultado.setValor(operacaoAMaiorB(aTemp, bTemp));
		}
		if(tempOperacao.equalsIgnoreCase("6")){
			resultado.setValor(operacaoInversaoB(bTemp));
		}
		if(tempOperacao.equalsIgnoreCase("7")){
			resultado.setValor(operacaoSubtracaoAMenosB(aTemp, bTemp));
		}
		if(tempOperacao.equalsIgnoreCase("8")){
			resultado.setValor(operacaoReceberA_B(aTemp, bTemp));
		}
		if(tempOperacao.equalsIgnoreCase("9")){
			resultado.setValor(operacaoReceberB_A(bTemp, aTemp));
		}
		if(tempOperacao.equalsIgnoreCase("10")){
			resultado.setValor(operacaoSubtracaoBMenosA(bTemp, aTemp));
		}
		if(tempOperacao.equalsIgnoreCase("11")){
			resultado.setValor(operacaoOUA_B(aTemp, bTemp));
		}
		if(tempOperacao.equalsIgnoreCase("12")){
			resultado.setValor(operacaoEA_B(aTemp, bTemp));
		}
		if(tempOperacao.equalsIgnoreCase("13")){
			resultado.setValor(operacaoShiftLeftRegister(aTemp));
		}
		if(tempOperacao.equalsIgnoreCase("14")){
			resultado.setValor(operacaoShiftRightRegister(aTemp));
		}
		if(tempOperacao.equalsIgnoreCase("15")){
			resultado.setValor(operacaoDecrescimoB(bTemp));
		}

		return resultado.getValorBinario();

	}

	/**
	 * Executa operação soma
	 * @param registradorA
	 * @param registradorB
	 * @return
	 */
	protected String operacaoSoma(Registrador registradorA, Registrador registradorB){
		Registrador resultado = new Registrador();
		resultado.setValor(registradorA.getValorDecimal() + registradorB.getValorDecimal());
		return resultado.getValorBinario();
	}

	/**
	 * Executa operação inversão do primeiro registraodor
	 * @param registradorA
	 * @return
	 */
	protected String operacaoInversaoA(Registrador registradorA){
		StringBuffer inversao = new StringBuffer(registradorA.getValorBinario());
		registradorA.setValor(inversao.reverse().toString());
		return registradorA.getValorBinario();
	}

	/**
	 * Executa operação incrementar A
	 * @param registradorA
	 * @param registradorB
	 * @return
	 */
	protected String operacaoIncrementarA(Registrador registradorA){
		registradorA.setValor(registradorA.getValorDecimal() + 1);
		return registradorA.getValorBinario();
	}

	/**
	 * Executa operação incrementar B
	 * @param registradorB
	 * @return
	 */
	protected String operacaoIncrementarB(Registrador registradorB){
		registradorB.setValor(registradorB.getValorDecimal() + 1);
		return registradorB.getValorBinario();
	}

	/**
	 * Executa operação A igual a B
	 * @param registradorA
	 * @param registradorB
	 * @return
	 */
	protected String operacaoAisEqualsB(Registrador registradorA, Registrador registradorB){
		//ver flag
		boolean eIgual = registradorA.getValorBinario().equalsIgnoreCase(registradorB.getValorBinario());
		return eIgual ? "1" : "0";
	}

	/**
	 * Executa operação A maior B
	 * @param registradorA
	 * @param registradorB
	 * @return
	 */
	protected String operacaoAMaiorB(Registrador registradorA, Registrador registradorB){
		//ver flag
		boolean eIgual = registradorA.getValorDecimal() > registradorB.getValorDecimal();
		return eIgual ? "1" : "0";
	}

	/**
	 * Executa operação inversão do segundo registraodor
	 * @param registradorB
	 * @return
	 */
	protected String operacaoInversaoB(Registrador registradorB){
		StringBuffer inversao = new StringBuffer(registradorB.getValorBinario());
		registradorB.setValor(inversao.reverse().toString());
		return registradorB.getValorBinario();
	}

	/**
	 * Executa operação subtração.
	 * @param registradorA
	 * @param registradorB
	 * @return
	 */
	protected String operacaoSubtracaoAMenosB(Registrador registradorA, Registrador registradorB){
		int result = registradorA.getValorDecimal() - registradorB.getValorDecimal();
		if(result < 0){
			resultado.setValor(0);			
		}else{
			resultado.setValor(result);
		}
		return resultado.getValorBinario();
	}

	/**
	 * Executa operação Primeiro Registrador maior que Segundo Registrador
	 * @param registradorA
	 * @param registradorB
	 * @return
	 */
	protected String operacaoReceberA_B(Registrador registradorA, Registrador registradorB){
		registradorA.setValor(registradorB.getValorBinario());
		return registradorA.getValorBinario();
	}

	/**
	 * Executa operação Segundo Registrador maior que Primeiro Registrador 
	 * @param registradorB
	 * @param registradorA
	 * @return
	 */
	protected String operacaoReceberB_A(Registrador registradorB, Registrador registradorA){
		registradorB.setValor(registradorA.getValorBinario());
		return registradorB.getValorBinario();
	}

	/**
	 * Executa operação subtração.
	 * @param registradorB
	 * @param registradorA
	 * @return
	 */
	protected String operacaoSubtracaoBMenosA(Registrador registradorB, Registrador registradorA){
		//ver flag
		int result = registradorB.getValorDecimal() - registradorA.getValorDecimal();
		if(result < 0){
			resultado.setValor(0);			
		}else{
			resultado.setValor(result);
		}
		return resultado.getValorBinario();
	}

	/**
	 * Executa operação logica OU
	 * @param registradorA
	 * @param registradorB
	 * @return
	 */
	protected String operacaoOUA_B(Registrador registradorA, Registrador registradorB){
		String a = registradorA.getValorBinario();
		String b = registradorB.getValorBinario();
		String aOrB = "";
		
		for(int i=0 ; i < Registrador.QTDBITS ; i++) {

			if(a.charAt(i) == '1' || b.charAt(i) == '1'){

				aOrB = aOrB + "1";

			}else{

				aOrB = aOrB + "0";
			}

		}

		return aOrB;
	}

	/**
	 * Executa operação logica OU
	 * @param registradorA
	 * @param registradorB
	 * @return
	 */
	protected String operacaoEA_B(Registrador registradorA, Registrador registradorB){
		String a = registradorA.getValorBinario();
		String b = registradorB.getValorBinario();
		String aOrB = "";
		
		for(int i=0 ; i < Registrador.QTDBITS ; i++) {
			
			if(a.charAt(i) == '1' && b.charAt(i) == '1'){
				
				aOrB = aOrB + "1";
				
			}else{
				
				aOrB = aOrB + "0";
			}
			
		}
		
		return aOrB;
	}

	/**
	 * Executa operação Shift Left Register
	 * @param registradorA
	 * @param registradorB
	 * @return
	 */
	protected String operacaoShiftLeftRegister(Registrador registrador){
		//ver flag
		//pego do segundo até o ultimo registro;
		String slr = "0" + registrador.getValorBinario().substring(0, registrador.getValorBinario().length()-1);
		registrador.setValor(slr);
		return registrador.getValorBinario();
	}

	/**
	 * Executa operação Shift Right Register
	 * @param registradorA
	 * @param registradorB
	 * @return
	 */
	protected String operacaoShiftRightRegister(Registrador registrador){
		//ver flag
		//pego do primeiro até o penultimo;
		String slr = registrador.getValorBinario().substring(1, registrador.getValorBinario().length()) + "0";
		registrador.setValor(slr);
		return registrador.getValorBinario();
	}

	/**
	 * Executa operação de Decricimo
	 * @param registradorA
	 * @param registradorB
	 * @return
	 */
	protected String operacaoDecrescimoB(Registrador registrador){
		registrador.setValor(registrador.getValorDecimal() - 1);
		return registrador.getValorBinario();
	}


	/** 
	 * Converts binary to decimal 
	 * 
	 * @param bin The binary number to convert 
	 * @return An integer containing the decimal number. 
	 */  
	private static int binaryToDec( String bin ) {  
		int i, result = 0;  

		for( i = 0; i < bin.length(); i++ ) {  
			result <<= 1;  
			if( bin.charAt( i ) == '1' ) result++;  
		}  

		return result;  
	}  
}

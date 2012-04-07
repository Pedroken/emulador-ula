package br.com.felipe;

public class ULA {

	private int[]    registradorDeFlags;
	private String[] operacoes; 
	private boolean padrao;
	private Registrador resultado;

	/**
	 * Instancia uma ULA padrão de 16 operações
	 */
	public ULA() {
		this.padrao    = true;
		this.resultado = new Registrador();
		this.operacoes = new String[]{"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1100","1101","1110","1111"};
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
		
		for(int i = 0; i < operacao.length() ; i++){
			if (this.operacoes[i].equalsIgnoreCase(operacao)){
				possui = true;
			}
		}
		return possui;
	}
	
	public String executar(String operacao, Registrador registradorA, Registrador registradorB){
		
		Registrador registrador = new Registrador();
		if(registradorA != null){
			
			registrador = registradorA;
			
		}else if(registradorB != null){

			registrador = registradorB;
		}

		if(this.padrao){
			if(operacao.equalsIgnoreCase("0000")){
				resultado.setValor(operacaoSoma( registradorA, registradorB));
			}
			if(operacao.equalsIgnoreCase("0001")){
				resultado.setValor(operacaoInversaoA(registradorA));
			}
			if(operacao.equalsIgnoreCase("0010")){
				resultado.setValor(operacaoIncrementarA(registradorA));
			}
			if(operacao.equalsIgnoreCase("0011")){
				resultado.setValor(operacaoIncrementarB(registradorB));
			}
			if(operacao.equalsIgnoreCase("0100")){
				resultado.setValor(operacaoAisEqualsB(registradorA, registradorB));
			}
			if(operacao.equalsIgnoreCase("0101")){
				resultado.setValor(operacaoAMaiorB(registradorA, registradorB));
			}
			if(operacao.equalsIgnoreCase("0110")){
				resultado.setValor(operacaoInversaoB(registradorB));
			}
			if(operacao.equalsIgnoreCase("0111")){
				resultado.setValor(operacaoSubtracaoAMenosB(registradorA, registradorB));
			}
			if(operacao.equalsIgnoreCase("1000")){
				resultado.setValor(operacaoReceberA_B(registradorA, registradorB));
			}
			if(operacao.equalsIgnoreCase("1001")){
				resultado.setValor(operacaoReceberB_A(registradorB, registradorA));
			}
			if(operacao.equalsIgnoreCase("1010")){
				resultado.setValor(operacaoSubtracaoBMenosA(registradorB, registradorA));
			}
			if(operacao.equalsIgnoreCase("1011")){
				resultado.setValor(operacaoOUA_B(registradorA, registradorB));
			}
			if(operacao.equalsIgnoreCase("1100")){
				resultado.setValor(operacaoEA_B(registradorA, registradorB));
			}
			if(operacao.equalsIgnoreCase("1101")){
				resultado.setValor(operacaoShiftLeftRegister(registrador));
			}
			if(operacao.equalsIgnoreCase("1110")){
				resultado.setValor(operacaoShiftRightRegister(registrador));
			}
			if(operacao.equalsIgnoreCase("1111")){
				resultado.setValor(operacaoDecrescimo(registrador));
			}
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
		//Registrador resultado = new Registrador();
		//resultado.setValor(registradorA.getValorDecimal() + registradorB.getValorDecimal());
		//return resultado.getValorBinario();
		return "0000";
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
		//Registrador resultado = new Registrador();
		//resultado.setValor(registradorA.getValorDecimal() + registradorB.getValorDecimal());
		//return resultado.getValorBinario();
		return "0000";
	}
	
	/**
	 * Executa operação logica OU
	 * @param registradorA
	 * @param registradorB
	 * @return
	 */
	protected String operacaoOUA_B(Registrador registradorA, Registrador registradorB){
		//implementar
		//Registrador resultado = new Registrador();
		//resultado.setValor(registradorA.getValorDecimal() + registradorB.getValorDecimal());
		//return resultado.getValorBinario();
		return "0000";
	}
	
	/**
	 * Executa operação logica OU
	 * @param registradorA
	 * @param registradorB
	 * @return
	 */
	protected String operacaoEA_B(Registrador registradorA, Registrador registradorB){
		//implementar
		//Registrador resultado = new Registrador();
		//resultado.setValor(registradorA.getValorDecimal() + registradorB.getValorDecimal());
		//return resultado.getValorBinario();
		return "0000";
	}
	
	/**
	 * Executa operação Shift Left Register
	 * @param registradorA
	 * @param registradorB
	 * @return
	 */
	protected String operacaoShiftLeftRegister(Registrador registrador){
		//pego do segundo até o ultimo registro;
		String slr = registrador.getValorBinario().substring(1, registrador.getValorBinario().length()-1) + "0";
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
		//pego do primeiro até o penultimo;
		String slr = "0" + registrador.getValorBinario().substring(0, registrador.getValorBinario().length()-2);
		registrador.setValor(slr);
		return registrador.getValorBinario();
	}
	
	/**
	 * Executa operação de Decricimo
	 * @param registradorA
	 * @param registradorB
	 * @return
	 */
	protected String operacaoDecrescimo(Registrador registrador){
		registrador.setValor(registrador.getValorDecimal() - 1);
		return registrador.getValorBinario();
	}
	
	public void get(){
		
	}
}

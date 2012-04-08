package br.com.felipe;

public class Registrador {
	
	private String  valor;
	
	public Registrador() {
		
	}
	
	/**
	 * Cria registrador usando um número binario
	 * @param valor
	 */
	public Registrador(String valor) {
		this.valor = valor;
	}
	
	/**
	 * Cria registrador usando um número decimal
	 * @param valor
	 */
	public Registrador(int valor) {
		this.valor = this.getValorBinario(valor);
	}
	
	public String getValorBinario() {
		return valor;
	}

	public void setValor(String valor) {
		while(valor.length() < 8){
			valor = "0" + valor;
		}
		this.valor = valor;
	}
	
	public void setValor(int valor) {
		this.valor = this.getValorBinario(valor);
	}

	/** 
	 * Converts decimal to binary 
	 * 
	 * @param dec The decimal number to convert 
	 * @return A string containing the binary number. 
	 */  
	private String getValorBinario( int dec ) {  
		String result = "";  

		while( dec > 0 ) {  
			result = (dec & 1) + result;  
			dec >>= 1;  
		}  

		while(result.length() < 8){
			result = "0" + result;
		}
		return result;  
	}  

	/** 
	 * Converts binary to decimal 
	 * 
	 * @param bin The binary number to convert 
	 * @return An integer containing the decimal number. 
	 */  
	
	public int getValorDecimal() {  
		int i, result = 0;  

		for( i = 0; i < this.valor.length(); i++ ) {  
			result <<= 1;  
			if( this.valor.charAt( i ) == '1' ) result++;  
		}  

		return result;  
	}  

}

package br.com.eduardo.prova;

/**
 * Interface de controle de navegação entre as incidencias encontradas em uma
 * stream.
 * 
 * @author eduardo
 *
 */
public interface Stream {

	/**
	 * Retorna o próximo caracter a ser processado na stream.
	 * 
	 * @return {@link Character}
	 */
	public char getNext();

	/**
	 * Retorna <code>true</code> se a stream ainda contem caracteres para
	 * processar e <code>false</code> caso não haja.
	 * 
	 * @return {@link Boolean}
	 */
	public boolean hasNext();
}

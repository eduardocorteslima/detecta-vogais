package br.com.eduardo.prova;

import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Processa e encontra o primeiro caracter Vogal, após uma consoante, onde a
 * mesma é antecessora a uma vogal e que não se repete no resto da stream. O
 * termino da leitura da stream é garantido através do método {@link #hasNext()}
 * , ou seja, retorna falso para o termino da leitura da stream.
 * 
 * @author eduardo
 *
 */
public class ProcessaTextoStream implements Stream {

	private static final String PADRAO_APENAS_CONSOANTES = "[b-df-hj-np-tv-xz]|[B-DF-HJ-NP-TV-XZ]";
	private static final String PADRAO_APENAS_VOGAIS = "[aeiouAEIOU]";
	private List<String> correspondencias = new ArrayList<>();
	private int index = -1;

	public ProcessaTextoStream(String stream) {
		if (stream != null) {
			Pattern pattern = Pattern.compile(PADRAO_APENAS_VOGAIS);
			Matcher matcher = pattern.matcher(stream);

			// Realiza iteração em todas as vogais encontradas na stream
			while (matcher.find()) {
				correspondencias.addAll(encontrarCorrespondencias(stream, matcher.group()));
			}
		}
	}

	/**
	 * {@link Inherited}
	 */
	@Override
	public char getNext() {
		if (hasNext()) {
			index += 1;
			return correspondencias.get(index).charAt(0);
		}
		return 0;
	}

	/**
	 * {@link Inherited}
	 */
	@Override
	public boolean hasNext() {
		return correspondencias.size() > index + 1;
	}

	/**
	 * Realiza o processo de identificar as correspondencias
	 * @param stream
	 * @param vogalUnica
	 * @return {@link List}
	 */
	private List<String> encontrarCorrespondencias(final String stream, final String vogalUnica) {
		List<String> correspondencias = new ArrayList<>();

		// Valida se essa vogal não se repete na stream
		if ((int) stream.chars().filter(caracter -> caracter == vogalUnica.charAt(0)).count() == 1) {

			// Valida se a antecessora é uma consoante e
			// Valida se a antecessora da consoante é uma vogal
			if (caractererEntraNoPadrao(stream, PADRAO_APENAS_CONSOANTES, vogalUnica, 1)
					&& caractererEntraNoPadrao(stream, PADRAO_APENAS_VOGAIS, vogalUnica, 2)) {

				// Correspondencia é identificada e adicionada na lista
				// de correspondencias
				correspondencias.add(vogalUnica);
			}
		}
		return correspondencias;
	}

	
	/**
	 * Realiza a busca de um caracter e faz a validação se o caracter
	 * corresponde ao padrão passado como parametro. Retorna <code>true</code>
	 * em caso de correspondência
	 * 
	 * @param stream
	 * @param pattern
	 * @param charDeReferencia
	 * @param indiceDoCharASerUtilizado
	 * @return {@link Boolean}
	 */
	private boolean caractererEntraNoPadrao(final String stream, final String pattern, final String charDeReferencia,
			final int indiceDoCharASerUtilizado) {
		try {
			char charASerValidado = stream.charAt(stream.indexOf(charDeReferencia) - indiceDoCharASerUtilizado);
			return Pattern.matches(pattern, String.valueOf(charASerValidado));
		} catch (StringIndexOutOfBoundsException ex) {
			return false;
		}

	}

}

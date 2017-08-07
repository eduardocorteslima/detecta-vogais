package br.com.eduardo.prova;

/**
 * Aplicação responsável por processar uma stream, aplicar padrões e identificar
 * caracteres.
 * 
 * @author eduardo
 *
 */
public class Aplicacao {

	public static void main(String[] args) {
		String texto = "";

		if (args.length > 0) {
			texto = args[0];
		}

		Stream stream = new ProcessaTextoStream(texto);

		System.out.println("**Processamento iniciado!");
		if (stream.hasNext()) {

			while (stream.hasNext()) {
				System.out.println(String.format(" Encontrado: %s ", stream.getNext()));
			}

		} else {
			System.out.println(" Nenhuma incidência encontrada!");
		}
		System.out.println("**Processamento concluído!");
	}

}

package br.com.eduardo.prova;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProcessaTextoStreamTest {

	private Stream stream;

	@Test
	public void testProcessaTextoStreamFuncionalComCaracteresEspeciais() {
		String texto = "!@#!@##$!@#$ t$%¨%&$%&&(231 23123afe";
		stream = new ProcessaTextoStream(texto);

		String resultado = "";
		while (stream.hasNext()) {
			resultado += stream.getNext();
		}
		assertEquals(resultado, "e");
	}
	
	@Test
	public void testProcessaTextoStreamFuncionalComEspacos() {
		String texto = "231 23123afe";
		stream = new ProcessaTextoStream(texto);

		String resultado = "";
		while (stream.hasNext()) {
			resultado += stream.getNext();
		}
		assertEquals(resultado, "e");
	}
	
	@Test
	public void testProcessaTextoStreamFuncionalComNumeros() {
		String texto = "23123123afe";
		stream = new ProcessaTextoStream(texto);

		String resultado = "";
		while (stream.hasNext()) {
			resultado += stream.getNext();
		}
		assertEquals(resultado, "e");
	}
	
	@Test
	public void testProcessaTextoStreamFuncionalTresLetras() {
		String texto = "afe";
		stream = new ProcessaTextoStream(texto);

		String resultado = "";
		while (stream.hasNext()) {
			resultado += stream.getNext();
		}
		assertEquals(resultado, "e");
	}
	
	@Test
	public void testProcessaTextoStreamFuncionalOriginal() {
		String texto = "aAbBABacafe";
		stream = new ProcessaTextoStream(texto);

		String resultado = "";
		while (stream.hasNext()) {
			resultado += stream.getNext();
		}
		assertEquals(resultado, "e");
	}
	
	@Test
	public void testProcessaTextoStreamFuncional() {
		String texto = "aAbBABacafegu";
		stream = new ProcessaTextoStream(texto);

		String resultado = "";
		while (stream.hasNext()) {
			resultado += stream.getNext();
		}
		assertEquals(resultado, "eu");
	}

	@Test
	public void testProcessaTextoStreamFuncionalMaiusculo() {
		String texto = "AABBABACAFEGU";
		stream = new ProcessaTextoStream(texto);

		String resultado = "";
		while (stream.hasNext()) {
			resultado += stream.getNext();
		}
		assertEquals(resultado, "EU");
	}

	@Test
	public void testProcessaTextoStreamNullo() {
		String texto = null;
		stream = new ProcessaTextoStream(texto);

		String resultado = "";
		while (stream.hasNext()) {
			resultado += stream.getNext();
		}
		assertEquals(resultado, "");
	}
	
	@Test
	public void testProcessaTextoStreamTudoVogalMaiusculo() {
		String texto = "AAAAAAAAAAAA";
		stream = new ProcessaTextoStream(texto);

		String resultado = "";
		while (stream.hasNext()) {
			resultado += stream.getNext();
		}
		assertEquals(resultado, "");
	}
	
	@Test
	public void testProcessaTextoStreamTudoVogalMinusculo() {
		String texto = "eeeeeeeeeeeeeeeee";
		stream = new ProcessaTextoStream(texto);

		String resultado = "";
		while (stream.hasNext()) {
			resultado += stream.getNext();
		}
		assertEquals(resultado, "");
	}
}

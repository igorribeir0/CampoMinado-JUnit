package com.igorribeiro.MF.modelo;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.igorribeiro.MF.execao.ExplosaoExeption;

public class CampoTeste {
	private Campo campo;
	private Tabuleiro tabuleiro;
	
	@BeforeEach
	void inicirCampo() {
		campo = new Campo(3, 3);
	}
	
	@Test
	void testeVizinhoRealDistancia1Esquerda() {
		Campo vizinho = new Campo(3, 2);
		boolean result = campo.adicionarVizinho(vizinho);
		
		assertTrue(result);
	}
	
	@Test
	void testeVizinhoRealDistancia1Direita() {
		Campo vizinho = new Campo(3, 4);
		boolean result = campo.adicionarVizinho(vizinho);
		
		assertTrue(result);
	}
	
	@Test
	void testeVizinhoRealDistancia1EmCima() {
		Campo vizinho = new Campo(2, 3);
		boolean result = campo.adicionarVizinho(vizinho);
		
		assertTrue(result);
	}
	
	@Test
	void testeVizinhoRealDistancia1EmBaixo() {
		Campo vizinho = new Campo(4, 2);
		boolean result = campo.adicionarVizinho(vizinho);
		
		assertTrue(result);
	}
	
	@Test
	void testeVizinhoRealDistancia1Diagonal() {
		Campo vizinho = new Campo(2, 2);
		boolean result = campo.adicionarVizinho(vizinho);
		
		assertTrue(result);
	}
	
	@Test
	void testeNoVizinho() {
		Campo vizinho = new Campo(1, 1);
		boolean result = campo.adicionarVizinho(vizinho);
		
		assertFalse(result);
	}
	
	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void alternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void alternarMarcacaoDuasVezes() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void abrirCampoNaoMinado () {
		assertTrue(campo.abrir());
	}
	
	@Test
	void abrirCampoNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void abrirCampoMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void abrirCampoMinadoNaoMarcado() {
		campo.minar();
		
		assertThrows(ExplosaoExeption.class, () -> {
			campo.abrir();
		});
	}
	
	@Test
	void abrirComVizinhos1() {
		Campo campo11 = new Campo(1, 1);
		Campo campo22 = new Campo(2, 2);

		campo22.adicionarVizinho(campo11);
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.IsAberto() && campo11.IsAberto());
	}
	
	@Test
	void abrirComVizinhos2() {
		Campo campo11 = new Campo(1, 1);
		Campo campo12 = new Campo(1, 1);
		campo12.minar();
		Campo campo22 = new Campo(2, 2);

		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.IsAberto() && campo11.IsFrchado());
	}
	
	
	@Test
	void testAbrirCampoSemExplosao() {
	        // Tenta abrir um campo sem mina
	        assertDoesNotThrow(() -> tabuleiro.abrir(0, 0));
	 }

	
}

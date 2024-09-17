package com.igorribeiro.MF;

import com.igorribeiro.MF.modelo.Tabuleiro;
import com.igorribeiro.MF.visao.TabuleiroConsole;

public class Aplicacao {
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		new TabuleiroConsole(tabuleiro);
		
		tabuleiro.abrir(3, 3);
		tabuleiro.alterarMarcacao(4, 5);
		tabuleiro.alterarMarcacao(4, 5);
		
		System.out.println(tabuleiro);
	}
}

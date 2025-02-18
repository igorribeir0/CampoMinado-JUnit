package com.igorribeiro.MF.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import com.igorribeiro.MF.execao.ExplosaoExeption;
import com.igorribeiro.MF.execao.SairException;
import com.igorribeiro.MF.modelo.Tabuleiro;

public class TabuleiroConsole {

	private Tabuleiro tabuleiro;
	private Scanner entrada = new Scanner(System.in);
	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		
		executarJogo();
	}

	private void executarJogo() {
		try {
			boolean continuar = true;
			
			while(continuar) {
				cicloDoJojo();
				
				System.out.println(" Outra partida? (S/n) ");
				String resposta = entrada.nextLine();
				
				if("n".equalsIgnoreCase(resposta)) {
					continuar = false;
				} else {
					tabuleiro.reiniciar();
				}
			}
		} catch (SairException e) {
			System.err.println("Tchau! Obrigado por jogar!");
		} finally {
			entrada.close();
		}
		
	}
	
	private void cicloDoJojo() {
		try {
			
			while( tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro.toString());
				
				String digitado = capturarValorDigitado("Digite (x, y): ");
				
				Iterator<Integer> xy = Arrays.stream(digitado.split(","))
				.map(e -> Integer.parseInt(e.trim())).iterator();
				
				digitado = capturarValorDigitado("1 - Abrir ou 2 - (Des)Marcar: ");
				if("1".equals(digitado)) {
					tabuleiro.abrir(xy.next(), xy.next());
				} else if("2".equals(digitado)) {
					tabuleiro.alterarMarcacao(xy.next(), xy.next());
				}
				
			}
			
			System.out.println(tabuleiro);
			System.out.println("Você ganhou!!");
		} catch (ExplosaoExeption e) {
			System.out.println(tabuleiro);
			System.out.println("Você perdeu!");
		}
	}
	
	
	private String capturarValorDigitado(String text) {
		System.out.print(text);
		String digitado = entrada.nextLine();
		
		if("sair".equalsIgnoreCase(digitado)) {
			throw new SairException();
		}
		return digitado;
	}
}

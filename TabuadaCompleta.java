package br.com.tlmtech.teste;

import java.io.*;
import javax.swing.JOptionPane;

public class TabuadaCompleta implements Serializable{

	public static void main(String[] args) throws IOException {

		int valor_inicio_tab, valor_fim_tabuada, numInicio, numFinal, i, cont;
		boolean dadosValidos;
		StringBuilder tabuadas = new StringBuilder();
		do {
			dadosValidos = true;
			valor_inicio_tab = Integer.parseInt(JOptionPane.showInputDialog("Numero inicia a tabuada.: "));
			valor_fim_tabuada = Integer.parseInt(JOptionPane.showInputDialog("Numero termino da tabuada.: "));
			numInicio = Integer.parseInt(JOptionPane.showInputDialog("Inicio do numero.: "));
			numFinal = Integer.parseInt(JOptionPane.showInputDialog("Termino do numero.: "));
			if ((valor_inicio_tab > valor_fim_tabuada) || (numInicio > numFinal)) {
				JOptionPane.showMessageDialog(null,
						"Informacoes invalidas\nNumeros iniciais precisam ser menor que do fim");
				dadosValidos = false;
			} else {
				JOptionPane.showMessageDialog(null, "Numeros validos!!");
				dadosValidos = true;
			}
		} while (dadosValidos == false);
		for (cont = valor_inicio_tab; cont <= valor_fim_tabuada; cont++) {
			tabuadas.append("=======================");
			tabuadas.append("\n**** TABUADA DE " + cont+" ****");
			tabuadas.append("\n=======================\n");
			for (i = numInicio; i <= numFinal; i++) {
				tabuadas.append("    " + cont + " X " + i + " = " + cont * i+"\n");
			}
		}
		tabuadas.append("=======================");
		System.out.println(tabuadas);
		FilterOutputStream fos = null;
		
		try {
			FileOutputStream arquivo = new FileOutputStream("tabuada_completa1.txt");
			ObjectOutputStream obj_tabuada_completa = new ObjectOutputStream(arquivo);
			obj_tabuada_completa.writeObject(tabuadas);
			obj_tabuada_completa.flush();
			JOptionPane.showMessageDialog(null, "Gravado em Arquivo tabuada_completa1.txt");
			System.out.println("Gravado em Arquivo tabuada_completa1.txt");
		}catch(Exception erro_grava){
			
		}finally {
			//obj_tabuada_completa.close();
		}
		
		
		
	}
}

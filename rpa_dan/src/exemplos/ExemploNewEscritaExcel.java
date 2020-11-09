package exemplos;


import java.util.*;
import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import leitorExcel.LeitorExcel;

public class ExemploNewEscritaExcel {

	public static String caminhoExcel = "C:\\Users\\Public\\testeCriação.xlsx";
	
	public static String aba1 = "aba1 x";
	public static String aba2 = "aba2";
	public static String aba3 = "aba3";
	public static String aba4 = "aba4";
	public static String aba5 = "aba5";
	public static String aba6 = "aba6";
	public static String aba7 = "aba7";
	public static String aba8 = "aba8";
	
	public static List<String> abaMaster = new ArrayList<String>();
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		// Linhas e colunas chumbadas para teste;
		int linha = 0;
		int coluna = 0;
		int valorLinhaMaximo = 5;
		int valorColunaMaximo = 5;

			abaMaster.add(aba1);
			abaMaster.add(aba2);
			abaMaster.add(aba3);
			abaMaster.add(aba4);
			abaMaster.add(aba5);
			abaMaster.add(aba6);
			abaMaster.add(aba7);
			abaMaster.add(aba8);	
			
		for (int y = 0; y < abaMaster.size(); y++) {	
			LeitorExcel.newExcel(caminhoExcel, abaMaster.get(y));		
			for (int i = 0; i <= valorLinhaMaximo; i++) {					
				for (int x = 0; x <= valorColunaMaximo; x++) {
					LeitorExcel.updateSheetLine(linha, caminhoExcel,"Atualizar linha " + linha + " na coluna " + coluna + "", coluna, abaMaster.get(y));					
					if (valorColunaMaximo == coluna) {
						coluna = 0;
						break;
					}
					coluna++;
				}
				if (valorLinhaMaximo == linha) {		
					linha = 0;
					break;					
				}
				linha++;
			}
		}
		System.out.println("FINAL");
	}

}

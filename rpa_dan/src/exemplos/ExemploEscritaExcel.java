package exemplos;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import leitorExcel.LeitorExcel;

public class ExemploEscritaExcel {

	
	public static String caminhoExcel = "C:\\Users\\Public\\teste123.xlsx";
	public static String Mensagem = "";	
	public static String aba = "TESTE1";

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		int linha = 0;
		int coluna = 0;
		int valorLinhaMaximo = 5;
		int valorColunaMaximo = 5;

		LeitorExcel.updateSheetLine(0, caminhoExcel, "VALOR ATUALIZADO LINHA 0 coluna 1", 0, aba);
		
		for (int i = 0; i <= valorLinhaMaximo; i++) {
			System.out.println(linha);			
			for (int x = 0; x <= valorColunaMaximo; x++) {		
				System.out.println("Update coluna"+coluna);
				LeitorExcel.updateSheetLine(linha, caminhoExcel,"Atualizar linha " + linha + " na coluna " + coluna + "", coluna, aba);				
				if (valorColunaMaximo == coluna) {
					coluna = 0;
					break;
				}
				coluna++;
			}
			linha++;
		}
		System.out.println("FINAL");

	}

}

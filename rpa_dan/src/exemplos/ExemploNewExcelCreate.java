package exemplos;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import leitorExcel.LeitorExcel;

public class ExemploNewExcelCreate {
	
	public static String caminhoExcel = "C:\\Users\\Public\\teste123.xlsx";
	public static String Mensagem = "";
	public static String aba = "TESTE";

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {	
		
				LeitorExcel.newExcel(caminhoExcel,aba);		
				
		System.out.println("FINAL");


	}

}

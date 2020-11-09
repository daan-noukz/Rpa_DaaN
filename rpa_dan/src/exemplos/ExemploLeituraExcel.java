package exemplos;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import leitorExcel.TipoLeitorExcel;
import massaDados.Massa;

public class ExemploLeituraExcel {

	
	public static ArrayList<Massa> listaExcel;
	public static String caminhoExcel = "C:\\Users\\Public\\teste123.xlsx";
	
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {		
		
		
		listaExcel = TipoLeitorExcel.leituraExcel(caminhoExcel, "TESTE", 1);
		
		System.out.println(listaExcel.get(0).getTesteColuna1());
		System.out.println(listaExcel.get(0).getTesteColuna2());
		System.out.println(listaExcel.get(0).getTesteColuna3());
	}

}

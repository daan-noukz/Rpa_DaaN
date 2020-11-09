package principal;

import java.awt.List;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import massaDados.Massa;
import frameWork.Driver;
import frameWork.FrameWork;
import leitorExcel.LeitorExcel;
import leitorExcel.TipoLeitorExcel;

public class Iniciar {

	

	public static ArrayList<Massa> listaExcel2;
	public static String caminhoExcel = "C:\\Users\\Public\\teste123.xlsx";
	
	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException {			
		
		listaExcel2 = TipoLeitorExcel.leituraExcel(caminhoExcel, "TESTE", 1);
		
		System.out.println(listaExcel2.get(0).getTesteColuna1());
		System.out.println(listaExcel2.get(0).getTesteColuna2());
		System.out.println(listaExcel2.get(0).getTesteColuna3());		
		
		LeitorExcel.updateSheetLine(0, caminhoExcel, "VALOR ATUALIZADO LINHA 0 coluna 1 xx", 0,"TESTE");
		LeitorExcel.updateSheetLine(0, caminhoExcel, "VALOR ATUALIZADO LINHA 0 coluna 2 xx", 1,"TESTE");
		LeitorExcel.updateSheetLine(0, caminhoExcel, "VALOR ATUALIZADO LINHA 0 coluna 3 xx", 2,"TESTE");		
		
	
		System.out.println("FINAL");	
	}

	
	
	
	
	

	
	
	
	
	
}

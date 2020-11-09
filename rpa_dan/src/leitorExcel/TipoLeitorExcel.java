package leitorExcel;
import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import frameWork.Driver;
import massaDados.Massa;

public class TipoLeitorExcel {
	
		
		Massa tipoMassa = new massaDados.Massa();
	
	/**
	 *Cria uma array recebendo por parametro a massa, Necessario receber o caminho do excel, a aba(sheet) e a linha check (verifica o status de enviado/processado ou algo generico para bloquear a leitura)
	 * @author Dvlopes - NouKz
	 * @param caminhoExcel
	 * @param aba
	 * @return
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 */
	public static ArrayList<Massa> leituraExcel(String caminhoExcel, String aba, int lineCheck) throws IOException, EncryptedDocumentException, InvalidFormatException{
		ArrayList<Massa> listMassaDados = new ArrayList<Massa>();
		listMassaDados = LeitorExcel.readExcelFileToObjectMassaDados(caminhoExcel, aba, lineCheck);
		System.out.println("Tamanho total ["+listMassaDados.size()+"]");
		return listMassaDados;
	}
	
	
	
	
	
	
	
	

}

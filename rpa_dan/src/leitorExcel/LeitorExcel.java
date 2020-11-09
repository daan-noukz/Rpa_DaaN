package leitorExcel;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.io.FileBackedOutputStream;

import auxiliares.Auxiliares;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import massaDados.Massa;

public class LeitorExcel {

	private static HSSFWorkbook workbook;

	// massa MassaDados = new massa();

	/**
	 * @author Dvlopes - NouKz
	 * @param caminho_arquivo_xlsx
	 * @return
	 * @return Retorna qualquer tipo de lista
	 * @throws IOException
	 * @throws InvalidFormatException
	 * @throws EncryptedDocumentException
	 */
	public static ArrayList<Massa> readExcelFileToObjectMassaDados(String caminho_arquivo_xlsx, String aba,
			int lineCheck) throws IOException, EncryptedDocumentException, InvalidFormatException {
		ArrayList<Massa> listCasoDeTeste = new ArrayList<Massa>();
		String filePath = caminho_arquivo_xlsx;

		try {
			FileInputStream file = new FileInputStream(new File(filePath));
			XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(file);
			XSSFSheet sheet = workbook.getSheet(aba);
			Iterator<?> rowIterator = sheet.rowIterator();
			while (rowIterator.hasNext()) {
				Row row = (Row) rowIterator.next();
				// Descartando a primeira linha com o header
				// if (row.getRowNum() == 0) {
				// continue;
				// }
				// Regra de leitura "caso tenha a palava / valor na line Check"
				// if
				// (row.getCell(lineCheck).getStringCellValue().contentEquals(RegrasLeitura.regrasLeituraExcel(row.getCell(lineCheck).getStringCellValue()))){
				// continue;
				// }
				Iterator<?> cellIterator = row.cellIterator();
				Massa MassaDados = new Massa();

				while (cellIterator.hasNext()) {
					Cell cell = (Cell) cellIterator.next();
					cell.setCellType(cell.CELL_TYPE_STRING);
					MassaDados = SelectionXLSX.switchCellRules(cell, MassaDados, aba);
				}
				listCasoDeTeste.add(MassaDados);

				file.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listCasoDeTeste;
	}

	/**
	 * Realiza update da cell, Verifica se a cell está em branco ou null, caso não
	 * sim cria uma nova ROW e preenche a a cell;
	 * 
	 * @author Dvlopes - NouKz
	 * @param caminho_arquivo_xlsx
	 * @param ct
	 * @throws IOException
	 * @throws InvalidFormatException
	 * @throws EncryptedDocumentException
	 *
	 */
	public static void updateSheetLine(int linha, String caminho_arquivo_xlsx, String msg, int coluna, String aba)
			throws IOException, EncryptedDocumentException, InvalidFormatException {
		try {
			FileInputStream inputStream = new FileInputStream(new File(caminho_arquivo_xlsx));
			Workbook workbook = WorkbookFactory.create(inputStream);
			XSSFSheet sheet = (XSSFSheet) workbook.getSheet(aba);
			if (sheet == null) {
				sheet = (XSSFSheet) workbook.createSheet(aba);
			}
			XSSFRow row = sheet.getRow(linha);
			if (row == null) {
				row = sheet.createRow(linha);
			}
			row = sheet.getRow(linha);
			XSSFCell cell = row.getCell(coluna);
			cell = row.createCell(coluna);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			cell.setCellValue(msg);
			inputStream.close();
			FileOutputStream outputStream = new FileOutputStream(caminho_arquivo_xlsx);
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Cria um arquivo Excel recebendo por parametro o destino & aba(sheet)
	 * 
	 * @author Dvlopes - NouKz
	 * @param caminho_arquivo_xlsx
	 * @param ct
	 * @throws IOException
	 * @throws InvalidFormatException
	 * @throws EncryptedDocumentException
	 */
	public static void newExcel(String caminho_arquivo_xlsx, String aba)
			throws IOException, EncryptedDocumentException, InvalidFormatException {
		if (Auxiliares.validaExistenciaDeArquivo(caminho_arquivo_xlsx)) {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet(aba);
			try (FileOutputStream outputStream = new FileOutputStream(caminho_arquivo_xlsx)) {
				workbook.write(outputStream);
			}
			System.out.println("Arquivo criado [" + caminho_arquivo_xlsx + "]");
		}
	}

}

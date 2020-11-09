package leitorExcel;

import org.apache.poi.ss.usermodel.Cell;

import massaDados.Massa;

public class CellRulesXLSX {	
	
	
	/**
	 * regra de leitura para a sheet
	 * @author Dvlopes - NouKz
	 * @param cell
	 * @param Massa
	 * @param aba
	 * @return
	 */
	public static Massa testeCellRules(Cell cell, Massa MassaDados){
		try{
			switch (cell.getColumnIndex()) {
				case 0:
					MassaDados.setTesteColuna1(cell.getStringCellValue());
					break;
				case 1:
					MassaDados.setTesteColuna2(cell.getStringCellValue());
					break;
				case 2:
					MassaDados.setTesteColuna3(cell.getStringCellValue());
					break;		
			}
			return MassaDados;
		} catch (Exception e){
			System.err.println(e);
			return null;
		}
	}
	
	
	/**
	 * @author Dvlopes - NouKz
	 * @param cell
	 * @param Massa
	 * @param aba
	 * @return
	 */
	public static Massa testeCellRules2(Cell cell, Massa MassaDados){
		try{
			switch (cell.getColumnIndex()) {
				case 3:
					MassaDados.setTesteColuna1(cell.getStringCellValue());
					break;
				case 4:
					MassaDados.setTesteColuna2(cell.getStringCellValue());
					break;
				case 5:
					MassaDados.setTesteColuna3(cell.getStringCellValue());
					break;		
			}
			return MassaDados;
		} catch (Exception e){
			System.err.println(e);
			return null;
		}
	}

}

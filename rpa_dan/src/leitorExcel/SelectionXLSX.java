package leitorExcel;

import org.apache.poi.ss.usermodel.Cell;

import massaDados.Massa;

public class SelectionXLSX {

	/**
	 * Regras para verificar a aba / leitura e atribuição de variavel
	 * @author Dvlopes - NouKz
	 * @param cell
	 * @param MassaDados
	 * @param aba
	 * @return
	 */
	public static Massa switchCellRules(Cell cell, Massa MassaDados, String aba) {
		try {
			switch (aba) {
			case "TESTE":
				return CellRulesXLSX.testeCellRules(cell, MassaDados);
			
			case "TESTE2":
				return CellRulesXLSX.testeCellRules2(cell, MassaDados);
				
			}
			return MassaDados;
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

}

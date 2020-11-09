package auxiliares;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Auxiliares {
	
	
	
	/**
	 * Recebe por paramentro Cmainho entrada / saida && Copia arquivo
	 * 
	 * @author  Dvlopes - NouKz
	 * @param caminhoFonte
	 * @param caminhoSaida
	 * @return
	 * @throws IOException
	 */
	public String copiarArquivo(String caminhoFonte, String caminhoSaida) throws IOException {
		FileChannel canalFont = null;
		FileChannel canalDest = null;
		try {
			canalFont = new FileInputStream(caminhoFonte).getChannel();
			canalDest = new FileOutputStream(caminhoSaida).getChannel();
			canalFont.transferTo(0, canalFont.size(), canalDest);
		} finally {
			if (canalFont != null && canalFont.isOpen()) {
				canalFont.close();
			}
			if (canalDest != null && canalDest.isOpen()) {
				canalDest.close();
			}
		}
		return caminhoSaida;
	}

	/**
	 * @author  Dvlopes - NouKz
	 * 
	 *         Recebe por parametro o formato de data e hora Retorna a data e hora
	 *         em formato string; Exemplo "dd/MM/yyyy HH:mm:ss" = 12/12/2019
	 *         15:07:28 dd-MM MM MM/yyyy
	 * @return
	 */
	public String getDateHourGenerico(String formatoData) {
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat(formatoData);
		String strDate = dateFormat.format(date);
		System.out.println("Data Recuperada [" + strDate + "]");
		return strDate;
	}

	/**
	 * Renomeia arquivo recebendo o PATH e o nome de saida Enviando para
	 * [C:\\Users\\Public\\]
	 * 
	 * @author Dvlopes - NouKz
	 * @param pathFileValue
	 * @param namePdf
	 * @return
	 */
	public void renomearArquivo(String pathFileValue, String namePdf) {
		File f = new File(pathFileValue);
		String nameReplace = namePdf.replace("/", "-").replace(".", "-");
		if (f.renameTo(new File("C:\\Users\\Public\\" + nameReplace))) {
			System.out.println("Arquivo renomeado");
		} else {
			System.out.println("Arquivo renomeado");
		}
	}
	
	/**
	 * Valida existencia de um arquivo recebendo seu path por parametro
	 * 
	 * @author Dvlopes - NouKz
	 * @param path
	 * @return
	 */
	public static boolean validaExistenciaDeArquivo(String path) {
		boolean resp;
		File arquivo = new File(path);
		if (arquivo.exists()) {
			System.err.println("O ARQUIVO EXISTE");
			resp = false;
		} else {
			System.err.println("O ARQUIVO N�O EXISTE");
			resp = true;
		}
		return resp;
	}
	

	/**
	 * Valida existencia de um arquivo recebendo seu path por parametro e deleta o
	 * mesmo
	 * 
	 * @author Dvlopes - NouKz
	 * @param pathValue
	 * @return
	 */
	public static void deleteFileDiretory(String pathValue) {
		try {
			boolean success = (new File(pathValue.toString())).delete();
			if (!success) {
				System.err.println("[ Arquivo [" + pathValue + "] n�o excluido ! ]");
			} else {
				System.err.println("[ Arquivo [" + pathValue + "] excluido ! ]");
			}

			while (validaExistenciaDeArquivo(pathValue) == false) {
				deleteFileDiretory(pathValue);
			}
		} catch (Exception e) {
			System.err.println("N�o foi poss�vel excluir o arquivo [" + pathValue + "]\n" + e);

		}
	}
	
	
	
	
	
	/**
	 * @param nomePasta
	 * @throws IOException
	 */
	public static void deletarPasta(String nomePasta) throws IOException {

		System.err.println(nomePasta);
		String pathValue = "C:\\Users\\Public\\"+nomePasta+"";
		File diretorio = new File(pathValue);
		String[] arqs;
		File arq;
		int i;

		arqs = diretorio.list();
		for(i=0; i<arqs.length; i++){
			arq = new File(diretorio.getPath(), arqs[i]);
			if(arq.isDirectory()){
				deletarPasta(nomePasta);
			} else {
				arq.delete();
			}
		}
		diretorio.delete();
	}
	
	
	
	/**
	 * 
	 * Limpa a string e retorna apenas o valor da opera��o Retornando [ 280059 ]
	 * ex: String [numero do contrato 280059 destinado a X]
	 * 
	 * @author  Dvlopes - NouKz
	 * @param valor
	 * @return
	 */
	public static String codBuilder(String valor) {
		StringBuilder build = new StringBuilder();
		String valorPadronizado = valor.replaceAll("\\s+", " ").replaceAll("-", " ").replaceAll("/", " ")
				.replaceAll(" ", "").trim();
		String[] vetor = valorPadronizado.split("");
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i].trim().toString().equals("]")) {
				break;
			}
			if (!vetor[i].trim().toString().equals("[") && !vetor[i].trim().toString().equals("#")) {
				build.append(vetor[i]);
			}
		}
		System.err.println("String Limpada [" + build.toString() + "]");
		return build.toString();
	}

	
	/**
	 * @author Dvlopes - NouKz
	 * @param arquivoEntrada
	 * @param caminhoSaida
	 * @return * Descompacta arquivo recebendo dois parametros [ENTRADA / SAIDA] *
	 *         Entrada [C:\\Users\\ALZ_ServiceQA\\Desktop\\teste.zip] Saida
	 *         [C:\\Users\\ALZ_ServiceQA\\Desktop]
	 * 
	 */
	public void descompactaArquivo(String arquivoEntrada, String caminhoSaida) {
		try {
			String cmd = "PowerShell Expand-Archive -Path " + arquivoEntrada + "-DestinationPath " + caminhoSaida + "";
			System.err.println(
					"PowerShell Expand-Archive -Path " + arquivoEntrada + " -DestinationPath " + caminhoSaida + "");
			Runtime.getRuntime().exec(cmd);
			Thread.sleep(5000);
		} catch (Exception e) {
			System.err.println("N�o foi possivel descompactar arquivo [" + arquivoEntrada + "] Para o caminho ["
					+ caminhoSaida + "]");
		}
	}
	
	
	
	/**
	 * Cria um diretorio novo no caminho padrao de [c:user/public] recebendo apenas o nome da pasta por parametro
	 *  @author Dvlopes - NouKz
	 * @param nomePasta
	 * @return
	 */
	public static String createDiretory(String nomePasta){
		nomePasta = nomePasta.replace(".","").replace("\\", "").replace(":", "-");
		String pathValue = "C:\\Users\\Public\\"+nomePasta+"";
		System.out.println(pathValue); 
		File dir = new File(pathValue);
		boolean result = dir.mkdirs();
		System.out.println("mkdirs ["+result+"]");
		return pathValue;
	}
	
	
	/**
	 * Trasfere arquivo da pasta X para Y recebendo caminho por parametro
	 * 
	 * @author Dvlopes - NouKz
	 * @param caminhoEntrada
	 * @param caminhoSaida
	 * @return
	 * @throws IOException
	 */
	public static String trasferirArquivo(String caminhoEntrada, String caminhoSaida) throws IOException {
		String caminhoPastaFixa = caminhoSaida;
		InputStream entrada1 = new FileInputStream(caminhoEntrada.trim());
		OutputStream saida1 = new FileOutputStream(caminhoSaida.trim());

		byte[] buf = new byte[1024];
		int len;
		while ((len = entrada1.read(buf)) > 0) {
			saida1.write(buf, 0, len);
		}
		entrada1.close();
		saida1.close();

		return caminhoPastaFixa;
	}
	
	
	/**
	 * @author Dvlopes
	 * @return
	 */
	public  static String getMes(){
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("MM");
		String strDate = dateFormat.format(date);
		Map<String, String> mes = new HashMap<String, String>();
		mes.put("01","01 - Janeiro");
		mes.put("02","02 - Feveeiro");
		mes.put("03","03 - Mar�o");
		mes.put("04","04 - Abril");
		mes.put("05","05 - Maio");
		mes.put("06","06 - Junho");
		mes.put("07","07 - Julho");
		mes.put("08","08 - Agosto");
		mes.put("09","09 - Setembro");
		mes.put("10","10 - Outubro");
		mes.put("11","11 - Novembro");
		mes.put("12","12 - Dezembro");
		return mes.get(strDate);
	}
	
	
	public static String data(){	
	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd--HH-mm-ss");  
	   LocalDateTime now = LocalDateTime.now();  
	   System.out.println(dtf.format(now));
	return dtf.format(now).toString();  
	}
	
	
	
	
	

}

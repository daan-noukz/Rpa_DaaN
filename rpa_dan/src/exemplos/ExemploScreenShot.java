package exemplos;
import frameWork.Driver;
import frameWork.FrameWork;
import frameWork.ScreenShot;

public class ExemploScreenShot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub			
		
		ScreenShot print = new ScreenShot();			
		
		Driver inicia = new Driver();
		FrameWork driver = new FrameWork();			
		inicia.iniciaChromeDrive("google");			
		driver.clicarElemento("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input");
		driver.preencheCampo("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input", "java");
		driver.enviaEnter("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input");
		print.printEvidencia("Chrome");
		driver.finalizaChrome();		
		
	}

}

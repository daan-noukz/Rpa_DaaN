package frameWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.security.auth.kerberos.KeyTab;
import javax.swing.event.TreeWillExpandListener;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.base.internal.Finalizer;

public class FrameWork extends Driver {

	/**
	 * Clica elemento da tela recebendo Xpath por parametro
	 * 
	 * @author Dvlopes
	 * @param xpath
	 */
	public void clicarElemento(String xpath) {
		try {
			WebElement getElement = driver.findElement(By.xpath(xpath));
			getElement.click();
		} catch (Exception e) {
			System.err.println("N�o foi possivel clicar no elemento da tela " + e);
			finalizaChrome();
		}
	}

	/**
	 * Preenche elemento da tela recebendo Xpath / String por parametro
	 * 
	 * @author Dvlopes
	 * @param xpath
	 * @param texto
	 */
	public void preencheCampo(String xpath, String texto) {
		try {
			WebElement getElement = driver.findElement(By.xpath(xpath));
			getElement.sendKeys(texto);
		} catch (Exception e) {
			System.err.println("N�o foi possivel preencher o campo " + e);
			finalizaChrome();
		}
	}

	/**
	 * Reucpera valor da tela recebedno Xpath por paremetro e retornando String
	 * 
	 * @author Dvlopes
	 * @param xpath
	 * @return
	 */
	public String recuperaValorText(String xpath) {
		try {
			String text;
			WebElement getElement = driver.findElement(By.xpath(xpath));
			text = getElement.getText();
			return text;
		} catch (Exception e) {
			System.err.println("N�o foi possivel recuperar valor do campo " + e);
			finalizaChrome();
		}
		return xpath;
	}

	/**
	 * Reucpera valor da tela recebedno Xpath & attributepor paremetro e retornando
	 * String
	 * 
	 * @author Dvlopes
	 * @param xpath
	 * @param attibute
	 * @return
	 */
	public String recuperaValorAttribute(String xpath, String atrtibute) {
		try {
			String text;
			WebElement getElement = driver.findElement(By.xpath(xpath));
			text = getElement.getAttribute(atrtibute);
			return text;
		} catch (Exception e) {
			System.err.println("N�o foi possivel recuperar Attribute do campo " + e);
			finalizaChrome();
		}
		return xpath;
	}

	/**
	 * Envia enter elemento da tela recebendo Xpath
	 * 
	 * @author Dvlopes
	 * @param xpath
	 * @param texto
	 */
	public void enviaEnter(String xpath) {
		try {
			WebElement getElement = driver.findElement(By.xpath(xpath));
			getElement.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			System.err.println("N�o foi possivel enviar ENTER o campo " + e);
			finalizaChrome();
		}
	}

	/**
	 * Envia TAB elemento da tela recebendo Xpath
	 * 
	 * @author Dvlopes
	 * @param xpath
	 * @param texto
	 */
	public void enviaTab(String xpath) {
		try {
			WebElement getElement = driver.findElement(By.xpath(xpath));
			getElement.sendKeys(Keys.TAB);
		} catch (Exception e) {
			System.err.println("N�o foi possivel enviar TAB para o campo" + e);
			finalizaChrome();
		}
	}

	/**
	 * Limpa Campo XPATH
	 * 
	 * @author Dvlopes
	 * @param xpath
	 * @param texto
	 */
	public void limparCampo(String xpath) {
		try {
			WebElement getElement = driver.findElement(By.xpath(xpath));
			getElement.clear();
		} catch (Exception e) {
			System.err.println("N�o foi possivel limpar o campo " + e);
			finalizaChrome();
		}
	}

	/**
	 * Clica Aceita no popup- alerta
	 * 
	 * @author dVlopes
	 * 
	 * @return
	 */
	public void fechaAlerta() {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.err.println("N�o foi possivel clicar o campo aceitar" + e);
			finalizaChrome();
		}
	}

	/**
	 * FinalizaChrome
	 * 
	 * @author Dvlopes
	 * @param xpath
	 * @param texto
	 */
	public static void finalizaChrome() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.err.println("N�o foi possivel preencher o campo " + e);

		}
	}

	/**
	 * Pagina 0 / 1 / 2 Recebe a quantidade de paginas para navergar e delay
	 * 
	 * @author Dvlopes
	 * @param qtd
	 * @return
	 */
	public void alteraJanejaGenerica(int qtd, int delay) {
		try {
			String x;
			Set st = driver.getWindowHandles();
			Iterator it = st.iterator();
			for (int i = 0; i <= qtd; i++) {
				x = Integer.toString(i);
				x = (String) it.next();
				driver.switchTo().window(x);
			}

		} catch (Exception e) {
			System.err.println("N�o foi possivel alterar janela");
		}
	}

	/**
	 * Aguarda ELEMENTRO DA TELA
	 * 
	 * @param xpath
	 * @param time
	 */
	public void aguardaElemento(String xpath, int time) {
		try {
			driver.findElements(By.xpath(xpath)).wait(time);
		} catch (Exception e) {
			System.err.println("Elemento n�o encontrado" + e);
			finalizaChrome();
		}
	}

	

	/**
	 * @param xpath
	 * @param tag
	 * @return
	 */
	public static List listaDeElementos(String xpath, String tag) {

		WebElement Table = driver.findElement(By.xpath(xpath));
		List rows_table = (List) Table.findElements(By.tagName(tag));
		return rows_table;
	}

	/**
	 * @param xpath
	 * 
	 */
	public static void highlightElement(String xpath) {
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
		} catch (Exception e) {
			System.err.println("N�o foi possivel utilizar Highlight; " + e);
			finalizaChrome();
		}
	}

	/**
	 * @param xpath
	 */
	public static void unHighlightElement(String xpath) {
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", element);
		} catch (Exception e) {
			System.err.println("N�o foi possivel utilizar unHighlight; " + e);
			finalizaChrome();
		}
	}
	
	
	public static void aguardar(int temp) {
		try {
			Thread.sleep(temp);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
	}

}

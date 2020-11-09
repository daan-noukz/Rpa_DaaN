package inmetrics;

import frameWork.Driver;
import frameWork.FrameWork;
import frameWork.ScreenShot;
import massaDados.Massa;
import massaDados.MassaDadosInmetrics;
import principal.Iniciar;

public class InmetricsMetodos {

	
	public static Driver inicia = new Driver();
	public static FrameWork driver = new FrameWork();
	public static ScreenShot print = new ScreenShot();
	
	static MassaDadosInmetrics massa = new MassaDadosInmetrics();
	
	
	
	public void massaDadosSet() {			
		
		massa.setUsuario("userInmetrics");
		massa.setSenha("teste1234");
		massa.setSenhaDuplicado("teste1234");		
		massa.setUsuarioDuplicado("teste1234");
	}
	
	
	

	public static void abrirChrome() {
		inicia.iniciaChromeDrive("inmetrics");
	}

	public static void finaliza() {
		driver.finalizaChrome();
	}

	public static void realizaLoginSemUsuario() {
		driver.clicarElemento("//html/body/div/div[2]/div/form/div[6]/button");
	}

	public static void recuperaValor() {
		String valor = driver.recuperaValorAttribute("/html/body/div/div[2]/div/form/div[3]/input", "text");
		print.printEvidencia(valor);
	}

	public static void clicoCadastreSe() {
		driver.clicarElemento("//*[@id='navbarSupportedContent']/ul/li[1]");
	}

	public static void validaTelaCadastro() {	
		String xpath = "/html/body/div/div/div/form/span";
		String valor = driver.recuperaValorAttribute(xpath, "textContent");
		valor = valor.replace(" ", "").trim();
		if (valor.equals("Cadastre-se")) {
			System.out.println(valor);
			FrameWork.highlightElement(xpath);
			print.printEvidencia(valor);
			FrameWork.unHighlightElement(xpath);
		} else {
			System.err.println("Erro ao Validar tela Cadastro");
			print.printEvidencia("Erro ao Validar tela Cadastro");
			driver.finalizaChrome();
		}

	}

	public static void preenchoCamposUsuarioSenhaCadastro(String usuario) {
		FrameWork.aguardar(2);
		if(usuario.equals("Novo")) {
			System.out.println(massa.getUsuario());
		driver.preencheCampo("/html/body/div/div/div/form/div[2]/input", massa.getUsuario());
		driver.preencheCampo("/html/body/div/div/div/form/div[4]/input", massa.getSenha());
		driver.preencheCampo("/html/body/div/div/div/form/div[6]/input", massa.getSenha());
		}else if(usuario.equals("Duplicado")) {
			driver.preencheCampo("/html/body/div/div/div/form/div[2]/input", massa.getUsuarioDuplicado());
			driver.preencheCampo("/html/body/div/div/div/form/div[4]/input", massa.getSenhaDuplicado());
			driver.preencheCampo("/html/body/div/div/div/form/div[6]/input", massa.getSenhaDuplicado());			
		}else {
			System.err.println("## Valor de usuario novo ou j� cadastrado Invalido ##");
			driver.finalizaChrome();
		}

	}

	public static void clicoBotaoCadastrar() {
		driver.clicarElemento("/html/body/div/div/div/form/div[7]/button");
	}

	public static void validaTelaLogin() {
		FrameWork.aguardar(2);
		String xpath = "//html/body/div/div[2]/div/form/span";
		String valor = driver.recuperaValorAttribute(xpath, "textContent");
		valor = valor.replace(" ", "").trim();

		if (valor.equals("Login")) {
			System.out.println(valor);
			FrameWork.highlightElement(xpath);
			print.printEvidencia(valor);
			FrameWork.unHighlightElement(xpath);
		} else {
			System.err.println("Erro ao Validar tela Login");
			print.printEvidencia("Erro ao Validar tela Login");
			driver.finalizaChrome();
		}
	}
	
	public static void validaUsuarioCadastrado() {
		String xpath = "/html/body/div/div/div/form/div[1]/span/div";
		String valor = driver.recuperaValorAttribute(xpath, "textContent");
		valor = valor.trim();
		if (valor.equals("Usu�rio j� cadastrado")) {
			System.out.println(valor);
			FrameWork.highlightElement(xpath);
			print.printEvidencia(valor);
			FrameWork.unHighlightElement(xpath);
		} else {
			System.err.println("Usuario N�o Cadastrado");
			print.printEvidencia("Usuario N�o Cadastrado");
			driver.finalizaChrome();
		}
	}

}

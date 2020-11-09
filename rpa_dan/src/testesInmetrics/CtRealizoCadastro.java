package testesInmetrics;

import frameWork.Driver;
import frameWork.FrameWork;
import frameWork.ScreenShot;
import inmetrics.InmetricsMetodos;

public class CtRealizoCadastro {
	
	public static void main(String[] args) {				
		
		InmetricsMetodos ct = new InmetricsMetodos();
		ct.massaDadosSet();
		
		System.out.println("Dado que estou na pagina Inicial");
		ct.abrirChrome();
		System.out.println("E clico em Cadastre-se");
		ct.clicoCadastreSe();
		System.out.println("E � apresentado a tela de cadastro");	
		ct.validaTelaCadastro();	
		System.out.println("E Preencho os campo Usuario, Senha & Confirmo a Senha com usuario j� cadastrado");	
		ct.preenchoCamposUsuarioSenhaCadastro("Duplicado");
		System.out.println("E clico em cadastrar");	
		ct.clicoBotaoCadastrar();
		System.out.println("Ent�o � apresentado a memsagem Usu�rio j� cadastrado");	
		ct.validaUsuarioCadastrado();
		System.out.println("E finalizo o teste");	
		ct.finaliza();
	}
}

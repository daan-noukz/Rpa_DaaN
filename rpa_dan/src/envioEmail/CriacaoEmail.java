package envioEmail;

import java.util.List;

import javax.xml.soap.MessageFactory;

public class CriacaoEmail {
	

	/**
	 * @author T_DCDias
	 * @param sender
	 * @param emaildestination
	 * @param pwdsender
	 * @param path1
	 * @param nome1
	 * @param path2
	 * @param nome2
	 * @param texto
	 * @param subject
	 * @param host
	 * @param porta
	 * @return 
	 * @return
	 */
	public static void createEmailSendMultipleFiles(String sender, String emaildestination,String pwdsender, List<String> anexos , String host, String  porta, String ramo ){
		try{
			ConfigOutlook configEmail = new ConfigOutlook();
	//		MessageFactory messageFactory = new MessageFactory(sender,pwdsender,emaildestination);
			//messageFactory.createMessageFiles(configEmail.configureOutLook(host, porta), anexos, ramo);
		} catch(Exception e){
			System.err.println("FAIL\n"+e);
		}
	}


/*	*//**
	 * Novas configuirações
	 *//*

	*//**
	 * @author T_DCDias
	 * @param sender
	 * @param emaildestination
	 * @param pwdsender
	 * @param texto
	 * @param subject
	 * @param host
	 * @param porta
	 * @return 
	 * @return
	 * Envio de e-mail sem anexo
	 *//*
	public static void createEmailSend(String sender, String emaildestination,String pwdsender, String host, String  porta, String ramo ){
		try{
			ConfigOutlook configEmail = new ConfigOutlook();
			MessageFactory messageFactory = new MessageFactory(sender,pwdsender,emaildestination);
			messageFactory.createMessage(configEmail.configureOutLook(host, porta), ramo);
		} catch(Exception e){
			System.err.println("FAIL\n"+e);
		}
	}*/

	



	
	
	
	
	
	
	
	
	
	
	
	

}

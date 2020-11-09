package envioEmail;

import java.util.List;
import java.util.Properties;

public class MessageFactory extends ConfigParameters{
	
	
//	protected static Message message;
//	protected static Multipart multipart;
//	protected static MimeBodyPart imagePart;

	public MessageFactory(String sender, String pwdsender, String emaildestination) {
		this.sender = sender;
		this.pwrsender = pwrsender;
		this.emaildestination = emaildestination;
	}

	/**
	 * @author ALZ_ServiceQA
	 * @param sender
	 * @param pwrsender
	 * @param emaildestination
	 * @param subject
	 * @param messagebory
	 * @return 
	 */
	public void MessageFactory(String sender, String pwrsender, String emaildestination){
		this.sender = sender;
		this.pwrsender = pwrsender;
		this.emaildestination = emaildestination;
	}
	
	
	
//	/**
//	 * @author ALZ_ServiceQA
//	 * @param config
//	 */
/*	public void createMessageFiles(Properties config, List<String> anexos ,String ramo ){
		try{
			addContext(sender, pwrsender, emaildestination, config );
			addMessagesMultFiles(ramo,anexos);
			transport();
			System.err.println("Create Message Files Done !");
		} catch (Exception e){
			throw new RuntimeException();
		}
	}*/

	
	/*public void addContext(String sender, String pwrsender, String emaildestination, Properties config  ){
		try{
			sessions sessions = new sessions();
			message = new MimeMessage(sessions.create(sender, pwrsender, config));
			message.setFrom(new InternetAddress(sender));
			Address[] toUser = InternetAddress.parse(emaildestination);
			message.setRecipients(Message.RecipientType.TO, toUser);
		} catch (Exception e){
			throw new RuntimeException();
		}
	}
	
	public void addMessagesMultFiles(String ramo, List<String> anexos){
		multipart = new MimeMultipart();
		addFiles(anexos)
		imagePart = new MimeBodyPart();
		imagePart.setContent(MessageRule.messageRules(ramo) , "text/html;charset=utf-8");
		multipart.addBodyPart(imagePart);
		message.setContent(multipart);
		message.saveChanges();
	}
	
	public void transport(){
		try{
			Transport.send(message);
		} catch (Exception e){
			throw new RuntimeException();
		}
	}*/
	
	
	

}

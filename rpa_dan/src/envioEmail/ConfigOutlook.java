package envioEmail;

import java.util.Properties;

public class ConfigOutlook {


		/**
		 * @author ALZ_ServiceQA
		 * @return
		 */
		public static Properties configureOutLook(String host, String  porta ){
			Properties props = new Properties();
			props.put("mail.smtp.auth", "false");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", porta);
			return props;
		}
	
	

}

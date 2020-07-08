package home.assignment.utility;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Emails
{
	public static void sendEmail(String username, String password, String address) throws EmailException
	{
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(username, password));
		email.setSSLOnConnect(true);
		email.setFrom("eduveen@gmail.com");
		email.setSubject("Automation Test Mail");
		email.setMsg("This is an automated test mail for my home assignment :-)\n Please do not reply and delete it.");
		email.addTo(address);
		email.send();
	}
}

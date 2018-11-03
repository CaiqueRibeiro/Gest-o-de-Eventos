package classes.testes;

import java.util.Properties;

import javax.mail.Session;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

public class TesteEmail {
	
	public static void main(String[] args) throws EmailException {
		
		
		  String hostName = "smtp.gmail.com";
		  String nomeRemetente = "Eu";
		  String remetente = "ribeiro.caique95@gmail.com";
		  String destinatarios = "caiqueribeirogtr@gmail.com";
		  String assuntoEmail = "teste email";
		  String mensagemRmail = "testando envio de email utilizando o JAVA";
		  String usuarioEmail = "ribeiro.caique95@gmail.com";
		  String senhaEmail = "8246xvix66";
		  int portaEnvio = 465;

	        SimpleEmail email = new SimpleEmail();
	        //configura o hostname
	        email.setHostName(hostName);
	        //configura porta de envio
	        email.setSmtpPort(portaEnvio);
	        //adiciona os emails de destino
	        email.addTo(destinatarios);
	        //configura o email do remetente
	        email.setFrom(remetente, nomeRemetente);
	        //adiciona o assunto
	        email.setSubject(assuntoEmail);
	        //mensagem do email
	        email.setMsg(mensagemRmail);
	        //autenticacao no servidor
	        email.setSSL(true);
	        email.setTLS(true);
	        //usuario e senha do remetente
	        email.setAuthentication(usuarioEmail, senhaEmail);
	        email.send();
		
	}

}

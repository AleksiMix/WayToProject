import java.io.IOException;

import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;

public class FTPConnector {
	private String login = null;
	private String pass = null;

	public void connectFTP(FTPClient client, String ftpServerName)
			throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException {
		
		client.connect(ftpServerName);
		client.login(login, pass);
	}
	public String getLogin(){
		return login;
	}
	public void setLogin(String login){
		this.login = login;
	}
	public String getPass(){
		return pass;
	}
	public void setPass(String password){
		this.pass = password;
	}

}

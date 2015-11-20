import java.io.IOException;
import java.util.Scanner;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPListParseException;

public class Runner {

	public static String welcomtext ="";	
	
	public static void main(String[] args) throws IllegalStateException, IOException, FTPException, FTPDataTransferException, FTPAbortedException, FTPListParseException, Exception {
		
		String folderName = null;
		String fileName = null;
		String ftpServerName = null;
		String command = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("Welcom to FTP Client!\n");
		sb.append("----------------------------------\n");
		sb.append("Usage commands:\n");
		sb.append("cd - change directory;\n");
		sb.append("cdtoorig - change dirrectory to origin;\n");
		sb.append("dloadf - download file;\n");
		sb.append("out - exit programm;\n");
		sb.append("sc - show content of the directory;\n");
		sb.append("----------------------------------");
		welcomtext = sb.toString();
		
		System.out.println(welcomtext);
		System.out.println("Enter the FTP Server name:");
        Scanner scn = new Scanner(System.in);
		if(scn.hasNextLine()){
		ftpServerName = scn.nextLine();
		}
		System.out.println("Enter login and password:");
        
		FTPConnector con = new FTPConnector();
		if(scn.hasNextLine()){
		String[] logpas	= scn.nextLine().split(" ",2);
		con.setLogin(logpas[0]);
		con.setPass(logpas[1]);
		scn.close();
		}
		
		
		FTPClient client = new FTPClient();
		con.connectFTP(client,ftpServerName);
		DirectoryWorker dw = new DirectoryWorker();
		
		while(true){
		System.out.println("Enter your command:...");
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextLine()){
			command = sc.nextLine();
			sc.close();
		}
		Scanner scanner = new Scanner(System.in);
		switch(command){
		case "cd":
			System.out.println("Enter the folder name you want to go into:");
			if(scanner.hasNextLine()){
			folderName = sc.nextLine();}
			scanner.close();
			try {
				client.changeDirectory(folderName);
				dw.getDirectoryContent(client);
			} catch (Exception e) {
				System.out.println("No such directory!");
			}
			break;
						
		case "cdtoorig":
			client.changeDirectoryUp();
			dw.getDirectoryContent(client);			
			break;
			
		case "dloadf":
			Downloader dlf = new Downloader();
			System.out.println("Enter the file name you want to download:");
			if(scanner.hasNextLine()){
			fileName = scanner.nextLine();
			scanner.close();
			}
			try {
				dlf.downloadFile(client, fileName);
			} catch (Exception e) {
				System.out.println("Download failed! "+e);
			}
			break;
			
		case "sc": 
			dw.getDirectoryContent(client);
			break;
			
		case "out":
			System.exit(0);
			break;
			
		default:
			System.out.println("No such command! Look into usage list of commands");
			break;
			
		}
		}
	}

}

import java.io.FileNotFoundException;
import java.io.IOException;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;

public class Downloader {
	
	public void downloadFile(FTPClient client, String fileName) throws IllegalStateException, FileNotFoundException,
	IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException {

String downloadDirectory = "/Volumes/Data/Projects/FtpClientProgram/Downloads/";

client.download(fileName, new java.io.File(downloadDirectory + fileName));
System.out.println("Download successed!");

}
}

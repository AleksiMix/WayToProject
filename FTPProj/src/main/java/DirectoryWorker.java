import java.io.IOException;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPFile;
import it.sauronsoftware.ftp4j.FTPListParseException;

public class DirectoryWorker {
	
      public void getDirectoryContent(FTPClient client) throws IllegalStateException, IOException, Exception, FTPException,
			FTPDataTransferException, FTPAbortedException, FTPListParseException {

		final int IS_DIRECTORY = 1;
		
		FTPFile[] listOfFiles = client.list();
		System.out.println("Directory " + client.currentDirectory());
		
		for (FTPFile file : listOfFiles) {
			if (file.getType() == IS_DIRECTORY) {
				System.out.println(" folder "+file.getName());
			} else {
				System.out.println(" file "+file.getName());
			}
			
		}
	}
      
}

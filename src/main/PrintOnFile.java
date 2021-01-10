
package main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PrintOnFile {
	public void printonfile(String data,String p) throws IOException
	{
		String str = data;
		Path path = FileSystems.getDefault().getPath(p);
				File userfile = new File(path.toString());
		//Path path =Paths.get( p);
        if (!Files.exists(path))
        {
            Files.createFile(path);
           // System.out.print("created successfully");
            
        }
	    BufferedWriter writer = new BufferedWriter(new FileWriter(p, true));
	   // writer.append(' ');
	    writer.append(str);
	    writer.close();
	}
	
}
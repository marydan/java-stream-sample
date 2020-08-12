package NIOSamples;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static java.nio.file.StandardCopyOption.*;

public class PathExample {

	public static void main(String[] args) {
		
		Path path=Paths.get("E:\\1-ust-wave9\\niosample\\nonblock.txt");
		
		if(Files.exists(path))
			System.out.println(path.getFileName());
		if(Files.isReadable(path))
			System.out.println("is readable");
		
		
		Path source=Paths.get("E:\\1-ust-wave9\\niosample\\aug9th.txt");
		Path destin=Paths.get("E:\\1-ust-wave9\\test\\nonblock.txt");
		
		try
		{
			Files.copy(source, destin,REPLACE_EXISTING);
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}

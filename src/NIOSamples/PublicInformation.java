package NIOSamples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class TendorNotice extends Thread
{
  static final ReentrantReadWriteLock rwlock=new ReentrantReadWriteLock();	
public void run()
{
	try
	{
		 writeInFile();
		  sleep(3000);
		 readfromFile();
	}
	catch(Exception e)
	{
		System.out.println(e); 	
	}
}
 public void writeInFile()
 {
	 try
	 {
		 rwlock.writeLock().lock();
		
		 Path file=Paths.get("E:\\1-ust-wave9\\niosample\\data.txt");
		 Charset charset=Charset.forName("US-ASCII");
		 try(BufferedWriter bufferw=Files.newBufferedWriter(file,charset,StandardOpenOption.CREATE))
				 {
			       bufferw.write("Tender Added for Coconut");
			       bufferw.flush();
					 bufferw.close();
        System.out.println("Written ");
				 }
		  catch(Exception e) {}
		 finally {
		 }
	 }
	 catch(Exception e)
	 {
		 System.out.println("Error");
	 }
//	 rwlock.writeLock().unlock();
 }
 

 public void readfromFile()
 {
	 try
	 {
		 rwlock.readLock().lock();
		 Path file=Paths.get("E:\\1-ust-wave9\\niosample\\data.txt");
		 BufferedReader bread=Files.newBufferedReader(file);
		 String line=bread.readLine();
		System.out.println("File content is " + line); 
	 }
	 catch(Exception e)
	 {
		System.out.println(e); 
	 }
	 rwlock.readLock().unlock();
 }
	
}



public class PublicInformation {

	public static void main(String[] args) {
	 
		TendorNotice monthbeg=new TendorNotice();
		monthbeg.start();
		TendorNotice monthend=new TendorNotice();
		monthend.start();

	}

}

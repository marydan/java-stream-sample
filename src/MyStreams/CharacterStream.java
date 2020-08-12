package MyStreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CharacterStream {

	public static void main(String[] args) throws Exception{
		
InputStreamReader inputstream=new InputStreamReader(System.in);
BufferedReader buffer=new BufferedReader(inputstream);


System.out.println("Enter the info");
String ans;


//buffer.close();

FileWriter files=new FileWriter("storedata.txt");
BufferedWriter bwrite=new BufferedWriter(files);



 while(  (ans=buffer.readLine())!=null)
 {		 
    bwrite.write(ans);
 }
 
bwrite.flush();

bwrite.close();

System.out.println("Done");
	}

}

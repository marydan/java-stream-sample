package NIOSamples;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import static java.nio.file.StandardWatchEventKinds.*;

public class MonitorDirectory {
	WatchService watchserve;
		Path path=Paths.get("E:\\1-ust-wave9\\niosample");
	
	void initializeService() throws Exception
	{
		try {
		watchserve=FileSystems.getDefault().newWatchService();
		
		path.register(watchserve, ENTRY_CREATE,ENTRY_DELETE,ENTRY_MODIFY);
		}
		catch(Exception e) {System.out.println(e);}
	}

	void monitorService()
	{
		WatchKey wkey=null;
		
		while(true)
		{
			try {
			wkey=watchserve.take();
			 
			 for(WatchEvent evt : wkey.pollEvents())
			 {
				Kind kindevt=evt.kind();
				System.out.println(evt.context().toString() + " is  "+ kindevt);
				
			 }
			}catch(Exception e) {}
	   	
		   boolean result=wkey.reset();
		  if(!result)
			break;
	    } //while
	}
	public static void main(String[] args) throws Exception {
		
MonitorDirectory monitorobject=new MonitorDirectory();
monitorobject.initializeService();
monitorobject.monitorService();

	}

}


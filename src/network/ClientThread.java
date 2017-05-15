package network;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ClientThread extends Thread{

	//create socket 
	private Socket socket;
	private JsonSerializer jsonSer;
	
	//apply the socket obj passed from ServerTCP to the local socket obj
	public ClientThread(Socket socket){
		this.socket = socket;
	}
	
	
	
	
	@Override
	public void run() {
		jsonSer = new JsonSerializer();
		
		jsonSer.addString("String", "Ich bin ein String");
		jsonSer.addDouble("Double", 0.0);
		jsonSer.addInteger("Int", 0);
		
		Map<String, Object> mop = new HashMap<String, Object>();
		int[] arr = {1,2,3,45,890};
		mop.put("Eins", arr);
		jsonSer.addArray("IntArray", mop );
		
		Map<String, Object> mip = new HashMap<String, Object>();
		double[] irr = {0.1,2.5,3.0,4.2};
		mip.put("Eins", irr);
		jsonSer.addArray("DoubleArray", mip );
		
		Map<String, Object> mup = new HashMap<String, Object>();
		String[] urr = {"Zwo","Drei","Vier"};
		mup.put("Eins", urr);
		jsonSer.addArray("StringArray", mup );
		
		jsonSer.writeFile();
		
//		System.out.println(jsonSer.getString());
//		jsonSer.getObjects().forEach((k,v) -> {
//			System.out.println(k + "  " + v);
//		});
//		for(double d : (double[])jsonSer.getKey("\"DoubleArray\"")){
//			System.out.println(d);
//		}
		
		System.out.println("New Client created..");
		//print ip
		System.out.println(socket.getInetAddress());
		
		//create in- and output streams on the existing socket
		try(InputStream in = socket.getInputStream();
			OutputStream os = socket.getOutputStream()){	
			System.out.println("Writing..");
			//create fileinput stream and read in the element at the location FILEPATH
			try(FileInputStream fis = new FileInputStream("file.txt")){
				//create new byte[] with dim of element FILEPATH
				byte[] b = new byte[fis.available()];
				//read the element into byte[]
				while(fis.available() > 0){
					fis.read(b);
				}
				//write the element in byte[] to the output stream
				os.write(b);
				//flush the stream! 
				os.flush();
				//close the socket! must be did manually here!
				socket.close();
				System.out.println("...closing Socket");
			}
		}catch(IOException e1) {
			e1.printStackTrace();
			System.err.println("Writing failed..");
		}
		
	}
	

}

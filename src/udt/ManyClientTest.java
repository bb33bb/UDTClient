package udt;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;

import udt.UDTClient;
import udt.util.Util;

public class ManyClientTest {

	public static void main(String[] args) throws Exception {
		UDTClient client=new UDTClient(InetAddress.getByName("localhost"),12345);
		client.connect("localhost", 65321);
		doClientCommunication(client,"1 send info");
		
		UDTClient client2=new UDTClient(InetAddress.getByName("localhost"),12346);
		client2.connect("localhost", 65321);
		doClientCommunication(client2,"2 send info");
		
	}

	private static void doClientCommunication(UDTClient client,String context)throws Exception{
		PrintWriter pw=new PrintWriter(new OutputStreamWriter(client.getOutputStream(),"UTF-8"));
		pw.println(context);
		pw.flush();
		System.out.println("Message sent.");
		client.getInputStream().setBlocking(false);
		String line=Util.readLine(client.getInputStream());
		System.out.println(line);
	}
}

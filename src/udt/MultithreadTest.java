package udt;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;

import udt.UDTClient;

public class MultithreadTest {

	public static void main(String[] args) throws Exception {
		new Runnable() {
			public void run() {
				UDTClient client;
				try {
					client = new UDTClient(InetAddress.getByName("localhost"),
							12345);
					client.connect("localhost", 65321);
					for (int i = 0; i < 5; i++) {
						doClientCommunication(client,"2test"+i);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.run();
		
		new Runnable() {
			public void run() {
				UDTClient client;
				try {
					client = new UDTClient(InetAddress.getByName("localhost"),
							12343);
					client.connect("localhost", 65321);
					for (int i = 0; i < 5; i++) {
						doClientCommunication(client,"2test"+i);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.run();
	}

	private static void doClientCommunication(UDTClient client,String context) throws Exception {
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(
				client.getOutputStream(), "UTF-8"));
		pw.println(context);
		pw.flush();
//		client.getInputStream().setBlocking(false);
//		String line = Util.readLine(client.getInputStream());
	}
}

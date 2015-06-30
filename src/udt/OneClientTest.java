package udt;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;

import udt.util.Util;

public class OneClientTest {
	public static void main(String[] args) throws InterruptedException,
			IOException {
		UDTClient client = new UDTClient(InetAddress.getByName("localhost"),
				12345);
		client.connect("192.168.22.129", 65321);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(
				client.getOutputStream(), "UTF-8"));
		pw.println("Message sent:test2");
		pw.flush();
//		client.getInputStream().setBlocking(false);
//		String line = Util.readLine(client.getInputStream());
//		System.out.println(line);
	}
}
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

	public static void main(String[] args) {
	
		final String Host = "127.0.0.1";
		final int Puerto =5000;
		DataInputStream  in;
		DataOutputStream out;
		try {
			Socket sc = new Socket(Host,Puerto);
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			out.writeUTF("Hola que onda servidor soy el cliente XD");
			String mensaje = in.readUTF();
			System.out.println(mensaje);
			sc.close();
		}
			catch(IOException ex) {
				Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
				}
	}
}

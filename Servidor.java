import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

	public static void main(String[] args) {
		
		ServerSocket servidor = null;
		Socket sc = null;
		DataInputStream in;
		DataOutputStream out;
		final int puerto = 5000;
		
		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Servidor iniciado");
			while(true) {
			sc = servidor.accept();
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			String mensaje = in.readUTF();
			System.out.println(mensaje);
			out.writeUTF("Bienvenido a servidor kruman");
			sc.close();
			System.out.println("Cliente desconectado");
			}
		}
			catch(IOException ex) {
				Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
				}
	}
}

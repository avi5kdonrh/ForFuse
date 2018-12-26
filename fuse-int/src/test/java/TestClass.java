import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;
import java.util.stream.IntStream;

import javax.xml.soap.MimeHeader;
import javax.xml.soap.MimeHeaders;
import javax.xml.stream.XMLStreamWriter;

import org.apache.log4j.net.SocketServer;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;

import com.sun.xml.bind.v2.runtime.output.UTF8XmlOutput;
import com.sun.xml.bind.v2.runtime.unmarshaller.Base64Data;

public class TestClass {

	public static void main(String[] args) throws Exception{
		String _string = "";
		File file = new File("/home/adongre/Downloads/SampleVideo_1280x720_1mb.mp4");
		FileInputStream fis = new FileInputStream(file);
		int count = fis.available();
		InputStreamReader isr = new InputStreamReader(fis);
		byte[] _theArray = new byte[fis.available()];
		fis.read(_theArray);
		OutputStream os = System.out;
		
		/*ByteArrayOutputStream bois = new ByteArrayOutputStream();
		bois.write(_theArray);
		bois.flush();*/
		
		ServerSocket serverSocket = new ServerSocket(8989);
		while(true) {
			final Socket socket = serverSocket.accept();
			OutputStream out = socket.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(out);
			System.out.println(" GOt Request >>> ");
			out.write("HTTP/1.0 200 OK\r\n".getBytes());
			out.write("Accept-Ranges: bytes\r\n".getBytes());
            // out.write(("Content-Length: "+file.length()+"\r\n").getBytes());
			out.write("Content-Type: text/html\r\n".getBytes());
			out.write("\r\n".getBytes());
			out.write("<h1>H>>></h1>".getBytes());
			out.flush();
			out.close();
		}
		
		//System.out.println(new String(_theArray));
	}
}

package org.mypackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Response {
    public static void sendResponse(Socket sock, StringBuffer response, File file) throws Exception {
        if(response != null) {
        PrintWriter printW = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock.getOutputStream())),true); 
        printW.println("HTTP/1.0 200 OK\r\n");
        printW.println(response.toString());
            }
            if (file != null) {
                OutputStream out = sock.getOutputStream();
                
                    if(file.isDirectory()) {
    
                        PrintWriter printW = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)),true); 
                        printW.println("HTTP/1.0 200 OK\r\n");
                            
                        StringBuffer sbuffer = new StringBuffer();
                        printW.println("<html><head><title>Files</title>"
                                +"<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css' integrity='sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO' crossorigin='anonymous'>"
                                +"<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js' integrity='sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy' crossorigin='anonymous'></script>"
                                + "<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.5.0/css/all.css' integrity='sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU' crossorigin='anonymous'>"
                                + "<style>li{list-style: none;}"
                                + "#mainDiv{margin: 40 auto;  width: 50%;}"
                                + "i.fas.fa-folder,i.fa-file{padding-right:14px}" 
                                + "</style>"
                                + "</head><body><div id='mainDiv'>");
                        printW.println("<ul>");
                        File[] files = file.listFiles();
                        for(File fi: files) {
                            if(fi.isDirectory()) {
                            printW.println("<li><i class=\"fas fa-folder\"></i><a href='"+fi.getAbsolutePath()+"'>"+fi.getName()+"</a></li>");
                            }else {
                                printW.println("<li><i class='far fa-file'></i><a href='"+fi.getAbsolutePath()+"'>"+fi.getName()+"</a></li>");
                            }
                        }
                        printW.println("</ul>");
                        printW.println("</div></body></html>");
                        //printW.println(sbuffer.toString());
                    }else {
                Path path = Paths.get(file.getAbsolutePath());
                out.write("HTTP/1.0 200 OK\r\n".getBytes());
                out.write("Accept-Ranges: bytes\r\n".getBytes());
                out.write(("Content-Length: "+file.length()+"\r\n").getBytes());
                out.write("Content-Type: application/octet-stream\r\n".getBytes());
                out.write(("Content-Disposition: attachment; filename=\""+file.getName()+"\"\r\n").getBytes());
                out.write("\r\n".getBytes()); 
                Files.copy(path, out);
                out.flush();
                    }
            }
}
}
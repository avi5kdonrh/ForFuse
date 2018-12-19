package org.mypackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class HttpTask implements Runnable {

    @Override
    public void run() {
    System.out.println("Running the http server on :8080");
        try(ServerSocket serverSocket = new ServerSocket(8080)){
            while(true){
                final Socket sock = serverSocket.accept();
               BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
               String line = "";
               StringBuffer strBuffer = new StringBuffer();
               while(!(line=br.readLine()).isEmpty()){
                  if(line.startsWith("GET")){
                      break;
                  }
               }
               StringTokenizer stoken = new StringTokenizer(line);
               stoken.nextToken();
               line = stoken.nextToken();
               if(!line.contains("favicon.ico")) {
                   File file = new File(line);
                   if(!file.exists()) {
                       strBuffer.append("<h1>The file does not exist</h1>");
                       Response.sendResponse(sock, strBuffer,null);
                   }
                   
                   Response.sendResponse(sock, null,file);
                       
                   
                   
               }
                   
         
              
                if(!sock.isClosed())
                sock.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
    
        }
    
    }

}
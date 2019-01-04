package com.split;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
/**
 * @author Avinash D
 * Generates the data to be written in a file
 */
public class FileGenerator implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String data = getData();
        exchange.getIn().setBody(data);
    }
    
    /**
     * This method generates a random 10 characters and merges them into a string
     * @return String
     */
    public String getData(){
        String str = "ABCDEFGHIJKLMNOPQRSTUVWZYZ1234567890abcdefghijklmnopqrstuvwxyz`~!@#$%^&*()?/.>,<'\"[]=+-_";
        int length = str.length();
     char[] chars = new char[30];
      for(int i=0;i<30;i++){
        int val =  (int) (Math.random()*100);
        chars[i] =  str.charAt((val%length));
      }

      return new String(chars);
    }

}
package org.pkg;

import java.net.URLDecoder;
import java.util.StringTokenizer;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.converter.stream.InputStreamCache;
import org.eclipse.jetty.server.Request;
import org.objects.StandardForm;

public class HttpProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
       // Request request = (Request) exchange.getIn().getHeader(Exchange.HTTP_SERVLET_REQUEST);
        InputStreamCache isc = exchange.getIn().getBody(InputStreamCache.class);
       /* StandardForm sdf = new  StandardForm();
        
        byte[] bytes = new byte[isc.available()];
        isc.read(bytes);
        String json = new String(bytes);
        System.out.println(json);*/
        ObjectMapper om = new ObjectMapper(); 
        StandardForm sdf = om.readValue(isc, StandardForm.class);

      /*  StringTokenizer stoken = new StringTokenizer(json, "&");
        while(stoken.hasMoreTokens()){
            String[] array = stoken.nextToken().split("=");
            if("name".equals(array[0])){
                sdf.setName(array[1]);
            }
            if("age".equals(array[0])){
                sdf.setAge(Integer.valueOf(array[1]));
            }
            if("dob".equals(array[0])){
                sdf.setDob(array[1]);
            }
            if("image".equals(array[0])){
                sdf.setImage(URLDecoder.decode(array[1],"UTF-8"));
            }
        }*/
        exchange.getIn().setBody(sdf);
	}

}
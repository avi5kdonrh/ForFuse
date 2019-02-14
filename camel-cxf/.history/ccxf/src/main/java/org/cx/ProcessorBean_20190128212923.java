package org.cx;

import java.io.ByteArrayInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import lasti.Test;
import lasti.TestResponse;

public class ProcessorBean implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String str = new String("Message Body");
        Test tr = new Test();
        tr.setArg0(str);
        
        exchange.getIn().setBody(tr);
    }

}
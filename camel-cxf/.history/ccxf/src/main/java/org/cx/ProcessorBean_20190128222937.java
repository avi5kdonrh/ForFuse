package org.cx;

import java.util.Map;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import rh.com.InputObject;

public class ProcessorBean implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        InputObject inputObject = new InputObject();
        inputObject.setId(91);
        inputObject.setDetails("This is the soap input object ");
        exchange.getIn().setBody(inputObject);
    }

    public void processOutput(Exchange exchange) throws SOAPException {
        SOAPMessage message = (SOAPMessage)exchange.getIn().getHeader("camelcxfmessage");
        System.out.println(message.getSOAPBody());
        


    }

}
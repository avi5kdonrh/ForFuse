package org.cx;

import java.util.Map;

import javax.xml.soap.SOAPException;
import org.apache.cxf.binding.soap.SoapMessage;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import rh.com.InputObject;
import rh.com.OutputObject;

public class ProcessorBean implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        InputObject inputObject = new InputObject();
        inputObject.setId(91);
        inputObject.setDetails("This is the soap input object ");
        exchange.getIn().setBody(inputObject);
    }

    public void processOutput(Exchange exchange) throws SOAPException {
        SoapMessage message = (SoapMessage)exchange.getIn().getHeader("camelcxfmessage");
        System.out.println(message.getContent(OutputObject.class));

    }

}
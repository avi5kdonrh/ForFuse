package org.cx;

import javax.xml.soap.SOAPMessage;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.binding.soap.SoapMessage;

public class ProcessorBean implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        SOAPMessage sm = SOAPMessage
        String string = new String("Message Body");
        exchange.getIn().setBody(string);
    }

}
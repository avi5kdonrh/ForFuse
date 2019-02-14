package org.cx;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.binding.soap.SoapMessage;

public class ProcessorBean implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        SoapMessage sm = new  Soap
        String string = new String("Message Body");
        exchange.getIn().setBody(string);
    }

}
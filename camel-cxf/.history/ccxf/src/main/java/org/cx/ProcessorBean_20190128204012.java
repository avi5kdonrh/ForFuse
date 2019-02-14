package org.cx;

import javax.xml.soap.MessageFactory;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ProcessorBean implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        MessageFactory.newInstance().create
        String string = new String("Message Body");
        exchange.getIn().setBody(string);
    }

}
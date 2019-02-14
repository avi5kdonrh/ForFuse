package org.cx;

import java.io.ByteArrayInputStream;

import javax.xml.soap.MessageFactory;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ProcessorBean implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        MessageFactory.newInstance().createMessage(null, new ByteArrayInputStream(buf))
        String string = new String("Message Body");
        exchange.getIn().setBody(string);
    }

}
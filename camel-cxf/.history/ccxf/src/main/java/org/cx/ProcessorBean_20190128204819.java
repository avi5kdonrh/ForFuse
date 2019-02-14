package org.cx;

import java.io.ByteArrayInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ProcessorBean implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String string = new String("Message Body");
        SOAPMessage soapMessage = MessageFactory.newInstance().createMessage(null,
                new ByteArrayInputStream(string.getBytes()));
        JAXBContext context = JAXBContext.newInstance(soapMessage.getClass());
        context.createMarshaller().marshal(soapMessage, handler);
        System.out.println(soapMessage);
        exchange.getIn().setBody(soapMessage);
    }

}
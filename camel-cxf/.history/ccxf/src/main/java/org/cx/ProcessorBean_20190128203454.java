package org.cx;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ProcessorBean implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String string = new String();
        exchange.getIn().setBody(body);
    }

}
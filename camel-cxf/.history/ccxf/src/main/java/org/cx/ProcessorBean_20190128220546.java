package org.cx;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import rh.com.InputObject;


public class ProcessorBean implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
      InputObject inputObject = new Input
        exchange.getIn().setBody(str);
    }

}
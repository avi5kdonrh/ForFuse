package com.rh;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class TheProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("The eX>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.");
    }

}
package com.camel.data.process;

import com.camel.data.Profile;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class DataProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {

        Profile profile = exchange.getIn().getBody(Profile.class);
        System.out.println(profile.getAddress());
    }


}
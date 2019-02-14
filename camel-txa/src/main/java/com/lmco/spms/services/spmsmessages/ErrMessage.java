package com.lmco.spms.services.spmsmessages;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ErrMessage implements Processor {
    AtomicInteger ain = new AtomicInteger(0);
    @Override
    public void process(Exchange exchange) throws Exception {
        if(ain.getAndIncrement()==0){
            
            throw new Exception("You are not good");
        }else{
            exchange.getIn().setBody(">>><<<<<");
        }
    }

}
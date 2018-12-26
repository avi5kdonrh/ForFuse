package org.pkg;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.eclipse.jetty.websocket.common.io.payload.PayloadProcessor;

public class MessageProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Object payload = exchange.getIn().getBody();
        if(payload != null && payload instanceof String){
            payload =   payload.toString().replaceAll("\\s", "");
            exchange.getIn().setBody(payload);
        }
        System.out.println(payload+" <<< Payload after process");
	}

}
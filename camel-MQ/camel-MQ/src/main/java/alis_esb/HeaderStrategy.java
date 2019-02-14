package alis_esb;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.camel.Exchange;
import org.apache.camel.spi.HeaderFilterStrategy;

public class HeaderStrategy implements HeaderFilterStrategy {
    AtomicInteger aint = new AtomicInteger(0);
    @Override
    public boolean applyFilterToCamelHeaders(String headerName, Object headerValue, Exchange exchange) {
        if(aint.get() <2){
            aint.incrementAndGet();
            throw new NullPointerException();
        }
        System.out.println(exchange.getIn().getBody().getClass()+"<<>");
        return false;
    }

    @Override
    public boolean applyFilterToExternalHeaders(String headerName, Object headerValue, Exchange exchange) {
        System.out.println(exchange.getIn().getHeaders()+ "<<");
        return true;
    }

}
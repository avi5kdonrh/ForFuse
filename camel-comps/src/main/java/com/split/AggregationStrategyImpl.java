package com.split;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

/**
 * @author Avinash Dongre
 * @apiNote
 * This class implements aggregation strategy and concatenates the messages from two exchanges
 *
 */
public class AggregationStrategyImpl implements AggregationStrategy {

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
    	String oldMessage = "";
    	if(oldExchange != null) {
         oldMessage = oldExchange.getIn().getBody(String.class);
    	}
        String newMessage = newExchange.getIn().getBody(String.class);

        newExchange.getIn().setBody(oldMessage+" "+newMessage);

        return newExchange;
	}
}
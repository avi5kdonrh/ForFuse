package com.split;

import com.objects.SerializableContainer;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class EnrichAggregationStrategyImpl implements AggregationStrategy {

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        String tokenBody = oldExchange!=null?oldExchange.getIn().getBody(String.class):"";
        String httpBody = newExchange.getIn().getBody(String.class);
        Document doc = Jsoup.parse(httpBody);
        SerializableContainer sc = new SerializableContainer();
        String permissions  = doc.getElementsByClass("perms").text();
        String href  = doc.select(".display-name a").attr("href");
        String name  = doc.select(".display-name a").text();
        sc.setHref(href);
        sc.setName(name);
        sc.setPermissions(permissions);
        sc.setPassword(tokenBody);
        newExchange.getIn().setBody(sc);
        System.out.println(sc.toString());
        return newExchange;
	}

}
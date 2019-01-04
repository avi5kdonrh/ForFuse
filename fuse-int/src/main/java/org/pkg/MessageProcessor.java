package org.pkg;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.objects.EnhancedForm;
import org.objects.StandardForm;
/**
 * @author Avinash Dongre
 * This is a custom message processor 
 * 
 * 
 * 
 */
public class MessageProcessor implements Processor {
final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
    @Override
    public void process(Exchange exchange) throws Exception {
        StandardForm sf = exchange.getIn().getBody(StandardForm.class);
        if(sf != null){
            EnhancedForm ef = new EnhancedForm();
            LocalDateTime localDate = LocalDateTime.parse(sf.getDob()+" 00:00:00", dateTimeFormatter);
            long timeMills = localDate.toInstant(ZoneOffset.ofHoursMinutes(5, 30)).toEpochMilli();
           ef.setDob(timeMills);
           ef.setName(sf.getName());
           ef.setImage(sf.getImage());
           exchange.getIn().setBody(ef);
        }else{    
        Object payload = exchange.getIn().getBody();
        if(payload != null && payload instanceof String){
            payload =   payload.toString().replaceAll("\\s", "");
            exchange.getIn().setBody(payload);
        }
        System.out.println(payload+" <<< Payload after process"); 
    }
    }

}
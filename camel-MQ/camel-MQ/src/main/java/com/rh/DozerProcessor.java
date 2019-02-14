package com.rh;

import com.lmco.spms.services.spmsmessages.ErrMessage;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.dozer.DozerBeanMapperBuilder;

import alis_esb.SendMessageRequest;

public class DozerProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		 DozerBeanMapperBuilder dbmb = DozerBeanMapperBuilder.create();
        SendMessageRequest smr = new SendMessageRequest();
        dbmb.withMappingFiles("dozer.file.xml");
        ErrMessage returnType = dbmb.build().map(smr.getSendMessage(), ErrMessage.class);
        System.out.println(">>>>>>>>>>>>> "+returnType); 
		
	}

}

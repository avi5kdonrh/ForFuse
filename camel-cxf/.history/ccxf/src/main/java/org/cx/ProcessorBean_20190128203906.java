package org.cx;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import javax.xml.soap.AttachmentPart;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.jaxws.handler.soap.SOAPMessageContextImpl;

public class ProcessorBean implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        SOAPMessageContextImpl impl = new SOAPMessage(){
        
            @Override
            public void writeTo(OutputStream out) throws SOAPException, IOException {
                
            }
        
            @Override
            public void setContentDescription(String description) {
                
            }
        
            @Override
            public boolean saveRequired() {
                return false;
            }
        
            @Override
            public void saveChanges() throws SOAPException {
                
            }
        
            @Override
            public void removeAttachments(MimeHeaders headers) {
                
            }
        
            @Override
            public void removeAllAttachments() {
                
            }
        
            @Override
            public SOAPPart getSOAPPart() {
                return null;
            }
        
            @Override
            public MimeHeaders getMimeHeaders() {
                return null;
            }
        
            @Override
            public String getContentDescription() {
                return null;
            }
        
            @Override
            public Iterator getAttachments(MimeHeaders headers) {
                return null;
            }
        
            @Override
            public Iterator getAttachments() {
                return null;
            }
        
            @Override
            public AttachmentPart getAttachment(SOAPElement element) throws SOAPException {
                return null;
            }
        
            @Override
            public AttachmentPart createAttachmentPart() {
                return null;
            }
        
            @Override
            public int countAttachments() {
                return 0;
            }
        
            @Override
            public void addAttachmentPart(AttachmentPart AttachmentPart) {
                
            }
        };
        String string = new String("Message Body");
        exchange.getIn().setBody(string);
    }

}
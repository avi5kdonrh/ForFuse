package org.pkg;
public class MediatorBean{
    public Object beanTranform(Object payload){
        if(payload != null && payload instanceof String){
            char first = payload.toString().charAt(0);
		char last  = payload.toString().charAt(payload.toString().length()-1);
		payload = first+payload.toString().substring(1, payload.toString().length()-2).replaceAll("|", "_^_")+last;
        }
        System.out.println("Payload from bean transform "+payload);
        return payload;
    }
}
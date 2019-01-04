package org.pkg;

import org.objects.EnhancedForm;

public class MediatorBean {
    public Object beanTranform(Object payload){
        
        if(payload instanceof EnhancedForm){
            EnhancedForm pl = (EnhancedForm)payload;
            String id = getId(pl.getName(), pl.getDob());
            pl.setId(id);
            return pl;
        }

       else if(payload != null && payload instanceof String){
            char first = payload.toString().charAt(0);
		char last  = payload.toString().charAt(payload.toString().length()-1);
		payload = first+payload.toString().substring(1, payload.toString().length()-2).replaceAll("|", "_^_")+last;
        }
        System.out.println("Payload from bean transform "+payload);
        return payload;
    }

    public String getId(String name, long dob){
        /*
        Bla Blah Blahh
        */
        return String.valueOf((int)(Math.random()*1100));
    }
}
package org.objects;

import java.io.Serializable;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Avinash Dongre
 * @category POJO This is EnhancedForm pojo class with simple getters and
 *           setters
 * 
 */
public class EnhancedForm implements Serializable{
    private static final long serialVersionUID = -5753946544299594952L;
    private String id;
    private String details;
    private long dob;
    private String name;
    private String image;


    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the details
     */
    public String getDetails() {
        return details;
    }

    /**
     * @param details the details to set
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * @return the dob
     */
    public long getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(long dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        String str = null;
        try{
            str = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        }catch(Exception e){
            e.printStackTrace();
        }
        return str;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

/**
 * @return the image
 */
public String getImage() {
	return image;
}

/**
 * @param image the image to set
 */
public void setImage(String image) {
	this.image = image;
}    }


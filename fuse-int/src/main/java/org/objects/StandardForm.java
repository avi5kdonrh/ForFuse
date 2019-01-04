package org.objects;

import java.io.Serializable;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * @author Avinash Dongre
 * @category POJO
 * This is StandardForm pojo class with simple getters and setters
 * 
  */
public class StandardForm implements Serializable{
    private static final long serialVersionUID = 8757927331922606516L;
    private String name;
    private int age;
    private String location;
    private String dob;
    private String image;

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
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set in dd-MMM-yyy format
     */
    public void setDob(String dob) {
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
    }
}
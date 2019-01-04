package com.objects;

import java.io.Serializable;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializableContainer implements Serializable{

    private static final long serialVersionUID = 1L;
    private String password;
    private String permissions;
    private String name;
    private String href;

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the permissions
     */
    public String getPermissions() {
        return permissions;
    }

    /**
     * @param permissions the permissions to set
     */
    public void setPermissions(String permissions) {
        this.permissions = permissions;
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
     * @return the href
     */
    public String getHref() {
        return href;
    }

    /**
     * @param href the href to set
     */
    public void setHref(String href) {
        this.href = href;
    }


@Override
public String toString() {
    String ret = "";
    try{
    ret =  new ObjectMapper().writeValueAsString(this);
    }catch(Exception e){
        e.printStackTrace();
    }
    return ret;
}






































}
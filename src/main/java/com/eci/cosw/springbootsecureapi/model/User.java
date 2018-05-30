package com.eci.cosw.springbootsecureapi.model;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
public class User
{

    private String phoneNumber;
    private String document;


    public User()
    {
    }

    public User( String phoneNumber, String document)
    {
        this.phoneNumber = phoneNumber;
        this.document = document;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the document
     */
    public String getDocument() {
        return document;
    }

    /**
     * @param document the identification to set
     */
    public void setDocument(String document) {
        this.document = document;
    }


    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Felipe
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
    @XmlElement
    private String street;
    @XmlElement
    private int exteriorNumber;
    @XmlElement
    private String suburb;
    @XmlElement
    private String city;

    public Address() {
    }    

    public Address(String street, int exteriorNumber, String suburb, String city) {
        this.street = street;
        this.exteriorNumber = exteriorNumber;
        this.suburb = suburb;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getExteriorNumber() {
        return exteriorNumber;
    }

    public void setExteriorNumber(int exteriorNumber) {
        this.exteriorNumber = exteriorNumber;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    
}

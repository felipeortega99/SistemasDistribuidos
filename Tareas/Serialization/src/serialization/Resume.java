/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialization;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Felipe
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Resume {
    @XmlElement
    private String name;
    @XmlElement
    private String cel;
    @XmlElement
    @XmlJavaTypeAdapter(Base64Adapter.class)
    private byte[] photo;    
    @XmlElement    
    private Email email;   
    @XmlElement
    private String birthPlace;    
    @XmlElement
    private Address address;
    @XmlElementWrapper
    @XmlElement(name="job")
    private List<Job> jobs;

    public Resume() {
    }                

    public Resume(String name, String cel, Email email, byte[] photo, String birthPlace, Address address, List<Job> jobs) {
        this.name = name;
        this.cel = cel;
        this.photo = photo;
        this.email = email;
        this.birthPlace = birthPlace;
        this.address = address;
        this.jobs = jobs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }
        
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
    
    public void addJob(Job job) {
        if(this.jobs == null)
            this.jobs = new ArrayList<Job>();
        
        this.jobs.add(job);
    }
    
}
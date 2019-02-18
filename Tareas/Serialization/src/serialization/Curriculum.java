/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialization;

import java.util.List;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Felipe
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Curriculum {
    @XmlElement
    private String name;
    @XmlElement(name="phone")
    private String cel;
    @XmlElement
    private String birthplace;    
    @XmlElement
    private Email email;
    @XmlElement(name="photo")
    @XmlJavaTypeAdapter(Base64Adapter.class)
    private byte[] photo;               
    @XmlElement
    private Address address;
    @XmlElementWrapper(name="jobs")
    @XmlElement(name="job")
    private List<Job> jobs;

    public Curriculum() {
    }                

    public Curriculum(String name, String cel, String birthplace, Email email, byte[] photo, Address address, List<Job> jobs) {
        this.name = name;
        this.cel = cel;
        this.birthplace = birthplace;
        this.email = email;
        this.photo = photo;
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

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
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
    
    
}
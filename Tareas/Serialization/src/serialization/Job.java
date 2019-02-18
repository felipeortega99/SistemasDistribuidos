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
public class Job {
    @XmlElement
    private String position;
    @XmlElement
    private String company;    
    @XmlElement
    private String startdate;
    @XmlElement
    private String enddate;    

    public Job() {
    }

    public Job(String position, String company, String startdate, String enddate) {
        this.position = position;
        this.company = company;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
}

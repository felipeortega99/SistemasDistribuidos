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
    private String startDate;
    @XmlElement
    private String endDate;
    @XmlElement
    private String companyName;
    @XmlElement
    private String position;

    public Job() {
    }

    public Job(String startDate, String endDate, String companyName, String position) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.companyName = companyName;
        this.position = position;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }    
    
}

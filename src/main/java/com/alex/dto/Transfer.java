package com.alex.dto;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "transfer")
public class Transfer {
    private long id;
    private User userFrom;
    private User userTo;
    private double ammount;
    private Date updated;
        
      
    public Transfer() {}
 
    public Transfer(long id, User userFrom, User userTo, double ammount) {
    	this.id = id;
    	this.userFrom = userFrom;
        this.userTo = userTo;
        this.ammount = ammount;
        this.updated = new Date();        
        }
    
    @XmlAttribute
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    
    @XmlElement
    public User getUserFrom() {
		return this.userFrom;
	}
    
    @XmlElement
	public User getUserTo() {
		return this.userTo;
	}

    @XmlElement
	public double getAmmount() {
		return this.ammount;
	}
    
    @XmlElement
	public Date getUpdated() {
		return this.updated;
	}

	public void setUserFrom(User userFrom) {
		this.userFrom = userFrom;
	}

	public void setUserTo(User userTo) {
		this.userTo = userTo;
	}

	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
  
        

    @Override
    public String toString() {
        return new StringBuffer(" Id : ").append(this.id)
                .append(" Ammount : ").append(this.ammount).toString();
    }
}
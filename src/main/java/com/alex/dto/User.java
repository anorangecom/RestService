package com.alex.dto;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class User {
	private int id;
    private String login;
    private double balance;
    private Date created;
    
    
    public User() {}
 
    public User(int id, String login, double balance) {
        this.id = id;
        this.login = login;
        this.balance = balance;
        this.created = new Date();
    	}


    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
    

    public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
    public String toString() {
        return new StringBuffer(" Id : ").append(this.id)
        		.append(" Login : ").append(this.login)
                .append(" Balance : ").append(this.balance)
                .append(" Created : ").append(this.created).toString();
    }
    
    
    
   
    
}
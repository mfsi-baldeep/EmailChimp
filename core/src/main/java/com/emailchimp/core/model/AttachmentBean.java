/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emailchimp.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

/**
 *
 * @author anshul
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttachmentBean implements Serializable{
    
    private String name;
    private String sName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

	@Override
	public String toString() {
		return "AttachmentBean [name=" + name + ", sName=" + sName + "]";
	}
    
    
}

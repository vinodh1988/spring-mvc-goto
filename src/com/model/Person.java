package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Entity
@Table(name="person")
@Component
@Scope(value="prototype",proxyMode=ScopedProxyMode.TARGET_CLASS)
@XmlRootElement(name="person")
public class Person implements Serializable
{

	static final long serialVersionUID = 1L;
	@Id
	private Integer sno;
	@Column
	private String name;
	@Column
	private String city;
	public Integer getSno() {
		return sno;
	}
	@XmlElement
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	@XmlElement
	public void setCity(String city) {
		this.city = city;
	}
	
	
}

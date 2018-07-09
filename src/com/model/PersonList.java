package com.model;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component; 

@XmlRootElement(name="person-list")
@Component
public class PersonList {
    private List<Person> personList;
    
    @XmlElement(name="person")
	public List<Person> getPersonList() {
		return personList;
	}

	
	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}
    
    
    
}


 
  

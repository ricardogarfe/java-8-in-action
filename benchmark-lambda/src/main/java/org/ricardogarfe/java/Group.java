package org.ricardogarfe.java;

import java.util.List;
import java.util.ArrayList;

public class Group {
	
	private List<Person> persons;

	public Group () {
    this.persons = new ArrayList<Person>();
	}

	public void addPersonToGroup (Person person) {
		this.persons.add(person);
	}
	
	public List<Person> getPersons() {
		return this.persons;
	}
}
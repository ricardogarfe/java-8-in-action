package org.ricardogarfe.java;

import java.util.ArrayList;
import java.util.List;

public class Group {

  private List<Person> persons;

  public Group() {
    this.persons = new ArrayList<>();
  }

  public void addPersonToGroup(Person person) {
    this.persons.add(person);
  }

  public List<Person> getPersons() {
    return this.persons;
  }
}
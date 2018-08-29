package io.github.oliviercailloux.y2018.j_biblio_session_2.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.oliviercailloux.y2018.j_biblio_session_2.AuthoritativePerson;
import io.github.oliviercailloux.y2018.j_biblio_session_2.Person;

public class ServletEquals {
	private Map<Person,HashMap<Person,Person>> mapPerson;
	
	public ServletEquals()
	{
		this.mapPerson = new HashMap<Person,HashMap<Person,Person>>();
	}
	
	public void SetEquals (Person user, Person person, Person authoritative_person, boolean equal)
	{
		AuthoritativePerson ap = (AuthoritativePerson) authoritative_person;
		ap.setAuthoritative(true);
		HashMap<Person,Person> mapEqualPerson = new HashMap<Person,Person>();
		if (equal)
		{		
			mapEqualPerson.put(ap,person);
			this.mapPerson.put(user,mapEqualPerson);
		}
	}
	@SuppressWarnings("unchecked")
	public List<Person> GetEquals(Person user, Person authoritative_person)
	{
		List<Person> listPerson = (List<Person>) this.mapPerson.get(user).get(authoritative_person);
		return listPerson;
	}
	public Map<Person, HashMap<Person, Person>> getMapPerson() {
		return mapPerson;
	}
	public void setMapPerson(Map<Person, HashMap<Person, Person>> mapPerson) {
		this.mapPerson = mapPerson;
	}
}

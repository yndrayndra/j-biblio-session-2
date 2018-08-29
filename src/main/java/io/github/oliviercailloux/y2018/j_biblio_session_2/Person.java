package io.github.oliviercailloux.y2018.j_biblio_session_2;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
//import javax.json.bind.JsonbConfig;

public class Person 
{
	private Name authorityName;
	private List<Name> otherNames;
	private String title;
	private Optional<Instant> date;
	private String designation;
	private List<Work> works;
	
	private Origin origin;
	
	/** Person constructor. **/
	public Person(Name authorityName, List<Name> otherNames, String title, Instant date, String designation, String source) 
	{
		this.origin = new Origin(Instant.now(), source);
		this.works = new ArrayList<Work>(); 
		this.otherNames = otherNames;
		this.authorityName = Objects.requireNonNull(authorityName);
		
		if(title == null)
			this.title = "";
		else
			this.title = title;
		
		this.date = Optional.of(date);
		
		if(designation == null)
			this.designation = null;
		else
			this.designation = designation;
	}
	
	
	public Person()
	{
	}

	/** Exports a Person to JSON format. **/
	public String txtExport() 
	{
		
		Jsonb jsonb = JsonbBuilder.create();
		String result = jsonb.toJson(this);
		return result;
		
	}
	
	public List<Work> getWorks() {
		return works;
	}

	/** Checks if the added work belongs to the right person **/
	public void addWork(Work work) {		
		if(work.getPerson().getName().equals(this.authorityName))
		{
			this.works.add(work);
		}
		
	}
	public void setWork(List<Work> works) {
		this.works = works;
	}

	public Name getName() {
		return this.authorityName;
	}
	
	public void setName(Name authorityName) {
		this.authorityName = Objects.requireNonNull(authorityName);
	}
	public List<Name> getotherNames() {
		return otherNames;
	}


	public void setotherNames(List<Name> otherNames) {
		this.otherNames = otherNames;
	}
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Instant getDate() {
		return date.get();
	}
	
	public void setDate(Instant date) {
		this.date = Optional.of(date);
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Origin getOrigin() {
		return origin;
	}


	public void setOrigin(Origin origin) {
		this.origin = origin;
	}


	@Override
	public String toString() 
	{
		return "Person [name=" + this.authorityName.toString() 
							   + ", title=" + this.title 
							   + ", date=" + this.date 
							   + ", designation=" + this.designation
							   + ", origin=" + this.origin.toString() + "]";
	}



}
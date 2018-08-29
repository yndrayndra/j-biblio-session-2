package io.github.oliviercailloux.y2018.j_biblio_session_2;


import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class Work {
	private String title;
	private String form;
	private String intendedAudiance;
	private String context;
	private String distinguishingCharacteristic;
	private boolean intendedTermination;
	private Optional<Instant> date;
	private Origin origin;
	private List<Expression> expressions;
	private Person person;
	
	public Work(String title, 
				String form, 
				String intendedAudiance, 
				String context, 
				String distinguishingCharacteristic,
				boolean intendedTermination,
				Instant date, 
				Person person, 
				String source)
	{
		origin = new Origin(Instant.now(),source);
		
		if(title == null)
			this.title = "";
		else
			this.title = title;
		
		if(form == null)
			this.form = "";
		else
			this.form = form;
		
		if(intendedAudiance == null)
			this.intendedAudiance = "";
		else
			this.intendedAudiance = intendedAudiance;
		
		if(context == null)
			this.context = "";
		else
			this.context = context;
		
		if(distinguishingCharacteristic == null)
			this.distinguishingCharacteristic = "";
		else
			this.distinguishingCharacteristic = distinguishingCharacteristic;
		
		this.intendedTermination = intendedTermination;
		this.date = Optional.of(date);
		this.expressions = new ArrayList<Expression>();
		this.person = person;
		//person.addWork(this); //add the work to the person
		
	}
	
	public Work()
	{	
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if(title == null)
			this.title = "";
		else
			this.title = title;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		if(form == null)
			this.form = "";
		else
			this.form = form;
	}

	public String getIntendedAudiance() {
		return intendedAudiance;
	}

	public void setIntendedAudiance(String intendedAudiance) {
		if(intendedAudiance == null)
			this.intendedAudiance = "";
		else
			this.intendedAudiance = intendedAudiance;
		}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		if(context == null)
			this.context = "";
		else
			this.context = context;
	}

	public String getDistinguishingCharacteristic() {
		return distinguishingCharacteristic;
	}

	public void setDistinguishingCharacteristic(String distinguishingCharacteristic) {
		if(distinguishingCharacteristic == null)
			this.distinguishingCharacteristic = "";
		else
			this.distinguishingCharacteristic = distinguishingCharacteristic;	}

	public boolean isIntendedTermination() {
		return intendedTermination;
	}

	public void setIntendedTermination(boolean intendedTermination) {
		this.intendedTermination = intendedTermination;
	}

	public Instant getDate() {
		return date.get();
	}

	public void setDate(Instant date) {
		this.date = Optional.of(date);
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public List<Expression> getExpressions() {
		return expressions;
	}

	public void setExpressions(List<Expression> expressions) {
		this.expressions = expressions;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		String expression = "";
		for (Expression exp: expressions)
		{
			expression += exp.toString() + ";";
		}
		return "Work [title=" + this.title 
				+ ", form=" + this.form 
				+ ", intendedAudiance=" + this.intendedAudiance 
				+ ", context=" + this.context 
				+ ", distinguishingCharacteristic=" + this.distinguishingCharacteristic 
				+ ", intendedTermination="+ this.intendedTermination 
				+ ", date=" + this.date 
				+ ", origin=" + this.origin.toString() 
				+ ", expressions=" + expression
				+ ", person=" + this.person.toString() + "]";
	}

	/** Exports a Work to JSON format. **/
	public String txtExport() {
		
		Jsonb jsonb = JsonbBuilder.create();
		String result = jsonb.toJson(this);
		return result;
	}
}

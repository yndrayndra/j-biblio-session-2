package io.github.oliviercailloux.y2018.j_biblio_session_2;

import java.time.Instant;


public class Origin {
	private Instant date;
	private String source;
	
	public Origin(Instant date, String source) 
	{
		this.date = date;
		this.source = source;
	}
	
	public Origin()
	{}
	
	@Override
	public String toString() {
		return "Origin [date=" + this.date + ", source=" + this.source + "]";
	}

	public Instant getDate() {
		return this.date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
}

package io.github.oliviercailloux.y2018.j_biblio_session_2;

import java.time.Instant;
import java.util.List;

public class AuthoritativePerson extends Person {
	/** 
	 * Ce champ permet de designer si 
	 * la personne est un Authority 
	 *
	 */
	private boolean authoritative;
	
	public AuthoritativePerson(Name authorityName, 
						  List<Name> otherNames,
						  String title, 
						  Instant date, 
						  String designation, 
						  String source, boolean authoritative)
	{
		super(authorityName,otherNames, title, date, designation, source);
		this.authoritative = authoritative;
	}


	public boolean isAuthoritative() {
		return this.authoritative;
	}
	public void setAuthoritative(boolean authoritative) {
		this.authoritative = authoritative;
	}	

}

package io.github.oliviercailloux.y2018.j_biblio_session_2.web;

import io.github.oliviercailloux.y2018.j_biblio_session_2.Expression;
import io.github.oliviercailloux.y2018.j_biblio_session_2.Item;
import io.github.oliviercailloux.y2018.j_biblio_session_2.ListeObjet;
import io.github.oliviercailloux.y2018.j_biblio_session_2.Manifestation;
import io.github.oliviercailloux.y2018.j_biblio_session_2.Person;
import io.github.oliviercailloux.y2018.j_biblio_session_2.Work;

public class ServletsSet {
	
	private ListeObjet liste;
	public ServletsSet()
	{}
	
	public int PutWork(Work work)
	{

		int id = this.liste.getWorks().size();
		liste.getWorks().put(id+1, work);
		return id+1;
	}
	public int PutExpression(Expression expression)
	{
		int id = this.liste.getExpressions().size();
		liste.getExpressions().put(id+1, expression);
		return id+1;
	}
	public int PutItem(Item item)
	{
		int id = this.liste.getItems().size();
		liste.getItems().put(id+1, item);
		return id+1;
	}
	public int PutManifestation(Manifestation manifestation)
	{
		int id = this.liste.getManifestations().size();
		liste.getManifestations().put(id+1, manifestation);
		return id+1;
	}
	public int PutPerson(Person person)
	{
		int id = this.liste.getPersons().size();
		liste.getPersons().put(id+1, person);
		return id+1;
	}
	
	public void setListe(ListeObjet liste) {
		this.liste = liste;
	}	
}

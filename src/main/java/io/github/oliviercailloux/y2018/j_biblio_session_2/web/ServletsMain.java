package io.github.oliviercailloux.y2018.j_biblio_session_2.web;

import io.github.oliviercailloux.y2018.j_biblio_session_2.Expression;
import io.github.oliviercailloux.y2018.j_biblio_session_2.Item;
import io.github.oliviercailloux.y2018.j_biblio_session_2.ListeObjet;
import io.github.oliviercailloux.y2018.j_biblio_session_2.Manifestation;
import io.github.oliviercailloux.y2018.j_biblio_session_2.Person;
import io.github.oliviercailloux.y2018.j_biblio_session_2.Work;

public class ServletsMain {

	public ListeObjet liste;
	public ServletsMain()
	{}
	public Work GetWork(int id)
	{
		return this.liste.getWorks().get(id);
	}
	public Expression GetExpression(int id)
	{
		return this.liste.getExpressions().get(id);
	}
	public Item GetItem(int id)
	{
		return this.liste.getItems().get(id);
	}
	public Manifestation GetManifestation(int id)
	{
		return this.liste.getManifestations().get(id);
	}
	public Person GetPerson(int id)
	{
		return this.liste.getPersons().get(id);
	}
	public void setListe(ListeObjet liste) {
		this.liste = liste;
	}
	public ListeObjet getListe() {
		return liste;
	}
}

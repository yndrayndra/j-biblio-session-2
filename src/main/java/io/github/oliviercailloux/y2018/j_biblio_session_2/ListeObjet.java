package io.github.oliviercailloux.y2018.j_biblio_session_2;

import java.util.HashMap;
import java.util.Map;

public class ListeObjet {
	/**
	 * Cette classe sert de base pour stocker les donnees.
	 * Pour chaque objet, on essaye de creer une table de type 
	 * Map<Integer,List<Objet>> 
	 * ou Integer est la valeur de la cle et
	 * List<Objet> contient les objets ayant cette cle
	 * 
	 */
	private Map<Integer,Person> persons;
	private Map<Integer,Work> works;
	private Map<Integer,Manifestation> manifestations;
	private Map<Integer,Expression> expressions;
	private Map<Integer,Item> items;
	
	public ListeObjet()
	{
		this.persons = new HashMap<Integer,Person>();
		this.works = new HashMap<Integer,Work>();
		this.manifestations = new HashMap<Integer,Manifestation>();
		this.expressions = new HashMap<Integer,Expression>();
		this.items = new HashMap<Integer,Item>();
	}

	public Map<Integer, Person> getPersons() {
		return persons;
	}

	public void setPersons(Map<Integer, Person> persons) {
		this.persons = persons;
	}

	public Map<Integer, Work> getWorks() {
		return works;
	}

	public void setWorks(Map<Integer, Work> works) {
		this.works = works;
	}

	public Map<Integer, Manifestation> getManifestations() {
		return manifestations;
	}

	public void setManifestations(Map<Integer, Manifestation> manifestations) {
		this.manifestations = manifestations;
	}

	public Map<Integer, Expression> getExpressions() {
		return expressions;
	}

	public void setExpressions(Map<Integer, Expression> expressions) {
		this.expressions = expressions;
	}

	public Map<Integer, Item> getItems() {
		return items;
	}

	public void setItems(Map<Integer, Item> items) {
		this.items = items;
	}
}

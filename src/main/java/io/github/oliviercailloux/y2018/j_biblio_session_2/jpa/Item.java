package io.github.oliviercailloux.y2018.j_biblio_session_2.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ITEM database table.
 * 
 */
@Entity
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String accessrestrictions;

	private String exhibitionhistory;

	private String fingerprint;

	private String intemprovenance;

	private String itemcondition;

	private String marks;

	private String source;

	//bi-directional many-to-one association to Manifestation
	@ManyToOne
	@JoinColumn(name="IDMANIFESTATION")
	private Manifestation manifestation;

	public Item() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccessrestrictions() {
		return this.accessrestrictions;
	}

	public void setAccessrestrictions(String accessrestrictions) {
		this.accessrestrictions = accessrestrictions;
	}

	public String getExhibitionhistory() {
		return this.exhibitionhistory;
	}

	public void setExhibitionhistory(String exhibitionhistory) {
		this.exhibitionhistory = exhibitionhistory;
	}

	public String getFingerprint() {
		return this.fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	public String getIntemprovenance() {
		return this.intemprovenance;
	}

	public void setIntemprovenance(String intemprovenance) {
		this.intemprovenance = intemprovenance;
	}

	public String getItemcondition() {
		return this.itemcondition;
	}

	public void setItemcondition(String itemcondition) {
		this.itemcondition = itemcondition;
	}

	public String getMarks() {
		return this.marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Manifestation getManifestation() {
		return this.manifestation;
	}

	public void setManifestation(Manifestation manifestation) {
		this.manifestation = manifestation;
	}

}
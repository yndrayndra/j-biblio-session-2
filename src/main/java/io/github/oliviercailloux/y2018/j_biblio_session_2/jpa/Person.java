package io.github.oliviercailloux.y2018.j_biblio_session_2.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PERSON database table.
 * 
 */
@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String authorityname;

	@Temporal(TemporalType.DATE)
	private Date dateperson;

	private String designation;

	private String othernames;

	private String source;

	private String title;

	//bi-directional many-to-one association to Workentity
	@OneToMany(mappedBy="person")
	private List<Workentity> workentities;

	public Person() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthorityname() {
		return this.authorityname;
	}

	public void setAuthorityname(String authorityname) {
		this.authorityname = authorityname;
	}

	public Date getDateperson() {
		return this.dateperson;
	}

	public void setDateperson(Date dateperson) {
		this.dateperson = dateperson;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getOthernames() {
		return this.othernames;
	}

	public void setOthernames(String othernames) {
		this.othernames = othernames;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Workentity> getWorkentities() {
		return this.workentities;
	}

	public void setWorkentities(List<Workentity> workentities) {
		this.workentities = workentities;
	}

	public Workentity addWorkentity(Workentity workentity) {
		getWorkentities().add(workentity);
		workentity.setPerson(this);

		return workentity;
	}

	public Workentity removeWorkentity(Workentity workentity) {
		getWorkentities().remove(workentity);
		workentity.setPerson(null);

		return workentity;
	}

}
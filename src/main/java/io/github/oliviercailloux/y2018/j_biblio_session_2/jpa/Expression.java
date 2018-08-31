package io.github.oliviercailloux.y2018.j_biblio_session_2.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the EXPRESSION database table.
 * 
 */
@Entity
@NamedQuery(name="Expression.findAll", query="SELECT e FROM Expression e")
public class Expression implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String context;

	private String criticalresponse;

	@Temporal(TemporalType.DATE)
	private Date dateexpression;

	private String form;

	private String langage;

	private short revisability;

	private String source;

	private String summarization;

	private String title;

	private String userrestrictions;

	//bi-directional many-to-one association to Workentity
	@ManyToOne
	@JoinColumn(name="IDWORK")
	private Workentity workentity;

	public Expression() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getCriticalresponse() {
		return this.criticalresponse;
	}

	public void setCriticalresponse(String criticalresponse) {
		this.criticalresponse = criticalresponse;
	}

	public Date getDateexpression() {
		return this.dateexpression;
	}

	public void setDateexpression(Date dateexpression) {
		this.dateexpression = dateexpression;
	}

	public String getForm() {
		return this.form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getLangage() {
		return this.langage;
	}

	public void setLangage(String langage) {
		this.langage = langage;
	}

	public short getRevisability() {
		return this.revisability;
	}

	public void setRevisability(short revisability) {
		this.revisability = revisability;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSummarization() {
		return this.summarization;
	}

	public void setSummarization(String summarization) {
		this.summarization = summarization;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserrestrictions() {
		return this.userrestrictions;
	}

	public void setUserrestrictions(String userrestrictions) {
		this.userrestrictions = userrestrictions;
	}

	public Workentity getWorkentity() {
		return this.workentity;
	}

	public void setWorkentity(Workentity workentity) {
		this.workentity = workentity;
	}

}
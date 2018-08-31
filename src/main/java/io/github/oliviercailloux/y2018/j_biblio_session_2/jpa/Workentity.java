package io.github.oliviercailloux.y2018.j_biblio_session_2.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the WORKENTITY database table.
 * 
 */
@Entity
@NamedQuery(name="Workentity.findAll", query="SELECT w FROM Workentity w")
public class Workentity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date datework;

	private String distinguishingcharacteristic;

	private String form;

	private String intendedaudience;

	private short intendedtermination;

	private String source;

	private String title;

	//bi-directional many-to-one association to Expression
	@OneToMany(mappedBy="workentity")
	private List<Expression> expressions;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="IDPERSON")
	private Person person;

	public Workentity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatework() {
		return this.datework;
	}

	public void setDatework(Date datework) {
		this.datework = datework;
	}

	public String getDistinguishingcharacteristic() {
		return this.distinguishingcharacteristic;
	}

	public void setDistinguishingcharacteristic(String distinguishingcharacteristic) {
		this.distinguishingcharacteristic = distinguishingcharacteristic;
	}

	public String getForm() {
		return this.form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getIntendedaudience() {
		return this.intendedaudience;
	}

	public void setIntendedaudience(String intendedaudience) {
		this.intendedaudience = intendedaudience;
	}

	public short getIntendedtermination() {
		return this.intendedtermination;
	}

	public void setIntendedtermination(short intendedtermination) {
		this.intendedtermination = intendedtermination;
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

	public List<Expression> getExpressions() {
		return this.expressions;
	}

	public void setExpressions(List<Expression> expressions) {
		this.expressions = expressions;
	}

	public Expression addExpression(Expression expression) {
		getExpressions().add(expression);
		expression.setWorkentity(this);

		return expression;
	}

	public Expression removeExpression(Expression expression) {
		getExpressions().remove(expression);
		expression.setWorkentity(null);

		return expression;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
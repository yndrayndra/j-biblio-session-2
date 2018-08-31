package io.github.oliviercailloux.y2018.j_biblio_session_2.jpa.servlets;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;

import io.github.oliviercailloux.y2018.j_biblio_session_2.jpa.Expression;
import io.github.oliviercailloux.y2018.j_biblio_session_2.jpa.Person;
import io.github.oliviercailloux.y2018.j_biblio_session_2.jpa.Workentity;

@ManagedBean
@SessionScoped
public class SetDBWork implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Workentity we;
	
	public SetDBWork(){}
	
	public String insertWork(){
		
		String retour = "";
		
		Workentity we = null;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("j-biblio-session-2");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(getWe());
		et.commit();
		we = em.find(Workentity.class,getId());
		if (we == null )
		{ return "Insertion non effectuee ";}
		else{
		retour = "Insertion effectuee";	}	
		return retour;		
	}
		

	public List<Workentity> listWork(){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("j-biblio-session-2");
		
		EntityManager em = emf.createEntityManager();

		@SuppressWarnings("unchecked")
		ArrayList<Workentity> listeWork = (ArrayList<Workentity>) em.createQuery("SELECT w FROM Workentity w").getResultList();
		
		return listeWork; 
	}
	
	
	
	public Workentity getWe() {
		return we;
	}

	public void setWe(Workentity we) {
		this.we = we;
	}

	public int getId() {
		if(we ==null){
			we = new Workentity();
		}
	   return getWe().getId();
	}

	public void setId(int id) {
		getWe().setId(id);
	}

	public Date getDatework() {
		if(we ==null){
			we = new Workentity();
		}	
		return getWe().getDatework();
	}

	public void setDatework(Date datework) {
		getWe().setDatework(datework);
	}

	public String getDistinguishingcharacteristic() {
		if(we ==null){
			we = new Workentity();
		}
		return getWe().getDistinguishingcharacteristic();
	}

	public void setDistinguishingcharacteristic(String distinguishingcharacteristic) {
		getWe().setDistinguishingcharacteristic(distinguishingcharacteristic);
	}

	public String getForm() {
		if(we ==null){
			we = new Workentity();
		}
		return getWe().getForm();
	}

	public void setForm(String form) {
		getWe().setForm(form);
	}

	public String getIntendedaudience() {
		if(we ==null){
			we = new Workentity();
		}
		return getWe().getIntendedaudience();
	}

	public void setIntendedaudience(String intendedaudience) {
		getWe().setIntendedaudience(intendedaudience);
	}

	public short getIntendedtermination() {
		if(we ==null){
			we = new Workentity();
		}
		return getWe().getIntendedtermination();
	}

	public void setIntendedtermination(short intendedtermination) {
		 getWe().setIntendedtermination(intendedtermination);
	}

	public String getSource() {
		if(we ==null){
			we = new Workentity();
		}
		return getWe().getSource();
	}

	public void setSource(String source) {
		getWe().setSource(source);
	}

	public String getTitle() {
		if(we ==null){
			we = new Workentity();
		}
		return getWe().getTitle();
	}

	public void setTitle(String title) {
		 getWe().setTitle(title);
	}

	public List<Expression> getExpressions() {
		if(we ==null){
			we = new Workentity();
		}
		return getWe().getExpressions();
	}

	public void setExpressions(List<Expression> expressions) {
		getWe().setExpressions(expressions);
	}

	public Expression addExpression(Expression expression) {
		getExpressions().add(expression);
		expression.setWorkentity(getWe());

		return expression;
	}

	public Expression removeExpression(Expression expression) {
		getExpressions().remove(expression);
		expression.setWorkentity(null);

		return expression;
	}

	public Person getPerson() {
		if(we ==null){
			we = new Workentity();
		}
		return getWe().getPerson();
	}

	public void setPerson(Person person) {
		getWe().setPerson(person);
	}
}

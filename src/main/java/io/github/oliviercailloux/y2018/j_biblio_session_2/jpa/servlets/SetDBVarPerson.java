package io.github.oliviercailloux.y2018.j_biblio_session_2.jpa.servlets;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import io.github.oliviercailloux.y2018.j_biblio_session_2.jpa.Person;
import io.github.oliviercailloux.y2018.j_biblio_session_2.jpa.Workentity;

@ManagedBean
@SessionScoped
public class SetDBVarPerson  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Person pers;
	
	public SetDBVarPerson(){}
	
	public String insertPerson(){
		
		String retour = "";
		
		Person pers = null;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("j-biblio-session-2");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(getPers());
		et.commit();
		pers = em.find(Person.class,getId());
		if (pers == null )
		{ return "Insertion non effectuee ";}
		else{
		retour = "Insertion effectuee";	}	
		return retour;		
	}
	
	public List<Person> listPerson(){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("j-biblio-session-2");
		
		EntityManager em = emf.createEntityManager();

		@SuppressWarnings("unchecked")
		ArrayList<Person> listePerson = (ArrayList<Person>) em.createQuery("SELECT p FROM Person p").getResultList();
		
		return listePerson;
	}
	
	public Person getPers() {
		return pers;
	}

	public void setPers(Person pers) {
		this.pers = pers;
	}

	public int getId() {
		if(pers ==null){
			pers= new Person();
	}
		return getPers().getId();
	}

	public void setId(int id) {
		getPers().setId(id);		
	}

	public String getAuthorityname() {
		if(pers ==null){
			pers= new Person();
	}
		return getPers().getAuthorityname();
	}

	public void setAuthorityname(String authorityname) {
		getPers().setAuthorityname(authorityname);
	}

	public Date getDateperson() {
		if(pers ==null){
			pers= new Person();
	}		
		return getPers().getDateperson();
	}

	public void setDateperson(Date dateperson) {
		getPers().setDateperson(dateperson);
	}

	public String getDesignation() {
		if(pers ==null){
			pers= new Person();
	}
		return getPers().getDesignation();
	}

	public void setDesignation(String designation) {
		getPers().setDesignation(designation);
	}

	public String getOthernames() {
		if(pers ==null){
			pers= new Person();
	}
		return getPers().getOthernames();
	}

	public void setOthernames(String othernames) {
		getPers().setOthernames(othernames);
	}

	public String getSource() {
		if(pers ==null){
			pers= new Person();
	}
		return getPers().getSource();
	}

	public void setSource(String source) {
		getPers().setSource(source);
	}

	public String getTitle() {
		if(pers ==null){
			pers= new Person();
	}
		return getPers().getTitle();
	}

	public void setTitle(String title) {
		getPers().setTitle(title);
	}

	public List<Workentity> getWorkentities() {
		if(pers ==null){
			pers= new Person();
	}
		return getPers().getWorkentities();
	}

	public void setWorkentities(List<Workentity> workentities) {
		getPers().setWorkentities(workentities);;
	}

	public Workentity addWorkentity(Workentity workentity) {
		getWorkentities().add(workentity);
		workentity.setPerson(getPers());

		return workentity;
	}

	public Workentity removeWorkentity(Workentity workentity) {
		getWorkentities().remove(workentity);
		workentity.setPerson(null);

		return workentity;
	}

}

package io.github.oliviercailloux.y2018.j_biblio_session_2.jpa.servlets;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import io.github.oliviercailloux.y2018.j_biblio_session_2.jpa.Item;
import io.github.oliviercailloux.y2018.j_biblio_session_2.jpa.Manifestation;

@ManagedBean
@SessionScoped
public class SetDBVarItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Item it;
	
	public SetDBVarItem(){}
	
	public String insertItem(){
		
		String retour = "";
		
		Item it= null;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("j-biblio-session-2");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(getIt());
		et.commit();
		it = em.find(Item.class,getId());
		if (it == null )
		{ return "Insertion non effectuee ";}
		else{
		retour = "Insertion effectuee";}		
		return retour;		
	}
	public List<Item> listItem(){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("j-biblio-session-2");
		
		EntityManager em = emf.createEntityManager();

		@SuppressWarnings("unchecked")
		ArrayList<Item> listeItem = (ArrayList<Item>) em.createQuery("SELECT i FROM Item i").getResultList();
		
		return listeItem;
	}
		
	public Item getIt() {
		return it;
	}

	public void setIt(Item it) {
		this.it = it;
	}

	public int getId() {
		if(it ==null){
			it = new Item();
	}
		return getIt().getId();
	}

	public void setId(int id) {
		getIt().setId(id);
	}

	public String getAccessrestrictions() {
		if(it ==null){
			it = new Item();
	}
		return getIt().getAccessrestrictions();
	}

	public void setAccessrestrictions(String accessrestrictions) {
		getIt().setAccessrestrictions(accessrestrictions);;
	}

	public String getExhibitionhistory() {
		if(it ==null){
			it = new Item();
	}
		return getIt().getExhibitionhistory();
	}

	public void setExhibitionhistory(String exhibitionhistory) {
		getIt().setExhibitionhistory(exhibitionhistory);
	}

	public String getFingerprint() {
		if(it ==null){
			it = new Item();
	}
		return getIt().getFingerprint();
	}

	public void setFingerprint(String fingerprint) {
		getIt().setFingerprint(fingerprint);
	}

	public String getIntemprovenance() {
		if(it ==null){
			it = new Item();
	}
		return getIt().getIntemprovenance();
	}

	public void setIntemprovenance(String intemprovenance) {
		getIt().setIntemprovenance(intemprovenance);
	}

	public String getItemcondition() {
		if(it ==null){
			it = new Item();
	}
		return getIt().getItemcondition();
	}

	public void setItemcondition(String itemcondition) {
		getIt().setItemcondition(itemcondition);
	}

	public String getMarks() {
		if(it ==null){
			it = new Item();
	}
		return getIt().getMarks();
	}

	public void setMarks(String marks) {
		getIt().setMarks(marks);;
	}

	public String getSource() {
		if(it ==null){
			it = new Item();
	}
		return getIt().getSource();
	}

	public void setSource(String source) {
		getIt().setSource(source);
	}

	public Manifestation getManifestation() {
		if(it ==null){
			it = new Item();
	}
		return getIt().getManifestation();
	}

	public void setManifestation(Manifestation manifestation) {
		getIt().setManifestation(manifestation);
	}


}

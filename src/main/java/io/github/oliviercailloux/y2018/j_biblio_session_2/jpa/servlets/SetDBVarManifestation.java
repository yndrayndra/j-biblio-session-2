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

import io.github.oliviercailloux.y2018.j_biblio_session_2.jpa.Item;
import io.github.oliviercailloux.y2018.j_biblio_session_2.jpa.Manifestation;


@ManagedBean
@SessionScoped
public class SetDBVarManifestation implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Manifestation manif ;
	
	public SetDBVarManifestation(){}
	
	public String insertManifestation(){
		
		String retour = "";
		
		 Manifestation manif = null;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("j-biblio-session-2");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(getManif());
		et.commit();
		manif = em.find(Manifestation.class,getId());
		if (manif == null )
		{ return "Insertion non effectuee ";}
		else{
		retour = "Insertion effectuee";}		
		return retour;		
	}
	public List<Manifestation> listManifestation(){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("j-biblio-session-2");
		
		EntityManager em = emf.createEntityManager();

		@SuppressWarnings("unchecked")
		ArrayList<Manifestation> listeManifestation = (ArrayList<Manifestation>) em.createQuery("SELECT m FROM Manifestation m").getResultList();
		
		return listeManifestation;
	}
	public Manifestation getManif() {
		return manif;
	}

	public void setManif(Manifestation manif) {
		this.manif = manif;
	}

	public int getId() {
		if(manif ==null){
			manif = new Manifestation();
	}
		return getManif().getId();
	}

	public void setId(int id) {
		getManif().setId(id);
	}

	public String getAccessrestrictions() {
		if(manif ==null){
			manif = new Manifestation();
	}
		return getManif().getAccessrestrictions();
	}

	public void setAccessrestrictions(String accessrestrictions) {
		getManif().setAccessrestrictions(accessrestrictions);
	}

	public Date getDateofpublication() {
		if(manif ==null){
			manif = new Manifestation();
	}
		return getManif().getDateofpublication();
	}

	public void setDateofpublication(Date dateofpublication) {
		getManif().setDateofpublication(dateofpublication);
	}

	public String getEdition() {
		if(manif ==null){
			manif = new Manifestation();
	}
		return getManif().getEdition();
	}

	public void setEdition(String edition) {
		getManif().setEdition(edition);
	}

	public int getExpressionid() {
		if(manif ==null){
			manif = new Manifestation();
	}
		return getManif().getExpressionid();
	}

	public void setExpressionid(int expressionid) {
		getManif().setExpressionid(expressionid);;
	}

	public String getFabricator() {
		if(manif ==null){
			manif = new Manifestation();
	}
		return getManif().getFabricator();
	}

	public void setFabricator(String fabricator) {
		getManif().setFabricator(fabricator);
	}

	public String getPlaceofpublication() {
		if(manif ==null){
			manif = new Manifestation();
	}
		return getManif().getPlaceofpublication();
	}

	public void setPlaceofpublication(String placeofpublication) {
		getManif().setPlaceofpublication(placeofpublication);
	}

	public String getPublisher() {
		if(manif ==null){
			manif = new Manifestation();
	}
		return getManif().getPublisher();
	}

	public void setPublisher(String publisher) {
		getManif().setPublisher(publisher);
	}

	public String getResponsabilities() {
		if(manif ==null){
			manif = new Manifestation();
	}
		return getManif().getResponsabilities();
	}

	public void setResponsabilities(String responsabilities) {
		getManif().setResponsabilities(responsabilities);
	}

	public String getSeriestatement() {
		if(manif ==null){
			manif = new Manifestation();
	}
		return getManif().getSeriestatement();
	}

	public void setSeriestatement(String seriestatement) {
		getManif().setSeriestatement(seriestatement);
	}

	public String getSource() {
		if(manif ==null){
			manif = new Manifestation();
	}
		return getManif().getSource();
	}

	public void setSource(String source) {
		getManif().setSource(source);
	}

	public String getSourceforacquisition() {
		if(manif ==null){
			manif = new Manifestation();
	}
		return getManif().getSourceforacquisition();
	}

	public void setSourceforacquisition(String sourceforacquisition) {
		getManif().setSourceforacquisition(sourceforacquisition);;
	}

	public String getTermsofavailability() {
		if(manif ==null){
			manif = new Manifestation();
	}
		return getManif().getTermsofavailability();
	}

	public void setTermsofavailability(String termsofavailability) {
		getManif().setTermsofavailability(termsofavailability);
	}

	public String getTitle() {
		if(manif ==null){
			manif = new Manifestation();
	}
		return getManif().getTitle();
	}

	public void setTitle(String title) {
		getManif().setTitle(title);
	}

	public String getTypeface() {
		if(manif ==null){
			manif = new Manifestation();
	}
		return getManif().getTypeface();
	}

	public void setTypeface(String typeface) {
		getManif().setTypeface(typeface);
	}

	public int getTypesize() {
		if(manif ==null){
			manif = new Manifestation();
	}
		return getManif().getTypesize();
	}

	public void setTypesize(int typesize) {
		getManif().setTypesize(typesize);
	}

	public List<Item> getItems() {
		if(manif ==null){
			manif = new Manifestation();
	}
		return getManif().getItems();
	}

	public void setItems(List<Item> items) {
		getManif().setItems(items);
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setManifestation(getManif());

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setManifestation(null);

		return item;
	}
}

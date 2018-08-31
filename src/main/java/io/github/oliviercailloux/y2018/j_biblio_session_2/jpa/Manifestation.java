package io.github.oliviercailloux.y2018.j_biblio_session_2.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MANIFESTATION database table.
 * 
 */
@Entity
@NamedQuery(name="Manifestation.findAll", query="SELECT m FROM Manifestation m")
public class Manifestation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String accessrestrictions;

	@Temporal(TemporalType.DATE)
	private Date dateofpublication;

	private String edition;

	private int expressionid;

	private String fabricator;

	private String placeofpublication;

	private String publisher;

	private String responsabilities;

	private String seriestatement;

	private String source;

	private String sourceforacquisition;

	private String termsofavailability;

	private String title;

	private String typeface;

	private int typesize;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="manifestation")
	private List<Item> items;

	public Manifestation() {
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

	public Date getDateofpublication() {
		return this.dateofpublication;
	}

	public void setDateofpublication(Date dateofpublication) {
		this.dateofpublication = dateofpublication;
	}

	public String getEdition() {
		return this.edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public int getExpressionid() {
		return this.expressionid;
	}

	public void setExpressionid(int expressionid) {
		this.expressionid = expressionid;
	}

	public String getFabricator() {
		return this.fabricator;
	}

	public void setFabricator(String fabricator) {
		this.fabricator = fabricator;
	}

	public String getPlaceofpublication() {
		return this.placeofpublication;
	}

	public void setPlaceofpublication(String placeofpublication) {
		this.placeofpublication = placeofpublication;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getResponsabilities() {
		return this.responsabilities;
	}

	public void setResponsabilities(String responsabilities) {
		this.responsabilities = responsabilities;
	}

	public String getSeriestatement() {
		return this.seriestatement;
	}

	public void setSeriestatement(String seriestatement) {
		this.seriestatement = seriestatement;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceforacquisition() {
		return this.sourceforacquisition;
	}

	public void setSourceforacquisition(String sourceforacquisition) {
		this.sourceforacquisition = sourceforacquisition;
	}

	public String getTermsofavailability() {
		return this.termsofavailability;
	}

	public void setTermsofavailability(String termsofavailability) {
		this.termsofavailability = termsofavailability;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTypeface() {
		return this.typeface;
	}

	public void setTypeface(String typeface) {
		this.typeface = typeface;
	}

	public int getTypesize() {
		return this.typesize;
	}

	public void setTypesize(int typesize) {
		this.typesize = typesize;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setManifestation(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setManifestation(null);

		return item;
	}

}
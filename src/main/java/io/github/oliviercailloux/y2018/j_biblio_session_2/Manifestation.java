
package io.github.oliviercailloux.y2018.j_biblio_session_2;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
//import javax.json.bind.JsonbConfig;

public class Manifestation {
	
	private Origin origin; // Date et source
	
	private Optional<Expression> expression;
	private List<Item> items;
	
	private String title;
	private List<String> responsibilities; // Individu(s) ou groupe(s) exercant une responsabilite sur le contenu 
	private String edition;
	private String placeOfPublication;
	private String publisher;
	private Optional<Instant> dateOfPublication;
	private String fabricator; //Fabricant
	private String serieStatement; // Emplacement au sein d une collection
	private int manifestationId;
	private String sourceForAcquisition; // Nom de l'editeur qui autorise l acquisition ou l acces a la manifestation
	private String termsOfAvailability; // Conditions de mise a disponibilite (gratuit, prix, etc)
	private String accessRestrictions; // Copyrights
	
	// Printed book attributes
	private String typeface; // Police
	private int typeSize; // Taille de la police
			
	public Manifestation() {
	}
	
 /** Manifestation constructor. **/
	public Manifestation(String title, List<String> responsibilities, String edition, String placeOfPublication,
			String publisher, Instant dateOfPublication, String fabricator, String serieStatement, int manifestationId, String sourceForAcquisition, 
			String termsOfAvailability, String accessRestrictions, String typeface, int typeSize, Expression expression, String source) {
		
		this.expression = Optional.of(expression);
		
		this.items = new ArrayList<Item>();
		
		if(title == null)
			this.title = title;
		else
			this.title = title;
		
		this.responsibilities = responsibilities;
		
		if(edition == null)
			this.edition = "";
		else
			this.edition = edition;
		
		if(placeOfPublication == null)
			this.placeOfPublication = "";
		else
			this.placeOfPublication = placeOfPublication;
		
		if(publisher == null)
			this.publisher = "";
		else
			this.publisher = publisher;
		
		this.dateOfPublication = Optional.of(dateOfPublication);
		
		if(fabricator == null)
			this.fabricator = "";
		else
			this.fabricator = fabricator;
		
		if(serieStatement == null)
			this.serieStatement = "";
		else
			this.serieStatement = serieStatement;
		
		this.manifestationId = manifestationId;
		
		if(sourceForAcquisition == null)
			this.sourceForAcquisition = "";
		else
			this.sourceForAcquisition = sourceForAcquisition;
		
		if(termsOfAvailability == null)
			this.termsOfAvailability = "";
		else
			this.termsOfAvailability = termsOfAvailability;
		
		if(accessRestrictions == null)
			this.accessRestrictions = "";
		else
			this.accessRestrictions = accessRestrictions;
		
		this.origin = new Origin(Instant.now(), source);
		
		if(title == null)
			this.typeface = "";
		else
			this.typeface = typeface;
		
		this.typeSize = typeSize;
	}
	
	/** Export Manifestation in JSON format. **/
	public String txtExport() {
	
		Jsonb jsonb = JsonbBuilder.create();
		String result = jsonb.toJson(this);
		return result;
	}
	public Optional<Expression> getExpression() {
		return this.expression;
	}

	public void setExpression(Expression expression) {
		this.expression = Optional.of(expression);
	}

	public List<Item> getItems() {
		return this.items;
	}
	
	public void addItem(Item item) {
		this.items.add(item);
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		if(title == null)
			this.title = "";
		else
			this.title = title;
	}

	public List<String> getResponsibilities() {
		return this.responsibilities;
	}

	public void setResponsibilities(List<String> responsibilities) {
		this.responsibilities = responsibilities;
	}

	public String getEdition() {
		return this.edition;
	}

	public void setEdition(String edition) {
		if(edition == null)
			this.edition = "";
		else
			this.edition = edition;
	}

	public String getPlaceOfPublication() {
		return placeOfPublication;
	}

	public void setPlaceOfPublication(String placeOfPublication) {
		if(placeOfPublication == null)
			this.placeOfPublication = "";
		else
			this.placeOfPublication = placeOfPublication;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		if(publisher == null)
			this.publisher = "";
		else
			this.publisher = publisher;
	}

	public Instant getDateOfPublication() {
		return this.dateOfPublication.get();
	}

	public void setDateOfPublication(Instant dateOfPublication) {
		this.dateOfPublication = Optional.of(dateOfPublication);
	}

	public String getFabricator() {
		return this.fabricator;
	}

	public void setFabricator(String fabricator) {
		if(fabricator == null)
			this.fabricator = "";
		else
			this.fabricator = fabricator;
	}

	public String getSerieStatement() {
		return this.serieStatement;
	}

	public void setSerieStatement(String serieStatement) {
		if(serieStatement == null)
			this.serieStatement = "";
		else
			this.serieStatement = serieStatement;
	}

	public int getManifestationId() {
		return this.manifestationId;
	}

	public void setManifestationId(int manifestationId) {
		this.manifestationId = manifestationId;
	}

	public String getSourceForAcquisition() {
		return this.sourceForAcquisition;
	}

	public void setSourceForAcquisition(String sourceForAcquisition) {
		if(sourceForAcquisition == null)
			this.sourceForAcquisition = "";
		else
			this.sourceForAcquisition = sourceForAcquisition;
	}

	public String getTermsOfAvailability() {
		return this.termsOfAvailability;
	}

	public void setTermsOfAvailability(String termsOfAvailability) {
		if(termsOfAvailability == null)
			this.termsOfAvailability = "";
		else
			this.termsOfAvailability = termsOfAvailability;
	}

	public String getAccessRestrictions() {
		return this.accessRestrictions;
	}

	public void setAccessRestrictions(String accessRestrictions) {
		if(accessRestrictions == null)
			this.accessRestrictions = "";
		else
			this.accessRestrictions = accessRestrictions;
	}



	public String getTypeface() {
		return this.typeface;
	}


	public void setTypeface(String typeface) {
		if(typeface == null)
			this.typeface = "";
		else
			this.typeface = typeface;
	}


	public int getTypeSize() {
		return this.typeSize;
	}


	public void setTypeSize(int typeSize) {
		this.typeSize = typeSize;
	}
	public Origin getOrigin() {
		return this.origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	@Override
	public String toString() {
		String resp = "";
		for (String s: this.responsibilities)
		{
			resp += s +",";
		}
		String it = "";
		for (Item item:this.items)
		{
			it += item.toString() + ",";
		}
		
		return "Manifestation [origin=" + this.origin.toString() 
				+ ", expression=" + this.expression 
				+ ", items=" + it 
				+ ", title="+ this.title 
				+ ", responsibilities=" + resp 
				+ ", edition=" + this.edition 
				+ ", placeOfPublication="+ this.placeOfPublication 
				+ ", publisher=" + this.publisher 
				+ ", dateOfPublication=" + this.dateOfPublication
				+ ", fabricator=" + this.fabricator 
				+ ", serieStatement=" + this.serieStatement 
				+ ", manifestationId=" + this.manifestationId 
				+ ", sourceForAcquisition=" + this.sourceForAcquisition 
				+ ", termsOfAvailability=" + this.termsOfAvailability + "]";
	}
}

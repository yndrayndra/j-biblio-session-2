package io.github.oliviercailloux.y2018.j_biblio_session_2;

import java.time.Instant;
import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
//import javax.json.bind.JsonbConfig;


public class Item {
	
	private Origin origin;
	
	private int itemIdentifier;
	private String fingerprint;
	private String itemProvenance; // Ancien possesseur
	private List<String> marks; // Signature
	private List<String> exhibitionHistory; // Expositions publiques
	private String itemCondition; // Etat de l'item (pages manquantes, etc)
	private String accessRestrictions; // Limitations (consultation sur place et sous controle, etc)
	
	private Manifestation manifestation;
	
	public Item(int itemIdentifier, 
				String fingerprint, 
				String itemProvenance, 
				List<String> marks,
				List<String> exhibitionHistory, 
				String itemCondition, 
				String accessRestrictions, 
				Manifestation manifestation, 
				String source) {	
		
		this.manifestation = manifestation;
		
		this.itemIdentifier = itemIdentifier;
		this.fingerprint = fingerprint;
		this.itemProvenance = itemProvenance;
		this.marks = marks;
		this.exhibitionHistory = exhibitionHistory;
		this.itemCondition = itemCondition;
		this.accessRestrictions = accessRestrictions;
		
		this.origin = new Origin(Instant.now(), source);
	}
	public Item() {}
	
	public String txtExport() {

		Jsonb jsonb = JsonbBuilder.create();	
		String result = jsonb.toJson(this);
		return result;
	}
	public int getItemIdentifier() {
		return itemIdentifier;
	}

	public void setItemIdentifier(int itemIdentifier) {
		this.itemIdentifier = itemIdentifier;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	public String getItemProvenance() {
		return itemProvenance;
	}

	public void setItemProvenance(String itemProvenance) {
		this.itemProvenance = itemProvenance;
	}

	public List<String> getMarks() {
		return marks;
	}

	public void setMarks(List<String> marks) {
		this.marks = marks;
	}

	public List<String> getExhibitionHistory() {
		return exhibitionHistory;
	}

	public void setExhibitionHistory(List<String> exhibitionHistory) {
		this.exhibitionHistory = exhibitionHistory;
	}

	public String getItemCondition() {
		return itemCondition;
	}

	@Override
	public String toString() {
		String mark = "";
		for (String s: this.marks)
		{
			mark += s + ",";
		}
		String eh = "";
		for (String s:this.exhibitionHistory)
		{
			eh += s +",";
		}
		return "Item [origin=" + this.origin.toString() 
				+ ", itemIdentifier=" + this.itemIdentifier 
				+ ", fingerprint=" + this.fingerprint
				+ ", itemProvenance=" + this.itemProvenance 
				+ ", marks=" + mark 
				+ ", exhibitionHistory=" + eh
				+ ", itemCondition=" + this.itemCondition 
				+ ", accessRestrictions=" + this.accessRestrictions
				+ ", manifestation=" + this.manifestation + "]";
	}

	public void setItemCondition(String itemCondition) {
		this.itemCondition = itemCondition;
	}

	public String getAccessRestrictions() {
		return accessRestrictions;
	}

	public void setAccessRestrictions(String accessRestrictions) {
		this.accessRestrictions = accessRestrictions;
	}
	public Origin getOrigin() {
		return origin;
	}
	public void setOrigin(Origin origin) {
		this.origin = origin;
	}
		
}

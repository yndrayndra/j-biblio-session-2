package io.github.oliviercailloux.y2018.j_biblio_session_2;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;


public class Expression 
{
	private String title,form,langage,summarization,context,criticalResponse,useRestrictions;
	private Optional<Instant> date;
	private boolean revisability;
	private Origin origin;
	private Work work;
	private List<Manifestation> manifestations;
	
	public Expression(String title,
					  String form,
					  String langage, 
					  String summarization,
					  String context,
					  String criticalResponse,
					  String useRestrictions,
					  Instant date,
					  boolean revisability,
					  Work work, 
					  String source)
	{
		this.origin = new Origin(Instant.now(),source);
		
		if(title == null)
			this.title = "";
		else
			this.title = title;

		if(form == null)
			this.form = "";
		else
			this.form = form;
		
		if(langage == null)
			this.langage = "";
		else
			this.langage = langage;
		
		if(summarization == null)
			this.summarization = "";
		else
			this.summarization = summarization;
		
		if(context == null)
			this.context = "";
		else
			this.context = context;
		
		if(criticalResponse == null)
			this.criticalResponse = "";
		else
			this.criticalResponse = criticalResponse;
		if(useRestrictions == null)
			this.useRestrictions = "";
		else
			this.useRestrictions = useRestrictions;
		
		this.date = Optional.of(date);
		this.revisability =revisability;
		this.work = work;
		this.manifestations = new ArrayList<Manifestation>();
	}
	
	public Expression()
	{
		
	}


	@Override
	public String toString() {
		String manifestation = "";
		for (Manifestation m: manifestations)
		{
			manifestation += m.toString() +";" ;
		}
		return "Expression [title=" + this.title 
				+ ", form=" + this.form 
				+ ", langage=" + this.langage 
				+ ", summarization="+ this.summarization 
				+ ", context=" + this.context 
				+ ", criticalResponse=" + this.criticalResponse
				+ ", useRestrictions=" + this.useRestrictions 
				+ ", date=" + this.date 
				+ ", revisability=" + revisability
				+ ", origin=" + this.origin.toString() 
				+ ", work=" + this.work.toString() 
				+ ", manifestations=" + manifestation + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getLangage() {
		return langage;
	}

	public void setLangage(String langage) {
		this.langage = langage;
	}


	public String getSummarization() {
		return summarization;
	}

	public void setSummarization(String summarization) {
		this.summarization = summarization;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getCriticalResponse() {
		return criticalResponse;
	}

	public void setCriticalResponse(String criticalResponse) {
		this.criticalResponse = criticalResponse;
	}

	public String getUseRestrictions() {
		return useRestrictions;
	}

	public void setUseRestrictions(String useRestrictions) {
		this.useRestrictions = useRestrictions;
	}

	public Instant getDate() {
		return date.get();
	}

	public void setDate(Instant date) {
		this.date = Optional.of(date);
	}

	public boolean isRevisability() {
		return revisability;
	}

	public void setRevisability(boolean revisability) {
		this.revisability = revisability;
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	public List<Manifestation> getManifestations() {
		return manifestations;
	}

	public void setManifestations(List<Manifestation> manifestations) {
		this.manifestations = manifestations;
	}
	
	public String txtExport() {

		Jsonb jsonb = JsonbBuilder.create();	
		String result = jsonb.toJson(this);
		return result;
	}
}
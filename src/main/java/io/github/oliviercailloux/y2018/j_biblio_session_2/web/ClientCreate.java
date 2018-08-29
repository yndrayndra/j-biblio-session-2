package io.github.oliviercailloux.y2018.j_biblio_session_2.web;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.oliviercailloux.y2018.j_biblio_session_2.Expression;
import io.github.oliviercailloux.y2018.j_biblio_session_2.Item;
import io.github.oliviercailloux.y2018.j_biblio_session_2.ListeObjet;
import io.github.oliviercailloux.y2018.j_biblio_session_2.Manifestation;
import io.github.oliviercailloux.y2018.j_biblio_session_2.Name;
import io.github.oliviercailloux.y2018.j_biblio_session_2.Origin;
import io.github.oliviercailloux.y2018.j_biblio_session_2.Person;
import io.github.oliviercailloux.y2018.j_biblio_session_2.Work;

/**
 * Servlet implementation class ClientCreate
 */
public class ClientCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String type;
	private String submit;
	private String search;
	private ListeObjet liste = null;
	
	/** Person attibutes **/
	private String authorityName;
	private String otherNames;
	private List<Name> listOtherNames;
	private String titlePerson ;
	private String datePerson;
	private String designation ; 
	
	/** Work attributes **/
	private String titleWork ;
	private String formWork ;
	private String intendedAudiance ;
	private String contextWork ;
	private String distinguishingCharacteristic;
	private boolean intendedTermination ;
	private String dateWork ;
	
	/** Expression attributes **/
	private String titleExpr ;
	private String formExpr ;
	private String language ;
	private String summarization ;
	private String context ;
	private String criticalResponse;
	private String useRestrictions ;
	private String dateExpr ;
	private String revisability ;
	
	/** Manifestation attributes **/
	private String titleManif ;
	private String responsibilitiesStr ;
	private String[] responsibilitiesArray ;
	private List<String> responsibilities ;
	private String edition ;
	private String placeOfPublication;
	private String publisher ;
	private String dateOfPublication ;
	private String fabricator ;
	private String serieStatement ;  
	private int manifestationId ;
	private String sourceForAcquisition ;
	private String termsOfAvailability ;
	private String accessRestrictionsManif ; 
	
	/** Item attributes**/
	private int itemIdentifier;
	private String fingerprint ;
	private String itemProvenance ;
	private String marksStr ;
	private String[] marksArray;
	private List<String> marks ;
	private String itemCondition;
	private String accessRestrictionsItem;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientCreate() {
        super(); 
    }
    public void init() throws ServletException{
    	liste = new ListeObjet();
    	super.init();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.submit     = request.getParameter("submit");
		this.type        = request.getParameter("type");
		Origin origin = new Origin(Instant.now(),"web");
		ServletsSet ss = new ServletsSet();
		ServletsMain sm = new ServletsMain();
		ss.setListe(this.liste);
		sm.setListe(this.liste);
		int id = -1;
		
		if (submit.equals("ajouter") || submit.equals("modifier"))
		{
			switch(type.toUpperCase()){
			
			case "PERSON": {
								this.listOtherNames = new ArrayList<Name>();
								this.titlePerson = request.getParameter("title");
								this.datePerson = request.getParameter("date") + "T00:00:00.00Z";
								this.designation = request.getParameter("designation");
								this.authorityName = request.getParameter("authorityName");
								this.otherNames = request.getParameter("otherNames");
								for (String s:this.otherNames.split(","))
								{
									listOtherNames.add(new Name(s)); 
								}
								
								Person person = new Person();
								person.setName(new Name(authorityName));
								person.setotherNames(listOtherNames);
								person.setTitle(titlePerson);
								person.setDesignation(designation);
								person.setDate(Instant.parse(datePerson));
								person.setOrigin(origin);
																					
								id = ss.PutPerson(person);
								request.setAttribute("id", id);
						        request.getRequestDispatcher("/affichage.jsp").forward(request, response);
						        break;
							}
			case "WORK":{
						this.titleWork = request.getParameter("titleWork");
						this.formWork = request.getParameter("formWork");
						this.intendedAudiance = request.getParameter("intendedAudiance");
						this.contextWork = request.getParameter("contextWork");
						this.distinguishingCharacteristic = request.getParameter("distinguishingCharacteristic");
						this.intendedTermination = request.getParameter("intendedTermination") != null;
						this.dateWork = request.getParameter("dateWork") + "T00:00:00.00Z";
						
						Work work = new Work();
						work.setTitle(titleWork);
						work.setForm(formWork);
						work.setIntendedAudiance(intendedAudiance);
						work.setContext(contextWork);
						work.setDistinguishingCharacteristic(distinguishingCharacteristic);
						work.setIntendedTermination(intendedTermination);
						work.setDate(Instant.parse(dateWork));	
						work.setOrigin(origin);
						
						id = ss.PutWork(work);
						request.setAttribute("id", id);
				        request.getRequestDispatcher("/affichage.jsp").forward(request, response);
				        break;
					}
			case "MANIFESTATION":{
								this.titleManif = request.getParameter("titleManif");
								this.responsibilitiesStr = request.getParameter("responsibilities");
								this.responsibilitiesArray = responsibilitiesStr.split(",");
								this.responsibilities = new ArrayList<String>(Arrays.asList(responsibilitiesArray));
								this.edition = request.getParameter("edition");
								this.placeOfPublication= request.getParameter("placeOfPublication");
								this.publisher = request.getParameter("publisher");
								this.dateOfPublication = request.getParameter("dateOfPublication") + "T00:00:00.00Z";
								this.fabricator = request.getParameter("fabricator");
								this.serieStatement = request.getParameter("serieStatement");  
								this.manifestationId = Integer.parseInt(request.getParameter("manifestationId"));
								this.sourceForAcquisition = request.getParameter("sourceForAcquisition");
								this.termsOfAvailability = request.getParameter("termsOfAvailability");
								this.accessRestrictionsManif = request.getParameter("accessRestrictionsManif");
								
								
								Manifestation manifestation = new Manifestation();
								manifestation.setTitle(titleManif);
								manifestation.setResponsibilities(responsibilities);
								manifestation.setEdition(edition);
								manifestation.setPlaceOfPublication(placeOfPublication);
								manifestation.setPublisher(publisher);
								manifestation.setDateOfPublication(Instant.parse(dateOfPublication));
								manifestation.setFabricator(fabricator);
								manifestation.setSerieStatement(serieStatement);
								manifestation.setManifestationId(manifestationId);
								manifestation.setSourceForAcquisition(sourceForAcquisition);
								manifestation.setTermsOfAvailability(termsOfAvailability);
								manifestation.setAccessRestrictions(accessRestrictionsManif);
								manifestation.setOrigin(origin);
								
								id = ss.PutManifestation(manifestation);
								request.setAttribute("id", id);
						        request.getRequestDispatcher("/affichage.jsp").forward(request, response);
						        break;
						  }
			case "EXPRESSION":{
							this.titleExpr = request.getParameter("titleExpr");
							this.formExpr = request.getParameter("formExpr");
							this.language = request.getParameter("language");
							this.summarization = request.getParameter("summarization");
							this.context = request.getParameter("context");
							this.criticalResponse = request.getParameter("criticalResponse");
							this.useRestrictions = request.getParameter("useRestrictions");
							this.dateExpr = request.getParameter("dateExpr") + "T00:00:00.00Z";
							this.revisability = request.getParameter("revisability");
							
							
							Expression expression = new Expression();
							expression.setTitle(titleExpr);
							expression.setForm(formExpr);
							expression.setLangage(language);
							expression.setSummarization(summarization);
							expression.setContext(context);
							expression.setCriticalResponse(criticalResponse);
							expression.setUseRestrictions(useRestrictions);
							expression.setDate(Instant.parse(dateExpr));
							expression.setRevisability(Boolean.parseBoolean(revisability));
							expression.setOrigin(origin);
							
							id = ss.PutExpression(expression);
							request.setAttribute("id", id);
					        request.getRequestDispatcher("/affichage.jsp").forward(request, response);
					        break;
						 }
			case "ITEM": {
							this.itemIdentifier = Integer.parseInt(request.getParameter("itemIdentifier"));
							this.fingerprint = request.getParameter("fingerprint");
							this.itemProvenance = request.getParameter("itemProvenance");
							this.marksStr = request.getParameter("marksStr");
							this.marksArray = marksStr.split(",");
							this.marks = new ArrayList<String>(Arrays.asList(marksArray));
							this.itemCondition = request.getParameter("itemCondition");
							this.accessRestrictionsItem = request.getParameter("accessRestrictionsItem");
							
							Item item = new Item();
							item.setItemIdentifier(itemIdentifier);
							item.setFingerprint(fingerprint);
							item.setItemProvenance(itemProvenance);
							item.setMarks(marks);
							item.setItemCondition(itemCondition);
							item.setAccessRestrictions(accessRestrictionsItem);	
							item.setOrigin(origin);
							
							id = ss.PutItem(item);
							request.setAttribute("id", id);
					        request.getRequestDispatcher("/affichage.jsp").forward(request, response);
					        break;
					}
			default: {
				break;
			}
			}
		}
		if (submit.equals("chercher"))
		{
			this.search = request.getParameter("search");
			switch(type.toUpperCase()){
				case "PERSON":{ if(sm.liste.getPersons().size()>0){
									Person person =  new Person();
									person = sm.GetPerson(Integer.parseInt(this.search));
									request.setAttribute("search", person.toString());
						        }
								else
								{
									request.setAttribute("search", "Table Person vide");
								}
								request.getRequestDispatcher("/affichage.jsp").forward(request, response);			
							  }
				case "WORK":{ if(sm.liste.getWorks().size()>0)
								{
									Work work = new Work();
									work = sm.GetWork(Integer.parseInt(this.search));
									request.setAttribute("search", work.toString());
								}
								else {
									request.setAttribute("search", "Table Work vide");
								}
								request.getRequestDispatcher("/affichage.jsp").forward(request, response);
							}
				case "MANIFESTATION":{ if(sm.liste.getManifestations().size()>0){
											Manifestation manif =  new Manifestation();
											manif = sm.GetManifestation(Integer.parseInt(this.search));
											request.setAttribute("search", manif.toString());
										}
										else{
											request.setAttribute("search", "Table Manifestation vide");											
										}
									   request.getRequestDispatcher("/affichage.jsp").forward(request, response);
									 }
				case "EXPRESSION":{ if(sm.liste.getExpressions().size()>0){
										Expression expr = new Expression();
										expr = sm.GetExpression(Integer.parseInt(this.search));
										request.setAttribute("search", expr.toString());
									}
									else{
										request.setAttribute("search", "Table Expression vide");
									}
									request.getRequestDispatcher("/affichage.jsp").forward(request, response);
								  }
				case "ITEM": { if(sm.liste.getItems().size()>0){
								Item it = new Item();
							   it = sm.GetItem(Integer.parseInt(this.search));
							   request.setAttribute("search", it.toString());
								}
								else{
									request.setAttribute("search", "Table item vide");
								}
							   request.getRequestDispatcher("/affichage.jsp").forward(request, response);
							  }
			}
		}
		if (submit.equals("lister"))
		{
			lister(request,response, this.type, this.liste);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private static void lister(HttpServletRequest request, HttpServletResponse response,String type,ListeObjet liste ) throws ServletException, IOException
	{
		switch(type.toUpperCase()){
		case "PERSON":{ List<Person> listePersonne = new ArrayList<Person>();
						listePersonne = new ArrayList<Person>(liste.getPersons().values());
						request.setAttribute("liste", listePersonne);
				        request.getRequestDispatcher("/affichage.jsp").forward(request, response);
				        break;
					  }
		case "WORK":{ List<Work> listeWork = new ArrayList<Work>();
					  listeWork = new ArrayList<Work>(liste.getWorks().values()); 	
					  request.setAttribute("liste", listeWork);
				      request.getRequestDispatcher("/affichage.jsp").forward(request, response);
				      break;
					}
		case "MANIFESTATION":{  List<Manifestation> listeManif = new ArrayList<Manifestation>();
								listeManif = new ArrayList<Manifestation>(liste.getManifestations().values());
								request.setAttribute("liste", listeManif);
						        request.getRequestDispatcher("/affichage.jsp").forward(request, response);
						        break;
							 }
		case "EXPRESSION":{	List<Expression> listeExpr = new ArrayList<Expression>();
							listeExpr = new ArrayList<Expression>(liste.getExpressions().values());
							request.setAttribute("liste", listeExpr);
					        request.getRequestDispatcher("/affichage.jsp").forward(request, response);
					        break;
						  }
		case "ITEM": {	List<Item> listeItem = new ArrayList<Item>();
						listeItem = new ArrayList<Item>(liste.getItems().values());
						request.setAttribute("liste", listeItem);
				        request.getRequestDispatcher("/affichage.jsp").forward(request, response);
				        break;
					  }
		}
	}
}

package io.github.oliviercailloux.y2018.j_biblio_session_2.jpa.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import io.github.oliviercailloux.y2018.j_biblio_session_2.jpa.Item;
import io.github.oliviercailloux.y2018.j_biblio_session_2.jpa.Manifestation;
import io.github.oliviercailloux.y2018.j_biblio_session_2.jpa.Person;

/**
 * Servlet implementation class SetDBVar
 */
public class SetDBVar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String type;
	private String submit;
	
	/** Person attibutes **/
	private String authorityName;
	private String otherNames;
	private String titlePerson ;
	//private String datePerson;
	private String designation ; 	
	
	/** Manifestation attributes **/
	private String titleManif ;
	private String responsibilitiesStr ;
	private String edition ;
	private String placeOfPublication;
	private String publisher ;
	//private String dateOfPublication ;
	private String fabricator ;
	private String serieStatement ;  
	private String sourceForAcquisition ;
	private String termsOfAvailability ;
	private String accessRestrictionsManif ; 
	
	/** Item attributes**/
	private String fingerprint ;
	private String itemProvenance ;
	private String marksStr ;
	private String itemCondition;
	private String accessRestrictionsItem;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetDBVar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.submit     = request.getParameter("submit");
		this.type        = request.getParameter("type");
		String retour = "";
		
		if (submit == "ajouter")
		{
			switch(type.toUpperCase()){
			
			case "PERSON": {
								this.titlePerson = request.getParameter("title");
								//this.datePerson = request.getParameter("date") + "T00:00:00.00Z";
								this.designation = request.getParameter("designation");
								this.authorityName = request.getParameter("authorityName");
								this.otherNames = request.getParameter("otherNames");
								
								Person person = new Person();
								SetDBVarPerson  sp = new SetDBVarPerson();
								person.setAuthorityname(authorityName);
								person.setOthernames(otherNames);
								person.setTitle(titlePerson);
								person.setDesignation(designation);
								//person.setDate(Instant.parse(datePerson));
								
								sp.setPers(person);
								
								retour = sp.insertPerson();
																													
								if (retour.equals("Insertion effectuee"))
								{
									request.setAttribute("retour",retour);
									request.getRequestDispatcher("/affichage.jsp").forward(request, response);
								}
								else
								{
									response.getWriter().append(retour).append(request.getContextPath());
								}			
						        break;
							}		
			case "MANIFESTATION":{
								this.titleManif = request.getParameter("titleManif");
								this.responsibilitiesStr = request.getParameter("responsibilities");								
								this.edition = request.getParameter("edition");
								this.placeOfPublication= request.getParameter("placeOfPublication");
								this.publisher = request.getParameter("publisher");
								//this.dateOfPublication = request.getParameter("dateOfPublication") + "T00:00:00.00Z";
								this.fabricator = request.getParameter("fabricator");
								this.serieStatement = request.getParameter("serieStatement");  								
								this.sourceForAcquisition = request.getParameter("sourceForAcquisition");
								this.termsOfAvailability = request.getParameter("termsOfAvailability");
								this.accessRestrictionsManif = request.getParameter("accessRestrictionsManif");
								
								
								Manifestation manifestation = new Manifestation();
								SetDBVarManifestation sm = new SetDBVarManifestation();
								manifestation.setTitle(titleManif);
								manifestation.setResponsabilities(responsibilitiesStr);
								manifestation.setEdition(edition);
								manifestation.setPlaceofpublication(placeOfPublication);
								manifestation.setPublisher(publisher);
							//	manifestation.setDateOfPublication(Instant.parse(dateOfPublication));
								manifestation.setFabricator(fabricator);
								manifestation.setSeriestatement(serieStatement);
								manifestation.setSourceforacquisition(sourceForAcquisition);
								manifestation.setTermsofavailability(termsOfAvailability);
								manifestation.setAccessrestrictions(accessRestrictionsManif);								
								
								sm.setManif(manifestation);
								
								retour = sm.insertManifestation();
								if (retour.equals("Insertion effectuee"))
								{
									request.setAttribute("retour",retour);
									request.getRequestDispatcher("/affichage.jsp").forward(request, response);
								}
								else
								{
									response.getWriter().append(retour).append(request.getContextPath());
								}			
						        break;
						  }
			case "ITEM": {
							
							this.fingerprint = request.getParameter("fingerprint");
							this.itemProvenance = request.getParameter("itemProvenance");
							this.marksStr = request.getParameter("marksStr");
							this.itemCondition = request.getParameter("itemCondition");
							this.accessRestrictionsItem = request.getParameter("accessRestrictionsItem");
							
							Item item = new Item();
							SetDBVarItem si = new SetDBVarItem();
							
							item.setFingerprint(fingerprint);
							item.setIntemprovenance(itemProvenance);
							item.setMarks(marksStr);
							item.setItemcondition(itemCondition);
							item.setAccessrestrictions(accessRestrictionsItem);	
							
							si.setIt(item);
							retour = si.insertItem();
							
							if (retour.equals("Insertion effectuee"))
							{
								request.setAttribute("retour",retour);
								request.getRequestDispatcher("/affichage.jsp").forward(request, response);
							}
							else
							{
								response.getWriter().append(retour).append(request.getContextPath());
							}			
					        break;
					}
			default: {
						break;
					}
			}
			
		}
		else 
		{
switch(type.toUpperCase()){
			
			case "PERSON": {
								SetDBVarPerson sp = new SetDBVarPerson();
								List<Person> listPers = sp.listPerson();
								request.setAttribute("liste",listPers);
								request.getRequestDispatcher("/affichage.jsp").forward(request, response);
								break;
							}
			case "MANIFESTATION":{
									SetDBVarManifestation sm = new SetDBVarManifestation();
									List<Manifestation> listMan = sm.listManifestation();
									request.setAttribute("liste",listMan);
									request.getRequestDispatcher("/affichage.jsp").forward(request, response);
									break;	
								 }
			case "ITEM": {
							SetDBVarItem si = new SetDBVarItem();
							List<Item> listItm = si.listItem();
							request.setAttribute("liste",listItm);
							request.getRequestDispatcher("/affichage.jsp").forward(request, response);
							break;
						}
			}	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

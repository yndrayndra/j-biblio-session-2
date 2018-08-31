package io.github.oliviercailloux.y2018.j_biblio_session_2.jpa.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.oliviercailloux.y2018.j_biblio_session_2.jpa.Expression;
import io.github.oliviercailloux.y2018.j_biblio_session_2.jpa.Workentity;
/**
 * Servlet implementation class SetDB1
 */
public class SetDB1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String type;
	private String submit;	
	
	/** Work attributes **/
	private String titleWork ;
	private String formWork ;
	private String intendedAudiance ;
	private String distinguishingCharacteristic;
	private String intendedTermination ;
	//private String dateWork ;
	
	/** Expression attributes **/
	private String titleExpr ;
	private String formExpr ;
	private String language ;
	private String summarization ;
	private String context ;
	private String criticalResponse;
	private String useRestrictions ;
	//private String dateExpr ;
	private String revisability ;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetDB1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.submit     = request.getParameter("submit");
		this.type       = request.getParameter("type");
		String retour   ="";
		
		if (submit == "ajouter")
		{
			switch(type.toUpperCase()){
			
			
			case "WORK":{
						this.titleWork = request.getParameter("titleWork");
						this.formWork = request.getParameter("formWork");
						this.intendedAudiance = request.getParameter("intendedAudiance");					
						this.distinguishingCharacteristic = request.getParameter("distinguishingCharacteristic");
						this.intendedTermination = request.getParameter("intendedTermination") ;
						//this.dateWork = request.getParameter("dateWork") + "T00:00:00.00Z";
						
						Workentity work = new Workentity();
						SetDBWork sw	= new SetDBWork();
						work.setTitle(titleWork);
						work.setForm(formWork);
						work.setIntendedaudience(intendedAudiance);					
						work.setDistinguishingcharacteristic(distinguishingCharacteristic);
						work.setIntendedtermination(Short.parseShort(intendedTermination));
						//work.setDatework(Instant.parse(dateWork));	
						
						sw.setWe(work);
						
						retour = sw.insertWork();
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
			
			case "EXPRESSION":{
							this.titleExpr = request.getParameter("titleExpr");
							this.formExpr = request.getParameter("formExpr");
							this.language = request.getParameter("language");
							this.summarization = request.getParameter("summarization");
							this.context = request.getParameter("context");
							this.criticalResponse = request.getParameter("criticalResponse");
							this.useRestrictions = request.getParameter("useRestrictions");
						//	this.dateExpr = request.getParameter("dateExpr") + "T00:00:00.00Z";
							this.revisability = request.getParameter("revisability");
							
							
							Expression expression = new Expression();
							SetDBExpression se = new SetDBExpression();
							expression.setTitle(titleExpr);
							expression.setForm(formExpr);
							expression.setLangage(language);
							expression.setSummarization(summarization);
							expression.setContext(context);
							expression.setCriticalresponse(criticalResponse);
							expression.setUserrestrictions(useRestrictions);
							//expression.setDateexpression((Instant.parse(dateExpr));
							expression.setRevisability(Short.parseShort(revisability));
							
							se.setEx(expression);
							retour = se.insertExpression();
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
			
			case "WORK":{
							SetDBWork sw	= new SetDBWork();
							List<Workentity> listWork  = sw.listWork();
							request.setAttribute("liste",listWork);
							request.getRequestDispatcher("/affichage.jsp").forward(request, response);
						    break;
						}
			
			case "EXPRESSION":{		
							SetDBExpression se = new SetDBExpression();
							List<Expression> listExp = se.listExpression();
							request.setAttribute("liste",listExp);
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

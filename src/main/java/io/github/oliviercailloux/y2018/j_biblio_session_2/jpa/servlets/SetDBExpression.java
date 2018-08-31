package io.github.oliviercailloux.y2018.j_biblio_session_2.jpa.servlets;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;

import io.github.oliviercailloux.y2018.j_biblio_session_2.jpa.Expression;
import io.github.oliviercailloux.y2018.j_biblio_session_2.jpa.Workentity;

@ManagedBean
@SessionScoped
public class SetDBExpression implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Expression ex;
	
	public SetDBExpression(){}
	
	public String insertExpression(){
		
		String retour = "";
		
		Expression ex = null;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("j-biblio-session-2");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(getEx());
		et.commit();
		ex = em.find(Expression.class,getId());
		if (ex == null )
		{ return "Insertion non effectuee ";}
		else{
		retour = "Insertion effectuee";	}	
		return retour;		
	}
		

	public List<Expression> listExpression(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("j-biblio-session-2");
		
		EntityManager em = emf.createEntityManager();

		@SuppressWarnings("unchecked")
		ArrayList<Expression> listeExpression = (ArrayList<Expression>) em.createQuery("SELECT e FROM Expression e").getResultList();
		return listeExpression ;
	}

	
	
	public Expression getEx() {
		return ex;
	}

	public void setEx(Expression ex) {
		this.ex = ex;
	}

	public int getId() {
		if(ex ==null){
			ex = new Expression();
	}
		return getEx().getId();
	}

	public void setId(int id) {
		getEx().setId(id);
	}

	public String getContext() {
		if(ex ==null){
			ex = new Expression();
	}
		return getEx().getContext();
	}

	public void setContext(String context) {
		getEx().setContext(context);
	}

	public String getCriticalresponse() {
		if(ex ==null){
			ex = new Expression();
	}
		return getEx().getCriticalresponse();
	}

	public void setCriticalresponse(String criticalresponse) {
		getEx().setCriticalresponse(criticalresponse);
	}

	public Date getDateexpression() {
		if(ex ==null){
			ex = new Expression();
	}
		return getEx().getDateexpression();
	}

	public void setDateexpression(Date dateexpression) {
		getEx().setDateexpression(dateexpression);
	}

	public String getForm() {
		if(ex ==null){
			ex = new Expression();
	}
		return getEx().getForm();
	}

	public void setForm(String form) {
		getEx().setForm(form);
	}

	public String getLangage() {
		if(ex ==null){
			ex = new Expression();
	}
		return getEx().getLangage();
	}

	public void setLangage(String langage) {
		getEx().setLangage(langage);
	}

	public short getRevisability() {
		if(ex ==null){
			ex = new Expression();
	}
		return getEx().getRevisability();
	}

	public void setRevisability(short revisability) {
		getEx().setRevisability(revisability);
	}

	public String getSource() {
		if(ex ==null){
			ex = new Expression();
	}
		return getEx().getSource();
	}

	public void setSource(String source) {
		getEx().setSource(source);;
	}

	public String getSummarization() {
		if(ex ==null){
			ex = new Expression();
	}
		return getEx().getSummarization();
	}

	public void setSummarization(String summarization) {
		getEx().setSummarization(summarization);
	}

	public String getTitle() {
		if(ex ==null){
			ex = new Expression();
	}
		return getEx().getTitle();
	}

	public void setTitle(String title) {
		getEx().setTitle(title);
	}

	public String getUserrestrictions() {
		if(ex ==null){
			ex = new Expression();
	}
		return getEx().getUserrestrictions();
	}

	public void setUserrestrictions(String userrestrictions) {
		getEx().setUserrestrictions(userrestrictions);
	}

	public Workentity getWorkentity() {
			if(ex ==null){
				ex = new Expression();
		}
		return getEx().getWorkentity();
	}

	public void setWorkentity(Workentity workentity) {
		getEx().setWorkentity(workentity);
	}
}

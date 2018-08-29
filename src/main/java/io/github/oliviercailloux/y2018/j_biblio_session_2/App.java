package io.github.oliviercailloux.y2018.j_biblio_session_2;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import io.github.oliviercailloux.y2018.j_biblio_session_2.web.ServletsMain;
import io.github.oliviercailloux.y2018.j_biblio_session_2.web.ServletsSet;

public class App 
{
    public static void main( String[] args )
    {
    	setup();    	 
    } 
    public static Object txtImport(String json, String type) {
		JsonbConfig js = new JsonbConfig().withNullValues(true);
		Jsonb jsonb = JsonbBuilder.create(js);
		switch(type.toUpperCase()){
		case "PERSON" :{
						 Person person = jsonb.fromJson(json, Person.class);
						 return person;
					   }
		case "WORK": {
						Work work = jsonb.fromJson(json, Work.class);
						return work;
					 }
		case "EXPRESSION":{
							Expression expression = jsonb.fromJson(json, Expression.class);
							return expression;
						  }
		case "MANIFESTATION":{
								Manifestation manifestation = jsonb.fromJson(json, Manifestation.class);
								return manifestation;
							 }
		case "ITEM":{
					  Item item = jsonb.fromJson(json, Item.class);
					  return item;
					 }
		default: return null;
		}
	}
    
    


	public static void setup()
   {
	 	Instant date1 = Instant.now();
	 	Name authorityName1 = new Name("Massil Achab");
	 	Name name1 = new Name("Massil");
	 	List<Name> names1 = new ArrayList<Name>();
	 	names1.add(name1);
	 	String title1 = "Scientist";
	 	String designation = "Designation";
	 	String source1 = "Source 1";
	 	
	 	Instant date2 = Instant.now();
	 	Name authorityName2 = new Name("Jayadev Acharya");
	 	Name name2 = new Name("Jayadev");
	 	List<Name> names2 = new ArrayList<Name>();
	 	names2.add(name2);
	 	String title2 = "Scientist";
	 	String source2 = "Source 2";
	 	
	    	Person person1 = new Person(authorityName1, names1, title1, date1, designation, source1);
	    	Person person2 = new Person(authorityName2, names2, title2, date2, designation, source2);
	    
	    	date1 = Instant.parse("2017-10-01T00:00:00.000Z");
	    	date2 = Instant.parse("2017-11-21T00:00:00.000Z");
	    	
	    	/** Test export for Person **/
	    	System.out.println("Export Person");
	    	System.out.println(person1.txtExport());
	    	System.out.println(person2.txtExport());
	    	
	    
	    	

	    	Work work1 = new Work("Uncovering Causality from Multivariate Hawkes Integrated Cumulants","article scientifique",
	    			"Tout le monde", "Hawkes process 2017","Proceedings of the 34th International Conference on Machine Learning, PMLR 70:1-10, 2017", 
	    			true, date1,person1, "http://proceedings.mlr.press/v70/achab17a.html");
	    	Work work2 = new Work("A Unified Maximum Likelihood Approach for Estimating Symmetric Properties of Discrete Distributions",
	    			"article scientifique", "Tout le monde", "Estimating Symmetric Properties of Discrete Distributions  2017",
	    			"Proceedings of the 34th International Conference on Machine Learning, PMLR 70:11-21, 2017",
	    			true, date2,person1, "http://proceedings.mlr.press/v70/acharya17a.html");
	    	
	    	/** Test export for work **/
	    	System.out.println("Export Work");
	    	System.out.println(work1.txtExport());
	    	System.out.println(work2.txtExport());
	    	
	    		    
	    	/*System.out.println(work1);
	    	System.out.println(work2);*/
	    		    
	    Expression expression1 = new Expression("Supplementary material of the article\n" +"Uncovering Causality from\n" +"Multivariate Hawkes Integrated Cumulants", "article", "french", "Proceedings of the 34th International Conference on Machine Learning, PMLR 70:1-10, 2017", "number by number", "", "None", date1, true, work1, source1);
	    Expression expression2 = new Expression("A Unified Maximum Likelihood Approach for Estimating Symmetric Properties of Discrete Distributions", "article", "french", "Proceedings of the 34th International Conference on Machine Learning, PMLR 70:11-21","number by number","","None",date2,true,work2, source2);
	    	
	    	/*System.out.println(expression1);
	    	System.out.println(expression2);
	    	
	    	/** Test txtExport for Expression **/
	    System.out.println("Export Expression");
	    System.out.println(expression1.txtExport());
	    System.out.println(expression2.txtExport());
	   	
       	String title11 = "English version";
       	String title12 = "English version";
       	
       	List<String> responsibilities1 = new ArrayList<String>(); 
       	responsibilities1.add("Massil Achab");
       	responsibilities1.add("Emmanuel Bakry");
       	responsibilities1.add("Stephane Gaiffas");
       	
       	List<String> responsibilities2 = new ArrayList<String>(); 
       	responsibilities2.add("Hirakendu Das");
       	responsibilities2.add("JAlon Orlitsky");

       	String edition1 = "UK";
       	String edition2 = "USA";
       	
       	String placeOfPublication1 = "London";
       	String placeOfPublication2 = "NY";
       	
       	String publisher1 = "Publ1";
       	String publisher2 = "Publ2";
       	
       	Instant dateOfPublication1 = Instant.parse("2017-10-01T00:00:00.000Z");
       	Instant dateOfPublication2 = Instant.parse("2017-11-21T00:00:00.000Z");

       	String fabricator1 = "fabr1";
       	String fabricator2 = "fabr2";

       	String serieStatement1 = "1"; 
       	String serieStatement2 = "1"; 
       	
       	int manifestationId1 = 1;
       	int manifestationId2 = 2;

       	String sourceForAcquisition1 = "source1"; 
       	String sourceForAcquisition2 = "source2"; 

       	String termsOfAvailability = "Free"; 
       	String accessRestrictions = "All";
       	String typeface = "Times New Roman"; 
       	int typeSize = 12; 
       	
       	String source11 = "http://proceedings.mlr.press/v70/achab17a/achab17a.pdf";
       	String source12 = "http://proceedings.mlr.press/v70/acharya17a.html";
       	
       	Manifestation manifestation1 = new Manifestation(title11, responsibilities1, edition1, placeOfPublication1, 
       			publisher1, dateOfPublication1, fabricator1, serieStatement1, manifestationId1, sourceForAcquisition1, 
       			termsOfAvailability, accessRestrictions, typeface, typeSize, expression1, source11);
       	  	
       	Manifestation manifestation2 = new Manifestation(title12, responsibilities2, edition2, placeOfPublication2, 
       			publisher2, dateOfPublication2, fabricator2, serieStatement2, manifestationId2, sourceForAcquisition2, 
       			termsOfAvailability, accessRestrictions, typeface, typeSize, expression2, source12);

       /** Test export for Manifestation **/
       System.out.println("Export Manifestation");
       System.out.println(manifestation1.txtExport());
       System.out.println(manifestation2.txtExport());
       	
       /*System.out.println(manifestation1);
       System.out.println(manifestation2);*/
   
	    int itemIdentifier1 = 1;
		String fingerprint1 = "F1";
		String itemProvenance1 = "Prov1"; 
		String itemCondition = "Complete";
		
		int itemIdentifier2 = 2;
		String fingerprint2 = "F2";
		String itemProvenance2 = "Prov2"; 
	
		Item item1 = new Item(itemIdentifier1, fingerprint1, itemProvenance1, null, null, itemCondition, 
				accessRestrictions, manifestation1, source11);
		Item item2 = new Item(itemIdentifier2, fingerprint2, itemProvenance2, null, null, itemCondition, 
				accessRestrictions, manifestation2, source12);
		
		/** Test export for Item **/
		System.out.println("Export Item");
		System.out.println(item1.txtExport());
		System.out.println(item2.txtExport());
		
		String testImpItem = item1.txtExport();
		Item item3 = (Item) txtImport(testImpItem,"item");
		
		System.out.println("Export Item3");
		System.out.println(item3.txtExport());
		/*System.out.println(item1);
		System.out.println(item2);*/
		
		ListeObjet liste = new ListeObjet();
		Map<Integer,Person> mapPerson = new HashMap<Integer,Person>();
		mapPerson.put(1, person1);
		liste.setPersons(mapPerson);
		
		ServletsSet ss = new ServletsSet();
		ss.setListe(liste);
		System.out.println(ss.PutPerson(person1));
		
		ServletsMain sm = new ServletsMain();
		sm.setListe(liste);
		System.out.println(sm.GetPerson(ss.PutPerson(person1)).toString());
		
   }
   
}

package io.github.oliviercailloux.y2018.j_biblio_session_2;

public class Name 
{
	private String name;
	private String middleName;
	private String lastName;
	
	public Name(String name, String middleName, String lastName) 
	{
		if (name == null)
			this.name = "";
		else
			this.name = name;

		if (middleName == null)
			this.middleName = "";
		else
			this.middleName = middleName;
		
		if (lastName == null)
			this.lastName = "";
		else
			this.lastName = lastName;
	}
	
	/**To use in case of the name can't be split**/
	public Name(String name) 
	{
		if (name == null)
			this.name = "";
		else
			this.name = name;
		
		this.middleName = "";
		this.lastName = "";
	}
	
	
	
	@Override
	public String toString() {
		return "Name [name=" + name + ", middleName=" + middleName + ", lastName=" + lastName + "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name == null)
			this.name = "";
		else
			this.name = name;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		if (middleName == null)
			this.middleName = "";
		else
			this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		if (lastName == null)
			this.lastName = "";
		else
			this.lastName = lastName;
	}
}

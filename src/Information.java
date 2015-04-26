import java.io.Serializable;


public class Information implements Serializable {

	//variables
	protected String name;
	protected String email;
	protected String phone;
	protected String password;
	protected String question;
	protected String answer;
	
	//default constructor
	public Information() 
	{
		this.name = "";
		this.email = "";
		this.phone = "";
		this.password = "";
		this.question = "";
		this.answer = "";
    }
	
	//constructor
	public Information(String n, String e, String ph, String p, String q, String a) 
	{
		this.name = n;
		this.email = e;
		this.phone = ph;
		this.password = p;
		this.question = q;
		this.answer = a;
    }
	
	//getters
	public String getName()
	{
		return name;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public String getPassword()
	{
		return password;
	}

	public String getQuestion()
	{
		return question;
	}
	
	public String getAnswer()
	{
		return answer;
	}
	
	//setters
	public void setName(String n)
	{
		this.name = n;
	}
	
	public void setEmail(String e)
	{
		this.email = e;
	}
	
	public void setPhone(String p)
	{
		this.phone = p;
	}
	
	public void setPassword(String p)
	{
		this.password = p;
	}

	public void setQuestion(String q)
	{
		this.question = q;
	}
	
	public void setAnswer(String a)
	{
		this.answer = a;
	}
	
	
}

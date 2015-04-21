import java.io.Serializable;


public class Information implements Serializable {

	//variables
	String name;
	String email;
	String phone;
	String password;
	String hospital;
	
	//constructor
	public Information(String n, String e, String ph, String p, String h) 
	{
		this.name = n;
		this.email = e;
		this.phone = ph;
		this.password = p;
		this.hospital = h;
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
	
	public String getHospital()
	{
		return hospital;
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
	
	public void setHospital(String h)
	{
		this.hospital = h;
	}
	
	
}

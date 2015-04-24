import java.io.Serializable;


public class Patient extends Information implements Serializable{
	
	//variables
	private String DOB;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String preferredDoctor;
	PatientRecordLinkedList patientRecordList;
	
	//constructor
	public Patient(String d, String ad, String c, String s, String z, String pd, String n, String e, String ph, String p, String h, String q, String a) 
	 {
		 super(n, e, ph, p, h, q, a);
		 this.DOB = d;
		 this.address = ad;
		 this.city = c;
		 this.state = s;
		 this.zip = z;
		 this.preferredDoctor = pd;
		 patientRecordList = new PatientRecordLinkedList();
	 } 
	
	//getters
	public String getDOB()
	{
		return DOB;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String getState()
	{
		return state;
	}
	
	public String getZip()
	{
		return zip;
	}
	
	public String getPreferredDoctor()
	{
		return preferredDoctor;
	}
	
	public PatientRecordLinkedList getPatientRecordList()
	{
		return patientRecordList;
	}
		
	//setters
	public void setDOB(String d)
	{
		this.DOB = d;
	}
	
	public void setAddress(String a)
	{
		this.address = a;
	}
	
	public void setCity(String c)
	{
		this.city = c;
	}
	
	public void setState(String s)
	{
		this.state = s;
	}
	
	public void setZip(String z)
	{
		this.zip = z;
	}
	
	public void setPreferredDoctor(String p)
	{
		this.preferredDoctor = p;
	}
	
	public void setPatientRecordList(PatientRecordLinkedList p)
	{
		this.patientRecordList = p;
	}
	
	//testable print method
	public void printInfo()
	{
		System.out.println("Date of birth: " + this.DOB + 
				"\nAddress: " + this.address + 
				"\nPreferred Doctor: " + this.preferredDoctor + 
				"\nEmail: " + super.email + 
				"\nHospital: " + super.hospital + 
				"\nName: " + super.name + 
				"\nPassword: " + super.password +
				"\nPhone Number: " + super.phone + "\n");
	}
	
}

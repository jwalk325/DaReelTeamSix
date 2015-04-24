import java.io.Serializable;


public class Patient extends Information implements Serializable{
	
	//variables
	String DOB;
	String address;
	String preferredDoctor;
	PatientRecordLinkedList patientRecordList;
	
	//constructor
	public Patient(String d, String ad, String pd, String n, String e, String ph, String p, String h, String q, String a) 
	 {
		 super(n, e, ph, p, h, q, a);
		 this.DOB = d;
		 this.address = ad;
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

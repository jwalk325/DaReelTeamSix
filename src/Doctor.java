
public class Doctor extends Information {
	
	//variables
	private PatientLinkedList patientList;
	
	//constructor
	 public Doctor(PatientLinkedList pl, String n, String e, String ph, String p, String q, String a) 
	 {
		 super(n, e, ph, p, q, a);
		 this.patientList = pl;
	 } 
	
	//getters
	public PatientLinkedList getPatientList()
	{
		return patientList;
	}
		
	//setters
	public void setPatientlist(PatientLinkedList p)
	{
		this.patientList = p;
	}
	
	//testable print method
	public String printInfo()
	{
		return super.email + super.name + super.password + super.phone;
	}
}


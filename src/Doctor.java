
public class Doctor extends Information {
	
	//variables
	private PatientLinkedList patientList;
	private NotificationLinkedList notificationList;
	
	//constructor
	 public Doctor(PatientLinkedList pl, String n, String e, String ph, String p, String q, String a) 
	 {
		 super(n, e, ph, p, q, a);
		 this.patientList = pl;
		 notificationList = new NotificationLinkedList();
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
	
	public void insertNoticationList(String name, PatientRecord pr)
	{
		notificationList.insert(name, pr);
	}
	
	public NotificationLinkedList getNotifcationsList()
	{
		return notificationList;
	}
	
}


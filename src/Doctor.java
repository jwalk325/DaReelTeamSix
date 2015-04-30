//The doctor class includes doctor information, a list of patients, and a notification list
//It also inherits information from the information class

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
	
	public NotificationLinkedList getNotifcationsList()
	{
		return notificationList;
	}
		
	//setters
	public void setPatientlist(PatientLinkedList p)
	{
		this.patientList = p;
	}
	
	//insert a new notification
	public void insertNoticationList(String name, PatientRecord pr)
	{
		notificationList.insert(name, pr);
	}
	
}


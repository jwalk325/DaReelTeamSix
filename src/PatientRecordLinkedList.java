import java.io.Serializable;

class PatientRecordNode implements Serializable
{
	PatientRecordNode next;
    PatientRecord patientRecord;

    public PatientRecordNode(PatientRecord p) 
    {
        patientRecord = p;
        next = null;
    }
}

public class PatientRecordLinkedList implements Serializable
{
	PatientRecordNode head;
	
	public void insert(PatientRecord p) 
	{
		PatientRecordNode temp = head;
        head = new PatientRecordNode(p);
        head.next = temp;
    }
	
	public void printList()
	{
		PatientRecordNode temp = head;
		
		while(temp != null)
		{
			temp.patientRecord.printInfo();
			temp = temp.next;
		}
	}
	
	//SEARCH FOR PATIENT RECORD BY INPUT
	public PatientRecord searchByInput(String input)
	{
		PatientRecordNode temp = head;
		
		while(temp != null)
		{
			if (input.compareTo(temp.patientRecord.get())==0)//patient record found
				return temp.patientRecord;
			temp = temp.next;
		}
		
		return null;
	}
	
}
//PatientRecordsLinkedList contains a list of records for a patient

import java.io.Serializable;

//node information
class PatientRecordNode implements Serializable
{
	protected PatientRecordNode next;
    protected PatientRecord patientRecord;
    
    //constructor
    public PatientRecordNode(PatientRecord p) 
    {
        patientRecord = p;
        next = null;
    }
    
    //getter
    public PatientRecordNode getNext()
    {
    	return next;
    }
}

public class PatientRecordLinkedList implements Serializable
{
	//variables
	private PatientRecordNode head;
	
	//constructor
	PatientRecordLinkedList()
	{
		head = null;
	}
	
	//getters
	public PatientRecordNode getHead()
	{
		return head;
	}
	
	//fillRecordDates is used to fill the record drop down bar in the doctors record view
	public String[] fillRecordDates()
	{
		PatientRecordNode temp = head;
		String[] records = new String[count()+1];//create array with the needed return size
		records[0] = "";//make the first selection empty forcing the doctor to select a patient
		for(int i = 1; temp != null; i++)//traverse Records in list
		{
			records[i] = temp.patientRecord.getDate();//store record in returned array
			temp = temp.next;
		}
		return records;//return array
	}
	
	//counts the number of records in the list
	public int count()
	{
		PatientRecordNode temp = head;
		int count = 0;
		while(temp != null)//traverse list
		{
			count++;
			temp = temp.next;
		}
		return count;
	}	
	
	//inserts a new record at the head of the list
	public void insert(PatientRecord p) 
	{
		PatientRecordNode temp = head;
        head = new PatientRecordNode(p);
        head.next = temp;
    }
}
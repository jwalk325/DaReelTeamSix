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
	
	//constructor
	PatientRecordLinkedList()
	{
		head = null;
	}
	
	//print patient list
		public String[] fillRecordDates()
		{
			PatientRecordNode temp = head;
			String[] records = new String[count()+1];
			records[0] = "";
			for(int i = 1; temp != null; i++)
			{
				records[i] = temp.patientRecord.getDate();
				temp = temp.next;
			}
			return records;
		}
			
		public int count()
		{
			PatientRecordNode temp = head;
			int count = 0;
			while(temp != null)
			{
				count++;
				temp = temp.next;
			}
			return count;
		}	
	
	public void insert(PatientRecord p) 
	{
		PatientRecordNode temp = head;
        head = new PatientRecordNode(p);
        head.next = temp;
    }

}
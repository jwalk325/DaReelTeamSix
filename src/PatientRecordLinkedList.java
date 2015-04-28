import java.io.Serializable;

class PatientRecordNode implements Serializable
{
	protected PatientRecordNode next;
    protected PatientRecord patientRecord;

    public PatientRecordNode(PatientRecord p) 
    {
        patientRecord = p;
        next = null;
    }
    
    public PatientRecordNode getNext()
    {
    	return next;
    }
}

public class PatientRecordLinkedList implements Serializable
{

	private PatientRecordNode head;
	
	//constructor
	PatientRecordLinkedList()
	{
		head = null;
	}
	
	public PatientRecordNode getHead()
	{
		return head;
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
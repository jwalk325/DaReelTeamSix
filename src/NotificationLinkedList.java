//NotificationLinkedList contains a list of reports that have not been accessed by the doctor
//It is used by the doctor class

import java.io.Serializable;

//node information
class NotificationNode implements Serializable
{
	//variables
	protected NotificationNode next;
	protected String name;
	protected PatientRecord patientRecord;
	
	//constructor
    public NotificationNode(String n, PatientRecord pr) 
    {
    	name = n;
        patientRecord = pr;
        next = null;
    }
    
    //getters
    public NotificationNode getNext(){
    	return next;
    }
    
    public String getLastName(){
    	return name.substring(name.indexOf(' '));
    }
    
    public String getFirstName(){
    	return name.substring(0, name.indexOf(' '));
    }
    
    public String getName(){
    	return name;
    }
}

public class NotificationLinkedList implements Serializable
{
	//variables
	private NotificationNode head;
	
	//constructor
	NotificationLinkedList()
	{
		head = null;
	}
	
	//getters
	public NotificationNode getHead(){
		return head;
	}
	
	//insert a new record at the head of the list
	public void insert(String name, PatientRecord pr) 
	{
		NotificationNode temp = head;
        head = new NotificationNode(name, pr);
        head.next = temp;
    }
	
	//delete a record from the list
	public void delete(String name, PatientRecord pr)
	{
		NotificationNode current = head;//temp pointer
		
		while(current != null)//traverse list
		{
			if(current.getName().equals(name) && current.patientRecord.getDate().equals(pr.getDate()))//patient found
			{
				if(head == current)//if at the head of the list
				{
					head = current.next;
					return;
				}
				
				NotificationNode prev = head;
				while(prev.next != current){
					prev = prev.next;
				}
				
				if(current.next == null)//if at the end of the list
				{
					prev.next = null;
					return;
				}
				else //if in-between 2 nodes
				{
					prev.next = current.next;
					return;
				}			
			}
			else //next
			{
				current = current.next;
			}
		}
	}

}
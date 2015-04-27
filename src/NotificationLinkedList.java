import java.io.Serializable;

class NotificationNode implements Serializable
{
	NotificationNode next;
	String name;
    PatientRecord patientRecord;

    public NotificationNode(String n, PatientRecord pr) 
    {
    	name = n;
        patientRecord = pr;
        next = null;
    }
    
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
	NotificationNode head;
	
	//constructor
	NotificationLinkedList()
	{
		head = null;
	}
	
	public void insert(String name, PatientRecord pr) 
	{
		NotificationNode temp = head;
        head = new NotificationNode(name, pr);
        head.next = temp;
    }
	
	public void delete(String name, PatientRecord pr){
		NotificationNode current = head;
		
		while(current != null){
			if(current.getName().equals(name) && current.patientRecord.getDate().equals(pr.getDate())){
				if(head == current){
					head = current.next;
					return;
				}
				
				NotificationNode prev = head;
				while(prev.next != current){
					prev = prev.next;
				}
				
				if(current.next == null){
					prev.next = null;
					return;
				}
				else{
					prev.next = current.next;
				}			
			}
			else{
				current = current.next;
			}
		}
	}

}
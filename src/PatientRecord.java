import java.io.Serializable;


public class PatientRecord implements Serializable{
	
	//variables
	int pain;
	final int painThresh = 4;
	int tiredness;
	final int tirednessThresh = 6;
	int nasuea;
	final int nasueaThresh = 6;
	int depression;
	final int depressionThresh = 4;
	int anxiety;
	final int anxietyThresh = 4;
	int drowsiness;
	final int drowsinessThresh = 6;
	String recordDate;
	String pComment1;
	String pComment2;
	String dComments;
	
	//default constructor
	public PatientRecord()
	{
		this.pain = 0;
		this.tiredness = 0;
		this.nasuea = 0;
		this.depression = 0;
		this.anxiety = 0;
		this.drowsiness = 0;
	}
	
	//constructor
	public PatientRecord(int p, int t, int n, int d, int a, int dr, String r, String c1, String c2) 
	 {
		this.pain = p;
		this.tiredness = t;
		this.nasuea = n;
		this.depression = d;
		this.anxiety = a;
		this.drowsiness = dr;
		this.recordDate = r;
		this.pComment1 = c1;
		this.pComment2 = c2;
	 } 
	
	//getters
	public int getPain()
	{
		return pain;
	}
	
	public int getTiredness()
	{
		return tiredness;
	}
	
	public int getNasuea()
	{
		return nasuea;
	}
	
	public int getDepression()
	{
		return depression;
	}
	
	public int getAnxiety()
	{
		return anxiety;
	}
	
	public int getDrowsiness()
	{
		return drowsiness;
	}
	
	public String getDate()
	{
		return recordDate;
	}
	
	public String getComments()
	{
		return pComment1 + "\n\n" + pComment2;
	}
	
	public String getDComments(){
		return dComments;
	}
		
	//setters
	public void setPain(int p)
	{
		this.pain = p;
	}
	
	public void setTiredness(int t)
	{
		this.tiredness = t;
	}
	
	public void setNasuea(int n)
	{
		this.nasuea = n;
	}
	
	public void setDepression(int d)
	{
		this.depression = d;
	}
	
	public void setAnxiety(int a)
	{
		this.anxiety = a;
	}
	
	public void setDrowsiness(int d)
	{
		this.drowsiness = d;
	}
	
	public void setDate(String d)
	{
		this.recordDate = d;
	}
	
	public void setComment1(String c)
	{
		this.pComment1 = c;
	}
	
	public void setComment2(String c)
	{
		this.pComment2 = c;
	}
	
	public void setDComments(String d){
		dComments = d;
	}
	
	public String getPriority(){
		if (
			pain >= painThresh + 3 ||
			tiredness >= tirednessThresh + 3 ||
			nasuea >= nasueaThresh + 3 ||
			depression >= depressionThresh + 3 ||
			anxiety >= anxietyThresh + 3 ||
			drowsiness >= drowsinessThresh + 3
		){
			return "High";
		}
		else if (
				pain >= painThresh + 2 ||
				tiredness >= tirednessThresh + 2 ||
				nasuea >= nasueaThresh + 2 ||
				depression >= depressionThresh + 2 ||
				anxiety >= anxietyThresh + 2 ||
				drowsiness >= drowsinessThresh + 2
			){
				return "Medium";
			}
		else {
			return "Low";
		}
	}
	
	public String getSeverity()
	{
		if
		(
			pain >= painThresh+3 ||
			tiredness >= tirednessThresh+3 ||
			nasuea >= tirednessThresh+3 ||
			depression >= depressionThresh+3 ||
			anxiety >= anxietyThresh+3 ||
			drowsiness >= drowsinessThresh+3
		)
			return "High";
		else if
		(
				pain >= painThresh+2 ||
				tiredness >= tirednessThresh+2 ||
				nasuea >= tirednessThresh+2 ||
				depression >= depressionThresh+2 ||
				anxiety >= anxietyThresh+2 ||
				drowsiness >= drowsinessThresh+2	
		)
			return "Medium";
		else
			return "Low";
	}
	
}


import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


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
	public PatientRecord(int p, int t, int n, int d, int a, int dr) 
	 {
		this.pain = p;
		this.tiredness = t;
		this.nasuea = n;
		this.depression = d;
		this.anxiety = a;
		this.drowsiness = dr;
		Date today = Calendar.getInstance().getTime();   
		DateFormat df = new SimpleDateFormat("MM/dd/yy");
		this.recordDate = df.format(today);
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
	
}


import java.io.Serializable;


public class PatientRecord implements Serializable{
	
	//variables
	int pain;
	int tiredness;
	int nasuea;
	int depression;
	int anxiety;
	int drowsiness;
	
	//constructor
	public PatientRecord(int p, int t, int n, int d, int a, int dr) 
	 {
		this.pain = p;
		this.tiredness = t;
		this.nasuea = n;
		this.depression = d;
		this.anxiety = a;
		this.drowsiness = dr;
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
	
	public void printInfo()
	{
		
	}
	
}


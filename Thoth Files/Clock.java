import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;
import java.time.*;
import java.time.LocalTime;
import java.time.temporal.*;
import java.util.Scanner;  
import java.util.Timer;
import java.util.TimerTask;

    
public class Clock 
{
	Scanner keyboard= new Scanner(System.in);
	Scanner in = new Scanner(System.in).useDelimiter("[,\\s+]");
	String userIn;
	int ahr, amin, asec;
	int hr, min, sec;
	MainClass myMain = new MainClass();
	;
	LocalTime time;
	
	public Clock()
	{
		
	}
	public Clock(int hours, int minutes, int seconds) //constructor 
    {
        hr = hours;
        min = minutes;
        sec = seconds;
    }
	
	

	public int getHr() {
		return hr;
	}
	public void setHr(int hr) {
		this.hr = hr;
	}
	
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	
	public int getSec() {
		return sec;
	}
	public void setSec(int sec) {
		this.sec = sec;
	}
	
	public void setTime(LocalTime time) 
	{
		this.time = time;
	}
	
	public LocalTime getTime() 
	{
		return time;
	}
	
	public void options()
	{
		
		System.out.println("What would you like? Do you want me to tell you the the current time or set a timer?");
		userIn = keyboard.nextLine();
		myMain.cmds.add(userIn);
		
		setTime(LocalTime.now());
		
		setHr(time.getHour());
		setMin(time.getMinute());
		setSec(time.getSecond());
		
		
		
		if((userIn.toLowerCase().contains("time") && userIn.toLowerCase().contains("what")) || ( userIn.toLowerCase().contains("time") && userIn.toLowerCase().contains("current")))
		{
			System.out.println(getTime());
			
		}else if(userIn.toLowerCase().contains("alarm"))//Not an advertised feature
		{
			
			System.out.println("When would you like to set the alarm for?");
			System.out.print("Please enter the time in this format: HH,MM,SS Thank You! ");
			ahr = in.nextInt();
			amin = in.nextInt();
			asec = in.nextInt();
			
			AlarmClock myAlarm = new AlarmClock(hr, min, sec, ahr, amin, asec);
			System.out.println(myAlarm.toString());
			System.out.println(myAlarm.equals(myAlarm));
			
		}else if (userIn.toLowerCase().contains("timer"))
		{
			
			TimerActual timer = new TimerActual();
			
			try {
				timer.time();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			
		}
		
	}

}

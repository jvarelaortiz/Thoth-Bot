import java.util.*;
import java.util.ArrayList;

class Helper extends TimerTask
{
    public static int i = 0;
    int count = 0;
    Scanner keyboard= new Scanner(System.in);
    int limit = 0;
    MainClass myMain = new MainClass();
    
    public void run()
    {
    	if(count == 0)
    	{
    	System.out.print("How many seconds would you like me to count? ");
    	limit = keyboard.nextInt();
    	myMain.cmds.add(limit + " seconds");
    	//myMain.cmds.add(Integer.toString(limit));
    	System.out.println("Understood");
    	}
        if(i == limit)
        {
            synchronized(TimerActual.obj)
            {
                TimerActual.obj.notify();
            }
        }
        
        System.out.println("Timer ran " + i );
        ++i;
        count++;
    }
     
}
 
 
public class TimerActual
{
	
    protected static TimerActual obj;
    public void time() throws InterruptedException
    {
        obj = new TimerActual();
         
        //creating a new instance of timer class
        Timer timer = new Timer();
        TimerTask task = new Helper();
 
        //instance of date object for fixed-rate execution
        Date date = new Date();
 
        timer.scheduleAtFixedRate(task, date, 1000);
         
        
        synchronized(obj)
        {
            //make the main thread wait
            obj.wait();
             
            //once timer has scheduled the task 4 times,
            //main thread resumes
            //and terminates the timer
            timer.cancel();
             
            //purge is used to remove all cancelled
            //tasks from the timer'stack queue
            System.out.println(timer.purge());
            System.out.println("DONE!!!");
        }
    }
}
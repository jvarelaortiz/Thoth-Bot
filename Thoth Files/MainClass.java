import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.*;  

public class MainClass 
{
	static List<String> cmds = new ArrayList<>();
	static Scanner in = new Scanner(System.in);
	static Scanner keyboard= new Scanner(System.in);
	
	
	public static void main(String[] args) throws IOException 
	{
		
		String userIn;
		boolean valid = true;
		int tries= 0;
		String name;
		
		Person myPerson = new Person();
		Clock myClock = new Clock();
		Calculator myCalc = new Calculator();
		Calendar myCalendar = new Calendar();
		
       
		
		
		do {
		//Different responses to number of tries
			if (tries == 0) 
			{
				System.out.print("Hello, my name is Geoffrey! What should I call you? ");  
				myPerson.setName(keyboard.nextLine());
			}else if(tries > 0 && tries < 5 )
			{
				System.out.print("Hahaha, Enter a real name: ");  
				myPerson.setName(keyboard.nextLine());
			}
			else if(tries >= 5 && tries < 10)
			{
				System.out.print("Okay, jokes over. Enter a real name: ");  
				myPerson.setName(keyboard.nextLine());
			}
			else if(tries == 10)
			{
				System.out.print("Okay, goodbye. ");  
				System.exit(0);
			}
		
			name = myPerson.getName();
			
			//check to see if string has numbers
			char[] chars = name.toCharArray();
		    for(char c : chars)
		    {
		      if(Character.isDigit(c))
		      {
		            valid = false;
		      }else if(!Character.isDigit(c))
		      {
		    	  valid = true;
		      }
		    }
		    tries++;
		}while(!valid);
	     
		//Continue Program
		System.out.println("");
		System.out.println("Hello, " + myPerson.getName() + ".");
		if(myPerson.getName().toLowerCase().contains("Saba") || myPerson.getName().toLowerCase().contains("Jamalian") )
		{
			System.out.println("Hello Proffesor you are an admin. Therefore you have acess to the ADMIN command in the next prompt.");
			
		}
		valid = false;
		
		do {
		System.out.printf("\nWhat would you like me to do? You can always ask for HELP: ");
		userIn = keyboard.nextLine();
		cmds.add(userIn);
		//Multiple cases
		if(userIn.toLowerCase().contains("help"))//Hidden option is ADMIN use to see all previous commands
		{
			System.out.printf("You can ask me to access my CLOCK functions, do MATH operations, and check the CALENDAR or tell me to go to SLEEP.\n");
			
		}else if(userIn.toLowerCase().contains("clock"))
		{
			
			myClock.options();
			
		}else if(userIn.toLowerCase().contains("math") || userIn.toLowerCase().contains("calculator"))
		{
			
			myCalc.options();
			
		}else if(userIn.toLowerCase().contains("calendar"))
		{
			myCalendar.options();
		}else if(userIn.toLowerCase().contains("admin"))// HIDDEN function only accessible to admins
		{
			if(myPerson.getName().toLowerCase().contains("saba") || myPerson.getName().toLowerCase().contains("jamalian") || myPerson.getName().toLowerCase().contains("juan") )
			{
				System.out.println("Entering ADMIN mode...");
			admin();
			}else
			{
				System.out.println("What are you doing not only do you not have acess you also shouldnt have knowledge of this function");
			}
		}else if(userIn.toLowerCase().contains("sleep"))
		{
			System.out.println("Goodnight " + name +"." );
			valid = true;
		}else 
		{
			valid = false;
		}
		}while(!valid);
		


	}
	
	public static void admin()
	{
		int userNum;
		String userIn2;
		boolean done = false;
		System.out.println(cmds);
		do 
		{
			
		
		System.out.println("1.Remove");
		System.out.println("2.Leave");
		userNum = in.nextInt();
		if(userNum == 1) 
		{
			System.out.println("Type the entry you wish to remove...");
			userIn2 = keyboard.nextLine();
			cmds.remove(userIn2);
			System.out.println("Revised List:" + cmds);
		}else if(userNum == 2)
		{
			System.out.println("Leaving ADMIN mode...");
			done = true;
		}
		}while(!done);
		
		System.out.println("Revised List:" + cmds);
	}

	
}

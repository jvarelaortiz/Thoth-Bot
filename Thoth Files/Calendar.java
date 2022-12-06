import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

//TODO
public class Calendar 
{
	ArrayList<String> ShoppingList = new ArrayList<>();
	Scanner keyboard = new Scanner(System.in);
	Scanner in = new Scanner(System.in);
	MainClass myMain = new MainClass();
	File myFile = new File("ShoppingList.txt");

	public void options() throws IOException
	{
		
		
		String userIn;
		FileOutputStream fos = new FileOutputStream(myFile);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		BufferedReader br = new BufferedReader(new FileReader("ShoppingList.txt"));
		Path fileName = Path.of(myFile.getPath());
		boolean done = false;
		do
		{
		System.out.printf("\nWould you like to see todays DATE, CREATE a shopping list, or VIEW the current list: ");
		userIn = keyboard.nextLine();
		myMain.cmds.add(userIn);
		
		if(userIn.toLowerCase().contains("date") || userIn.toLowerCase().contains("today"))
		{
			today();
			
		}else if(userIn.toLowerCase().contains("create"))
		{
			createList(fileName, bw);
			
		}else if(userIn.toLowerCase().contains("view"))
		{
			viewList(fileName, br);
		}
		else if(userIn.toLowerCase().contains("done"))
		{
			done = true;
		}
		System.out.printf("\nRemmember to let me know when you are DONE. ");
		}while(!done);
	}
	
	public static void today() 
	{
		//System.out.println(java.time.LocalDatetime.now());
		
		LocalDateTime myDate = LocalDateTime.now();
	    DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	    String formattedDate = myDate.format(myFormat);
	    System.out.println("It is currently: " + formattedDate);
		
	}
	
	public void createList(Path fileName, BufferedWriter bw)
	{
		boolean done = false;
		int count = 0;
		String userIn2;
				
		System.out.printf("\nEnter the first item in your shopping list: ");
		userIn2 = keyboard.nextLine();
		
		try {
			bw.write(userIn2);
			bw.newLine();
			
		
		do 
		{
							
			
				System.out.printf("\nUnless you are DONE, enter the next item: ");
				userIn2 = keyboard.nextLine();
				
				if(userIn2.toLowerCase().contains("done"))
				{
					done = true;
					//myWriter.close();
				}else
				{
					bw.write(userIn2);
					bw.newLine();
				}
			
			
			count++;
			
		}while(!done);
		bw.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void viewList(Path fileName, BufferedReader br) throws IOException
	{
		String line;
		 while ((line = br.readLine()) != null) {
		   System.out.println(line);
		 }
	}

	
}


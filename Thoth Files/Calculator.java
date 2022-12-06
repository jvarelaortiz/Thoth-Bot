import java.util.Scanner;  

public class Calculator 
{
	//Math options
	public void options()
	{
		Scanner input = new Scanner(System.in); 
		String userIn;
		int userNum;
		boolean exit = false;
		MainClass myMain = new MainClass();
		
		
		do {
			System.out.printf("\nWhat can I help you with?");
			
			System.out.println("I am campable of preforming a number of operations. If you wish to know exactly what or simply need a refresher you can ask for HELP");
			System.out.println("Let me know when youre DONE");
			userIn = input.nextLine();
			myMain.cmds.add(userIn);
			//Multiple cases
			if(userIn.toLowerCase().contains("help"))
			{
				System.out.println("You can ask me to preform basic CALCULATOR functions, solve a QUADRATIC equation, find the FACTORIAL of a number, and find a RANDOM number.");
				System.out.println("Let me know when youre DONE");
				
			}else if(userIn.toLowerCase().contains("quad"))
			{
				//quadratic
				System.out.print("Enter the value of a: ");  
				double a = input.nextDouble();  
				System.out.print("Enter the value of b: ");  
				double b = input.nextDouble();  
				System.out.print("Enter the value of c: ");  
				double c = input.nextDouble(); 
				quadratic(a,b,c);
				
				
			}else if(userIn.toLowerCase().contains("calculator"))
			{
				//TODO add math functions
				System.out.println("Do you wish to: ");
				System.out.println("1. Add? ");
				System.out.println("2. Subtract? ");
				System.out.println("3. Multiply? ");
				System.out.println("4. Divide? ");
				System.out.println("5. Exponential? ");
				System.out.println("6. Back? ");
				userNum = input.nextInt();
				if(userNum == 1)
				{
					myMain.cmds.add("**Add**");
					System.out.println("Enter the first number:");
					int a = input.nextInt();
					System.out.println("Enter the second number:");
					int b = input.nextInt();
					System.out.println(a + " + " + b + " = " + add(a, b));
				}else if(userNum == 2)
				{
					myMain.cmds.add("**Subtract**");
					System.out.println("Enter the first number:");
					int a = input.nextInt();
					System.out.println("Enter the second number:");
					int b = input.nextInt();
					System.out.println(a + " - " + b + " = " + subtract(a, b));
				}else if(userNum == 3)
				{
					myMain.cmds.add("**Multiply**");
					System.out.println("Enter the first number:");
					int a = input.nextInt();
					System.out.println("Enter the second number:");
					int b = input.nextInt();
					System.out.println(a + " * " + b + " = " + multiplication(a, b));
				}else if(userNum == 4)
				{
					myMain.cmds.add("**Divide**");
					System.out.println("Enter the dividend:");
					int dividend = input.nextInt();
					System.out.println("Enter the divisor:");
					int divisor = input.nextInt();
					System.out.println(dividend + " / " + divisor + " = " + division(dividend, divisor));
					
				}else if(userNum == 5)
				{
					myMain.cmds.add("**Exponential**");
					System.out.println("Enter the base number:");
					int base = input.nextInt();
					System.out.println("Enter the power number:");
					int exp = input.nextInt();
					System.out.println(base + "^" + exp + " = " + exponential(base, exp));
				}else if(userNum == 6)
				{
					options();
				}
				
			}else if(userIn.toLowerCase().contains("factorial"))
			{
				//TODO add calendar
				System.out.println("Enter a value: ");
				userNum = input.nextInt();
				System.out.println(userNum + "! = " + factorial(userNum));
			}else if(userIn.toLowerCase().contains("slope") || userIn.toLowerCase().contains("intercept"))
			{
				
				
				
			}else if(userIn.toLowerCase().contains("random"))
			{
				System.out.println("What is your desired range? Enter the upper limit and I will supply you a number within that range");
				userNum = input.nextInt();
				System.out.println("Here is the number as requested: " + randomNum(userNum));
				
				
			}else if(userIn.toLowerCase().contains("done"))
			{
				
				exit = true;
			}else 
			{
				exit = false;
			}
			}while(!exit);
		
		
		
		
	}
	
	public int add(int i, int n)
	{
		int res = i + n;
		
		return res;
		
	}
	public int subtract(int i, int n)
	{
		int res = i - n;
		
		return res;
		
	}
	public int multiplication(int i, int n)
	{
		int res = i * n;
		
		return res;
	}
	public int division(int dividend, int divisor)
	{
		int res = dividend/divisor;
		
		return res;
	}
	public long factorial(int in)
	{
		long fact = 1;
	    for (int i = 2; i <= in; i++) 
	    {
	        fact = fact * i;
	    }
	    return fact;
	}
	public void quadratic(double a, double b, double c)
	{
		 
		 
		double d= b * b - 4.0 * a * c;  
		if (d> 0.0)   
		{  
		double r1 = (-b + Math.pow(d, 0.5)) / (2.0 * a);  
		double r2 = (-b - Math.pow(d, 0.5)) / (2.0 * a);  
		System.out.println("The roots are " + r1 + " and " + r2);  
		}   
		else if (d == 0.0)   
		{  
		double r1 = -b / (2.0 * a);  
		System.out.println("The root is " + r1);  
		}   
		else   
		{  
		System.out.println("Roots are not real.");  
		}  
		
		
	}  
		
	//TODO
	public void slopeIntercept()
	{
		
	}
		
	public double exponential(int num, int exp)
	{
		double res = 0;
		for(int i = 0; i <= exp; i++)
		{
			res = res * num;
			
		}
		res = Math.pow(num, exp);
		return res;
	}
	
	public double randomNum(int a)
	{
		double res = Math.random() * a; //random form 0 to a
		
		return res;
	}
	
	//TODO mean median mode

}

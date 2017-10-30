package View;
import Controller.*;
import Exceptions.ControllerExceptions;
import Exceptions.ViewExceptions;
import java.util.Scanner;
public class View {
	private MyIController ctrl;
	public View(MyIController cont)
	{
		ctrl= cont;
	}
	private void printMenu()
	{
		System.out.println("1. Example 1");
		System.out.println("2. Example 2");
		System.out.println("3. Example 3");
		System.out.println("4. Exit");
	}
	
	private void printSubMenu()
	{
		System.out.println("1. One step");
		System.out.println("2. All steps");
		System.out.println("3. Reset");
		System.out.println("4. Back");
		
	}
	
	public void run()
	{
		while(true){
			try{
				this.printMenu();
				Scanner key = new Scanner(System.in);
				System.out.println("Enter command: ");
				int command = key.nextInt();
				if(command==4)
					break;
				else if (command==1)
				{
					while(true)
					{
						this.printSubMenu();
						System.out.println("Enter command: ");
						int command2 = key.nextInt();
						if(command2==1)
							ctrl.oneStep(0);
						else if(command2==2)
							ctrl.allSteps(0);
						else if(command2==4)
							break;
						else if(command2==3)
							ctrl.resetProgram(0);
					}
					
				}
				
				else if (command==2)
				{
					while(true)
					{
						this.printSubMenu();
						System.out.println("Enter command: ");
						int command2 = key.nextInt();
						if(command2==1)
							ctrl.oneStep(1);
						else if(command2==2)
							ctrl.allSteps(1);
						else if(command2==4)
							break;
						else if(command2==3)
							ctrl.resetProgram(1);
					}
					
				}
				
				else if (command==3)
				{
					while(true)
					{
						this.printSubMenu();
						System.out.println("Enter command: ");
						int command2 = key.nextInt();
						if(command2==1)
							ctrl.oneStep(2);
						else if(command2==2)
							ctrl.allSteps(2);
						else if(command2==4)
							break;
						else if(command2==3)
							ctrl.resetProgram(2);
					}
					
				}
				
			
			}
			catch(ControllerExceptions e)
			{
				System.out.println(e.getMessage());
			}
			
		
		}
		
	}
	
}

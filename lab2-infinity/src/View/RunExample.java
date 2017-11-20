package View;

import java.util.Scanner;

import Controller.MyController;
import Exceptions.ControllerExceptions;

public class RunExample extends Command {
	private MyController ctrl;
	public RunExample(String k, String d, MyController c){
		super(k,d);
		ctrl=c;
	}
	
	@Override
	public void execute()
	{
		try{
			System.out.println("Give the log path: \n");
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			this.ctrl.setLogPath(scan.nextLine());
			ctrl.allSteps();
		}catch(ControllerExceptions e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	

}

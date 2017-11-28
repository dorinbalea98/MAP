package Controller;
import Exceptions.ControllerExceptions;
import Statements.PrgState;
public interface MyIController {
	public PrgState oneStep() throws ControllerExceptions; 
	public void allSteps() throws ControllerExceptions;
	public void setLogPath(String log);
} 

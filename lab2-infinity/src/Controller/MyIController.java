package Controller;
import model.PrgState;
import Exceptions.ControllerExceptions;
public interface MyIController {
	public PrgState oneStep() throws ControllerExceptions; 
	public void allSteps() throws ControllerExceptions;
	public void setLogPath(String log);
} 

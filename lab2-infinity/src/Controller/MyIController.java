package Controller;
import model.PrgState;
import Exceptions.ControllerExceptions;
public interface MyIController {
	public PrgState oneStep(int index) throws ControllerExceptions; 
	public void allSteps(int index) throws ControllerExceptions;
	public void completeExcecution(int index) throws ControllerExceptions;
	public void resetProgram(int index) throws ControllerExceptions;
} 

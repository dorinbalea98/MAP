package Controller;
import java.util.List;

import Exceptions.ControllerExceptions;
import Statements.PrgState;
public interface MyIController {
	//public PrgState oneStep() throws ControllerExceptions; 
	public void allSteps() throws ControllerExceptions;
	public void setLogPath(String log);
	List<PrgState> removeCompletedPrg(List<PrgState> prgList);
	public void oneStepForAllPrg(List<PrgState> prgList);
} 

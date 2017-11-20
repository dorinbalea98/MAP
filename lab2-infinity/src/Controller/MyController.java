package Controller;

import Exceptions.ControllerExceptions;
import Exceptions.MyStackException;
import Exceptions.RepoExceptions;
import Exceptions.StmtExceptions;
import Repository.MyIRepository;
import model.PrgState;
import model.IStmt;
import tools.MyIStack;
public class MyController implements MyIController{

	private MyIRepository repo;
	public MyController(MyIRepository r)
	{
		repo=r;
	}
	@Override
	public PrgState oneStep() throws ControllerExceptions {
		
		try{
			PrgState state = repo.getCurrentPrg();
			MyIStack<IStmt> stk = state.getStack();
			this.repo.logPrgStateExec();
			IStmt crtStmt = stk.pop();
			return crtStmt.execute(state);
		}
		catch(MyStackException e)
		{
			throw new ControllerExceptions(e.getMessage());
		}
		catch(StmtExceptions ex)
		{
			throw new ControllerExceptions(ex.getMessage());
		}
		catch(RepoExceptions re)
		{
			throw new ControllerExceptions(re.getMessage());
		}
	}

	@Override
	public void allSteps() throws ControllerExceptions {
		try{
			
			while(true)
			{
				this.repo.setCurrentPrg(oneStep());
			
			}
		}
		catch(ControllerExceptions e)
		{
			if(e.getMessage().toLowerCase().equals("stack is empty!"))
				throw new ControllerExceptions("End of execution");
			else
				throw new ControllerExceptions(e.getMessage());
		}
		catch(RepoExceptions r)
		{
			throw new ControllerExceptions(r.getMessage());
		}
		
		
	}
	@Override
	public void setLogPath(String log) {
		this.repo.setLogPath(log);
	}


}

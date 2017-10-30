package Controller;

import Exceptions.ControllerExceptions;
import Exceptions.MyListException;
import Exceptions.MyStackException;
import Exceptions.RepoExceptions;
import Exceptions.StmtExceptions;
import Repository.MyIRepository;
import model.PrgState;
import model.IStmt;
import tools.MyIStack;
import tools.MyIList;
import tools.MyList;
public class MyController implements MyIController{

	private MyIRepository repo;
	private MyIList<PrgState> auxList;
	public MyController(MyIRepository r)
	{
		auxList = new MyList<PrgState>();
		repo=r;
		try{
		for(int i=0; i<repo.getPrograms().length();i++)
		{
			auxList.append(repo.getPrograms().get_value(i));
		}
		}
		catch(MyListException e){}
	}
	@Override
	public PrgState oneStep(int index) throws ControllerExceptions {
		
		try{
			PrgState state = repo.getPrgOnPosition(index);
			MyIStack<IStmt> stk = state.getStack();
			System.out.println(state.getStack().toString());
			System.out.println(state.getSymtbl().toString());
			System.out.println(state.getOut().toString());
			System.out.println();
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
	public void allSteps(int index) throws ControllerExceptions {
		try{
			
			while(true)
			{
				oneStep(index);
			
			}
		}
		catch(ControllerExceptions e)
		{
			if(e.getMessage().toLowerCase().equals("stack is empty!"))
				throw new ControllerExceptions("End of execution");
			else
				throw new ControllerExceptions(e.getMessage());
		}
		
		
	}
	@Override
	public void completeExcecution(int index) throws ControllerExceptions {
		try{
			PrgState state = repo.getPrgOnPosition(index);
			MyIStack<IStmt> stk = state.getStack();
			while(!stk.is_empty())
			{
				System.out.println(stk.toString());
				System.out.println(state.getSymtbl().toString());
				System.out.println(state.getOut().toString());
				System.out.println();
				IStmt crtStmt = stk.pop();
				state= crtStmt.execute(state);
				
			}
		}
		catch(RepoExceptions re)
		{
			throw new ControllerExceptions(re.getMessage());
		}
		catch(MyStackException se)
		{
			throw new ControllerExceptions(se.getMessage());
		} catch (StmtExceptions e) {
			throw new ControllerExceptions(e.getMessage());
		}
		
		
		
	}
	@Override
	public void resetProgram(int index) throws ControllerExceptions {
		try{
			repo.update(index, auxList.get_value(index));
		}
		catch(MyListException e )
		{
			throw new ControllerExceptions(e.getMessage());
		}
	}

}

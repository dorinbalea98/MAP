package Controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import Exceptions.ControllerExceptions;
import Exceptions.MyStackException;
import Exceptions.RepoExceptions;
import Exceptions.StmtExceptions;
import Repository.MyIRepository;
import Statements.IStmt;
import Statements.PrgState;
import tools.MyIStack;
public class MyController implements MyIController{

	private MyIRepository repo;
	Map<Integer,Integer> conservativeGarbageCollector(Collection<Integer> symTableValues,
			Map<Integer,Integer> heap){
			return heap.entrySet().stream()
			 .filter(e->symTableValues.contains(e.getKey()))
			 .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));}
	public MyController(MyIRepository r)
	{
		repo=r;
	}
	@Override
	public PrgState oneStep() throws ControllerExceptions {
		
		try{
			PrgState state = repo.getCurrentPrg();
			MyIStack<IStmt> stk = state.getStack();
			state.getHeap().setContent(conservativeGarbageCollector(state.getSymtbl().getContent().values(), state.getHeap().getContent()));
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
		finally
		{
			try{
				this.repo.getCurrentPrg().getFileTable().entrySet().stream()
				.forEach(s->{
					try{
						s.getValue().getSecondElement().close();
					}catch(IOException e){
						System.out.println("\n" + e.getMessage());
					}
				});
			}catch(RepoExceptions r){
				throw new ControllerExceptions(r.getMessage());
			}
		}
			
		
	}
	@Override
	public void setLogPath(String log) {
		this.repo.setLogPath(log);
	}


}

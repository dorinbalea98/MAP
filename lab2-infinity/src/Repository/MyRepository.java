package Repository;

import model.PrgState;
import tools.MyIList;
import tools.MyList;
import Exceptions.MyListException;
import Exceptions.RepoExceptions;
public class MyRepository implements MyIRepository{
	private MyIList<PrgState> programs;
	private int index;
	
	public MyRepository()
	{
		programs = new MyList<PrgState>();
		index=0;
	}
	
	public void addProgram(PrgState p)
	{
		programs.append(p);
	}
	@Override
	public PrgState getCurrentPrg() {
		if(index+1==programs.length())
			index=0;
		try
		{
			return programs.get_value(index++);
		}
		catch(MyListException e){
			return null;
		}
	}

	@Override
	public PrgState getPrgOnPosition(int i) throws RepoExceptions {
		try
		{
			return programs.get_value(i);
		}
		catch(MyListException e){
			throw new RepoExceptions(e.getMessage());
		}
	}

	@Override
	public MyIList<PrgState> getPrograms() {
		return this.programs;
	}

	@Override
	public void update(int index, PrgState state) {
		programs.update(index, state);
		
	}
}

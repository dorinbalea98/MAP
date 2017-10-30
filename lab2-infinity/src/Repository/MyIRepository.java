package Repository;
import model.PrgState;
import tools.MyIList;
import Exceptions.RepoExceptions;
public interface MyIRepository  {
	public PrgState getCurrentPrg();
	public PrgState getPrgOnPosition(int i) throws RepoExceptions;
	public void addProgram(PrgState p);
	public MyIList<PrgState> getPrograms();
	public void update(int index, PrgState state);
}

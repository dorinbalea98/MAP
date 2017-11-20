package Repository;
import model.PrgState;
import tools.MyIList;


import Exceptions.RepoExceptions;
public interface MyIRepository  {
	public PrgState getCurrentPrg() throws RepoExceptions;
	public void addProgram(PrgState p);
	public MyIList<PrgState> getPrograms();
	public void setCurrentPrg(PrgState state) throws RepoExceptions;
	public void logPrgStateExec() throws RepoExceptions;
	public void setLogPath(String path);
	public String getPath();
}

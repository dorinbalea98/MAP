package Repository;
import tools.MyIList;


import Exceptions.RepoExceptions;
import Statements.PrgState;
public interface MyIRepository  {
	public PrgState getCurrentPrg() throws RepoExceptions;
	public void addProgram(PrgState p);
	public MyIList<PrgState> getPrograms();
	public void setCurrentPrg(PrgState state) throws RepoExceptions;
	public void logPrgStateExec() throws RepoExceptions;
	public void setLogPath(String path);
	public String getPath();
}

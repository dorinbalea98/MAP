package Repository;

import java.util.List;

import Exceptions.RepoExceptions;
import Statements.PrgState;
public interface MyIRepository  {
	public void addProgram(PrgState p);
	public void logPrgStateExec(PrgState state) throws RepoExceptions;
	public void setLogPath(String path);
	public List<PrgState> getPrgList();
	void setPrgList(List<PrgState> l);
	public String getPath();
}

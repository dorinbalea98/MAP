package Repository;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


import Exceptions.RepoExceptions;
import Statements.PrgState;
public class MyRepository implements MyIRepository{
	private List<PrgState> programs;
	String filename;
	public MyRepository(PrgState state)
	{
		programs =new ArrayList<PrgState>();;
		programs.add(state);
			}
	
	public void addProgram(PrgState p)
	{
		programs.add(p);
	}
	


	
	@Override
	public void logPrgStateExec(PrgState state) throws RepoExceptions {
		try{
			java.io.File f = new java.io.File(this.filename);
			if(!f.exists() || f.isDirectory())
				throw new RepoExceptions("IOException: File does not exist");
			
			PrintWriter log= new PrintWriter(new BufferedWriter(new FileWriter(this.filename, true)));
			log.print(state.toString());			
			log.close();
		}catch(IOException e)
		{
			throw new RepoExceptions("IOException" + e.getMessage());
		}
		
	}

	

	@Override
	public void setLogPath(String path) {
		this.filename=path;
	}

	@Override
	public String getPath() {
		return this.filename;
	}

	@Override
	public List<PrgState> getPrgList() {
		return this.programs;
	}

	@Override
	public void setPrgList(List<PrgState> l) {
		this.programs=l;
	}

}

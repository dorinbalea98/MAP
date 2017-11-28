package Repository;

import tools.MyIList;
import tools.MyList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Exceptions.MyListException;
import Exceptions.RepoExceptions;
import Statements.PrgState;
public class MyRepository implements MyIRepository{
	private MyIList<PrgState> programs;
	private int index;
	String filename;
	public MyRepository(PrgState state)
	{
		programs = new MyList<PrgState>();
		programs.append(state);
		index=0;
			}
	
	public void addProgram(PrgState p)
	{
		programs.append(p);
	}
	@Override
	public PrgState getCurrentPrg() throws RepoExceptions {
		try{
		return programs.get_value(index);
		}
		catch(MyListException e)
		{
			throw new RepoExceptions("No prgstate at index");
		}
		
	}


	@Override
	public MyIList<PrgState> getPrograms() {
		return this.programs;
	}

	
	@Override
	public void logPrgStateExec() throws RepoExceptions {
		try{
			java.io.File f = new java.io.File(this.filename);
			if(!f.exists() || f.isDirectory())
				throw new RepoExceptions("IOException: File does not exist");
			
			PrintWriter log= new PrintWriter(new BufferedWriter(new FileWriter(this.filename, true)));
			log.print(this.getCurrentPrg().toString());			
			log.close();
		}catch(IOException e)
		{
			throw new RepoExceptions("IOException" + e.getMessage());
		}
		
	}

	@Override
	public void setCurrentPrg(PrgState state) throws RepoExceptions {
		try{
			programs.update(0, state);
		}
		catch(MyListException e)
		{
			throw new RepoExceptions("Program is missing!");
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
}

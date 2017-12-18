package Statements;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import Exceptions.MyDictionaryExceptions;
import Exceptions.StmtExceptions;
import tools.MyIDictionary;
import tools.MyTuple;


public class OpenRFile implements IStmt{
	String var_file_id;
	String filename;
	
	public OpenRFile(String var_id, String fn)
	{
		var_file_id=var_id;
		filename=fn;
	}
	@Override
	public PrgState execute(PrgState state) throws StmtExceptions {
		MyIDictionary<Integer, MyTuple<String, BufferedReader>> filetable=state.getFileTable();
		MyIDictionary<String,Integer> symtbl = state.getSymtbl();
		
		try{
			if(filetable.ExistsInFirst(filename))
				throw new StmtExceptions("File is already opened!");
		}catch(MyDictionaryExceptions e){
			throw new StmtExceptions(e.getMessage());
		}
		BufferedReader buffReader;
		try{
			buffReader=new BufferedReader(new FileReader(filename));
		}catch(FileNotFoundException e1){
			throw new StmtExceptions("File \"" + filename + "\" not found");
		}
		MyTuple<String, BufferedReader>  entry = new MyTuple<String, BufferedReader>(filename, buffReader);
		int id = filetable.generateId();
		filetable.add(id, entry);
		symtbl.add(var_file_id,id);
		return null;
		
	}
	
	@Override
	public String toString()
	{
		return "openRFile(" + var_file_id +", " + "\"" + filename + "\")";
	}
}

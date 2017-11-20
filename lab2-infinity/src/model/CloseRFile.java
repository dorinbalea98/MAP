package model;

import java.io.BufferedReader;
import java.io.IOException;

import Exceptions.ExpressionException;
import Exceptions.MyDictionaryExceptions;
import Exceptions.StmtExceptions;
import tools.MyIDictionary;
import tools.MyTuple;

public class CloseRFile implements IStmt{
	Expression exp_file_id;
	public CloseRFile(Expression e)
	{
		exp_file_id=e;
	}
	@Override
	public PrgState execute(PrgState state) throws StmtExceptions {
		MyIDictionary<Integer, MyTuple<String, BufferedReader>> filetable=state.getFileTable();
		MyIDictionary<String,Integer> symtbl= state.getSymtbl();
		int v;
		try{
			v=exp_file_id.Eval(symtbl);
		}catch(ExpressionException e)
		{
			throw new StmtExceptions(e.getMessage());
		}
		try{
			BufferedReader buffReader = filetable.get_value(v).getSecondElement();
			buffReader.close();
			filetable.delete(v);
		}catch(IOException i){
			throw new StmtExceptions("File does not exist or has not been opened!");
		}catch(MyDictionaryExceptions i){
			throw new StmtExceptions("File does not exist or has not been opened!");
		}
		return state;
	}
	
	@Override
	public String toString()
	{
		return "closeRFile(" + exp_file_id.toString() + ")";
	}

}

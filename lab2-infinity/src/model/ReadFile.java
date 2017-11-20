package model;

import java.io.BufferedReader;
import java.io.IOException;

import Exceptions.ExpressionException;
import Exceptions.MyDictionaryExceptions;
import Exceptions.StmtExceptions;
import tools.MyIDictionary;
import tools.MyTuple;

public class ReadFile implements IStmt {
	public Expression exp_file_id;
	public String var_name;
	
	public ReadFile(Expression e, String v)
	{
		exp_file_id=e;
		var_name=v;
	}
	
	
	@Override
	public PrgState execute(PrgState state) throws StmtExceptions {
		MyIDictionary<Integer, MyTuple<String, BufferedReader>> filetable=state.getFileTable();
		MyIDictionary<String,Integer> symtbl=state.getSymtbl();
		int v;
		BufferedReader buffReader;
		
		try{
			v= exp_file_id.Eval(symtbl);
		}catch(ExpressionException e)
		{
			throw new StmtExceptions("Invalid expression!");
		}
		
		try{
			buffReader=filetable.get_value(v).getSecondElement();
		}catch(MyDictionaryExceptions d){
			throw new StmtExceptions("File does not exist");
		}
		
		try{
			String reader= buffReader.readLine();
			int value;
			if(reader==null)
			{
				value=0;
			}
			else
			{
				value=Integer.parseInt(reader);
			}
			symtbl.add(var_name, value);
		}catch(NumberFormatException n){
			throw new StmtExceptions(n.getMessage());
		}catch(IOException i){
			throw new StmtExceptions(i.getMessage());
		}
		return state;
		
	}

	@Override
	public String toString()
	{
		return "readFile(" + exp_file_id + ", " +  var_name + ")";
	}
}

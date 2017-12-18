package Statements;


import java.util.Iterator;
import java.util.Map.Entry;

import Exceptions.StmtExceptions;
import tools.MyDictionary;
import tools.MyIDictionary;
import tools.MyIStack;
import tools.MyStack;

public class Fork implements IStmt{
	IStmt stmt;
	public Fork(IStmt s)
	{
		stmt=s;
	}
	@Override
	public PrgState execute(PrgState state) throws StmtExceptions {
		MyIStack<IStmt> stk = new MyStack<IStmt>();
		MyIDictionary<String,Integer> symtbl= new MyDictionary<String,Integer>();
		Iterator<Entry<String,Integer>> it = state.getSymtbl().getIterator();
		while(it.hasNext()){
			Entry<String,Integer> next = it.next();
			String key = next.getKey();
			Integer value = next.getValue();
			System.out.println(key + "  " + value);
			symtbl.add(key, value);
		}
		PrgState newState = new PrgState(stk, symtbl, state.getOut(), state.getFileTable(), 
				state.getHeap(), stmt, state.getId()*10);
		return newState;
	}
	@Override
	public String toString(){
		String rez="";
		rez+="Fork( " + stmt.toString() +")";
		return rez;
	}

}

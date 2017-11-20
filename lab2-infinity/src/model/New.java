package model;

import Exceptions.ExpressionException;
import Exceptions.StmtExceptions;
import tools.MyIDictionary;

public class New implements IStmt {
	String var_name;
	Expression exp;
	@Override
	public PrgState execute(PrgState state) throws StmtExceptions {
		MyIDictionary<String,Integer> symtbl= state.getSymtbl();
		MyIDictionary<Integer,Integer> heap = state.getHeap();
		try{
			int v=heap.generateId();
			symtbl.add(var_name, v);
			heap.add(v, exp.Eval(symtbl, heap));
			return state;
		}catch(ExpressionException e){
			throw new StmtExceptions(e.getMessage());
		}
	}

}

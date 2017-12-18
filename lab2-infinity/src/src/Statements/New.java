package Statements;

import Exceptions.ExpressionException;
import Exceptions.StmtExceptions;
import Expressions.Expression;
import tools.MyIDictionary;

public class New implements IStmt {
	String var_name;
	Expression exp;
	public New(String v, Expression e){
		var_name=v;
		exp=e;
	}
	@Override
	public PrgState execute(PrgState state) throws StmtExceptions {
		MyIDictionary<String,Integer> symtbl= state.getSymtbl();
		MyIDictionary<Integer,Integer> heap = state.getHeap();
		try{
			int v=heap.generateId();
			symtbl.add(var_name, v);
			heap.add(v, exp.Eval(symtbl, heap));
			return null;
		}catch(ExpressionException e){
			throw new StmtExceptions(e.getMessage());
		}
	}
	@Override
	public String toString(){
		return "New( " + var_name +", " + exp.toString() + ")";
	}

}

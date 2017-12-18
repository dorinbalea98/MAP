package Statements;

import Exceptions.ExpressionException;
import Exceptions.MyDictionaryExceptions;
import Exceptions.StmtExceptions;
import Expressions.Expression;
import tools.MyIDictionary;

public class WriteHeap implements IStmt{
	String var_name;
	Expression exp;
	public WriteHeap(String v, Expression e){
		var_name=v;
		exp=e;
	}
	@Override
	public PrgState execute(PrgState state) throws StmtExceptions {
		MyIDictionary<String,Integer> symtbl = state.getSymtbl();
		MyIDictionary<Integer,Integer> heap = state.getHeap();
		try{
			int v = symtbl.get_value(var_name);
			if(!heap.exists(v))
				throw new StmtExceptions("Invalid address!");
			heap.update(v, exp.Eval(symtbl, heap));
			return null;
		}catch(MyDictionaryExceptions d){
			throw new StmtExceptions(d.getMessage());
		}catch(ExpressionException e){
			throw new StmtExceptions(e.getMessage());
		}
			
		
	}
	
	@Override
	public String toString(){
		return "wH( " + var_name +", " + exp.toString() +")";
	}
	
}

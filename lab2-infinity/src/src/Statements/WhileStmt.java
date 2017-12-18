package Statements;

import Exceptions.ExpressionException;
import Exceptions.StmtExceptions;
import Expressions.Expression;
import tools.MyIDictionary;
import tools.MyIStack;

public class WhileStmt implements IStmt{
	Expression exp;
	IStmt stmt;
	public WhileStmt(Expression e, IStmt i){
		exp=e;
		stmt=i;
	}
	
	@Override
	public PrgState execute(PrgState state) throws StmtExceptions {
		MyIStack<IStmt> stk = state.getStack();
		MyIDictionary<String,Integer>tbl = state.getSymtbl();
		MyIDictionary<Integer,Integer> heap=state.getHeap();
		try{
			if(exp.Eval(tbl, heap)!=0){
				stk.push(this);
				stk.push(stmt);
				
			}
			return null;
		}catch(ExpressionException e){
			throw new StmtExceptions(e.getMessage());
		}
	}
	
	@Override
	public String toString(){
		return "While( " + exp.toString()  + stmt.toString() +") "; 
	}

}

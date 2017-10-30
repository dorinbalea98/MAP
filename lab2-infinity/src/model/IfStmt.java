package model;
import Exceptions.ExpressionException;
import Exceptions.StmtExceptions;
import tools.MyIDictionary;
import tools.MyIStack;
public class IfStmt implements IStmt{
	private Expression exp;
	private IStmt thenS;
	private IStmt elseS;
	public IfStmt(Expression expr, IStmt t, IStmt e)
	{
		exp=expr;
		thenS=t;
		elseS=e;
	}
	
	@Override
	public String toString()
	{
		return "IF(" + exp.toString() +") THEN(" +thenS.toString() + ") ELSE(" + elseS.toString() + ")";
	}
	
	@Override
	public PrgState execute(PrgState state) throws StmtExceptions
	{
		MyIDictionary<String,Integer> symtbl = state.getSymtbl();
		MyIStack<IStmt> exeStack = state.getStack();
		try{
			if(exp.Eval(symtbl)!=0)
				exeStack.push(thenS);
			else
				exeStack.push(elseS);
			return state;
		}
		catch(ExpressionException e)
		{
			throw new StmtExceptions(e.getMessage());
		}

		 
	}
}

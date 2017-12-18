package Statements;
import Exceptions.ExpressionException;
import Exceptions.StmtExceptions;
import Expressions.Expression;
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
		MyIDictionary<Integer,Integer> heap = state.getHeap();
		try{
			if(exp.Eval(symtbl,heap)!=0)
				exeStack.push(thenS);
			else
				exeStack.push(elseS);
			return null;
		}
		catch(ExpressionException e)
		{
			throw new StmtExceptions(e.getMessage());
		}

		 
	}
}

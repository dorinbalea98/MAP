package Statements;
import tools.MyIList;
import tools.MyIDictionary;
import Exceptions.ExpressionException;
import Exceptions.StmtExceptions;
import Expressions.Expression;
public class PrintStmt implements IStmt {
	Expression exp;
	public PrintStmt(Expression e)
	{
		exp=e;
	}
	
	@Override
	public String toString()
	{
		return "print(" + exp.toString() +")";
	}
	public PrgState execute(PrgState state) throws StmtExceptions
	{
		MyIList<Integer> list = state.getOut();
		MyIDictionary<String, Integer> dic=state.getSymtbl();
		MyIDictionary<Integer,Integer> heap = state.getHeap();
		try{
			list.append(exp.Eval(dic, heap));
			return state;
		}
		catch (ExpressionException e)
		{
			throw new StmtExceptions(e.getMessage());
		}
	}
}

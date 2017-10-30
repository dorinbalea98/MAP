package model;
import tools.MyIList;
import tools.MyIDictionary;
import Exceptions.ExpressionException;
import Exceptions.StmtExceptions;
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
		try{
			list.append(exp.Eval(dic));
			return state;
		}
		catch (ExpressionException e)
		{
			throw new StmtExceptions(e.getMessage());
		}
	}
}

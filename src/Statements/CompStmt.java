package Statements;
import tools.MyIStack;
public class CompStmt implements IStmt{
	IStmt first;
	IStmt second;
	
	public CompStmt(IStmt f, IStmt s)
	{
		first=f;
		second=s;
	}
	@Override
	public PrgState execute(PrgState state) {
		MyIStack<IStmt> stk = state.getStack();
		stk.push(second);
		stk.push(first);
		return state;
	}
	@Override
	public String toString()
	{
		return "" + first.toString() +" ; " + second.toString();
	}
	
}

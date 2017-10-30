package model;
import tools.MyIDictionary;
import Exceptions.StmtExceptions;
import Exceptions.ExpressionException;
public class AssignmentStmt implements IStmt{
	private String id;
	private Expression exp;
	public AssignmentStmt(String i, Expression e)
	{
		id=i;
		exp=e;
	}
	@Override
	public String toString()
	{
		return id + "=" + exp.toString();
	}
	@Override
	public PrgState execute(PrgState state) throws StmtExceptions {
		MyIDictionary<String,Integer> symtbl = state.getSymtbl();
		try{
			int val=exp.Eval(symtbl);
			if (symtbl.exists(id))
				symtbl.update(id, val);
			else
				symtbl.add(id, val);
		}
		catch(ExpressionException e){
			throw new StmtExceptions(e.getMessage());
		}
		return state;
	} 

}

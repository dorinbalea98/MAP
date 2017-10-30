package model;
import tools.*;
public class PrgState {
	private MyIStack<IStmt> exeStack;
	private MyIDictionary<String, Integer> symtbl;
	private MyIList<Integer> out;
	private IStmt originalProgram;
	
	public PrgState(MyIStack<IStmt> stk, MyIDictionary<String,Integer> sym, MyIList<Integer> o, IStmt prg)
	{
		exeStack=stk;
		symtbl=sym;
		out=o;
		originalProgram=prg;
		stk.push(prg);
		
	}
	
	public MyIStack<IStmt> getStack()
	{
		return this.exeStack;
	}
	
	public MyIDictionary<String,Integer> getSymtbl()
	{
		return this.symtbl;
	}
	
	public MyIList<Integer> getOut()
	{
		return this.out;
	}
	
	public IStmt getOriginalProgram()
	{
		return this.originalProgram;
	}
	
	public void setStack(MyIStack<IStmt> stk)
	{
		this.exeStack=stk;
	}
	
	public void setSymtbl(MyIDictionary<String,Integer> dic)
	{
		this.symtbl=dic;
	}
	
	public void setOut(MyIList<Integer> l)
	{
		this.out=l;
	}
	
	public void setOriginalProgram(IStmt orp)
	{
		this.originalProgram=orp;
	}
	
	@Override
	public String toString()
	{
		//to be implemented
		return null;
	}
	
} 

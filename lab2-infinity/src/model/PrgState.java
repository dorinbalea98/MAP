package model;
import java.io.BufferedReader;

import tools.*;
public class PrgState {
	private MyIStack<IStmt> exeStack;
	private MyIDictionary<String, Integer> symtbl;
	private MyIDictionary<Integer, MyTuple<String, BufferedReader>> filetable;
	private MyIList<Integer> out;
	private MyIDictionary<Integer,Integer> heap;
	private IStmt originalProgram;
	
	public PrgState(MyIStack<IStmt> stk, MyIDictionary<String,Integer> sym, MyIList<Integer> o,MyIDictionary<Integer, MyTuple<String, BufferedReader>> ft, MyIDictionary<Integer,Integer> heap ,IStmt prg)
	{
		exeStack=stk;
		symtbl=sym;
		out=o;
		originalProgram=prg;
		filetable=ft;
		this.heap=heap;
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
	
	public MyIDictionary<Integer, MyTuple<String, BufferedReader>> getFileTable()
	{
		return this.filetable;
	}
	
	public MyIDictionary<Integer,Integer> getHeap()
	{
		return this.heap;
	}
	
	public void setHeap(MyIDictionary<Integer,Integer> heap)
	{
		this.heap=heap;
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
	
	public void setFileTable(MyIDictionary<Integer, MyTuple<String, BufferedReader>> ft)
	{
		this.filetable=ft;
	}
	
	public void setOriginalProgram(IStmt orp)
	{
		this.originalProgram=orp;
	}
	
	@Override
	public String toString()
	{
		String res="";
		res+=this.getStack().toString() +'\n';
		res+=this.getSymtbl().toString()+'\n';
		res+=this.getOut().toString() + '\n';
		res+=this.getFileTable().toString();
		res+='\n';
		return res;
	}
	
} 

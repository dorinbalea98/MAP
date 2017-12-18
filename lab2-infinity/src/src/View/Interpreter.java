package View;
import tools.*;

import java.io.BufferedReader;

import Controller.*;
import Expressions.ArithExpression;
import Expressions.ConstExpression;
import Expressions.ReadHeapExpression;
import Expressions.VarExpression;
//import Expressions.leExpression;
import Repository.*;
import Statements.*;
public class Interpreter {
	public static void main(String[] args)
	{
		IStmt orp = new CompStmt(
						new OpenRFile("var_f", "test.in"),
						new CompStmt(
								new ReadFile(new VarExpression("var_f"), "var_c"),
								new PrintStmt(new VarExpression("var_c"))));
		
		IStmt ifs =new IfStmt(
						new VarExpression("var_c"),
						new CompStmt(
								new ReadFile(new VarExpression("var_f"), "var_c"),
								new PrintStmt(new VarExpression("var_c"))),
						new PrintStmt(new ConstExpression(0)));
		IStmt a = new CompStmt(ifs, new CloseRFile(new VarExpression("var_f")));
		IStmt ex1 = new CompStmt(orp, a);
		
		
		MyIStack<IStmt> stk = new MyStack<IStmt>();
		MyIDictionary<String,Integer> symtbl = new MyDictionary<String,Integer>();
		MyIList<Integer> out = new MyList<Integer>();
		MyIDictionary<Integer, MyTuple<String,BufferedReader>> filetable = new MyFileDictionary<Integer, MyTuple<String,BufferedReader>>();
		MyIDictionary<Integer,Integer> heap = new MyHeapDictionary<Integer,Integer>();
		PrgState state = new PrgState(stk, symtbl, out, filetable,heap, ex1,1);
		MyRepository repo = new MyRepository(state);
		MyController ctrl = new MyController(repo);
		
		IStmt aaa = new CompStmt(
							new OpenRFile("var_f", "test.in"),
							new CompStmt(
									new ReadFile(new ArithExpression(new VarExpression("var_f"), new ConstExpression(2),1),"var_c"),
									new PrintStmt(new VarExpression("var_c")))
							);
		
		IStmt ex2=new CompStmt(aaa, a);
		MyIStack<IStmt> stk1 = new MyStack<IStmt>();
		MyIDictionary<String,Integer> symtbl1 = new MyDictionary<String,Integer>();
		MyIList<Integer> out1 = new MyList<Integer>();
		MyIDictionary<Integer, MyTuple<String,BufferedReader>> filetable1 = new MyFileDictionary<Integer, MyTuple<String,BufferedReader>>();
		MyIDictionary<Integer,Integer> heap1 = new MyHeapDictionary<Integer,Integer>();
		PrgState state1 = new PrgState(stk1, symtbl1, out1, filetable1,heap1,ex2,1);
		MyRepository repo1 = new MyRepository(state1);
		MyController ctrl1 = new MyController(repo1);
		
		
		
		IStmt ex3=  
				new CompStmt(
						new CompStmt(
							new AssignmentStmt("v", new ConstExpression(10)),
							new New("v", new ConstExpression(20))
							),
						new CompStmt(
							new New("a", new ConstExpression(22)),
							new PrintStmt(new VarExpression("v"))
							)
						);
				
				
				
		MyIStack<IStmt> stk2 = new MyStack<IStmt>();
		MyIDictionary<String,Integer> symtbl2 = new MyDictionary<String,Integer>();
		MyIList<Integer> out2 = new MyList<Integer>();
		MyIDictionary<Integer, MyTuple<String,BufferedReader>> filetable2 = new MyFileDictionary<Integer, MyTuple<String,BufferedReader>>();
		MyIDictionary<Integer,Integer> heap2 = new MyHeapDictionary<Integer,Integer>();
		PrgState state2 = new PrgState(stk2, symtbl2, out2, filetable2,heap2,ex3,1);
		MyRepository repo2 = new MyRepository(state2);
		MyController ctrl2 = new MyController(repo2);
		
		IStmt ex4=
				new CompStmt(
						new CompStmt(
							new CompStmt(
								new AssignmentStmt("v", new ConstExpression(10)),
								new New("v", new ConstExpression(20))
								),
							new CompStmt(
								new New("a", new ConstExpression(22)),
								new PrintStmt(new ArithExpression(new ConstExpression(100), new ReadHeapExpression("v"), 1))
								)
						),
						new PrintStmt(new ArithExpression(new ConstExpression(100), new ReadHeapExpression("a"), 1))
					);
		
		MyIStack<IStmt> stk3 = new MyStack<IStmt>();
		MyIDictionary<String,Integer> symtbl3 = new MyDictionary<String,Integer>();
		MyIList<Integer> out3 = new MyList<Integer>();
		MyIDictionary<Integer, MyTuple<String,BufferedReader>> filetable3 = new MyFileDictionary<Integer, MyTuple<String,BufferedReader>>();
		MyIDictionary<Integer,Integer> heap3 = new MyHeapDictionary<Integer,Integer>();
		PrgState state3 = new PrgState(stk3, symtbl3, out3, filetable3,heap3,ex4,1);
		MyRepository repo3 = new MyRepository(state3);
		MyController ctrl3 = new MyController(repo3);
		
		/*
		IStmt ex5=new CompStmt(
				new AssignmentStmt("v", new ConstExpression(1)),
				new WhileStmt(new leExpression(new VarExpression("v"), new ConstExpression(3)),
						new CompStmt(
								new PrintStmt(new VarExpression("v")),
								new AssignmentStmt("v", new ArithExpression(new VarExpression("v"), new ConstExpression(2),1))))
				);
		*/
		IStmt frk = new CompStmt(
				new WriteHeap("a", new ConstExpression(30)),
				new CompStmt(
						new AssignmentStmt("v", new ConstExpression(32)),
						new CompStmt(
								new PrintStmt(new VarExpression("v")),
								new PrintStmt(new ReadHeapExpression("a")))));
				
		IStmt ex5= new CompStmt(
				new CompStmt(
						new AssignmentStmt("v", new ConstExpression(10)),
						new New("a", new ConstExpression(22))),
				new CompStmt(
						new Fork(frk),
						new CompStmt(
								new PrintStmt(new VarExpression("v")),
								new PrintStmt(new ReadHeapExpression("a")))
						));
		MyIStack<IStmt> stk4 = new MyStack<IStmt>();
		MyIDictionary<String,Integer> symtbl4 = new MyDictionary<String,Integer>();
		MyIList<Integer> out4 = new MyList<Integer>();
		MyIDictionary<Integer, MyTuple<String,BufferedReader>> filetable4 = new MyFileDictionary<Integer, MyTuple<String,BufferedReader>>();
		MyIDictionary<Integer,Integer> heap4 = new MyHeapDictionary<Integer,Integer>();
		PrgState state4 = new PrgState(stk4, symtbl4, out4, filetable4,heap4,ex5,1);
		MyRepository repo4 = new MyRepository(state4);
		MyController ctrl4 = new MyController(repo4);
		
		
		TextMenu menu = new TextMenu();
		menu.addCommand(new Exit("0","exit"));
		menu.addCommand(new RunExample("1", ex1.toString(), ctrl));
		menu.addCommand(new RunExample("2", ex2.toString(), ctrl1));
		menu.addCommand(new RunExample("3", ex3.toString(), ctrl2));
		menu.addCommand(new RunExample("4", ex4.toString(), ctrl3));
		menu.addCommand(new RunExample("5", ex5.toString(), ctrl4));
		menu.show();
		
	}
}

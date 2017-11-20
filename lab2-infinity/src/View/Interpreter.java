package View;
import model.*;
import tools.*;

import java.io.BufferedReader;

import Controller.*;
import Repository.*;
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
		PrgState state = new PrgState(stk, symtbl, out, filetable, ex1);
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
		PrgState state1 = new PrgState(stk1, symtbl1, out1, filetable1, ex2);
		MyRepository repo1 = new MyRepository(state1);
		MyController ctrl1 = new MyController(repo1);
		
		
		
		
		
		
		
		TextMenu menu = new TextMenu();
		menu.addCommand(new Exit("0","exit"));
		menu.addCommand(new RunExample("1", ex1.toString(), ctrl));
		menu.addCommand(new RunExample("2", ex2.toString(), ctrl1));
		menu.show();
		
	}
}

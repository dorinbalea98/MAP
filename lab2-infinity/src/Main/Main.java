package Main;
import model.*;
import tools.*;
import Controller.*;
import Repository.*;
import View.View;
public class Main {
	public static void main(String[] args)
	{
		//v=2;Print(v)
		IStmt ex1 = new CompStmt(new AssignmentStmt("v", new ConstExpression(2)), new PrintStmt(new VarExpression("v")));
		MyIStack<IStmt> stk = new MyStack<IStmt>();
		MyIDictionary<String, Integer> symtbl = new MyDictionary<String,Integer>();
		MyIList<Integer> out = new MyList<Integer>();
		PrgState state = new PrgState(stk, symtbl, out, ex1);
		
		//a=2+3*5; b= a+1; print(b)
		ArithExpression ari = new ArithExpression(new ConstExpression(2), new ArithExpression(new ConstExpression(3), new ConstExpression(5), 3),1);
		AssignmentStmt asign = new AssignmentStmt("a", ari);
		AssignmentStmt asign2 = new AssignmentStmt("b", new ArithExpression(new VarExpression("a"),new ConstExpression(1),1));
		PrintStmt prt= new PrintStmt(new VarExpression("b"));
		IStmt ex2 = new CompStmt(asign, new CompStmt(asign2, prt));

		MyIStack<IStmt> stk2 = new MyStack<IStmt>();
		MyIDictionary<String, Integer> symtbl2 = new MyDictionary<String,Integer>();
		MyIList<Integer> out2 = new MyList<Integer>();
		PrgState state2 = new PrgState(stk2, symtbl2, out2, ex2);
		
		//a=2-2; (If a Then v=2 Else v=3); print(v)
		
		AssignmentStmt asign3 = new AssignmentStmt("a", new ArithExpression(new ConstExpression(2), new ConstExpression(2), 2));
		CompStmt ifff = new CompStmt(new IfStmt(new VarExpression("a"), new AssignmentStmt("v", new ConstExpression(2)), new AssignmentStmt("v",
				new ConstExpression(3))), new PrintStmt(new VarExpression("v")));
		IStmt ex3 = new CompStmt(asign3, ifff);
		
		
		MyIStack<IStmt> stk3 = new MyStack<IStmt>();
		MyIDictionary<String, Integer> symtbl3 = new MyDictionary<String,Integer>();
		MyIList<Integer> out3 = new MyList<Integer>();
		PrgState state3 = new PrgState(stk3, symtbl3, out3, ex3);
		
		
		MyIRepository repo = new MyRepository();
		repo.addProgram(state);
		repo.addProgram(state2);
		repo.addProgram(state3);
		MyIController c = new MyController(repo);
		View v = new View(c);
		v.run();
	}	
}

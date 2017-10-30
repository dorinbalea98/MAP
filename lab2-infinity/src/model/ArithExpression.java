package model;

import tools.MyIDictionary;
import Exceptions.ExpressionException;

public class ArithExpression extends Expression{
	Expression first;
	Expression second;
	int op;
	public ArithExpression(Expression exp1, Expression exp2, int op)
	{
		first=exp1;
		second=exp2;
		this.op=op;
	}
	
	@Override
	public int Eval(MyIDictionary<String, Integer> tbl) throws ExpressionException {
		if(op==1)
			return (first.Eval(tbl) + second.Eval(tbl));
		
		if(op==2)
			return (first.Eval(tbl) - second.Eval(tbl));
		
		if(op==3)
			return (first.Eval(tbl) * second.Eval(tbl));
		
		if(op==4)
		{
			if(second.Eval(tbl)==0)
				throw new ExpressionException("Division by 0");
			return (first.Eval(tbl) / second.Eval(tbl));
			
		}
		return 0;
	}
	@Override
	public String toString() {
		char[] operators= { '+', '-', '*', '/' };
		return "(" + first.toString() + operators[op-1] + second.toString() + ")";
	}
}

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
	public int Eval(MyIDictionary<String, Integer> tbl,MyIDictionary<Integer, Integer> heap) throws ExpressionException {
		if(op==1)
			return (first.Eval(tbl,heap) + second.Eval(tbl,heap));
		
		if(op==2)
			return (first.Eval(tbl,heap) - second.Eval(tbl,heap));
		
		if(op==3)
			return (first.Eval(tbl,heap) * second.Eval(tbl,heap));
		
		if(op==4)
		{
			if(second.Eval(tbl,heap)==0)
				throw new ExpressionException("Division by 0");
			return (first.Eval(tbl,heap) / second.Eval(tbl,heap));
			
		}
		return 0;
	}
	@Override
	public String toString() {
		char[] operators= { '+', '-', '*', '/' };
		return "(" + first.toString() + operators[op-1] + second.toString() + ")";
	}
}

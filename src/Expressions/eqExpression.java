package Expressions;

import Exceptions.ExpressionException;
import tools.MyIDictionary;

public class eqExpression extends Expression {
	Expression first;
	Expression second;
	
	public eqExpression(Expression e1, Expression e2){
		first=e1;
		second=e2;
	}
	@Override
	public int Eval(MyIDictionary<String, Integer> tbl, MyIDictionary<Integer, Integer> heap)
			throws ExpressionException {
		if(first.Eval(tbl, heap) == second.Eval(tbl, heap))
			return 1;
		return 0;
	}

	@Override
	public String toString() {
		return "( " + first.toString() + " == " + second.toString() +")";
	}

}

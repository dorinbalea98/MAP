package model;

import Exceptions.ExpressionException;
import tools.MyIDictionary;

public class ConstExpression extends Expression{
	private int number;
	public ConstExpression(int n)
	{
		number=n;
	}
	@Override
	public int Eval(MyIDictionary<String, Integer> tbl,MyIDictionary<Integer, Integer> heap) throws ExpressionException {
		return number;
	}

	@Override
	public String toString() {
		return ""+number;
	}
	
}

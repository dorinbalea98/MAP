package model;

import Exceptions.ExpressionException;
import Exceptions.MyDictionaryExceptions;
import tools.MyIDictionary;

public class VarExpression extends Expression {
	private String id;
	public VarExpression(String i)
	{
		id=i;
	}
	@Override
	public int Eval(MyIDictionary<String, Integer> tbl, MyIDictionary<Integer,Integer> heap) throws ExpressionException {
		try{
			return tbl.get_value(id); 
		}
		catch(MyDictionaryExceptions e)
		{
			throw new ExpressionException(e.getMessage());
		}
	}

	@Override
	public String toString() {
		return id;
	}

}

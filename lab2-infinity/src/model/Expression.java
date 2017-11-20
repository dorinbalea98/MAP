package model;
import tools.MyIDictionary;
import Exceptions.ExpressionException;
public abstract class Expression {
	public abstract int Eval(MyIDictionary<String,Integer> tbl, MyIDictionary<Integer, Integer> heap) throws ExpressionException;
	@Override
	public abstract String toString();
}

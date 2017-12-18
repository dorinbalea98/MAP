package Expressions;

import Exceptions.ExpressionException;
import Exceptions.MyDictionaryExceptions;
import tools.MyIDictionary;

public class ReadHeapExpression extends Expression {
	public String var_name;
	
	public ReadHeapExpression(String vn){
		var_name=vn;
	}
	@Override
	public int Eval(MyIDictionary<String, Integer> tbl, MyIDictionary<Integer, Integer> heap)
			throws ExpressionException {
		try{
			int v=tbl.get_value(var_name);
			return heap.get_value(v);
		}catch(MyDictionaryExceptions d){
			throw new ExpressionException(d.getMessage());
		}
		
	}

	@Override
	public String toString() {
		return "rH( " + var_name +")";
	}

}

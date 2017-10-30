package tools;

import Exceptions.MyStackException;
import java.util.Stack;

public class MyStack<T> implements MyIStack<T> {
	private Stack<T> st;
	public MyStack()
	{
		this.st= new Stack<T>();
	}
	public T pop() throws MyStackException
	{
		if(st.isEmpty())
			throw new MyStackException("Stack is empty!");
		return this.st.pop();
			
	}
	
	public boolean is_empty()
	{
		return st.isEmpty();
	}
	public void push(T val)
	{
		this.st.push(val);
	}
	public T peek() throws MyStackException
	{
		if(st.isEmpty())
			throw new MyStackException("Stack is empty!");
		return this.st.peek();
	}
	
	@Override
	public String toString()
	{
		String res;
		res="[";
		try{
			Object[] obj = this.st.toArray();
			for(int i=obj.length-1;i>0;i--)
			{
				res=res+obj[i].toString() + " | ";
			}
			if (obj.length > 0)
			{
				res+=obj[0].toString();
			}
		}
		catch(NullPointerException e){
		
		}
		res+="]";
		return res;
	}
	
}

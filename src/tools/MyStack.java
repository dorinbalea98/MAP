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
		if(st.isEmpty())
			return "Stack is empty\n";
		String res="Exe stack:\n";
		Object[] val= st.toArray();
		for(int i=st.size()-1;i>=0;i--)
			res+=val[i].toString() + '\n';
		return res;
	}
	
}

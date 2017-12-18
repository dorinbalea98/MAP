package tools;
import Exceptions.MyStackException;
public interface MyIStack<T> {
	public T pop() throws MyStackException;
	public void push(T val);
	public T peek() throws MyStackException;
	public String toString();
	public boolean is_empty();
}

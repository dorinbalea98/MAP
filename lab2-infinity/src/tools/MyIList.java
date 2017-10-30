package tools;
import Exceptions.MyListException;

public interface MyIList<T> {
	public void append(T val);
	public void insert(int pos, T val) throws MyListException;
	public String toString();
	public T get_value(int key) throws MyListException;
	public int length();
	public void update(int key, T val);
}

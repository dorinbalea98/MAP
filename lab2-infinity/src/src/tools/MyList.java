package tools;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import Exceptions.MyListException;
public class MyList<T> implements MyIList<T> {
	private List<T> list;
	public MyList()
	{
		list = new ArrayList<T>();
	}
	public void append(T val)
	{
		list.add(val);
	}
	
	public int length()
	{
		return list.size();
	}
	public T get_value(int key) throws MyListException
	{
		if(key<0 || key >= list.size())
			throw new MyListException("Index out of bounds!");
		return list.get(key);
		
	}
	
	public void update(int key, T val) throws MyListException
	{
		if(key<0 || key>=list.size())
			throw new MyListException("Index out of bounds!");
		list.set(key, val);
	}
	
	public ListIterator<T> getIterator(){
		return list.listIterator();
	}
	
	public void insert(int pos, T val) throws MyListException
	{
		if(pos<0 || pos >= list.size())
			throw new MyListException("Out of bounds!!");
		list.add(pos, val);
	}
	
	
	@Override
	public String toString()
	{
		if(list.isEmpty())
			return "List is empty\n";
		String res="Out:\n";
		ListIterator<T> it=this.getIterator();
		while(it.hasNext())
		{
			res+=it.next() + "\n";
		}
		return res;
	}
}

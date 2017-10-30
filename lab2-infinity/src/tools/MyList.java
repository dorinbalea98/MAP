package tools;
import java.util.List;
import java.util.LinkedList;
import Exceptions.MyListException;
public class MyList<T> implements MyIList<T> {
	private List<T> list;
	public MyList()
	{
		list = new LinkedList<T>();
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
	
	public void update(int key, T val)
	{
		list.set(key, val);
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
		String res;
		res="[";
		Object[] obj = this.list.toArray();
		for(int i=0; i<obj.length-1; i++)
			res=res + obj[i].toString() + " | ";
		if(obj.length>=1)
			res+=obj[obj.length-1].toString();
		res+="]";
		
		return res;
		
	}
}

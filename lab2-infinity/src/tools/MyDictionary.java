package tools;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import Exceptions.MyDictionaryExceptions;
public class MyDictionary<K,E> implements MyIDictionary<K,E> {
	private HashMap<K,E> dict;
	public MyDictionary()
	{
		this.dict = new HashMap<K,E>();
	}
	
	public void add(K key, E elem){
		this.dict.put(key, elem);
	}
	
	public void delete(K key){
		this.dict.remove(key);
	}
	public void update(K key, E elem){
		this.dict.replace(key, elem);
	}
	public boolean exists(K key){
		return this.dict.get(key)!=null;
	}
	public E get_value(K key) throws MyDictionaryExceptions{
		if(!this.exists(key))
			throw new MyDictionaryExceptions("Variable is not defined!");
		return this.dict.get(key);
	}
	@Override
	public String toString()
	{
		String res;
		res="[";
		Iterator<Entry<K,E>> it=this.dict.entrySet().iterator();
		while(it.hasNext())
		{
	
			@SuppressWarnings("rawtypes")
			Map.Entry pair=(Map.Entry)it.next();
			res=res+"(Key: " + pair.getKey().toString() + " ; Element: " + pair.getValue().toString() +" ) ; ";
		}
		res=res+"]";
		return res;
		
	}
}


package tools;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class MyFileDictionary<TKey, T extends MyTuple<String,BufferedReader>> extends MyDictionary<TKey,T> 
implements MyIDictionary<TKey,T>{
	private int Id;
	
	public MyFileDictionary()
	{
		super();
		this.Id=0;
	}
	
	public int generateId()
	{
		this.Id+= (int)Math.random() % 5 +1;
		return Id;
	}
	
	public boolean ExistsInFirst(String el)
	{
		Iterator<HashMap.Entry<TKey,T>> it= this.getIterator();
		while(it.hasNext())
			if(it.next().getValue().getFirstElement()==el)
				return true;
		return false;
	}
	
	public boolean ExistsInSecond(BufferedReader el)
	{
		Iterator<HashMap.Entry<TKey,T>> it = this.getIterator();
		while(it.hasNext())
			if(it.next().getValue().getSecondElement()==el)
				return true;
		return false;
	}
	@Override
	public String toString()
	{
		if(dict.isEmpty())
			return "File table is empty\n";
		String res="File table:\n";
		for(Entry<TKey,T> entry: dict.entrySet()){
			TKey key=entry.getKey();
			T value = entry.getValue();
			res+=key +"-->" + value + "\n";
		}
		
		return res;
		
	}
	

}



package tools;

import java.util.Map.Entry;

public class MyHeapDictionary<TKey, T> extends MyDictionary<TKey,T> implements MyIDictionary<TKey,T> {
	int id;
	public MyHeapDictionary()
	{
		super();
		this.id=0;
	}
	@Override
	public int generateId()
	{
		id+=1;
		return id;
	}
	@Override
	public String toString()
	{
		if(dict.isEmpty()){
			return "Heap is empty\n";
		}
		String res="Heap:\n";
		for(Entry<TKey, T> entry: dict.entrySet())
		{
			TKey key=entry.getKey();
			T value=entry.getValue();
			res+=key+"-->" + value +'\n';
		}
		return res;
		
	}
}

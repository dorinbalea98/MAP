package tools;

import java.io.BufferedReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import Exceptions.MyDictionaryExceptions;
public class MyDictionary<K,E> implements MyIDictionary<K,E> {
	protected Map<K,E> dict;
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
		return this.dict.containsKey(key);
	}
	public E get_value(K key) throws MyDictionaryExceptions{
		if(!this.exists(key))
			throw new MyDictionaryExceptions("Variable is not defined!");
		return this.dict.get(key);
	}
	@Override
	public String toString()
	{
		if(dict.isEmpty()){
			return "SymTable is empty \n";
		}
		String res="SymTable:\n";
		for(Entry<K,E> entry: dict.entrySet())
		{
			K key=entry.getKey();
			E value=entry.getValue();
			res+=key+"-->" + value +'\n';
		}
		return res;
		
	}
	public int generateId()
	{
		return (int)Math.random();
	}
	
	public Set<Map.Entry<K,E>> entrySet(){
		return dict.entrySet();
	}

	@Override
	public boolean ExistsInFirst(String el) throws MyDictionaryExceptions{
		throw new MyDictionaryExceptions("Method not supported for MyDict");
	}

	@Override
	public boolean ExistsInSecond(BufferedReader el) throws MyDictionaryExceptions{
		throw new MyDictionaryExceptions("Method not supported for MyDict");
	}

	

	@Override
	public Iterator<Entry<K, E>> getIterator() {
		return dict.entrySet().iterator();
	}
	@Override
	public boolean isEmpty()
	{
		return dict.isEmpty();
	}

	@Override
	public void setContent(Map<K, E> newMap) {
		this.dict = newMap;
		
	}

	@Override
	public Map<K, E> getContent() {
		return this.dict;
	}

	@Override
	public Collection<E> values() {
		return dict.values();
	}
}

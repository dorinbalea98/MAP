package tools;
import java.io.BufferedReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import Exceptions.MyDictionaryExceptions;

public interface MyIDictionary<K,E> {
	public void setContent(Map<K, E> newMap);
	public Map<K, E> getContent();
	public Collection<E> values();
	public void add(K key, E elem);
	public void delete(K key);
	public void update(K key, E elem);
	public boolean exists(K key);
	public E get_value(K key) throws MyDictionaryExceptions;
	public String toString();
	public int generateId();
	public boolean ExistsInFirst(String el) throws MyDictionaryExceptions;
	public boolean ExistsInSecond(BufferedReader el) throws MyDictionaryExceptions;
	public Iterator<HashMap.Entry<K, E>> getIterator();
	public boolean isEmpty();
	public Set<Map.Entry<K,E>> entrySet();
}

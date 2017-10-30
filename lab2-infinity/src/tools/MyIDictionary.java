package tools;
import Exceptions.MyDictionaryExceptions;

public interface MyIDictionary<K,E> {
	public void add(K key, E elem);
	public void delete(K key);
	public void update(K key, E elem);
	public boolean exists(K key);
	public E get_value(K key) throws MyDictionaryExceptions;
	public String toString();

}

package tools;

public class MyHeapDictionary<TKey, T> extends MyDictionary<TKey,T> implements MyIDictionary<TKey,T> {
	int id;
	public MyHeapDictionary()
	{
		super();
		this.id=1;
	}
	@Override
	public int generateId()
	{
		return this.id+ (int)Math.random() % 3 +1;
	}
}

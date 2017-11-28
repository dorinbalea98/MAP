package tools;

public class MyTuple<X,Y> {
	private X x;
	private Y y;
	
	public MyTuple(X x1, Y y1)
	{
		x=x1;
		y=y1;
	}
	
	public X getFirstElement()
	{
		return this.x;
	}
	
	public Y getSecondElement()
	{
		return this.y;
	}
	
	@Override
	public String toString(){
		String res="";
			res+=" < " + this.x.toString() + " ; " + this.y.toString() +" > ";
		return res;
	}
	
}

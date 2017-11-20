package View;

public abstract class Command {
	private String key, description;
	
	public Command(String k, String d)
	{
		key=k;
		description=d;
	}
	
	public abstract void execute();
	
	public String getKey(){
		return this.key;
	}
	public String getDescription()
	{
		return this.description;
	}
}

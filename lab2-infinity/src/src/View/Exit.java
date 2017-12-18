package View;

public class Exit extends Command{

	public Exit(String k, String d) {
		super(k, d);
	}
	@Override
	public void execute(){
		System.exit(0);
	}
	
	
}

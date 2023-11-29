package command;

public abstract class Command {
	public final String NAME;
	public final String DESCRIPTION;
	
	public Command(String name, String desc) {
		this.NAME = name;
		this.DESCRIPTION = desc;
	}
	
	public abstract boolean execute(String[] args);

}

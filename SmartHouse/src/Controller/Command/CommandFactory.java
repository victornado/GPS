package Controller.Command;

public abstract class CommandFactory {

	private static CommandFactoryImp instance;

	public static CommandFactory getInstance() {
		if(instance == null) instance = new CommandFactoryImp();
		return instance;
	}

	public abstract Command getCommand(int commandName);

}

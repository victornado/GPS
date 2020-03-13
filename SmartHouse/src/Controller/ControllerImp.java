package Controller;

import Controller.Command.Command;
import Controller.Command.CommandFactory;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class ControllerImp extends Controller{

	@Override
	public ResponseContext handleRequest(RequestContext requestContext) {
		
		ResponseContext responseContext = null;
		
		int commandName = requestContext.getCommandName();
		CommandFactory commandFactory = CommandFactory.getInstance();
		Command command = commandFactory.getCommand(commandName);
		
		responseContext = command.invoke(command,requestContext);
		
		return responseContext; 

	}

	@Override
	public void handleResponse(RequestContext requestContext, ResponseContext responseContext) {
		
		
		
	}
}
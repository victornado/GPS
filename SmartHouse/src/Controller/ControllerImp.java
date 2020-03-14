package Controller;

import Controller.Command.Command;
import Controller.Command.CommandFactory;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;
import Prototipo.Factory.FactoryVistas;

public class ControllerImp extends Controller{

	@Override
	public void handleRequest(RequestContext requestContext) {
		
		ResponseContext responseContext = null;
		
		int commandName = requestContext.getCommandName();
		CommandFactory commandFactory = CommandFactory.getInstance();
		Command command = commandFactory.getCommand(commandName);
		
		responseContext = command.invoke(command,requestContext);
		handleResponse(responseContext);
		
	}

	@Override
	public void handleResponse(ResponseContext responseContext) {
		
		FactoryVistas.getInstance().getVistas(responseContext.getVista()).update(responseContext);
		
	}
}
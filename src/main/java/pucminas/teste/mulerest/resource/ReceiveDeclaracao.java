package pucminas.teste.mulerest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pucminas.asd.tcc.canonicoserv.messages.MessageRequest;


@Path("rest")
public class ReceiveDeclaracao {

	@POST
	@Path("receber")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public MessageRequest receiveSalesOrder(MessageRequest request) {
		
		return request;
	}
	
	
}

package pucminas.teste.mulerest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pucminas.asd.tcc.canonicoserv.messages.LoginRequest;


@Path("rest")
public class OrgaoMessageRequest {

	@POST
	@Path("login")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public LoginRequest login(LoginRequest request) {
		
		return request;
	}
	
	
}

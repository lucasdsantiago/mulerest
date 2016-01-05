package pucminas.teste.mulerest.resource.autenticaserv;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("rest")
public class AutenticaServ {

	@POST
	@Path("auth")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public String autenticar(){
		return  "";
	}
	
}

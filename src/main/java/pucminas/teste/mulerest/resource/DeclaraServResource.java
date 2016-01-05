package pucminas.teste.mulerest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pucminas.asd.tcc.canonicoserv.Declaracao;

//FIXME: REMOVER CLASSE. NAO UTILIZADA
@Path("declara")
public class DeclaraServResource {

	@POST
	@Path("add")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response inserirDeclaracao(Declaracao declaracao){
		// add declaracao na fila
		System.out.println("Declaracao do " + declaracao.getAgente().getCpf());
		return Response.ok(declaracao).build();
	}
	
}

package pucminas.teste.mulerest.resource.transformers;

import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import pucminas.teste.mulerest.resource.LoginResponse;

/**
 * Classe que verifica se o retorno do Fluxo AutenticaServ
 * foi com o login com sucesso ou nao.
 * 
 * Define uma variavel no fluxo de mensagem para ser tratada no roteamento.
 * @author Lucas
 *
 */
public class VerificaLoginRetorno implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		
		String payload = eventContext.getMessage().getPayloadAsString();
		// login com sucesso o fluxo de declaracao continua
		// caso contrário é retornado para o usuário.
		if(!payload.equals("[]"))
			eventContext.getMessage().setInvocationProperty("LoginSucesso", "S");

		/* PARSE JSON TO OBJECT USANDO GSON?
		String payloadLogin = eventContext.getMessage().getPayloadAsString();
		ObjectMapper om = new ObjectMapper();
		om.configure(Feature.UNWRAP_ROOT_VALUE, true);
		LoginResponse loginResponse = om.readValue(payloadLogin, LoginResponse.class);
		// login com sucesso o fluxo de declaracao continua
		// caso contrário é retornado para o usuário.
		if(loginResponse != null){
			eventContext.getMessage().setInvocationProperty("LoginSucesso", "S");
			eventContext.getMessage().setInvocationProperty("nome", loginResponse.getNome());
			eventContext.getMessage().setInvocationProperty("email", loginResponse.getEmail());
			
		}
		*/
		
		return eventContext.getMessage().getPayload();
	}

}

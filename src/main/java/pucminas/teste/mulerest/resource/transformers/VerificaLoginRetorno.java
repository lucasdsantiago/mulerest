package pucminas.teste.mulerest.resource.transformers;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

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
		
		Object payload = eventContext.getMessage().getPayloadAsString();
		// login com sucesso o fluxo de declaracao continua
		// caso contrário é retornado para o usuário.
		if(!payload.equals("[]"))
			eventContext.getMessage().setInvocationProperty("LoginSucesso", "S");

		return eventContext.getMessage().getPayload();
	}

}

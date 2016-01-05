package pucminas.teste.mulerest.resource.components;

import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import pucminas.asd.tcc.canonicoserv.Declaracao;

/**
 * Transforma mensagem json (payload) em objeto.
 * Define variaveis no fluxo de mensagens.
 * @author Lucas
 *
 */
public class DefineOrgaoVariable implements Callable{
	
	@Override
    public Object onCall(MuleEventContext eventContext) throws Exception {
		
		String declaracaoJSON = eventContext.getMessage().getPayloadAsString().replaceAll("declaracao", "Declaracao"); 
		ObjectMapper om = new ObjectMapper();
		om.configure(Feature.UNWRAP_ROOT_VALUE, true);
		Declaracao declaracao = om.readValue(declaracaoJSON, Declaracao.class);
		
		// define variavel orgao para o fluxo de mensagem.
		eventContext.getMessage().setInvocationProperty("orgao", declaracao.getAgente().getOrgao());
		// pode definri aqui outras variaveis
		eventContext.getMessage().setInvocationProperty("cpf", declaracao.getAgente().getCpf());
		eventContext.getMessage().setInvocationProperty("senha", declaracao.getAgente().getSenha());
		eventContext.getMessage().setInvocationProperty("declaracao", declaracao);
		
		
		return eventContext.getMessage().getPayload();
    }

}

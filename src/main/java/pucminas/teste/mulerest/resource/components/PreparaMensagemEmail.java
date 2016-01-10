package pucminas.teste.mulerest.resource.components;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import pucminas.asd.tcc.canonicoserv.DeclaracaoProcessada;

/**
 * Transforma mensagem json (payload) em objeto.
 * Define variaveis no fluxo de mensagens.
 * @author Lucas
 *
 */
public class PreparaMensagemEmail implements Callable{
	
	@Override
    public Object onCall(MuleEventContext eventContext) throws Exception {
		
		DeclaracaoProcessada declaracaoProcessada = (DeclaracaoProcessada) eventContext.getMessage().getPayload();
		// variavel de controle para envio de email	
		eventContext.getMessage().setInvocationProperty("destinatario", declaracaoProcessada.getEmailAgente());
		// define o corpo do email que ser aenviado
		eventContext.getMessage().setPayload(declaracaoProcessada.getCorpoEmailConfirmacao());
		return eventContext.getMessage();
    }

}

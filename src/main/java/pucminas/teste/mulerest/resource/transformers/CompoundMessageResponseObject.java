package pucminas.teste.mulerest.resource.transformers;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import pucminas.asd.tcc.canonicoserv.Bem;
import pucminas.asd.tcc.canonicoserv.Declaracao;
import pucminas.teste.mulerest.resource.modelo.MessageResponse;


public class CompoundMessageResponseObject extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {

		String uuid = "";
		String nomeServidor = "";
		String bemDeclarado = "";
		String declaracaoNumber = "";
		String date = "";
		Declaracao declaracao = null;
		try {
			uuid = message.getPayloadAsString();
			declaracao = message.getInvocationProperty("declaracao");
			//nomeServidor = message.getInvocationProperty("nomeServidor");
			nomeServidor = declaracao.getAgente().getCpf();
			//bemDeclarado = message.getInvocationProperty("bemDeclarado");
			bemDeclarado = ((Bem)declaracao.getBens().get(0)).getNome();
			declaracaoNumber = message.getInvocationProperty("declaracaoNumber");
			date = message.getInvocationProperty("date");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new MessageResponse(uuid, nomeServidor, bemDeclarado, declaracaoNumber, date);
	}


}

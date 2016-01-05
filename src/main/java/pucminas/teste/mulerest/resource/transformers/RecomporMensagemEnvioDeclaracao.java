package pucminas.teste.mulerest.resource.transformers;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import pucminas.asd.tcc.canonicoserv.Declaracao;
import pucminas.asd.tcc.canonicoserv.messages.MessageRequest;


public class RecomporMensagemEnvioDeclaracao extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {

		//FIXME: ADD NA MSG O RETORNO DO LOGIN (NOME E EMAIL)
		// PARA ISSO SERA NECESSARIO FAZER O PARSE DE JSON PARA OBJECT
		Declaracao declaracao = null;
		try {
			declaracao = message.getInvocationProperty("declaracao");
			//message.getPayload();
			//FIXME: add tb o SID do login na mensagem ?
		} catch (Exception e) {
			e.printStackTrace();
		}
		MessageRequest request = new MessageRequest();
		request.setDeclaracao(declaracao);
		return request;
	}


}

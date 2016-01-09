package pucminas.teste.mulerest.resource.transformers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import com.fasterxml.jackson.databind.ObjectMapper;

import pucminas.asd.tcc.canonicoserv.Declaracao;
import pucminas.asd.tcc.canonicoserv.messages.MessageRequest;

public class RecomporMensagemEnvioDeclaracao extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {

		Declaracao declaracao = null;
		try {
			String jsonString = message.getPayloadAsString();
			ObjectMapper mapper = new ObjectMapper();
			Object responseSaveOrder = mapper.readValue(jsonString, Object.class);

			LinkedHashMap<Object, Object> retorno = ((LinkedHashMap<Object, Object>)((List<Object>) responseSaveOrder).get(0));
			for (Entry<Object, Object> entry : retorno.entrySet()) {
			    String chave = (String) entry.getKey();
			    if(chave.equalsIgnoreCase(("email"))){
			    	// adicionado no fluxo o valor do email que sera utilizado no fluxo de enviar email.
			    	message.setInvocationProperty("email", (String) entry.getValue());
			    }
			}
			// FIXME: ADD NA MSG O RETORNO DO LOGIN (NOME E EMAIL)
			// PARA ISSO SERA NECESSARIO FAZER O PARSE DE JSON PARA OBJECT
			declaracao = message.getInvocationProperty("declaracao");
			// message.getPayload();
			// FIXME: add tb o SID do login na mensagem ?
		} catch (Exception e) {
			e.printStackTrace();
		}
		MessageRequest request = new MessageRequest();
		request.setDeclaracao(declaracao);
		return request;
	}

}

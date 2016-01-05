package pucminas.teste.mulerest.resource;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pucminas.asd.tcc.canonicoserv.Declaracao;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class MessageRequestOLD {
	
	
	private Declaracao declaracao;

	
	public Declaracao getDeclaracao() {
		return declaracao;
	}


	public void setDeclaracao(Declaracao declaracao) {
		this.declaracao = declaracao;
	}


	public static class Builder {
		private MessageRequestOLD messageRequest = new MessageRequestOLD();
		
		private Builder() {
		}
		
		public static Builder newInstance() {
			return new Builder();
		}
		
		public Builder declaracao(Declaracao declaracao) {
			this.messageRequest.setDeclaracao(declaracao);
			return this;
		}
		
		public MessageRequestOLD build() {
			return messageRequest;
		}
		
	}

}

package pucminas.teste.mulerest.resource.modelo;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class MessageResponse {
	
	private String correlationId;
	private String nomeServidor;
	private String bemDeclarado;
	private String declaracaoNumber;
	private String date;
	
	
	public MessageResponse(String correlationId, String nomeServidor, String bemDeclaro, String declaracaoNumber, String date){
		this.correlationId = correlationId;
		this.nomeServidor = nomeServidor;
		this.bemDeclarado = bemDeclaro;
		this.declaracaoNumber = declaracaoNumber;
		this.date = date;
	}
	
	public String getDeclaracaoNumber() {
		return declaracaoNumber;
	}

	public void setDeclaracaoNumber(String declaracaoNumber) {
		this.declaracaoNumber = declaracaoNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCorrelationId() {
		return correlationId;
	}
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}
	public String getNomeServidor() {
		return nomeServidor;
	}
	public void setNomeServidor(String nomeServidor) {
		this.nomeServidor = nomeServidor;
	}
	public String getBemDeclarado() {
		return bemDeclarado;
	}
	public void setBemDeclarado(String bemDeclarado) {
		this.bemDeclarado = bemDeclarado;
	}
	
	

	

}

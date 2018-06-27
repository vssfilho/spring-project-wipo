package com.java.rest.util;

import org.springframework.http.HttpStatus;

/**
 * Classe usada no retorno do webservice rest, retornando apenas dois itens
 * status (sucesso e erro) e data (objects ou string de mensagens)
 * 
 * Utilização: Response.builder().
 * 				setError(). ou setSuccess().
 * 				setData()
 * 				.build()
 */
public final class ResponseBuilder {

	private final HttpStatus status;
	private final String messages;
	private final Object data;
	
	private ResponseBuilder(Builder builder) {
		status = builder.status;
		data = builder.data;
		messages = builder.messages;
	}
	
	public HttpStatus getStatus() {
		return status;
	}

	public Object getData() {
		return data;
	}

	public String getMessages() {
		return messages;
	}
	
	public static Builder builder() {
        return new Builder();
    }

	public static final class Builder {
		
		private HttpStatus status;
		private Object data;
		private String messages;
		
		public Builder setData(final Object data) {
			this.data = data;
			return this;
		}
		
		public Builder setMessages(final String messages) {
			this.messages = messages;
			return this;
		}
		
		public Builder setError() {
			this.status = HttpStatus.FAILED_DEPENDENCY;
			return this;
		}
		
		public Builder setSuccess() {
			this.status = HttpStatus.OK;
			return this;
		}
		
		public ResponseBuilder build() {
            return new ResponseBuilder(this);
        }
		
	}
	
}
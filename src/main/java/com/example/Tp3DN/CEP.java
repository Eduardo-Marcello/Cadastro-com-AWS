package com.example.Tp3DN;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CEP {
	   @JsonProperty
	   private String cep;
	    
	   @JsonProperty
	   private String logradouro;
	    
	   @JsonProperty
	   private String complemento;
	    
	   @JsonProperty
	   private String municipio;
	    
	   @JsonProperty
	   private String bairro;
	    
	   @JsonProperty
	   private String localidade;
	   
	   public String getCep() {
		   return cep;
	   }
	   
	   public String getLogradouro() {
		   return logradouro;
	   }
	   
	   public String getComplemento() {
		   return complemento;
	   }
	   
	   public String getMunicipio() {
		   return municipio;
	   }
	   
	   public String getBairro() {
		   return bairro;
	   }
	   
	   public String getLocalidade() {
		   return localidade;
	   }

	@Override
	public String toString() {
		return cep + ";" + logradouro + ";" + complemento + ";"
				+ municipio + ";" + bairro + ";" + localidade;
	}
	    
}


package com.example.Tp3DN;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PessoaCEP {
	 public CEP buscaCEP(String cep){
	        RestTemplate template = new RestTemplate();
	        return template.getForObject("https://viacep.com.br/ws/{cep}/json/", CEP.class, cep);
	    }
}

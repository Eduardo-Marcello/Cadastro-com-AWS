package com.example.Tp3DN;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PessoaService {
    private final PessoaRepository pr;
    
    public PessoaService(PessoaRepository pr) {
        this.pr = pr;
    }
    
    public Pessoa register(String nome, String email, String telefone, String cep){
    	PessoaCEP pc = new PessoaCEP();
    	CEP endereco = pc.buscaCEP(cep);
    	String cep1 = endereco.getCep();
    	String logradouro = endereco.getLogradouro();
    	String bairro = endereco.getBairro();
    	String localidade = endereco.getLocalidade();
    	return this.pr.save(new Pessoa(nome, email, telefone, cep1, logradouro, bairro, localidade));
    }
    
    @Transactional(readOnly = true)
    public List<Pessoa> findAll(){
        return this.pr.findAll();
    }
}

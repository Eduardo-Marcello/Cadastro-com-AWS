package com.example.Tp3DN;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PessoaController {
	private final PessoaService pessoaService;
	private AmazonClient amazonClient;
	
	@Autowired
	public PessoaController(PessoaService pessoaService, AmazonClient amazonClient) {
		this.pessoaService = pessoaService;
		this.amazonClient = amazonClient;
	}
	
	@GetMapping("/persons")
	List<Pessoa> all() {
		return pessoaService.findAll();
	}

	@PostMapping("/registerPerson")
	Pessoa register(String nome, String email, String telefone, String cep, @RequestPart(value = "file") MultipartFile file) {
		amazonClient.uploadFile(file);
		return pessoaService.register(nome, email, telefone, cep);
	}
	
	@DeleteMapping("/deleteFile")
	public String deleteFile(@RequestPart(value = "url") String fileUrl) {
		return this.amazonClient.deleteFileFromBucketS3(fileUrl);
	}
}


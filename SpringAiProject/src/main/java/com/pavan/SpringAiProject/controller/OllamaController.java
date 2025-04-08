package com.pavan.SpringAiProject.controller;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ollama")
@CrossOrigin("*")
public class OllamaController {
	
	private OllamaChatModel ollamaChatModel;
	
	public OllamaController(OllamaChatModel ollamaChatModel) {
		this.ollamaChatModel = ollamaChatModel;
	}

	@GetMapping("/{message}")
	public ResponseEntity<String> getAnswer(@PathVariable String message){
		String response = ollamaChatModel.call(message);
		return ResponseEntity.ok(response);
	}
}

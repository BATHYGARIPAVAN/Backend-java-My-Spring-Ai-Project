package com.pavan.SpringAiProject.controller;

import org.springframework.ai.anthropic.AnthropicChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/anthropic")
@CrossOrigin("*")
public class AnthropicController {
	
	private AnthropicChatModel anthropicChatModel;
	
	public AnthropicController(AnthropicChatModel anthropicChatModel) {
		this.anthropicChatModel = anthropicChatModel;
	}

	@GetMapping("/{message}")
	public ResponseEntity<String> getAnswer(@PathVariable String message){
		String response = anthropicChatModel.call(message);
		return ResponseEntity.ok(response);
	}
}

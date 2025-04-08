package com.pavan.SpringAiProject.controller;

import org.springframework.ai.huggingface.HuggingfaceChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/huggingface")
@CrossOrigin("*")
public class HuggingfaceIController {
	
	private HuggingfaceChatModel chatModel;
	
	public HuggingfaceIController(HuggingfaceChatModel chatModel) {
		this.chatModel = chatModel;
	}

	@GetMapping("/{message}")
	public ResponseEntity<String> getAnswer(@PathVariable String message){
		String response = chatModel.call(message);
		return ResponseEntity.ok(response);
	}
}

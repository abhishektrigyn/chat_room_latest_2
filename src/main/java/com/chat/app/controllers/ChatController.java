package com.chat.app.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.app.models.Message;

@RestController
public class ChatController {

	
	@MessageMapping("/message")
	@SendTo("/topic/sendbackurl") // users will suscribe this url
	public Message getData(@RequestBody Message message)
	{
		System.out.println("message ===== "+message);
		return message;
		
	}
}

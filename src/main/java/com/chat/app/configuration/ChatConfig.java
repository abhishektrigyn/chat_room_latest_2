package com.chat.app.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class ChatConfig implements WebSocketMessageBrokerConfigurer{
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// TODO Auto-generated method stub
		registry.addEndpoint("/server").withSockJS(); // registering server
		
		//WebSocketMessageBrokerConfigurer.super.registerStompEndpoints(registry);
	}
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// TODO Auto-generated method stub\
		registry.enableSimpleBroker("/topic");//  topic  url configured for broadcasting
		registry.setApplicationDestinationPrefixes("/chat"); //user will put this prefix before /topic	
		//WebSocketMessageBrokerConfigurer.super.configureMessageBroker(registry);
	}

}
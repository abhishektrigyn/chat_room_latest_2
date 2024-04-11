package com.chat.app.mockito.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.chat.app.constant.Constatnt;
import com.chat.app.models.MessageInsertDTO;
import com.chat.app.models.UserMessageDTO;

@Service
public class UserMessageDTOService {
	@Autowired
	private RestTemplate restTemplate;

	public UserMessageDTO validateUserDto(UserMessageDTO inputUser) {
		ResponseEntity<UserMessageDTO> resp = 
		restTemplate.postForEntity(Constatnt.LOGIN_URL ,inputUser, UserMessageDTO.class);
		return resp.getStatusCode() == HttpStatus.OK ? resp.getBody() : null;
	}
	public UserMessageDTO deleteMessageDto(UserMessageDTO inputUser) {
		ResponseEntity<UserMessageDTO> resp = 
		restTemplate.postForEntity(Constatnt.DELETE_URL ,inputUser, UserMessageDTO.class);
		return resp.getStatusCode() == HttpStatus.OK ? resp.getBody() : null;
	}
	public MessageInsertDTO insertMessageDto(MessageInsertDTO inputUser) {
		ResponseEntity<MessageInsertDTO> resp = 
		restTemplate.postForEntity(Constatnt.INSERT_URL ,inputUser, MessageInsertDTO.class);
		return resp.getStatusCode() == HttpStatus.OK ? resp.getBody() : null;
	}
}

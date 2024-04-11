package com.chat.app.mockito.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.chat.app.constant.Constatnt;
import com.chat.app.models.MessageDTO;
import com.chat.app.models.MessageInsertDTO;
import com.chat.app.models.UserMessageDTO;

@ExtendWith(MockitoExtension.class)
public class UserMessageDTOTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private UserMessageDTOService userMessageDtoService = new UserMessageDTOService();

    @Test
   // public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedObject() {
    public void validateUserTest() {	
    UserMessageDTO userMessageDto = new UserMessageDTO();
    	UserMessageDTO mockDto=new UserMessageDTO();
    	userMessageDto.setUsername("abhishek");
    	userMessageDto.setPassword("test");
    	
    	mockDto.setUsername("abhishek");
    	mockDto.setValidUser("YES");
    	

        Mockito
          .when(restTemplate.postForEntity(
        		  Constatnt.LOGIN_URL , userMessageDto,UserMessageDTO.class))
          .thenReturn(new ResponseEntity(mockDto, HttpStatus.OK));

        UserMessageDTO userMessageDtoRes = userMessageDtoService.validateUserDto(userMessageDto);
        //Assertions.assertEquals(emp, userMessageDto);
        System.out.println("userMessageDtoRes "+userMessageDtoRes);
    }
    @Test
    public void deleteMessageTest() 
    {
    	
        UserMessageDTO userMessageDto = new UserMessageDTO();
        	UserMessageDTO mockDto=new UserMessageDTO();
        	userMessageDto.setUsername("abhishek");
        	userMessageDto.setPassword("test");
        	userMessageDto.setDeleteIds("1,2");
        	mockDto.setUsername("abhishek");
        	mockDto.setValidUser("YES");
        	List<MessageDTO> msgList= new ArrayList<>();
        	MessageDTO msgDto1 = new MessageDTO();
        	msgDto1.setMessageId(200);
        	msgDto1.setMessage("Hi How Are You ?");
        	MessageDTO msgDto2 = new MessageDTO();
        	msgDto2.setMessageId(201);
        	msgDto2.setMessage("I am fine");
        	msgList.add(msgDto1);
        	msgList.add(msgDto2);
        	mockDto.setMessages(msgList);

            Mockito
              .when(restTemplate.postForEntity(
            		  Constatnt.DELETE_URL , userMessageDto,UserMessageDTO.class))
              .thenReturn(new ResponseEntity(mockDto, HttpStatus.OK));

            UserMessageDTO userMessageDtoRes = userMessageDtoService.deleteMessageDto(userMessageDto);
            //Assertions.assertEquals(emp, userMessageDto);
            System.out.println("deleted mock response  "+userMessageDtoRes);
        
    }
    @Test
    // public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedObject() {
     public void insertMessageTest() {	
    	MessageInsertDTO userMessageDto = new MessageInsertDTO();
    	MessageInsertDTO mockDto=new MessageInsertDTO();
     	userMessageDto.setUsername("abhishek");
     	userMessageDto.setPassword("test");
     	userMessageDto.setMessageId("50");
     	userMessageDto.setMessage("Good Morning !");
     	
     	mockDto.setUsername("abhishek");
     	mockDto.setMessageId("60");
     	mockDto.setMessage("whatsup!");
     	
     	

         Mockito
           .when(restTemplate.postForEntity(
         		  Constatnt.INSERT_URL , userMessageDto,MessageInsertDTO.class))
           .thenReturn(new ResponseEntity(mockDto, HttpStatus.OK));

         MessageInsertDTO userMessageDtoRes = userMessageDtoService.insertMessageDto(userMessageDto);
         //Assertions.assertEquals(emp, userMessageDto);
         System.out.println("inserted mock response  "+userMessageDtoRes);
     }
}
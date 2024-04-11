package com.chat.app.configuration;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import com.chat.app.constant.Constatnt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chat.app.models.User;
import com.chat.app.models.UserMessageDTO;
import com.chat.app.models.MessageInsertDTO;
import com.google.gson.Gson;


@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	RestTemplate restTemplate;


	@PostMapping(value="/insertMessage",consumes= {"application/json"},produces = {"application/json"})   
	public String insertMessage(@RequestBody MessageInsertDTO userSingleMessage)
	{   RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<MessageInsertDTO> responseDTO = null;
		String url=Constatnt.INSERT_URL;

		try {
			responseDTO
			= restTemplate.postForEntity(url,userSingleMessage, MessageInsertDTO.class);
			//restTemplate.delete(url, user);
			System.out.println("returned");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			if(responseDTO!=null)
			{
				String response=new Gson().toJson(responseDTO.getBody());
				return response;
			}
			else
			{
				return "FAILED";
			}
		}
}
	@PostMapping(value="/delete",consumes= {"application/json"},produces = {"application/json"})   
	public String deleteMessage(@RequestBody UserMessageDTO user)
	{
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserMessageDTO> responseDTO = null;
        String url=Constatnt.DELETE_URL;
		try {
			responseDTO
			= restTemplate.postForEntity(url,user, UserMessageDTO.class);
			System.out.println("returned");

		}
		catch(Exception e)
		{
			e.printStackTrace();

		}
		finally {
			if(responseDTO!=null)
			{
				String response=new Gson().toJson(responseDTO.getBody());

				return response;

			}
			else
			{
				return "FAILED";
			}
		}



	}
	@PostMapping(value="/check",consumes= {"application/json"},produces = {"application/json"})   
	public String validateUser(@RequestBody UserMessageDTO user)
	{

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserMessageDTO> responseDTO = null;

		String url=Constatnt.LOGIN_URL;
		try {
			responseDTO
			= restTemplate.postForEntity(url,user, UserMessageDTO.class);
		}
		catch(Exception e)
		{
			e.printStackTrace();

		}
		finally {
			if(responseDTO!=null)
			{
				String response=new Gson().toJson(responseDTO.getBody());

				return response;

			}
			else
			{
				return "FAILED";
			}
		}
	}
}


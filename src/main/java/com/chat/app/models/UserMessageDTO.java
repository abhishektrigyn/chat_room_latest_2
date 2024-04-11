package com.chat.app.models;

import java.util.List;

public class UserMessageDTO {
private String username;
private String password;
private String deleteIds;
private String validUser;

public String getValidUser() {
	return validUser;
}
public void setValidUser(String validUser) {
	this.validUser = validUser;
}
public String getDeleteIds() {
	return deleteIds;
}
public void setDeleteIds(String deleteIds) {
	this.deleteIds = deleteIds;
}
private List<MessageDTO> messages;


public List<MessageDTO> getMessages() {
	return messages;
}
public void setMessages(List<MessageDTO> messages) {
	this.messages = messages;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}



}

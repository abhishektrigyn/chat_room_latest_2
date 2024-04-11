package com.chat.app.models;

public class Message {
private String name;
private String data;
private String password;
private String sendFlag;
private String removeMessageId;
private String messageIdNew;

public String getRemoveMessageId() {
	return removeMessageId;
}
public void setRemoveMessageId(String removeMessageId) {
	this.removeMessageId = removeMessageId;
}
public String getSendFlag() {
	return sendFlag;
}
public void setSendFlag(String sendFlag) {
	this.sendFlag = sendFlag;
}

public String getMessageIdNew() {
	return messageIdNew;
}
public void setMessageIdNew(String messageIdNew) {
	this.messageIdNew = messageIdNew;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Message(String name,String content) {
	// TODO Auto-generated constructor stub
	this.name=name;
	this.data=data;
	
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}
}

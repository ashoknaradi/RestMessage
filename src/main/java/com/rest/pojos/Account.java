package com.rest.pojos;

public class Account {
	private String User;
	private String Password;
	private String SenderId;
	private String Channel;
	private String DCS;
	private String SchedTime;
	private String GroupId;

	public String getUser() {
		return User;
	}

	public void setUser(String user) {
		User = user;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getSenderId() {
		return SenderId;
	}

	public void setSenderId(String senderId) {
		SenderId = senderId;
	}

	public String getChannel() {
		return Channel;
	}

	public void setChannel(String channel) {
		Channel = channel;
	}

	public String getDCS() {
		return DCS;
	}

	public void setDCS(String dCS) {
		DCS = dCS;
	}

	public String getSchedTime() {
		return SchedTime;
	}

	public void setSchedTime(String schedTime) {
		SchedTime = schedTime;
	}

	public String getGroupId() {
		return GroupId;
	}

	public void setGroupId(String groupId) {
		GroupId = groupId;
	}

}

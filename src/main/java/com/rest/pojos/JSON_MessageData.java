package com.rest.pojos;

import java.util.List;

public class JSON_MessageData {
	private Account Account;
	private List<Messages> Messages;

	public Account getAccount() {
		return Account;
	}

	public void setAccount(Account account) {
		Account = account;
	}

	public List<Messages> getMessages() {
		return Messages;
	}

	public void setMessages(List<Messages> messages) {
		Messages = messages;
	}
}
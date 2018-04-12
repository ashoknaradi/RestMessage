package com.rest.services;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.rest.pojos.Account;
import com.rest.pojos.JSON_MessageData;
import com.rest.pojos.Messages;

@Controller
public class RestMessageService {

	@RequestMapping(value = "sendMessageButton")
	public String sendMessageButton() {
		return "SendMessage";
	}
	
	@RequestMapping(value = "sendMessageByJSONButton")
	public String sendMessageByJSONButton() {
		return "SendMessageByJSON";
	}
	
	@RequestMapping(value = "sendMessage")
	public String sendMessage(@RequestParam("mobileNumber") String MobileNumber, @RequestParam("textMessage") String TextMessage) {
		System.out.println(MobileNumber + "  " + TextMessage);
		String uri = "https://www.smsgatewayhub.com/api/mt/SendSMS?APIKey=Yu76Ml6QXEKc64xWYlvntA&senderid=TESTIN&channel=2&DCS=0&flashsms=0&"
				+ "number=91" + MobileNumber + "&text=" + TextMessage;
		RestTemplate restTemplate = new RestTemplate();
	    HttpHeaders requestHeaders = new HttpHeaders();
	    requestHeaders.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity<String> entity = new HttpEntity<String>(requestHeaders);
	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
	    System.out.println(result);
		return "Home";
	}
	
	@RequestMapping(value = "sendMessageByJSON", method=RequestMethod.POST)
	public String sendMessageByJSON(@RequestParam("mobileNumber") String MobileNumber, @RequestParam("textMessage") String TextMessage, Model model) {
		List<Messages> list = new ArrayList<Messages>();
		String mobileNumbers[] = MobileNumber.split(",");
		for (String mobile : mobileNumbers) {
			Messages messages = new Messages();
			messages.setNumber("91" + mobile);
			messages.setMessage(TextMessage);
			System.out.println(messages.getNumber() + "  " + messages.getMessage());
			list.add(messages);
		}

		JSON_MessageData json_MessageData = new JSON_MessageData();
		json_MessageData.setAccount(getAccount());
		json_MessageData.setMessages(list);
		
		String uri = "https://www.smsgatewayhub.com/api/mt/SendSMS";
		RestTemplate restTemplate = new RestTemplate();
	    HttpHeaders requestHeaders = new HttpHeaders();
	    requestHeaders.setContentType(MediaType.APPLICATION_JSON);
	    Gson gson = new Gson();
	    String json = gson.toJson(json_MessageData);
	    System.out.println("Requested JSON is :::: " + json);
	    HttpEntity<?> entity = new HttpEntity<Object>(json, requestHeaders);
	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
	    gson.fromJson(result.getBody(), JSON_MessageData.class);
	    System.out.println(result.getBody());
	    System.out.println(result);
	    System.out.println(result.getStatusCodeValue());
	    model.addAttribute("JsonMessage", "Successfully message sent by json");
	    return "SendMessageByJSON";
	}
	
	public Account getAccount() {
		Account account = new Account();
		account.setUser("ashok27");
		account.setPassword("9951551572");
		account.setSenderId("TESTIN");
		account.setChannel("1");
		account.setDCS("0");
		account.setSchedTime(null);
		account.setGroupId(null);
		return account;
	}
	
	/*public static void main(String[] args) {
		String uri = "https://www.smsgatewayhub.com/api/mt/SendSMS?APIKey=Yu76Ml6QXEKc64xWYlvntA&senderid=TESTIN&channel=2&DCS=0&flashsms=0&"
				+ "number=918639648007&text=What r u dng ra";
		RestTemplate restTemplate = new RestTemplate();
	    HttpHeaders requestHeaders = new HttpHeaders();
	    requestHeaders.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity<String> entity = new HttpEntity<String>(requestHeaders);
	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
	    System.out.println(result);
	    System.out.println(result.getStatusCodeValue());
	    System.out.println(result.getBody());
	    System.out.println(result.getHeaders());
	}*/
	
	/*public static void main(String[] args) {
		String MobileNumber = "8639648007,919573448820";
		String TextMessage ="test";
		System.out.println(MobileNumber + "  " + TextMessage);
		List<Messages> list = new ArrayList<Messages>();
		String mobileNumbers[] = MobileNumber.split(",");
		for (String mobile : mobileNumbers) {
			Messages messages = new Messages();
			messages.setNumber("91" + mobile);
			messages.setMessage(TextMessage);
			System.out.println(messages.getNumber() + "  " + messages.getMessage());
			list.add(messages);
		}
		
		Account account = new Account();
		account.setUser("ashok27");
		account.setPassword("9951551572");
		account.setSenderId("TESTIN");
		account.setChannel("1");
		account.setDCS("0");

		JSON_MessageData json_MessageData = new JSON_MessageData();
		json_MessageData.setAccount(account);
		json_MessageData.setMessages(list);
		
		String uri = "https://www.smsgatewayhub.com/api/mt/SendSMS";
		RestTemplate restTemplate = new RestTemplate();
	    HttpHeaders requestHeaders = new HttpHeaders();
	    requestHeaders.setContentType(MediaType.APPLICATION_JSON);
	    Gson gson = new Gson();
	    String json = gson.toJson(json_MessageData);
	    System.out.println("Requested JSON is :::: " + json);
	    HttpEntity<?> entity = new HttpEntity<Object>(json, requestHeaders);
	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
	    gson.fromJson(result.getBody(), JSON_MessageData.class);
	    System.out.println(result.getBody());
	    System.out.println(result);
	}*/
}
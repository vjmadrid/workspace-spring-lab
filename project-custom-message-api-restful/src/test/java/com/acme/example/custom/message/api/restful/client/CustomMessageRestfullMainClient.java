package com.acme.example.custom.message.api.restful.client;
 
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.acme.example.custom.message.api.restful.constant.CustomMessageRestfullConstant;
import com.acme.example.custom.message.core.entity.CustomMessage;
import com.acme.example.custom.message.core.factory.CustomMessageDataFactory; 

public class CustomMessageRestfullMainClient {
 
    public static final String REST_SERVICE_URI = "http://localhost:8090/restful-boot"+CustomMessageRestfullConstant.MAPPING;
    
    @SuppressWarnings("unchecked")
    private static void listAllCustomMessage(){
        System.out.println("**** Test listAllCustomMessage API ***");
         
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI, List.class);
         
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
                //System.out.println("UserMessage ["+map+"] : id="+map.get(UserMessageConstant.FIELD_ID)+", description="+map.get(UserMessageConstant.FIELD_DESCRIPTION)+", vip="+map.get(UserMessageConstant.FIELD_VIP)+", creationDate="+map.get(UserMessageConstant.FIELD_CREATIONDATE)+", deletedDate="+map.get(UserMessageConstant.FIELD_DELETEDDATE));
            	System.out.println("UserMessage ["+map+"]");
            }
        }else{
            System.out.println("No user exist");
        }
    }
     
    private static void getCustomMessage(){
        System.out.println("*** Test getCustomMessage API ***");
        RestTemplate restTemplate = new RestTemplate();
        CustomMessage customMessage = restTemplate.getForObject(REST_SERVICE_URI+"/1", CustomMessage.class);
        System.out.println(customMessage);
    }
        
    private static void createCustomMessage() {
        System.out.println("*** Test create CustomMessage API ***");
        RestTemplate restTemplate = new RestTemplate();
        CustomMessage customMessage = CustomMessageDataFactory.create(5,"TEST",true);
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI, customMessage, CustomMessage.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
 
    private static void updateCustomMessage() {
        System.out.println("*** Testing update CustomMessage API ***");
        RestTemplate restTemplate = new RestTemplate();
        CustomMessage customMessage = CustomMessageDataFactory.create(5,"TEST UPDATED",true);
        restTemplate.put(REST_SERVICE_URI+"/5", customMessage);
        System.out.println(customMessage);
    }
 
    private static void deleteCustomMessage() {
        System.out.println("*** Testing delete CustomMessage API ***");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/1");
    }
    public static void main(String args[]){
    	listAllCustomMessage();
        deleteCustomMessage();
        listAllCustomMessage();

    }
}
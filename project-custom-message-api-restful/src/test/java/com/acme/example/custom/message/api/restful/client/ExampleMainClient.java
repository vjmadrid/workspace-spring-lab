package com.acme.example.custom.message.api.restful.client;
 
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.acme.example.custom.message.core.entity.CustomMessage; 

public class ExampleMainClient {
 
    public static final String REST_SERVICE_URI = "http://localhost:8090/restful-boot/test/example";
    
    @SuppressWarnings("unchecked")
    private static void listAllCustomMessage(){
        System.out.println("**** Test listAllCustomMessage API ***");
         
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI, List.class);
         
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
                //System.out.println("CustomMessage ["+map+"] : id="+map.get(CustomMessageConstant.FIELD_ID)+", description="+map.get(CustomMessageConstant.FIELD_DESCRIPTION)+", vip="+map.get(UserMessageConstant.FIELD_VIP)+", creationDate="+map.get(CustomMessageConstant.FIELD_CREATIONDATE)+", deletedDate="+map.get(CustomMessageConstant.FIELD_DELETEDDATE));
            	System.out.println("CustomMessage ["+map+"]");
            }
        }else{
            System.out.println("No custom message exist");
        }
    }
     
    private static void getCustomMessage(){
        System.out.println("*** Test getCustomMessage API ***");
        RestTemplate restTemplate = new RestTemplate();
        CustomMessage customMessage = restTemplate.getForObject(REST_SERVICE_URI+"/1", CustomMessage.class);
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
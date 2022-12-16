package com.example.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;


public class UserServiceResttemplatApplicationTest {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceResttemplatApplicationTest.class);

	private static int volume = 40;
    private RestTemplate restTemplate = new RestTemplate();
    
    public static final String USER_SERVICE="userService";
    public static final String USER_SERVICE_TIMEOUT="userServiceTimeout";

    private static final String BASEURL = "http://localhost:9292/user-service/displayOrders";

    public String displayOrders(String category) {
        String url = BASEURL + "?category=" + category;
        
        JsonNode json = null;
        JsonNode fl = null;
        
        for (int i = 1; i <= volume; i++ ) {
        	fl = restTemplate.getForObject(url, JsonNode.class);
        	
        	logger.debug(i + " Request sent.");
        	logger.debug( i + " " + fl.toString());
        }
        
        return "success";
    }
    
    public static void main(String[] args) {
    	if (args.length > 0) volume = Integer.parseInt(args[0]);
        new UserServiceResttemplatApplicationTest().displayOrders("electronics");
    }
}

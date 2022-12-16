package com.example.test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;

import reactor.core.publisher.Mono;


public class UserServiceWebClientApplicationTest {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceWebClientApplicationTest.class);

	private static int volume = 40;
    //private RestTemplate restTemplate = new RestTemplate();
    private static WebClient.Builder builder = WebClient.builder();
    
    public static final String USER_SERVICE="userService";
    public static final String USER_SERVICE_TIMEOUT="userServiceTimeout";

    private static final String BASEURL = "http://localhost:9292";
    private static WebClient client = builder.baseUrl(BASEURL).build();

    public String displayOrders(String category) {
        String url = BASEURL + "?category=" + category;
        
        JsonNode json = null;
        Mono<JsonNode> fl = null;
        List<Mono<JsonNode>> list = new ArrayList<Mono<JsonNode>>();
        
        for (int i = 1; i <= volume; i++ ) {
        	fl = client.get().uri(uriBuilder -> uriBuilder
        		    .path("/user-service/displayOrders")
        		    .queryParam("category", category)
        		    .build()).accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(JsonNode.class);
        	
        	list.add(fl);
        	
        	logger.debug(i + " Request sent.");
        	
        	try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        
        for (int i = 0; i < volume; i++ ) {
        	Mono<JsonNode> monoNode = list.get(i);
        	try {
        	JsonNode node = monoNode.block();
        	logger.debug( i + 1 + " " + node.toString());
        	} catch (Exception e) {
        		logger.debug(i + 1 + " exception: " + e.getMessage());
        	}
        }
        
        return "success";
    }
    
    public static void main(String[] args) {
    	if (args.length > 0) volume = Integer.parseInt(args[0]);
        new UserServiceWebClientApplicationTest().displayOrders("electronics");
    }
}

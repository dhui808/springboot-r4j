package com.example.cs;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/orders")
public class MockCatalogServiceController {
	
	private static final Logger logger = LoggerFactory.getLogger(MockCatalogServiceController.class);

    @Autowired
    private OrderRepository orderRepository;
    @Value(value = "${jobs-json-path}")
    private String jobsJsonPath;
    @Value(value = "${thread-sleep:5000}")
    private int threadSleep;
    private List<Map<String, Integer>> jobs;
    private int counter;
    private int subcounter;
    
    @PostConstruct
    public void initOrdersTable() {
    	loadJobs();
        orderRepository.saveAll(Stream.of(
                        new Order("mobile", "electronics", "white", 20000),
                        new Order("T-Shirt", "clothes", "black", 999),
                        new Order("Jeans", "clothes", "blue", 1999),
                        new Order("Laptop", "electronics", "gray", 50000),
                        new Order("digital watch", "electronics", "black", 2500),
                        new Order("Fan", "electronics", "black", 50000)
                ).
                collect(Collectors.toList()));
    }

	@GetMapping
	public List<Order> getOrders(){
		return orderRepository.findAll();
	}
	@GetMapping("/{category}")
	public List<Order> getOrdersByCategory(@PathVariable String category){
		
		logger.debug("getOrdersByCategory called.");
		Map<String, Integer> map = jobs.get(counter);
		String scenario = map.keySet().iterator().next();
		int i = map.get(scenario);
		
		subcounter++;
		
		if (subcounter == i) {
			counter++;
			subcounter = 0;
		} 
		
		if (counter == jobs.size()) {
			counter = 0;
		}
		
		List<Order> order = getOrderByScenario(scenario, category);
		
		return order;
	}

    private List<Order> getOrderByScenario(String scenario, String category) {
    	
    	logger.debug("Scenario " + scenario);
    	if ("timeout".equals(scenario)) {
    		try {
				Thread.sleep(threadSleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	} else if (false == "200".equals(scenario)) {
    		throw new MyException(scenario);
    	}
    	
    	return orderRepository.findByCategory(category);
	}

    private void loadJobs() {
    	ObjectMapper mapper = new ObjectMapper();
    	
    	try {
			jobs = mapper.readValue(Paths.get(jobsJsonPath).toFile(), List.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}

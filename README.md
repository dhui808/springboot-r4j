# springboot-r4j
Springboot and Resilience4J

### Create folders and symbolic links
	cd C:\
	cd opt
	mkdir springboot-r4j-logs 
	mklink /J "C:\opt\springboot-r4j" "C:\Users\username\research\github\springboot-r4j\springboot-r4j"
	
### Run
	Run MockCatalogServiceApplication
	Run UserServiceApplication
	From commandline:
	run-test.cmd 40 > tmp.txt
### Note
	Have to use commandline to send a number of requests. (40 requests, 16 seconds)
	Alternatively, run UserServiceApplicationTest and pass the desired volume. (40 requests, 20 seconds)
	(Why is WebClient not faster when sending all 40 request async???)
	
	 
	 
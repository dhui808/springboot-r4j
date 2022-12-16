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
	Use commandline to send a number of requests. (1000 requests, 885 seconds, received all responses 875 seconds)
	Alternatively, run UserServiceApplicationTest and pass the desired volume. (1000 requests, 601 seconds, received all responses 9 seconds)
	
	 
	 
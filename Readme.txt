Kindly follow below steps to run application 
1. Build application with following command 
	mvn clean install 
	Once build is successful, it will generate one tar file under target folder 

2. Once build is sucess, execute below command to run the same application in docker 
	Make sure docker is install in the machine where its executed 
	create image -> docker build -t eurodigital . 
	verify image once created -> docker images 
		eurodigital must be availble 
	Run image -> docker run -t -p9090:9090 eurodigital
	above step will run application in docker contianer 
	
3. Steps2 will create image and run the same on 9099 port. Hit below URL to open swagger documents 
	http://localhost:9090/swagger-ui.html
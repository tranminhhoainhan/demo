# demo
This is a demo which has been developed in short time to demostrate
 + Spin up mongodb using docker (run setup/setup.bat)
 + Feed date from expored bson files 
   - Install mongoimport
   - Run import.bat ./test-collection/{{filename_without_extension}}
 + How to build service :
   - Run gradlew openApiGenerate to generate Api source code from openapi specification
   - Run gradlew bootRun to run service
 + How to test:
   - Using postman and import collection under api-test
   - Select request and change parameters and execute.
   - Verify response

 + Points to improve
   - Support cross cutting concerns like logging, rest api security, etc
   - Improve the way to get data and filter using aggregator
   - Rest api should support pagination
   - Formalize the data especially DateTime field
   - Pipeline and docker based deployment support (docker based host, K8S, Openshift, etc) 
 + Note :
   - Demo is based on a "universal" Spring Boot skeleton --> there is "have not used" framework, library
   - Currently support "spring native" to speed up Spring boot start-up time and cloud ready ()
   - Swagger UI has been supported at http://localhost:8080/swagger-ui/4.10.3/index.html to verify other extra rest api as well   
   - A liquibased is suppored for DB schemas version control (transformed based on test-collection data)
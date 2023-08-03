# springboot-microservices

Project built to learn microservices implementation using springboot 

## Architecture

![image](https://github.com/ThejasNU/springboot-microservices/assets/77475353/6e6e993e-b73d-47f3-8bf0-683d08dc0618)

### Main components

1. `Department and Employee Service`: Serives responsible for handling requests
2. `Service registry`: Contains details about all the services present in the setup
3. `API Gateway`: Abstracts the inner implementation to the user, so that users can directly request to this and the call will be forwarded to the suitable service
4. `Config server`: Provides configurations for all services
5. `Zipkin`: Keeps track of all the requests coming, so makes it easy to debug

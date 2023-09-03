# BookingApp-Spring

 - Running the Application

    1. Open your project with a Java-based IDE (Integrated Development Environment) like IntelliJ IDEA or Eclipse.

    2. Compile and run the project. Spring Boot projects typically start from a "main" class.

- Requests

    you can use postman to send requests. Here is some sample request contents:

    - Post request for user
    ```bash
    Url : http://localhost:8080/users
    body : {"firstName":"Kadir2", "phoneNumber": "123456789", "age": 28}
    ```
    - Get request for user
    ```bash
    Url : http://localhost:8080/users/{id}
    ```
    - Update request for user
    ```bash
    Url : http://localhost:8080/users/{id}
    body : {"firstName":"KadirUpdate", "phoneNumber": "123456789", "age": 28}
    ```
    - delete request for user
    ```bash
    Url : http://localhost:8080/users/{id}
    ```
    
    to send request for other classes you can change the url with class name and change the parameters in body with the variable names of the class



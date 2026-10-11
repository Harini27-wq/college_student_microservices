# College-Student Microservices (Java 21, Spring Boot 3.5)

Start order (each in its own terminal, inside the module folder, run `mvn spring-boot:run`):
1. naming-server   (8761)  -> http://localhost:8761
2. config-server   (8888)
3. college-service (8081)
4. student-service (8082)
5. api-gateway     (8080)

Test through the gateway:
- GET  http://localhost:8080/colleges
- GET  http://localhost:8080/students
- GET  http://localhost:8080/students/1/details
=======


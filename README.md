# Prescription App (Spring Boot)

This is a complete small web application for prescription generation and management.
Features:
- H2 in-memory database for users and prescriptions
- Spring Security with users stored in H2
- Create / Edit / Delete prescriptions with server-side and client-side validation
- REST API: GET /api/v1/prescription returns JSON list
- Day-wise prescription report
- External API consumer (RXNAV) shown in UI
- Swagger/OpenAPI available at /swagger-ui.html

Default credentials:
- username: admin
- password: password

Build & Run:
- Requires Java 17+ and Maven
- `mvn clean package`
- `mvn spring-boot:run` or run the generated jar

H2 Console: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:prescriptionsdb)

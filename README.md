# Apache Camel ActiveMQ Demo Application

This is a demo application built with Spring Boot and Apache Camel to showcase how to:

1. Expose a REST API endpoint.
2. Process incoming requests with Apache Camel.
3. Send messages to an ActiveMQ queue.

This application also includes Behavior-Driven Development (BDD) tests using Cucumber to validate its functionality.

## Features

- A REST API endpoint to accept messages.
- Apache Camel routes to process and forward messages.
- ActiveMQ integration for queue-based messaging.
- Dockerized ActiveMQ instance for testing.
- BDD tests with Cucumber.

---

## Prerequisites

Before running the application, ensure the following tools are installed:

- [Java 17](https://adoptium.net/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) (optional, but recommended for development)

---

## Getting Started

### Step 1: Clone the Repository

```bash
git clone https://github.com/your-repo/apache-camel-activemq-demo.git
cd apache-camel-activemq-demo
```

### Step 2: Start ActiveMQ with Docker

1. Make sure Docker is running.
2. Create and start the ActiveMQ container using the provided `docker-compose.yml`:

```bash
docker-compose up -d
```

ActiveMQ will be available at:

- **Admin Console:** [http://localhost:8161](http://localhost:8161)
- **Broker URL:** `tcp://localhost:61616`

Credentials for the admin console:
- Username: `admin`
- Password: `admin`

### Step 3: Configure the Application

Update the `application.properties` file to match your ActiveMQ setup if needed (default values are provided):

```properties
spring.activemq.broker-url=tcp://localhost:61616
spring.activemq.user=admin
spring.activemq.password=admin
```

### Step 4: Build and Run the Application

To build and start the application:

```bash
mvn clean install
mvn spring-boot:run
```

The application will be available at:
- **API Endpoint:** [http://localhost:8080/api/send](http://localhost:8080/api/send)

### Step 5: Send a Test Message

Use `curl`, Postman, or any HTTP client to send a message:

```bash
curl -X POST http://localhost:8080/api/send \
     -H "Content-Type: application/json" \
     -d "Hello, Camel!"
```

Check the ActiveMQ admin console to see the message in the `demo-queue`.

---

## Running BDD Tests

The application includes Cucumber-based BDD tests. To execute the tests:

```bash
mvn test
```

Test scenarios are defined in `src/test/java/features/restToQueue.feature`.

---

## Project Structure

```plaintext
src/
├── main/
│   ├── java/com/example/
│   │   ├── CamelRoute.java       # Apache Camel route configuration
│   │   ├── RestApiController.java # REST API endpoint
│   │   └── CamelActivemqDemoApplication.java # Main application class
│   └── resources/
│       ├── application.properties # Spring Boot configuration
│       └── docker-compose.yml      # Docker setup for ActiveMQ
└── test/
    ├── java/
    │   ├── features/              # Cucumber feature files
    │   ├── stepdefinitions/       # Cucumber step definitions
    │   └── RunnerTest.java        # Cucumber test runner
```

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Contributing

Feel free to open issues or submit pull requests for improvements or bug fixes. Contributions are welcome!

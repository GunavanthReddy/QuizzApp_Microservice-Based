# QuizzApp: Microservice-Based Quiz Application
## Overview

QuizzApp is a scalable and modular quiz application designed using a microservices architecture. It allows users to participate in quizzes, track scores, and manage quizzes through a user-friendly interface. The application is built with Spring Boot and utilizes various technologies to ensure high availability and maintainability.

## Technologies Used

**Backend:** Spring Boot, Spring Cloud

**Frontend:** React.js (optional, if applicable)

**Database:** MySQL, MongoDB

**Messaging:** Kafka

**Authentication:** JWT (JSON Web Tokens)

**Containerization:** Docker

**API Gateway:** Spring Cloud Gateway

**Service Discovery:** Eureka Server

**Load Balancing:** Spring Cloud LoadBalancer

## Microservices Architecture

The application is divided into several microservices, each responsible for a specific domain:

**User Service:** Manages user registration, authentication, and profile.

**Quiz Service:** Handles quiz creation, question management, and quiz logic.

**Result Service:** Calculates and stores user scores and quiz results.

**Notification Service:** Sends notifications to users about quiz updates and results.



## Future Enhancements

- Implementing a frontend dashboard for quiz management.

- Integrating with external quiz question providers.

- Adding analytics and reporting features.

- Implementing role-based access control (RBAC).

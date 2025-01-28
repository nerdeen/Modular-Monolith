Doctor Appointment Booking System

🏥 Project Overview

This project is a practice in Modular Monolith Architecture, exploring different interaction styles between modules such as shared database and direct calls. Each module follows a distinct architectural pattern as specified in the assessment:

Doctor Availability Module: Traditional Layered Architecture

Appointment Booking Module: Clean Architecture

Appointment Confirmation Module: Simplest Architecture Possible

Doctor Appointment Management Module: Hexagonal Architecture

The system is designed for doctors to manage their appointment scheduling and patient bookings.

📌 Features

Doctor Availability Management: List, add, and manage available time slots.

Appointment Booking: Patients can book available slots.

Appointment Confirmation: Generates a confirmation notification upon successful booking.

Doctor Appointment Management: View, complete, or cancel appointments.

Data Persistence: Uses an in-memory store or database (configurable).

API-Based System: Designed as a RESTful service.

🏗️ System Architecture

Below is the architecture diagram illustrating the modular monolith structure:

![theCompleteFlow](https://github.com/user-attachments/assets/375655ec-d84a-4e1c-8546-b5285d25fd88)

Each module operates independently while integrating within the monolithic system using different architectural paradigms.

📜 API Documentation (Swagger UI)
![image](https://github.com/user-attachments/assets/d0c0acd5-7afa-4a30-862d-d854e157eedb)

The application exposes its APIs through Swagger. You can access it after running the project at:

http://localhost:8080/swagger-ui.html

🚀 API Endpoints & Business Logic

📌 Doctor Availability Module

Endpoint

Method

Description

/v1/doctor/slot

POST

Add a new available slot for the doctor. The slot must be at least 1 hour ahead of the current time.

/v1/doctor/slot/{doctorId}

GET

Retrieve all upcoming available slots for the doctor.

📌 Appointment Booking Module

Endpoint

Method

Description

/v1/appointment/slot

GET

Retrieve all available slots for patients to book.

/v1/appointments/book

POST

Book an appointment in a free slot. Ensures slots cannot be double-booked.

📌 Appointment Confirmation Module

Endpoint

Method

Description

Integrated in booking logic

-

Upon booking, the system logs a confirmation message for the doctor and patient.

📌 Doctor Appointment Management Module

Endpoint

Method

Description

/v1/manage/appointment/{doctorId}

GET

Retrieve upcoming appointments for the doctor.

/v1/manage/appointment/complete/{appointmentId}

PUT

Mark an appointment as completed.

/v1/manage/appointment/cancel/{appointmentId}

PUT

Cancel an appointment (if it is not already completed), if the slot in the future we release this slot to reserve it again if needed.

🔮 Future Enhancements

🛠 Dockerization: Containerizing the application for easy deployment.

🔑 JWT Authentication: Implement authentication and authorization.

✅ Unit & Integration Tests: Increase test coverage using automated tests.

📊 Monitoring & Logging: Add observability tools for monitoring system health.

🛠 Installation & Setup

📌 Prerequisites

JDK 17+ (if applicable)

Docker & Docker Compose (if planning to containerize)

Postman (optional, for testing APIs)

📌 Running the Application

Clone the Repository:

git clone https://github.com/nerdeen/doctor-appointment-booking.git
cd doctor-appointment-booking

Run the Application:

./gradlew bootRun # or mvn spring-boot:run (if using Maven)

Access Swagger UI:

Open: http://localhost:8080/swagger-ui.html

📌 Running with Docker (Future Implementation)

docker-compose up --build

🤝 Contributing

Feel free to fork this repository and submit a pull request with improvements or new features.

# Clarity Plus Package

## Problem Statement

The existing package management procedure within IIITB involves the delivery of shipments intended for students and professors to the reception area. At this point, an on-duty guard is tasked with manually recording the recipient's details in a register. Subsequently, upon receiving a courier, the designated recipient is required to provide their signature in the register, acknowledging the successful receipt of the package.

However, this seemingly straightforward process is marred by two fundamental challenges that significantly impact its efficiency and security. The primary challenge revolves around the authenticity of the recipient. The inherent risk of individuals falsifying signatures to claim packages not intended for them introduces a critical security vulnerability. Moreover, the second challenge pertains to the environmentally unsustainable consumption of paper resources due to the manual register-based documentation.

## Project Structure

The GitHub repository contains the following folders and files:

1. **Frontend**: Contains the source code of the frontend using ReactJS.
2. **OrderMService**: Contains the source code of the order microservice, responsible for managing and processing orders within the package handling workflow.
3. **RecipientMService**: Contains the source code of the recipient microservice, dedicated to managing recipient information and order details.
4. **apigateway**: Serves as the entry point for external clients to interact with the microservices.
5. **eurekaServer**: Eureka Spring Cloud facilitates micro-service discovery and registration.

## How It Works

1. Login as either a Guard or a Recipient.
2. After the recipient logs in, they can enter the details of the order they are about to deliver, which will be saved in the Recipient Database.
3. The guard will enter the details about the arrived parcel. (Steps 2 and 3 are independent and can be done in any order.)
4. The recipient will go to collect the parcel. An OTP will be sent to their email ID. On successful verification, the guard will hand over the parcel to the recipient.

## Testing and Mutation Coverage

Mutation testing has been performed to evaluate the test suite effectiveness.

- Frontend testing was done using Jest, and all frontend test cases were generated using this tool.
- Backend mutation testing was performed using PIT (PITest) for the Order Microservice and Recipient Microservice.
  - Order Microservice achieved a mutation coverage of 82%.
  - Recipient Microservice achieved a mutation coverage of 64%.
  - All backend test cases were generated through DiffBlue.

## Project Contributions

- Yasha: Order Microservice Testing
- Anisha: Recipient Microservice Testing
- Yasha and Anisha: Frontend Testing

## Team Members
- [Yasha Dayal (MT2022137)](https://github.com/yashadayal)
- [Anisha Rani (MT2022153)](https://github.com/anisha-sudo)

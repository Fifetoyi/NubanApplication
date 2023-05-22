# Nigerian Uniform Bank Account Number (NUBAN) Generator

This is a sample project that demonstrates a RESTful backend application using the Spring framework for generating Nigerian Uniform Bank Account Numbers (NUBANs). It also includes a minimal AngularJS frontend app to interact with the backend.

## Prerequisites

Before running the project, make sure you have the following installed:

- Java Development Kit (JDK) 8 or later
- Node.js and npm (Node Package Manager)
- AngularJS 1.8.2

## Setup

1. Clone the repository:

   ```
   git clone https://github.com/Fifetoyi/NubanApplication.git
   
2. Navigate to the code directory:
    ```
    cd NubanApplication/src/main
    
3. Build the application:

    ``` 
    ./mvnw clean package

4. Run the application
    ```
    ./mvnw spring-boot:run

## Usage

Open your web browser and visit http://localhost:8080 to access the application.

Enter the bank institution code and serial in the provided form fields.

Click on the "Generate NUBAN" button to send a request to the backend.

The generated NUBAN will be displayed on the page.


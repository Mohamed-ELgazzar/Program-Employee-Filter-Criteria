# Program-Employee-Filter-Criteria
Program Employee Filter Criteria

## Table of contents
* [Description](#description)
* [Database](#database)
* [Technologies](#technologies)
* [Setup](#setup)
* [Usage](#usage)
* [API Endpoints](#api_endpoints)
* [Frontend](#frontend)
* [Postman Collection](#postman_collection)
* [Output webisite](#output_of_website)
* [Contributing](#contributing)
* [License](#license)

## Description
This project is a web application that allows users to filter employee data based on various criteria. It provides a backend API built with Java Spring Boot and a frontend interface built with HTML, CSS, and JavaScript.

The application utilizes a database to store employee data, and users can search for employees using different parameters such as employee code, name, birth date, birth city, department, job title, direct manager, contract type, and status.

## Database
![Screenshot from 2023-07-23 20-59-37](https://github.com/Mohamed-ELgazzar/Program-Employee-Filter-Criteria/assets/122599973/f13a0568-2536-4de1-a17f-8dc15b5e3434)
#### ContractType

An entity that represents a contract type.

* **name** attribute.
* **one-to-many** relationship with `Employee`.

#### Department

An entity that represents a department.

* **name** attribute.
* **one-to-many** relationship with `Employee`.

#### Employee

An entity that represents an employee.

* **code** attribute.
* **name** attribute.
* **birthDate** attribute.
* **birthCity** attribute.
* **status** attribute.
* **many-to-one** relationship with `ContractType`.
* **many-to-one** relationship with `Job`.
* **one-to-one** relationship with `Employee` (the employee's direct manager).
* **one-to-many** relationship with `Employee` (the employee's subordinates).

#### Job

An entity that represents a job title.

* **name** attribute.
* **many-to-one** relationship with `Employee`.
## Technologies
The project uses the following technologies:

* Java Spring Boot (Backend API)
* HTML, CSS, JavaScript (Frontend Interface)
* MySQL (Database)
## Setup
To set up the project on your local machine, follow these steps:

Clone the repository from GitHub.
bash
Copy code
git clone https://github.com/Mohamed-ELgazzar/Program-Employee-Filter-Criteria.git
Import the project into your preferred IDE (e.g., IntelliJ, Eclipse).

Configure the database connection in the application.properties file with your MySQL credentials.

Run the Spring Boot application to start the backend server.

## Usage
To use the employee filter criteria application, follow these steps:

Access the frontend interface by opening the index.html file in a web browser.

Enter the search criteria in the form provided on the page.

Click the "View" button to trigger a search based on the entered criteria.

The search results will be displayed in a table below the form.

## API Endpoints
The backend API provides the following endpoint:

POST /employees/search: Performs a search for employees based on the provided criteria. The search criteria are sent as JSON data in the request body. The API responds with a JSON array containing the matching employee data.
#Frontend
The frontend interface is built with HTML, CSS, and JavaScript. The interface allows users to enter search criteria and view the results of their search in a table format.

## Postman Collection
You can test the API endpoints using Postman. Import the following Postman collection to access the API endpoints:

Program Employee Filter Criteria Postman Collection
![Screenshot from 2023-07-23 20-30-07](https://github.com/Mohamed-ELgazzar/Program-Employee-Filter-Criteria/assets/122599973/c55dd86f-9c4a-4a01-9dbb-2c420c6b1c66)
![Screenshot from 2023-07-23 20-29-36](https://github.com/Mohamed-ELgazzar/Program-Employee-Filter-Criteria/assets/122599973/5bedc80d-7881-4dd4-9e8e-e339211b3e23)
![Screenshot from 2023-07-23 20-30-37](https://github.com/Mohamed-ELgazzar/Program-Employee-Filter-Criteria/assets/122599973/b68ae93c-7e46-4ce5-ac6f-0693707d02ae)

## Output webisite
* Run the application using Maven:
     mvn spring-boot:run
![Screenshot from 2023-07-23 21-01-50](https://github.com/Mohamed-ELgazzar/Program-Employee-Filter-Criteria/assets/122599973/8f4ed58b-0a9a-42e5-b48c-ad7d6b6da576)

![Screenshot from 2023-07-23 21-01-18](https://github.com/Mohamed-ELgazzar/Program-Employee-Filter-Criteria/assets/122599973/1c4a4ef8-9fb8-43fa-a4e1-b643ea50706b)

* Open your web browser and enter the following URL:
    http://localhost:9076/index.html
* With these steps, you should be able to view the frontend page in your browser and search for employees using the Java Spring Boot backend.

## Contributing
Contributions to this project are welcome. If you find any issues or have suggestions for improvements, feel free to open a GitHub issue or submit a pull request.

## License
This project is licensed under the MIT License. You are free to modify and distribute the code as long as you include the original license in your distribution.
Java Spring Boot (Backend API)
HTML, CSS, JavaScript (Frontend Interface)
MySQL (Database)

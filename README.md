# Program-Employee-Filter-Criteria
Program Employee Filter Criteria

## Table of contents
* [Description](#description)
* [Technologies](#technologies)
* [Setup](#setup)
* [Usage](#usage)
* [API Endpoints](#api_endpoints)
* [Frontend](#frontend)
* [Postman Collection](#postman_collection)
* [Contributing](#contributing)
* [License](#license)

## Description
This project is a web application that allows users to filter employee data based on various criteria. It provides a backend API built with Java Spring Boot and a frontend interface built with HTML, CSS, and JavaScript.

The application utilizes a database to store employee data, and users can search for employees using different parameters such as employee code, name, birth date, birth city, department, job title, direct manager, contract type, and status.

## Technologies
The project uses the following technologies:

Java Spring Boot (Backend API)
HTML, CSS, JavaScript (Frontend Interface)
MySQL (Database)
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



## Contributing
Contributions to this project are welcome. If you find any issues or have suggestions for improvements, feel free to open a GitHub issue or submit a pull request.

## License
This project is licensed under the MIT License. You are free to modify and distribute the code as long as you include the original license in your distribution.
Java Spring Boot (Backend API)
HTML, CSS, JavaScript (Frontend Interface)
MySQL (Database)

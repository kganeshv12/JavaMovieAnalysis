# Movie Analysis Platform using Model, View, and Controller Architecture in JAVA & SpringBoot

This project is a Movie Analysis Platform that follows the Model, View, and Controller (MVC) architecture using Java and Spring Boot. It allows users to add movies, rate them, and view the updated average ratings. The platform handles various error conditions gracefully.

## Features

- Add a movie to the platform.
- Add a rating for a movie.
- View the updated average rating of a movie.
- View the database of movies and ratings.
- Handle error conditions.

## Prerequisites

- Java 8 or later installed on your machine. You can download it from [here](https://www.oracle.com/java/technologies/javase-downloads.html).
- Maven installed. You can download it from [here](https://maven.apache.org/download.cgi).
- A SQL database (e.g., MySQL, PostgreSQL) set up and running.

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/kganeshv12/JavaMovieAnalysis.git
   cd JavaMovieAnalysis
   ```
2. **Configure the database:**

    Update the application.properties file in the src/main/resources directory with your database connection details.

3. **Install dependencies and build the project:**

    ```bash
    mvn clean install
    ```
    Run the application:
    ```bash
    mvn spring-boot:run
    ```
    The application will start running on http://localhost:8080.

## ADDING A MOVIE :
![Images]("img1.png")

## ADDING A RATING
![Images]("img2.png")

## UPDATED AVERAGE RATING
![Images]("img3.png")

## DATABASE VIEW
![Images]("img4.png")

## ERROR CONDITIONS :
![Images]("img5.png")

![Images]("img6.png")

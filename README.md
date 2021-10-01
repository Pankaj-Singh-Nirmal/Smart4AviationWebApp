# Smart4AviationWebApp

## Demo:
Application can be run on a machine with following docker commands:
  >**docker pull pankajsn/smart4aviation**\
  >**docker run -p 8080:8080 pankajsn/smart4aviation**

## Tasks:
- For requested Flight Number and date will respond with following :
  - Cargo Weight for requested Flight
  - Baggage Weight for requested Flight
  - Total Weight for requested Flight
- For requested IATA Airport Code and date will respond with following :
  - Number of flights departing from this airport,
  - Number of flights arriving to this airport,
  - Total number (pieces) of baggage arriving to this airport,
  - Total number (pieces) of baggage departing from this airport.

## Stack
- Java 11
- Spring : Boot, Web, Tests
- HTML
- CSS
- JUnit 5
- Maven

## Build
Execute mvn clean install. It will start building process with test validations.
If process will be successful, a war will be created in target folder with all dependencies: smart4aviation.war

# Cab-Service

[![Java](https://img.shields.io/static/v1.svg?label=Java&color=red&message=v11)]() 
[![SpringBoot](https://img.shields.io/static/v1.svg?label=SpringBoot&color=orange&message=v2.4.0)]() 
[![Hibernate](https://img.shields.io/static/v1.svg?label=Hibernate&color=blue&message=v5.4.23)]() 
[![JPA](https://img.shields.io/static/v1.svg?label=SpringDataJPA&color=green&message=v2.4)]() 
[![SpringMVC](https://img.shields.io/static/v1.svg?label=SpringMVC&color=maroon&message=v5.3.1)]()
[![Maven](https://img.shields.io/static/v1.svg?label=Maven&color=cyan&message=v3.6.3)]()

A springboot application that lets you add drivers and get nearby drivers by providing your location as longitude and latitude values.

---

### Table of Contents
- [Description](#description)
- [Specification](#specification)
- [How to use](#how-to-use)
 
 ---
 
 ## Description
 
 Cab-Service application uses a relational database to store the driver's inforamtion(id, driver_name, car_name, vehicle_number, longitude, latitude). It provides Restful CRUD API  which can be used to :-  
 - Create driver.
 - Read driver/drivers information.
 - Update driver.
 - Delete driver.
 - Get list of all the nearby drivers by providing your location.
 
 It accepts and provides information in JSON and XML format.
 
 ---
 
 ## Specification
 
 - Java v11.
 - Springboot v2.4.0
 - Hibernate v5.4.23
 - Spring MVC v5.3.1
 - Spring Data JPA v2.4
 - Maven v3.6.3
 
 ---
 
  ## How to use
 
 #### Installation
 
 - Use your favourite IDE ex - Eclipse, STS, IntelliJ, Netbeans.
 - Import the project.
 - Fill up the properties in the application.properties file according to the database type.
 
 ##### For mysql database
 
 ```html
spring.datasource.url = jdbc:mysql://localhost:3306/$Schema name
spring.datasource.username = $username
spring.datasource.password = $password
spring.jpa.hibernate.ddl-auto = create-drop
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
spring.jpa.show-sql = true
spring.datasource.initialization-mode=always
cabservice.distance = $distance in kilometer between the nearby drivers and your location.

```

##### For H2 : in-memory database

````html
spring.datasource.url = jdbc:h2:mem:test
spring.datasource.platform = h2
spring.h2.console.enabled = true
cabservice.distance = $distance in kilometer between the nearby drivers and your location.
 
 ````
 
 - Run the project
 
 #### Create a driver
 
 The application on startup use the data.sql file to accumulate the data initially.
 To create a driver send a POST request using postman client and send the data in the body and set header Content-Type as application/json or xml  . id field can be skipped as it is auto-generated and auto-incremented by the appllication.
 
 ````html

localhost:8080/cab/driver

JSON format

 {
        "id": 2,
        "longitude": 10.01,
        "latitude": 10.01,
        "carName": "beat",
        "driverName": "ram",
        "vehicleNumber": "UP32 LR0002"
    }

XML format

<List>
    <item>
        <id>2</id>
        <longitude>10.01</longitude>
        <latitude>10.01</latitude>
        <carName>beat</carName>
        <driverName>ram</driverName>
        <vehicleNumber>UP32 LR0002</vehicleNumber>
    </item>
  </List>
````
 
#### Get all the drivers

To get all the drivers create a GET request 

````html

localhost:8080/cab/drivers
````

#### Get a driver uisng an id field

To get a driver by id create a GET request

````html

localhost:8080/cab/driver/$id
````

#### Delete a driver using an id field

To delete a driver create a DELETE request

````html

localhost:8080/cab/driver/$id
````

#### Update a driver

To update a driver create a PUT request and send the updated information in the body

````html

localhost:8080/cab/driver

JSON format

 {
        "id": 2,
        "longitude": 10.01,
        "latitude": 10.01,
        "carName": "beat",
        "driverName": "ram",
        "vehicleNumber": "UP32 LR0002"
    }

XML format

<List>
    <item>
        <id>2</id>
        <longitude>10.01</longitude>
        <latitude>10.01</latitude>
        <carName>beat</carName>
        <driverName>ram</driverName>
        <vehicleNumber>UP32 LR0002</vehicleNumber>
    </item>
 </List>
````

#### Get nearby drivers

To get nearby drivers send a POST request and send longitude and latitude values in the body.

```` html

localhost:8080/cab/book

JSON format

{  
        "longitude": 10.01,
        "latitude": 10.01    
    }

XML format

<Item>
     <longitude>10.01</longitude>
     <latitude>10.01</latitude>
       
</Item>
````

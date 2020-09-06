#Project Title
sn-patrimoine

##Getting Started
These introductions will get you a copy of the project up and running in your local machine for developpement and testing purposes.

###Prerequisites
You have to import the project with a compatible IDE as IntelliJ. Then let some the time to the IDE to Add all dependancies.
For further references please check HELP.md file

###Running
Once the project imported run open your terminal in run this command

```
mvn spring-boot:run
```

### WEB layer

|Res verb   |Endpoint   |Description   |Status   |
|---|---|---|---|
|GET   |/api/v1/heritages   |List all heritages in system   |200, 401, 500 |
|GET   |/api/v1/heritages/:id   |Retrieves a heritage   |200, 401, 404   |
|POST  |/api/v1/heritages   |   |   |
|PUT   |/api/v1/heritages   |   |   |
|DELETE   |/api/v1/heritages   |   |   |


### Examples
####GET all Heritages

```
curl -X GET http://localhost:8080/api/heritages?category=Building,Status
```

####GET one Heritage

```
http://localhost:8080/api/heritage/{id}
```


####POST Heritage

```
curl -X POST \
    -- data ...
    --url http://localhost:8080/api/heritage
```

####PUT one Heritage

```
http://localhost:8080/api/heritage/{id}
```
####Delete one Heritage

```
http://localhost:8080/api/heritage/{id}
```

####GET all Categories

```
http://localhost:8080/api/heritages
```

####GET one Category

```
http://localhost:8080/api/heritage/{id}
```


####POST Category

```
http://localhost:8080/api/heritage
```

####PUT one Category
```
http://localhost:8080/api/heritage/{id}
```
####Delete one Category

```
http://localhost:8080/api/heritage/{id}
```





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
|GET   |/api/v1/heritage/:id   |Retrieves a heritage   |200, 401, 404   |
|POST  |/api/v1/heritage/   | create new heritage   | 200, 401,404  |
|PUT   |/api/v1/heritage/:id   | update heritage  | 200, 401,404   |
|DELETE   |/api/v1/heritage/:id   |  Delete heritage | 200, 401,404   |
|GET   |/api/v1/categories   |List all categories in system   |200, 401, 500 |
|GET   |/api/v1/category/:id   |Retrieves a category   |200, 401, 404   |
|POST  |/api/v1/category/   | create new category   | 200, 401,404  |
|PUT   |/api/v1/category/:id   | update category  | 200, 401,404   |
|DELETE   |/api/v1/category/:id   |  Delete category | 200, 401,404   |


### Examples
####GET all Heritages

```
curl -X GET http://localhost:8080/api/heritages?category=Building,Status
```

####GET one Heritage

```
 curl -X GET http://localhost:8080/api/heritage/:id
```


####POST Heritage

```
curl -X POST http://localhost:8080/api/heritage/
```

####PUT one Heritage

```
curl -X PUT http://localhost:8080/api/heritage/:id
```
####Delete one Heritage

```
curl -X DELETE http://localhost:8080/api/heritage/:id
```

####GET all Categories

```
curl -X PUT http://localhost:8080/api/categories
```

####GET one Category

```
curl -X GET http://localhost:8080/api/category/:id
```


####POST Category

```
curl -X POST http://localhost:8080/api/category/:id
```

####PUT one Category
```
curl -X PUT http://localhost:8080/api/category/:id
```
####Delete one Category

```
curl -X DELETE http://localhost:8080/api/category/:id
```





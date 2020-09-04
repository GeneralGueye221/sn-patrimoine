#Project Title
sn-patrimoine

##Getting Started
These introductions will get you a copy of the project up and running in your local machine for developpement and testing purposes.

###Prerequisites
You have to import the project with a compatible IDE as IntelliJ. Then let some the time to the IDE to Add all dependancies.
For further references please check HELP.md file

###Running
Once the project imported run open your terminal in run this command

```$xslt
mvn spring-boot:run
```

### WEB layer
####GET all Heritages

```$xslt
http://localhost:8080/api/heritages
```

####GET one Heritage

```$xslt
http://localhost:8080/api/heritage/{id}
```


####POST Heritage

```$xslt
http://localhost:8080/api/heritage
```

####PUT one Heritage

```$xslt
http://localhost:8080/api/heritage/{id}
```
####Delete one Heritage

```$xslt
http://localhost:8080/api/heritage/{id}
```

####GET all Categories

```$xslt
http://localhost:8080/api/heritages
```

####GET one Category

```$xslt
http://localhost:8080/api/heritage/{id}
```


####POST Category

```$xslt
http://localhost:8080/api/heritage
```

####PUT one Category
```$xslt
http://localhost:8080/api/heritage/{id}
```
####Delete one Category

```$xslt
http://localhost:8080/api/heritage/{id}
```





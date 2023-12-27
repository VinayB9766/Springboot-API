# Springboot-API
#  Logistic Load Management API
In order to understand the API see the basic structure of API it is as given below:
project-root/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── logistic/
│   │   │           └── assigment/
│   │   │               ├── controller/
│   │   │               │   └── LoadController.java
│   │   │               ├── model/
│   │   │               │   └── Load.java
│   │   │               ├── repository/
│   │   │               │   └── LoadRepository.java
│   │   │               └── service/
│   │   │                   ├── LoadService.java
│   │   │                   └── LoadServiceImpl.java
│   │   ├── resources/
│   │   │   └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── logistic/
│                   └── assigment/
│                       └── controller/
│                           └── LoadControllerTest.java
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
Explanation:

src/main/java/com/logistic/assigment/controller/: Contains controller classes.
src/main/java/com/logistic/assigment/model/: Contains model classes (e.g., Load.java).
src/main/java/com/logistic/assigment/repository/: Contains repository interfaces (e.g., LoadRepository.java).
src/main/java/com/logistic/assigment/service/: Contains service interfaces and implementations (e.g., LoadService.java, LoadServiceImpl.java).
src/resources/: Contains application configuration files (e.g., application.properties).
test/: Contains test classes.
.gitignore: Specifies files and directories to be ignored by Git.
mvnw, mvnw.cmd: Maven wrapper scripts for building the project without needing to install Maven globally.
pom.xml: Maven Project Object Model file, where project dependencies and configuration are specified.
README.md: Documentation file providing information about project.

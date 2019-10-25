# VAT Calculator

## Technologies used

* Language: Kotlin 1.3.31
* Core framework: Spring Boot 2.1 with Spring Framework 5 Kotlin support
* Web framework: Spring MVC
* JQuery 2.2.4
* Google Cloud Jib Tool 1.3.0 (for building Docker image)
* Templates: Thymeleaf and Bootstrap
* Build: Gradle Script with the Kotlin DSL
* Testing: Junit 5, Mockito

### To run on gradle command line

```
cd kotlin-vat-calc
./gradlew bootRun
```

### To create and push Docker image

```
./gradlew jibDockerBuild
```





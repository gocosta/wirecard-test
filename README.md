# Wirecard payment test

[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![Coverage Status](https://coveralls.io/repos/github/codecentric/springboot-sample-app/badge.svg?branch=master)](https://coveralls.io/github/codecentric/springboot-sample-app?branch=master)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

## Requisitos

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 4](https://maven.apache.org) 
- [MySql](https://www.mysql.com/) server with schema "paymentinfo_database"

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `br.paymentapi.wirecard.WirecardApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

##Rest API Document

To see the documentation about the requests used in this project access the link:

https://documenter.getpostman.com/view/1463674/SWT8hza7?version=latest

##Useful

parameters to do a payment:

amount: 1200
paymentType: CARTAO
card.holder: Guilherme
card.number: 4563412367896852
card.expiration: 10/2022
card.cvv: 123
buyer.name: Guilherme+Oliveira
buyer.email: guilherme@gmail.com
buyer.CPF: 41551086832
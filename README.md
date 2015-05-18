## Intro

An example Maven project to show you how to interact with MySQL using Hibernate framework

## App.java

Client to demonstrate insertion and query with Hibernate

## User.java

Java model class for Table **USER** in DB

## HibernateUtil.java

Java class to create Hibernate **session** to interact with the DB

## User.hbm.xml

Hibernate XML **mapping** file

## hibernate.cfg.xml

Hibernate XML **configuration** file to establish connection to MySQL DB

## Dependencies
```
CREATE TABLE USER (
 USER_ID INT (5) NOT NULL,
 USERNAME VARCHAR (20) NOT NULL,
 CREATED_BY VARCHAR (20) NOT NULL,
 CREATED_DATE DATE NOT NULL,
 PRIMARY KEY ( USER_ID )
)
```
## Dependencies

- hibernate-core
- mysql-connector-java

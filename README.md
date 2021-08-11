#Authentication-app

Simple application that uses spring security to authenticate an user.

This application is using in memory users. Available users: `user, admin`. For testing purposes, 
both users are sharing the same password which can be configured as explained below.

###Run locally
Before running the application,you need to setup `MOCK_USER_PASSWORD` as an environment variable. 
The value shall be used as your user password when you try to login.

Run `mvn spring-boot:run` to start the application.
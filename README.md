#Authentication-app

Simple application that uses spring security to authenticate.

This application is using PostgresSQL database to fetch users.


###Run locally
You must provide datasource information in `application.yml` so you need to setup `PSQL_URL`, `PSQL_USER` and `PSQL_PASS` as environment variables that are pointing to your PostgreSQL server.

The database must match the same schema as the one from resources folder (see `schema.sql`)

**Run command:** 

`mvn spring-boot:run` 

to start the application.
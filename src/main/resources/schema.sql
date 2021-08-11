drop table if exists users cascade;
drop table if exists authorities cascade;

CREATE TABLE users (
  username VARCHAR(50) NOT NULL,
  password VARCHAR(100) NOT NULL,
  enabled SMALLINT NOT NULL DEFAULT 1,
  email VARCHAR(50) NOT NULL,
  age NUMERIC NOT NULL,
  PRIMARY KEY (username)
);

CREATE TABLE authorities (
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  FOREIGN KEY (username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username
  on authorities (username,authority);
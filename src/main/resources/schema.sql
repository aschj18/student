drop table if exists ACCOUNT;

create table ACCOUNT(
  ID long not null AUTO_INCREMENT,
  NAME varchar(255) ,
  STATUS varchar(255),
  PRIMARY KEY ( ID )
);
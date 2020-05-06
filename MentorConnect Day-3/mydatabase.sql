create database mentorconnect;
use mentorconnect;

create table login
(username varchar(10),
password varchar(10));

insert into login values('Nik','Sejal');
insert into login values('Pra','Beauty');

select * from login;

create table registration
(name varchar(20),
companyname varchar(20),
contactnumber varchar(20),
gender boolean,
city varchar(20),
state varchar(20),
country varchar(20)
);



select * from registration;
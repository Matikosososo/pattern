create database muestra_db;
GO
USE muestra_db;


create table arma(
    id INT identity(1,1), 
    nombre varchar(30),
    municion INT,
    primary key(id)
);

create table skin(
    id INT identity(1,1),
    nombre varchar(150),
    primary key(id)
);

create table ciudad(
    id INT identity(1,1),
    nombre varchar(30),
    primary key(id)
);
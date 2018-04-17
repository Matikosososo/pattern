create database bd_muestra;

USe bd_muestra;

create table arma(
    id INT AUTO_INCREMENT, 
    nombre varchar(30),
    municion INT,
    primary key(id)
);

create table skin(
    id INT AUTO_INCREMENT,
    nombre varchar(150),
    primary key(id)
);

create table ciudad(
    id INT AUTO_INCREMENT,
    nombre varchar(30),
    primary key(id)
);

insert into arma values(null, 'Pistola Silenciada')
insert into ciudad values(null, 'Pisos Picados')
insert into skin values(null, 'Unicornio')

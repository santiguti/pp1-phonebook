#DROP DATABASE if exists agenda;
CREATE DATABASE agenda;
USE agenda;

CREATE TABLE domicilios
(
  idDomicilio int(11) NOT NULL AUTO_INCREMENT,
  Calle varchar(60),
  Altura int(15),
  Piso int(5),
  Depto varchar(4),
  Pais varchar(50),
  Provincia varchar(24),
  Localidad varchar(45),
  PRIMARY KEY (idDomicilio)
);
CREATE TABLE personas
(
  idPersona int(11) NOT NULL AUTO_INCREMENT,
  idDomicilio int(11) NOT NULL,
  Nombre varchar(45) NOT NULL,
  Telefono varchar(20) NOT NULL,
  Email varchar(45),
  Cumpleanios date,
  Etiqueta varchar(10),
  PRIMARY KEY (idPersona),
  FOREIGN KEY (idDomicilio) REFERENCES domicilios(idDomicilio)
);

CREATE DATABASE `agenda`;
USE agenda;
CREATE TABLE `personas`
(
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  PRIMARY KEY (`idPersona`)
);
CREATE TABLE `domicilios`
(
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `Calle` varchar(60) NOT NULL,
  `Altura` int(15) NOT NULL,
  `Piso` int(5),
  `Depto` varchar(4),
  `Provincia` varchar(24) NOT NULL,
  `Localidad` varchar(45) NOT NULL,
  PRIMARY KEY (`idPersona`),
  FOREIGN KEY (`idPersona`) REFERENCES `personas`(`idPersona`)
);
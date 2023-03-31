-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-04-2017 a las 23:14:15
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: 'tienda'
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla 'usuario'
--

CREATE TABLE IF NOT EXISTS usuario (
  idusuario int(11) NOT NULL AUTO_INCREMENT,
  nombre varchar(30) DEFAULT NULL,
  apellido varchar(25) DEFAULT NULL,
  codigo varchar(28) DEFAULT NULL,
  edad int(2) DEFAULT NULL,
  genero varchar(1) DEFAULT NULL,
  ciudad varchar(40) DEFAULT NULL,
  PRIMARY KEY (idusuario)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- Volcado de datos para la tabla 'usuario'
--

INSERT INTO usuario (idusuario, nombre, apellido, codigo, edad, genero, ciudad) VALUES
(5, 'Mario Alberto', 'Cáceres', 'addb47291ee169f330801ce73520', 23, 'S', 'San Miguel'),
(7, 'Lucía Carolina', 'Duarte', '7c4a8d09ca3762af61e59520943d', 28, 'F', 'San Salvador'),
(8, 'Julio Amilcar', 'Durán Umaña', '912ec803b2ce49e4a541068d495a', 21, 'M', 'San Vicente'),
(9, 'Diana Liseth', 'Benítez Contreras', 'd41d8cd98f00b204e9800998ecf8', 25, 'F', 'Santo Tomás'),
(11, 'Erika  María', 'Landaverde Castro', '25d55ad283aa400af464c76d713c', 32, 'M', 'San Salvador'),
(12, 'Diana Lisseth', 'Benítez Contreras', '25d55ad283aa400af464c76d713c', 25, 'F', 'Santo Tomás'),
(13, 'Marcos Antonio', 'Villalta Cortez', '25d55ad283aa400af464c76d713c', 25, 'C', 'Ahuachapán'),
(14, 'Julian Alberto', 'Alvarado Ruíz', 'e10adc3949ba59abbe56e057f20f', 36, 'M', 'Mejicanos'),
(15, 'Alexander Ismael', 'Contreras', 'e10adc3949ba59abbe56e057f20f', 24, 'M', 'San Salvador');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-04-2018 a las 17:45:12
-- Versión del servidor: 5.7.14
-- Versión de PHP: 5.6.25

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tienda`
--
CREATE DATABASE tienda CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';
USE tienda;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `apellido` varchar(25) DEFAULT NULL,
  `codigo` varchar(32) DEFAULT NULL,
  `edad` int(2) DEFAULT NULL,
  `genero` varchar(1) DEFAULT NULL,
  `ciudad` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idusuario`, `nombre`, `apellido`, `codigo`, `edad`, `genero`, `ciudad`) VALUES
(5, 'Mario Alberto', 'Cáceres', 'addb47291ee169f330801ce73520', 23, 'M', 'San Miguel'),
(7, 'Lucía Carolina', 'Duarte', '7c4a8d09ca3762af61e59520943d', 28, 'F', 'San Salvador'),
(8, 'Julio Amilcar', 'Durán Umaña', '912ec803b2ce49e4a541068d495a', 21, 'M', 'San Vicente'),
(9, 'Diana Lissette', 'Benítez Contreras', 'd41d8cd98f00b204e9800998ecf8', 23, 'F', 'Santo Tomás'),
(11, 'Erika  María', 'Landaverde Castro', '25d55ad283aa400af464c76d713c', 32, 'M', 'San Salvador'),
(12, 'Luis Alexander', 'Díaz Muñoz', '25d55ad283aa400af464c76d713c', 25, 'M', 'Soyapango'),
(13, 'Marcos Antonio', 'Villalta Cortez', '25d55ad283aa400af464c76d713c', 25, 'M', 'Ahuachapán'),
(14, 'Julian Alberto', 'Alvarado Ruíz', 'e10adc3949ba59abbe56e057f20f', 36, 'M', 'Mejicanos'),
(15, 'Alexander Ismael', 'Contreras', 'e10adc3949ba59abbe56e057f20f', 24, 'M', 'San Salvador'),
(16, 'Mónica Lucía', 'Arévalo Chinchilla', 'e10adc3949ba59abbe56e057f20f883e', 31, 'F', 'Santa Tecla'),
(17, 'Lilian Adrina', 'Cortéz Montalvo', 'e10adc3949ba59abbe56e057f20f883e', 28, 'F', 'San Vicente');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idusuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

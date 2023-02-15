-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 15, 2023 at 07:18 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `escuela`
--

-- --------------------------------------------------------

--
-- Table structure for table `alumno`
--

CREATE TABLE `alumno` (
  `Cod_alumno` int(11) NOT NULL,
  `Nombre` varchar(80) NOT NULL,
  `Apellido` varchar(80) NOT NULL,
  `Edad` int(11) NOT NULL,
  `Direccion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `alumno`
--

INSERT INTO `alumno` (`Cod_alumno`, `Nombre`, `Apellido`, `Edad`, `Direccion`) VALUES
(1, 'Erick', 'Fuentes', 19, 'Santa Tecla'),
(2, 'Bryan', 'Cornejo', 18, 'Soyapango'),
(4, 'Angie', 'Valencia', 18, 'San Marcos'),
(5, 'Diego', 'Chevez', 18, 'SS'),
(9, 'Roxana', 'García', 50, 'Santa Tecla');

-- --------------------------------------------------------

--
-- Table structure for table `alumno_materia`
--

CREATE TABLE `alumno_materia` (
  `Cod_Reporte` int(11) NOT NULL,
  `Cod_alumno` int(11) NOT NULL,
  `Cod_materia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `alumno_materia`
--

INSERT INTO `alumno_materia` (`Cod_Reporte`, `Cod_alumno`, `Cod_materia`) VALUES
(1, 1, 1),
(2, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `materia`
--

CREATE TABLE `materia` (
  `Cod_materia` int(11) NOT NULL,
  `Nombre` varchar(25) NOT NULL,
  `Descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `materia`
--

INSERT INTO `materia` (`Cod_materia`, `Nombre`, `Descripcion`) VALUES
(1, 'DSP', 'Desarrollo de C#'),
(2, 'DAW', 'JavaScript');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`Cod_alumno`);

--
-- Indexes for table `alumno_materia`
--
ALTER TABLE `alumno_materia`
  ADD PRIMARY KEY (`Cod_Reporte`),
  ADD KEY `Cod_alumno` (`Cod_alumno`,`Cod_materia`),
  ADD KEY `Cod_materia` (`Cod_materia`);

--
-- Indexes for table `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`Cod_materia`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `alumno`
--
ALTER TABLE `alumno`
  MODIFY `Cod_alumno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `alumno_materia`
--
ALTER TABLE `alumno_materia`
  MODIFY `Cod_Reporte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `materia`
--
ALTER TABLE `materia`
  MODIFY `Cod_materia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `alumno_materia`
--
ALTER TABLE `alumno_materia`
  ADD CONSTRAINT `alumno_materia_ibfk_1` FOREIGN KEY (`Cod_materia`) REFERENCES `materia` (`Cod_materia`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `alumno_materia_ibfk_2` FOREIGN KEY (`Cod_alumno`) REFERENCES `alumno` (`Cod_alumno`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

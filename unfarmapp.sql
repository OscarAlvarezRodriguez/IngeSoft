-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-05-2020 a las 04:32:57
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.2.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `unfarmapp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `CEDULACLIENTE` varchar(12) NOT NULL,
  `APELLIDOCLIENTE` varchar(50) NOT NULL,
  `DESCRIPCIONDIRECCIONCLIENTE` varchar(32) NOT NULL,
  `DIRECCIONCLIENTE` varchar(15) NOT NULL,
  `NOMBRECLIENTE` varchar(2) NOT NULL,
  `TELEFONOCLIENTE` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`CEDULACLIENTE`, `APELLIDOCLIENTE`, `DESCRIPCIONDIRECCIONCLIENTE`, `DIRECCIONCLIENTE`, `NOMBRECLIENTE`, `TELEFONOCLIENTE`) VALUES
('UFU', 'FUYF', 'FYUY', 'FYUF', 'FF', 'GUYG');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `IDCOMPRA` bigint(20) NOT NULL,
  `NOMBREPROVEDORCOMPRA` varchar(50) NOT NULL,
  `PRECIOTOTALCOMPRA` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `domicilio`
--

CREATE TABLE `domicilio` (
  `IDDOMICILIO` int(11) NOT NULL,
  `ESTADODOMICILIO` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `drogueria`
--

CREATE TABLE `drogueria` (
  `NITDROGUERIA` varchar(20) NOT NULL,
  `DIRECCIONDROGUERIA` varchar(32) NOT NULL,
  `EMAILDROGUERIA` varchar(50) NOT NULL,
  `NOMBREDROGUERIA` varchar(32) NOT NULL,
  `REPRESENTANTELEGALDROGUERIA` varchar(32) NOT NULL,
  `TELEFONODROGUERIA` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `CEDULAEMPLEADO` varchar(11) NOT NULL,
  `APELLIDOEMPLEADO` varchar(25) NOT NULL,
  `CONTRESENIAEMPLEADO` varchar(20) NOT NULL,
  `CORREOEMPLEADO` varchar(50) NOT NULL,
  `DESCRIPCIONDIRECCIONEMPLEADO` varchar(50) NOT NULL,
  `DIRECCIONEMPLEADO` varchar(32) NOT NULL,
  `NOMBREEMPLEADO` varchar(25) NOT NULL,
  `TELEFONOEMPLEADO` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`CEDULAEMPLEADO`, `APELLIDOEMPLEADO`, `CONTRESENIAEMPLEADO`, `CORREOEMPLEADO`, `DESCRIPCIONDIRECCIONEMPLEADO`, `DIRECCIONEMPLEADO`, `NOMBREEMPLEADO`, `TELEFONOEMPLEADO`) VALUES
('1000602028', 'Alvarez R', 'Zekrom13', 'oalvarezr@unal.edu.co', '??', 'Cll 134 #160B - 43', 'Oscar E', '300 206 27 29');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `IDFACTURA` int(11) NOT NULL,
  `PRECIOTOTALFACTURA` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamento`
--

CREATE TABLE `medicamento` (
  `IDMEDICAMENTO` int(11) NOT NULL,
  `DTYPE` varchar(31) DEFAULT NULL,
  `DESCRIPCIONMEDICAMENTO` varchar(50) NOT NULL,
  `CANTIDADMEDICAMENTO` int(11) NOT NULL,
  `NOMBREMEDICAMENTO` varchar(60) NOT NULL,
  `PRECIOVENTAMEDICAMENTO` varchar(10) NOT NULL,
  `PRESENTACIONMEDICAMENTO` varchar(20) NOT NULL,
  `PRINCIPIOACTIVOMEDICAMENTO` varchar(90) NOT NULL,
  `TITULARMEDICAMENTO` varchar(25) NOT NULL,
  `CANTIDADCOMPRADAMEDICAMENTO` int(11) NOT NULL,
  `IDCOMPRAMEDICAMENTO` int(11) NOT NULL,
  `PRECIOUNITARIOMEDICAMENTO` int(11) NOT NULL,
  `CANTIDADVENDIDAMEDICAMENTO` int(11) NOT NULL,
  `IDFACTURAMEDICAMENTO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`CEDULACLIENTE`);

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`IDCOMPRA`);

--
-- Indices de la tabla `domicilio`
--
ALTER TABLE `domicilio`
  ADD PRIMARY KEY (`IDDOMICILIO`);

--
-- Indices de la tabla `drogueria`
--
ALTER TABLE `drogueria`
  ADD PRIMARY KEY (`NITDROGUERIA`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`CEDULAEMPLEADO`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`IDFACTURA`);

--
-- Indices de la tabla `medicamento`
--
ALTER TABLE `medicamento`
  ADD PRIMARY KEY (`IDMEDICAMENTO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 14-10-2020 a las 20:50:57
-- Versión del servidor: 5.7.31-0ubuntu0.18.04.1
-- Versión de PHP: 7.3.22-1+ubuntu18.04.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_mini_proyecto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TblAdministrador`
--

CREATE TABLE `TblAdministrador` (
  `AdmIdentificacion` int(11) NOT NULL,
  `AdmContrasenia` varchar(200) NOT NULL,
  `AdmNombre1` varchar(50) NOT NULL,
  `AdmNombre2` varchar(50) DEFAULT NULL,
  `AdmApellido1` varchar(50) NOT NULL,
  `AdmApellido2` varchar(50) DEFAULT NULL,
  `AdmCelular` varchar(50) DEFAULT NULL,
  `AdmCorreo` varchar(50) DEFAULT NULL,
  `TblTipoIdenticacion_TipId` int(11) NOT NULL,
  `TblEstado_EstId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `TblAdministrador`
--

INSERT INTO `TblAdministrador` (`AdmIdentificacion`, `AdmContrasenia`, `AdmNombre1`, `AdmNombre2`, `AdmApellido1`, `AdmApellido2`, `AdmCelular`, `AdmCorreo`, `TblTipoIdenticacion_TipId`, `TblEstado_EstId`) VALUES
(1005934460, '12345', 'Julio', NULL, 'Ruiz', NULL, '3104123331', 'jcruiz064@misena.edu.co', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TblCliente`
--

CREATE TABLE `TblCliente` (
  `CliIdentificacion` int(11) NOT NULL,
  `CliContrasenia` varchar(200) NOT NULL,
  `CliNombre1` varchar(50) NOT NULL,
  `CliNombre2` varchar(50) DEFAULT NULL,
  `CliApellido1` varchar(50) NOT NULL,
  `CliApellido2` varchar(50) DEFAULT NULL,
  `CliCelular` varchar(50) DEFAULT NULL,
  `CliCorreo` varchar(50) DEFAULT NULL,
  `TblTipoIdenticacion_TipId` int(11) NOT NULL,
  `TblEstado_EstId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TblEstado`
--

CREATE TABLE `TblEstado` (
  `EstId` int(11) NOT NULL,
  `EstEstado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `TblEstado`
--

INSERT INTO `TblEstado` (`EstId`, `EstEstado`) VALUES
(1, 'activo'),
(2, 'inactivo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TblMetodoPago`
--

CREATE TABLE `TblMetodoPago` (
  `MetId` int(11) NOT NULL,
  `MetDescripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `TblMetodoPago`
--

INSERT INTO `TblMetodoPago` (`MetId`, `MetDescripcion`) VALUES
(1, 'efectivo'),
(2, 'tarjeta debito'),
(3, 'tarjeta credito');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TblPedido`
--

CREATE TABLE `TblPedido` (
  `PedId` int(11) NOT NULL,
  `PedFecha` date NOT NULL,
  `TblCliente_CliIdenficacion` int(11) NOT NULL,
  `TblMetodoPago_MetId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TblProducto`
--

CREATE TABLE `TblProducto` (
  `ProRef` int(11) NOT NULL,
  `ProNombre` varchar(50) NOT NULL,
  `ProPrecio` decimal(10,0) NOT NULL,
  `ProStock` int(11) NOT NULL,
  `ProFechaVencimiento` date NOT NULL,
  `TblTipoProducto_TipId` int(11) NOT NULL,
  `TblEstado_EstId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `TblProducto`
--

INSERT INTO `TblProducto` (`ProRef`, `ProNombre`, `ProPrecio`, `ProStock`, `ProFechaVencimiento`, `TblTipoProducto_TipId`, `TblEstado_EstId`) VALUES
(1, 'El burgues', '2300', 12, '2020-09-08', 10, 1),
(2, 'El cash', '2345', 20, '2020-09-18', 25, 1),
(3, 'Kione el de la money', '2300', 12, '2020-09-08', 10, 1),
(4, 'Papel de baño', '2345', 20, '2020-09-18', 25, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TblProductoPedido`
--

CREATE TABLE `TblProductoPedido` (
  `ProPedId` int(11) NOT NULL,
  `TblProducto_ProRef` int(11) NOT NULL,
  `TblPedido_PedId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TblTipoIdentificacion`
--

CREATE TABLE `TblTipoIdentificacion` (
  `TipId` int(11) NOT NULL,
  `TipNombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `TblTipoIdentificacion`
--

INSERT INTO `TblTipoIdentificacion` (`TipId`, `TipNombre`) VALUES
(1, 'cedula'),
(2, 'cedula extrangeria'),
(3, 'NIT');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TblTipoProducto`
--

CREATE TABLE `TblTipoProducto` (
  `TipProId` int(11) NOT NULL,
  `TipProNombre` varchar(50) NOT NULL,
  `TipProIva` decimal(10,0) NOT NULL,
  `TblEstado_EstId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `TblTipoProducto`
--

INSERT INTO `TblTipoProducto` (`TipProId`, `TipProNombre`, `TipProIva`, `TblEstado_EstId`) VALUES
(1, 'Papeleria', '12', 2),
(5, 'jhjhj', '12', 2),
(6, 'cateogria 2', '19', 1),
(7, 'jkjkjkjkhjhhj', '34', 2),
(8, 'jjj', '8', 2),
(9, 'klkjjjjjjlklkl', '12', 2),
(10, 'jkjkjk', '12', 2),
(11, 'jkhjk', '3', 2),
(12, 'hjhjjjjjhj', '23', 2),
(19, 'p', '99', 2),
(20, '8', '13', 2),
(21, 'klkll', '0', 2),
(22, 'kjkjkjk', '20', 2),
(23, 'hjjhjh', '2', 2),
(24, 'hghhggh', '1', 2),
(25, 'jhjhjhj', '3', 2),
(26, 'asfjj', '16', 2),
(27, 'pol', '1', 2),
(28, 'hjjhjj', '16', 2),
(29, 'Epa', '8', 2),
(30, 'Farmacia', '3', 2),
(31, 'lkkl', '2', 2),
(32, 'ghgh', '1', 2),
(33, 'hghg', '1', 2),
(44, 'Farmacias', '3', 1),
(45, 'bbv', '5', 2),
(48, 'hghgghhg', '1', 2),
(51, 'hjghghgh', '4', 1),
(52, 'ghghgh', '1', 2),
(53, 'categoria-3', '20', 1),
(54, 'jkfddfjfjk', '3', 1),
(55, 'klklklkl', '1', 1),
(56, 'periodico', '1', 1),
(57, 'jhhjhjhj', '2', 1),
(58, 'kdfjkdfjk', '1', 1),
(61, 'hjhhh', '3', 1),
(63, 'hkjkk', '6', 1),
(67, 'jjjjjjjj', '2', 1),
(70, 'llll', '2', 1),
(71, 'poooo', '2', 1),
(72, 'jjjkk', '1', 1),
(76, 'yuuuy', '3', 1),
(77, 'kk', '1', 1),
(78, 'jkljkljkl', '3', 1),
(79, 'kjkjjkkj', '2', 1),
(80, 'jhjhjh', '3', 1),
(81, 'hjjj', '3', 1),
(83, 'jjjjjjjjjjj', '2', 1),
(85, 'hhjj', '1', 1),
(86, 'jkljklkljkljkl', '1', 1),
(89, 'jkjk', '1', 1),
(91, 'ghghhg', '2', 1),
(95, 'jhj', '4', 1),
(96, 'jkkjjkjk', '2', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TblVendedor`
--

CREATE TABLE `TblVendedor` (
  `VenIdentificacion` int(11) NOT NULL,
  `VenContrasenia` int(200) NOT NULL,
  `VenNombre1` varchar(50) NOT NULL,
  `VenNombre2` varchar(50) DEFAULT NULL,
  `VenApellido1` varchar(50) NOT NULL,
  `VenApellido2` varchar(50) DEFAULT NULL,
  `VenCelular` varchar(50) DEFAULT NULL,
  `VenCorreo` varchar(50) DEFAULT NULL,
  `TblTipoIdenticacion_TIpId` int(11) NOT NULL,
  `TblEstado_EstId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `TblAdministrador`
--
ALTER TABLE `TblAdministrador`
  ADD PRIMARY KEY (`AdmIdentificacion`),
  ADD KEY `TblEstado_EstId` (`TblEstado_EstId`),
  ADD KEY `TblTipoIdenticacion_TipId` (`TblTipoIdenticacion_TipId`);

--
-- Indices de la tabla `TblCliente`
--
ALTER TABLE `TblCliente`
  ADD PRIMARY KEY (`CliIdentificacion`),
  ADD KEY `TblEstado_EstId` (`TblEstado_EstId`),
  ADD KEY `TblTipoIdenticacion_TipId` (`TblTipoIdenticacion_TipId`);

--
-- Indices de la tabla `TblEstado`
--
ALTER TABLE `TblEstado`
  ADD PRIMARY KEY (`EstId`);

--
-- Indices de la tabla `TblMetodoPago`
--
ALTER TABLE `TblMetodoPago`
  ADD PRIMARY KEY (`MetId`);

--
-- Indices de la tabla `TblPedido`
--
ALTER TABLE `TblPedido`
  ADD PRIMARY KEY (`PedId`),
  ADD KEY `TblMetodoPago_MetId` (`TblMetodoPago_MetId`);

--
-- Indices de la tabla `TblProducto`
--
ALTER TABLE `TblProducto`
  ADD PRIMARY KEY (`ProRef`),
  ADD UNIQUE KEY `ProNombre` (`ProNombre`),
  ADD KEY `TblTipoProducto_TipId` (`TblTipoProducto_TipId`),
  ADD KEY `TblEstado_EstId` (`TblEstado_EstId`);

--
-- Indices de la tabla `TblProductoPedido`
--
ALTER TABLE `TblProductoPedido`
  ADD PRIMARY KEY (`ProPedId`),
  ADD KEY `TblPedido_PedId` (`TblPedido_PedId`),
  ADD KEY `TblProducto_ProRef` (`TblProducto_ProRef`);

--
-- Indices de la tabla `TblTipoIdentificacion`
--
ALTER TABLE `TblTipoIdentificacion`
  ADD PRIMARY KEY (`TipId`);

--
-- Indices de la tabla `TblTipoProducto`
--
ALTER TABLE `TblTipoProducto`
  ADD PRIMARY KEY (`TipProId`),
  ADD UNIQUE KEY `TipProId` (`TipProId`),
  ADD UNIQUE KEY `TipProId_2` (`TipProId`),
  ADD UNIQUE KEY `TipProNombre` (`TipProNombre`),
  ADD KEY `TblEstado_EstId` (`TblEstado_EstId`);

--
-- Indices de la tabla `TblVendedor`
--
ALTER TABLE `TblVendedor`
  ADD PRIMARY KEY (`VenIdentificacion`),
  ADD KEY `TblEstado_EstId` (`TblEstado_EstId`),
  ADD KEY `TblTipoIdenticacion_TIpId` (`TblTipoIdenticacion_TIpId`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `TblAdministrador`
--
ALTER TABLE `TblAdministrador`
  MODIFY `AdmIdentificacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1005934461;
--
-- AUTO_INCREMENT de la tabla `TblCliente`
--
ALTER TABLE `TblCliente`
  MODIFY `CliIdentificacion` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `TblEstado`
--
ALTER TABLE `TblEstado`
  MODIFY `EstId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `TblMetodoPago`
--
ALTER TABLE `TblMetodoPago`
  MODIFY `MetId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `TblPedido`
--
ALTER TABLE `TblPedido`
  MODIFY `PedId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `TblProducto`
--
ALTER TABLE `TblProducto`
  MODIFY `ProRef` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `TblProductoPedido`
--
ALTER TABLE `TblProductoPedido`
  MODIFY `ProPedId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `TblTipoIdentificacion`
--
ALTER TABLE `TblTipoIdentificacion`
  MODIFY `TipId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `TblTipoProducto`
--
ALTER TABLE `TblTipoProducto`
  MODIFY `TipProId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=97;
--
-- AUTO_INCREMENT de la tabla `TblVendedor`
--
ALTER TABLE `TblVendedor`
  MODIFY `VenIdentificacion` int(11) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `TblAdministrador`
--
ALTER TABLE `TblAdministrador`
  ADD CONSTRAINT `TblAdministrador_ibfk_1` FOREIGN KEY (`TblEstado_EstId`) REFERENCES `TblEstado` (`EstId`),
  ADD CONSTRAINT `TblAdministrador_ibfk_2` FOREIGN KEY (`TblTipoIdenticacion_TipId`) REFERENCES `TblTipoIdentificacion` (`TipId`);

--
-- Filtros para la tabla `TblCliente`
--
ALTER TABLE `TblCliente`
  ADD CONSTRAINT `TblCliente_ibfk_1` FOREIGN KEY (`TblEstado_EstId`) REFERENCES `TblEstado` (`EstId`),
  ADD CONSTRAINT `TblCliente_ibfk_2` FOREIGN KEY (`TblTipoIdenticacion_TipId`) REFERENCES `TblTipoIdentificacion` (`TipId`);

--
-- Filtros para la tabla `TblPedido`
--
ALTER TABLE `TblPedido`
  ADD CONSTRAINT `TblPedido_ibfk_1` FOREIGN KEY (`TblMetodoPago_MetId`) REFERENCES `TblMetodoPago` (`MetId`);

--
-- Filtros para la tabla `TblProducto`
--
ALTER TABLE `TblProducto`
  ADD CONSTRAINT `TblProducto_ibfk_1` FOREIGN KEY (`TblTipoProducto_TipId`) REFERENCES `TblTipoProducto` (`TipProId`),
  ADD CONSTRAINT `TblProducto_ibfk_2` FOREIGN KEY (`TblEstado_EstId`) REFERENCES `TblEstado` (`EstId`);

--
-- Filtros para la tabla `TblProductoPedido`
--
ALTER TABLE `TblProductoPedido`
  ADD CONSTRAINT `TblProductoPedido_ibfk_1` FOREIGN KEY (`TblPedido_PedId`) REFERENCES `TblPedido` (`PedId`),
  ADD CONSTRAINT `TblProductoPedido_ibfk_2` FOREIGN KEY (`TblProducto_ProRef`) REFERENCES `TblProducto` (`ProRef`);

--
-- Filtros para la tabla `TblTipoProducto`
--
ALTER TABLE `TblTipoProducto`
  ADD CONSTRAINT `TblTipoProducto_ibfk_1` FOREIGN KEY (`TblEstado_EstId`) REFERENCES `TblEstado` (`EstId`);

--
-- Filtros para la tabla `TblVendedor`
--
ALTER TABLE `TblVendedor`
  ADD CONSTRAINT `TblVendedor_ibfk_1` FOREIGN KEY (`TblEstado_EstId`) REFERENCES `TblEstado` (`EstId`),
  ADD CONSTRAINT `TblVendedor_ibfk_2` FOREIGN KEY (`TblTipoIdenticacion_TIpId`) REFERENCES `TblTipoIdentificacion` (`TipId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

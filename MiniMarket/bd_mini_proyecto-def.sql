-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 23-10-2020 a las 18:16:55
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
CREATE DATABASE IF NOT EXISTS `bd_mini_proyecto` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bd_mini_proyecto`;

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
  `TblUsuario_UsuIdentificacion` int(11) NOT NULL,
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
(2, 'kEl cash', '23845', 270, '2020-09-01', 6, 2),
(3, 'Kione el de la money', '2300', 12, '2020-09-08', 10, 1),
(4, 'Papel de baño', '2345', 20, '2020-09-18', 25, 1),
(5, 'ooooplp', '35', 3, '2020-09-08', 1, 1),
(6, 'nice', '34', 3, '2020-09-08', 1, 1),
(8, 'plp', '35', 3, '2020-09-08', 1, 1),
(10, 'ooolllloplp', '35', 3, '2020-09-08', 1, 1),
(11, 'jggfj', '7778', 2, '2020-09-20', 54, 1),
(12, 'keyone', '300', 1, '2010-09-10', 56, 1),
(13, 'sfsdfsdf', '46', 1, '2020-10-19', 53, 1),
(14, 'Err', '1000', 2, '2020-10-05', 56, 1),
(15, 'jkjkjkjk', '90', 3, '2020-10-12', 51, 1),
(16, 'Exjkxjkxjk', '300', 3, '2020-10-20', 54, 1),
(17, 'xpxopxopop', '300', 3, '2020-10-15', 54, 1),
(18, 'klklklkl', '898989', 2, '2020-10-14', 54, 1),
(19, '8909898', '8998', 3, '2020-10-28', 54, 1),
(21, 'klklklkkkkkl', '9090', 2, '2020-10-14', 56, 1),
(22, 'kjklljkjkljkljklkljjkljkljkljkl', '56', 1, '2020-10-09', 57, 1);

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
-- Estructura de tabla para la tabla `TblRol`
--

CREATE TABLE `TblRol` (
  `RolId` int(11) NOT NULL,
  `RolNombre` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `TblRol`
--

INSERT INTO `TblRol` (`RolId`, `RolNombre`) VALUES
(1, 'administrador'),
(2, 'vendedor'),
(3, 'cliente');

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
(1, 'C.C'),
(2, 'C.T'),
(3, 'T.I');

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
(1, 'pollllllll', '30', 2),
(5, 'nonas', '34', 2),
(6, 'Epa.9', '34', 2),
(7, 'jkjkjkjkhjhhj', '34', 2),
(8, 'jjj', '8', 2),
(9, 'nomjjjkjkjk', '34', 2),
(10, 'ju,,,,,', '34', 2),
(11, 'jkhjk', '3', 2),
(12, 'kjjkjkjkjkjkkj', '34', 2),
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
(44, 'Farmacias', '3', 2),
(45, 'bbv', '5', 2),
(48, 'hghgghhg', '1', 2),
(51, 'hjghghgh', '4', 1),
(52, 'ghghgh', '1', 2),
(53, 'categoria-3', '20', 1),
(54, 'jkfddfjfjk', '3', 1),
(55, 'klklklkl', '1', 2),
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
(78, 'Julio Huummm', '13', 1),
(79, 'kjkjjkkj', '2', 1),
(80, 'jhjhjh', '3', 1),
(81, 'hjjj', '3', 1),
(83, 'jjjjjjjjjjj', '2', 1),
(85, 'hhjj', '1', 1),
(86, 'jkljklkljkljkl', '1', 1),
(89, 'jkjk', '1', 1),
(91, 'ghghhg', '2', 1),
(95, 'jhj', '4', 1),
(96, 'jkkjjkjk', '2', 1),
(97, 'julio', '3', 2),
(98, 'nask', '23', 1),
(99, 'kkkkkjknask', '23', 1),
(101, 'kkiuiukkkjknask', '23', 1),
(103, 'kkiullliukkkjknask', '23', 1),
(105, 'kkiulkjjkjklliukkkjknask', '23', 1),
(107, 'kkiulkjjknmmnmjklliukkkjknask', '23', 1),
(109, 'kkiulkjjkklklnmmnmjklliukkkjknask', '23', 1),
(110, 'kkiulkjjkkjkjkjklklnmmnmjklliukkkjknask', '23', 1),
(112, 'kkiulkjjkkjkjkklkljklklnmmnmjklliukkkjknask', '23', 1),
(114, 'kkiulkjjkkjkjkklklkkjklklnmmnmjklliukkkjknask', '23', 1),
(115, 'klllljkkjkjkklklkkjklklnmmnmjklliukkkjknask', '23', 1),
(116, 'klllljkkjkjkklklllkkjklklnmmnmjklliukkkjknask', '23', 1),
(118, 'jkjkkkkkjk', '4', 1),
(119, 'nonasssssss', '1', 1),
(121, 'lllllll', '3', 1),
(122, 'jmmmmmmmmmmmm', '4', 1),
(123, 'klklkl', '5', 1),
(125, 'klkllllkl', '3', 1),
(126, 'ppppppp', '1', 1),
(127, 'mklklklklklklklkl', '0', 1),
(128, 'klñklñklñ', '1', 1),
(129, ',m,m,m,m,m,m,m,', '2', 1),
(130, 'ggg', '6', 1),
(133, 'jjjhhh', '1', 1),
(134, 'hjhjhjhj', '1', 1),
(135, '898989', '1', 1),
(136, 'jkjkjkjkjk', '0', 1),
(137, 'opooioo', '2', 1),
(138, 'olololololo', '1', 1),
(139, 'sisas', '4', 1),
(140, 'depa', '5', 1),
(141, 'Jabones', '4', 1),
(143, 'Jlglgl', '5', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TblUsuario`
--

CREATE TABLE `TblUsuario` (
  `UsuIdentificacion` int(11) NOT NULL,
  `UsuContrasenia` varchar(200) NOT NULL,
  `UsuNombre1` varchar(50) NOT NULL,
  `UsuNombre2` varchar(50) DEFAULT NULL,
  `UsuApellido1` varchar(50) NOT NULL,
  `UsuApellido2` varchar(50) DEFAULT NULL,
  `UsuCelular` varchar(50) DEFAULT NULL,
  `UsuCorreo` varchar(50) DEFAULT NULL,
  `TblTipoIdentificacion_TipId` int(11) NOT NULL,
  `TblEstado_EstId` int(11) NOT NULL,
  `TblRol_RolId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `TblUsuario`
--

INSERT INTO `TblUsuario` (`UsuIdentificacion`, `UsuContrasenia`, `UsuNombre1`, `UsuNombre2`, `UsuApellido1`, `UsuApellido2`, `UsuCelular`, `UsuCorreo`, `TblTipoIdentificacion_TipId`, `TblEstado_EstId`, `TblRol_RolId`) VALUES
(1239494, '12345', 'Franklin', NULL, 'Quihuang', NULL, '3455659', NULL, 1, 1, 2),
(100593448, '12345', 'Julio', NULL, 'Ruiz', NULL, '3104123331', 'juliocrui@gmail.com', 1, 1, 1);

--
-- Índices para tablas volcadas
--

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
  ADD KEY `TblMetodoPago_MetId` (`TblMetodoPago_MetId`),
  ADD KEY `TblUsuario_UsuIdentificacion` (`TblUsuario_UsuIdentificacion`);

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
-- Indices de la tabla `TblRol`
--
ALTER TABLE `TblRol`
  ADD PRIMARY KEY (`RolId`);

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
-- Indices de la tabla `TblUsuario`
--
ALTER TABLE `TblUsuario`
  ADD PRIMARY KEY (`UsuIdentificacion`),
  ADD KEY `TblRol_RolId` (`TblRol_RolId`),
  ADD KEY `TblEstado_EstId` (`TblEstado_EstId`),
  ADD KEY `TblTipoIdentificacion_TipId` (`TblTipoIdentificacion_TipId`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

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
  MODIFY `ProRef` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT de la tabla `TblProductoPedido`
--
ALTER TABLE `TblProductoPedido`
  MODIFY `ProPedId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `TblRol`
--
ALTER TABLE `TblRol`
  MODIFY `RolId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `TblTipoIdentificacion`
--
ALTER TABLE `TblTipoIdentificacion`
  MODIFY `TipId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `TblTipoProducto`
--
ALTER TABLE `TblTipoProducto`
  MODIFY `TipProId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=144;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `TblPedido`
--
ALTER TABLE `TblPedido`
  ADD CONSTRAINT `TblPedido_ibfk_1` FOREIGN KEY (`TblMetodoPago_MetId`) REFERENCES `TblMetodoPago` (`MetId`),
  ADD CONSTRAINT `TblPedido_ibfk_2` FOREIGN KEY (`TblUsuario_UsuIdentificacion`) REFERENCES `TblUsuario` (`UsuIdentificacion`);

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
-- Filtros para la tabla `TblUsuario`
--
ALTER TABLE `TblUsuario`
  ADD CONSTRAINT `TblUsuario_ibfk_1` FOREIGN KEY (`TblRol_RolId`) REFERENCES `TblRol` (`RolId`),
  ADD CONSTRAINT `TblUsuario_ibfk_2` FOREIGN KEY (`TblEstado_EstId`) REFERENCES `TblEstado` (`EstId`),
  ADD CONSTRAINT `TblUsuario_ibfk_3` FOREIGN KEY (`TblTipoIdentificacion_TipId`) REFERENCES `TblTipoIdentificacion` (`TipId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

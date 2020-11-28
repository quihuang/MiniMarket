-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-11-2020 a las 01:08:26
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
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
-- Estructura de tabla para la tabla `tblestado`
--

CREATE TABLE `tblestado` (
  `EstId` int(11) NOT NULL,
  `EstEstado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tblestado`
--

INSERT INTO `tblestado` (`EstId`, `EstEstado`) VALUES
(1, 'activo'),
(2, 'inactivo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblmetodopago`
--

CREATE TABLE `tblmetodopago` (
  `MetId` int(11) NOT NULL,
  `MetDescripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tblmetodopago`
--

INSERT INTO `tblmetodopago` (`MetId`, `MetDescripcion`) VALUES
(1, 'efectivo'),
(2, 'tarjeta debito'),
(3, 'tarjeta credito');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblpedido`
--

CREATE TABLE `tblpedido` (
  `PedId` int(11) NOT NULL,
  `PedFecha` date NOT NULL,
  `TblUsuario_UsuIdentificacion` int(11) NOT NULL,
  `TblMetodoPago_MetId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tblpedido`
--

INSERT INTO `tblpedido` (`PedId`, `PedFecha`, `TblUsuario_UsuIdentificacion`, `TblMetodoPago_MetId`) VALUES
(1, '2020-11-03', 1144213155, 1),
(3, '2020-11-03', 1144213155, 2),
(4, '2020-11-03', 1144213155, 1),
(5, '2020-11-03', 1144213155, 1),
(6, '2020-11-05', 1144213155, 1),
(7, '2020-11-05', 1144213155, 1),
(8, '2020-11-05', 1144213155, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblproducto`
--

CREATE TABLE `tblproducto` (
  `ProRef` int(11) NOT NULL,
  `ProNombre` varchar(50) NOT NULL,
  `ProPrecio` decimal(10,0) NOT NULL,
  `ProStock` int(11) NOT NULL,
  `ProFechaVencimiento` date NOT NULL,
  `TblTipoProducto_TipId` int(11) NOT NULL,
  `TblEstado_EstId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tblproducto`
--

INSERT INTO `tblproducto` (`ProRef`, `ProNombre`, `ProPrecio`, `ProStock`, `ProFechaVencimiento`, `TblTipoProducto_TipId`, `TblEstado_EstId`) VALUES
(1, 'Arroz Diana', '1200', 50, '2021-03-18', 2, 1),
(2, 'Aceite Mediano', '12500', 27, '2021-03-25', 2, 1),
(3, 'Atún VanCamps 240 gr', '14050', 21, '2022-03-14', 2, 1),
(4, 'Harina de maíz 1000 gr', '3550', 47, '2022-06-17', 2, 1),
(5, 'Galletas Saltín x6 tacos', '5300', 30, '2021-06-16', 2, 1),
(6, 'Chocolate Corona 500gr', '5950', 15, '2020-11-18', 2, 1),
(7, 'Frijol Bola roja 1000 gr', '8500', 6, '2020-12-17', 2, 1),
(8, 'Garbanzo', '2800', 32, '2021-12-14', 2, 1),
(9, 'Lenteja', '2650', 25, '2021-09-06', 2, 1),
(10, 'Pasta Rigate Monticello ', '5600', 31, '2021-08-10', 2, 1),
(11, 'Avena en Hojuelas 960g', '8450', 40, '2021-07-19', 2, 1),
(12, 'Vinagre Blanco', '2050', 17, '2021-06-16', 2, 1),
(13, 'Pasta de tomate 250g', '4150', 24, '2021-06-17', 2, 1),
(14, 'Carton Paja 1/8', '400', 29, '2050-07-17', 1, 1),
(15, 'Cartulina 180g 1/8', '350', 25, '2050-07-17', 1, 1),
(16, 'Borrador Rapid Br-20', '400', 44, '2050-07-17', 1, 1),
(17, 'Borrador de Nata x2', '2300', 45, '2050-07-17', 1, 1),
(18, 'Resma Papel Carta', '9900', 30, '2050-07-17', 1, 1),
(19, 'Carpeta Legajadora Oficio', '3500', 15, '2050-07-17', 1, 1),
(20, 'Transportador 360°', '2100', 23, '2050-07-17', 1, 1),
(21, 'Compas de Precision', '7550', 15, '2050-07-17', 1, 1),
(22, 'Cuaderno Cosido 50 Hojas', '6600', 29, '2050-07-17', 1, 1),
(23, 'Tempera Pelikan x6', '8900', 7, '2050-07-17', 1, 1),
(24, 'Pegante Colbon x225Gr', '7200', 14, '2050-07-17', 1, 1),
(25, 'Alcohol JGB x120ml', '1400', 24, '2042-07-16', 3, 1),
(26, 'Alcohol JGB x700ml', '4800', 22, '2042-07-15', 3, 1),
(27, 'Dolex Adulto x24 ', '20550', 18, '2042-12-13', 3, 1),
(28, 'Condon Today', '18750', 20, '2042-12-12', 3, 1),
(29, 'Distán Tripe Acción NF', '9200', 28, '2042-12-13', 3, 1),
(30, 'Yodopavidona MK', '9750', 18, '2042-12-14', 3, 1),
(31, 'Curitas JGB x10', '1350', 32, '2043-01-14', 3, 1),
(32, 'Ensoy Lata x1000g', '98900', 21, '2023-02-15', 3, 1),
(33, 'Bonfiest Plus Caja x32', '77700', 14, '2023-03-07', 3, 1),
(34, 'Glucerna Polvo x400g', '46750', 23, '2023-03-21', 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblproductopedido`
--

CREATE TABLE `tblproductopedido` (
  `ProPedId` int(11) NOT NULL,
  `ProPedCantidad` int(11) NOT NULL,
  `TblProducto_ProRef` int(11) NOT NULL,
  `TblPedido_PedId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tblproductopedido`
--

INSERT INTO `tblproductopedido` (`ProPedId`, `ProPedCantidad`, `TblProducto_ProRef`, `TblPedido_PedId`) VALUES
(1, 7, 14, 6),
(2, 2, 15, 7),
(3, 1, 20, 7),
(4, 1, 3, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblrol`
--

CREATE TABLE `tblrol` (
  `RolId` int(11) NOT NULL,
  `RolNombre` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tblrol`
--

INSERT INTO `tblrol` (`RolId`, `RolNombre`) VALUES
(1, 'administrador'),
(2, 'vendedor'),
(3, 'cliente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbltipoidentificacion`
--

CREATE TABLE `tbltipoidentificacion` (
  `TipId` int(11) NOT NULL,
  `TipNombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tbltipoidentificacion`
--

INSERT INTO `tbltipoidentificacion` (`TipId`, `TipNombre`) VALUES
(1, 'C.C'),
(2, 'C.T'),
(3, 'T.I');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbltipoproducto`
--

CREATE TABLE `tbltipoproducto` (
  `TipProId` int(11) NOT NULL,
  `TipProNombre` varchar(50) NOT NULL,
  `TipProIva` decimal(10,0) NOT NULL,
  `TblEstado_EstId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tbltipoproducto`
--

INSERT INTO `tbltipoproducto` (`TipProId`, `TipProNombre`, `TipProIva`, `TblEstado_EstId`) VALUES
(1, 'Papeleria', '16', 1),
(2, 'SuperMercado', '4', 1),
(3, 'Drogueria', '12', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblusuario`
--

CREATE TABLE `tblusuario` (
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
  `TblRol_RolId` int(11) NOT NULL,
  `create_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tblusuario`
--

INSERT INTO `tblusuario` (`UsuIdentificacion`, `UsuContrasenia`, `UsuNombre1`, `UsuNombre2`, `UsuApellido1`, `UsuApellido2`, `UsuCelular`, `UsuCorreo`, `TblTipoIdentificacion_TipId`, `TblEstado_EstId`, `TblRol_RolId`, `create_at`) VALUES
(12345678, '827ccb0eea8a706c4c34a16891f84e7b', 'Jose', 'Freddy', 'Caicedo', 'Tenorio', '3205443265', 'joseTenorio@misena.edu.co', 1, 1, 1, '2020-11-04 00:34:38'),
(153621110, '827ccb0eea8a706c4c34a16891f84e7b', 'Paco ', 'Emilio', 'Zapata', NULL, '3104123331', 'zapataEmilio564@gmail.com', 1, 1, 2, '2020-11-06 00:06:37'),
(1005934460, '827ccb0eea8a706c4c34a16891f84e7b', 'Julio', NULL, 'Ruiz', NULL, '3104123331', 'juliocrui@gmail.com', 1, 1, 1, '2020-11-06 00:02:52'),
(1006015905, 'a446fa0d255397f579b2c8d99a84f9d1', 'Andres', 'Felipe', 'Jaimes', 'Diaz', '3016990885', 'andresfelipejaimesdias@gmail.com', 1, 1, 3, '2020-11-03 15:10:03'),
(1144213155, '827ccb0eea8a706c4c34a16891f84e7b', 'Franklin', 'German', 'Quihuang', 'Garzón', '3205282231', 'quihuang2017@gmail.com', 1, 1, 1, '2020-11-03 14:13:38');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tblestado`
--
ALTER TABLE `tblestado`
  ADD PRIMARY KEY (`EstId`);

--
-- Indices de la tabla `tblmetodopago`
--
ALTER TABLE `tblmetodopago`
  ADD PRIMARY KEY (`MetId`);

--
-- Indices de la tabla `tblpedido`
--
ALTER TABLE `tblpedido`
  ADD PRIMARY KEY (`PedId`),
  ADD KEY `TblMetodoPago_MetId` (`TblMetodoPago_MetId`),
  ADD KEY `TblUsuario_UsuIdentificacion` (`TblUsuario_UsuIdentificacion`);

--
-- Indices de la tabla `tblproducto`
--
ALTER TABLE `tblproducto`
  ADD PRIMARY KEY (`ProRef`),
  ADD UNIQUE KEY `ProNombre` (`ProNombre`),
  ADD KEY `TblTipoProducto_TipId` (`TblTipoProducto_TipId`),
  ADD KEY `TblEstado_EstId` (`TblEstado_EstId`);

--
-- Indices de la tabla `tblproductopedido`
--
ALTER TABLE `tblproductopedido`
  ADD PRIMARY KEY (`ProPedId`),
  ADD KEY `TblPedido_PedId` (`TblPedido_PedId`),
  ADD KEY `TblProducto_ProRef` (`TblProducto_ProRef`);

--
-- Indices de la tabla `tblrol`
--
ALTER TABLE `tblrol`
  ADD PRIMARY KEY (`RolId`);

--
-- Indices de la tabla `tbltipoidentificacion`
--
ALTER TABLE `tbltipoidentificacion`
  ADD PRIMARY KEY (`TipId`);

--
-- Indices de la tabla `tbltipoproducto`
--
ALTER TABLE `tbltipoproducto`
  ADD PRIMARY KEY (`TipProId`),
  ADD UNIQUE KEY `TipProId` (`TipProId`),
  ADD UNIQUE KEY `TipProId_2` (`TipProId`),
  ADD UNIQUE KEY `TipProNombre` (`TipProNombre`),
  ADD KEY `TblEstado_EstId` (`TblEstado_EstId`);

--
-- Indices de la tabla `tblusuario`
--
ALTER TABLE `tblusuario`
  ADD PRIMARY KEY (`UsuIdentificacion`),
  ADD KEY `TblRol_RolId` (`TblRol_RolId`),
  ADD KEY `TblEstado_EstId` (`TblEstado_EstId`),
  ADD KEY `TblTipoIdentificacion_TipId` (`TblTipoIdentificacion_TipId`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tblestado`
--
ALTER TABLE `tblestado`
  MODIFY `EstId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tblmetodopago`
--
ALTER TABLE `tblmetodopago`
  MODIFY `MetId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tblpedido`
--
ALTER TABLE `tblpedido`
  MODIFY `PedId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `tblproducto`
--
ALTER TABLE `tblproducto`
  MODIFY `ProRef` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de la tabla `tblproductopedido`
--
ALTER TABLE `tblproductopedido`
  MODIFY `ProPedId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tblrol`
--
ALTER TABLE `tblrol`
  MODIFY `RolId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tbltipoidentificacion`
--
ALTER TABLE `tbltipoidentificacion`
  MODIFY `TipId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tbltipoproducto`
--
ALTER TABLE `tbltipoproducto`
  MODIFY `TipProId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tblpedido`
--
ALTER TABLE `tblpedido`
  ADD CONSTRAINT `TblPedido_ibfk_1` FOREIGN KEY (`TblMetodoPago_MetId`) REFERENCES `tblmetodopago` (`MetId`),
  ADD CONSTRAINT `TblPedido_ibfk_2` FOREIGN KEY (`TblUsuario_UsuIdentificacion`) REFERENCES `tblusuario` (`UsuIdentificacion`);

--
-- Filtros para la tabla `tblproducto`
--
ALTER TABLE `tblproducto`
  ADD CONSTRAINT `TblProducto_ibfk_1` FOREIGN KEY (`TblTipoProducto_TipId`) REFERENCES `tbltipoproducto` (`TipProId`),
  ADD CONSTRAINT `TblProducto_ibfk_2` FOREIGN KEY (`TblEstado_EstId`) REFERENCES `tblestado` (`EstId`);

--
-- Filtros para la tabla `tblproductopedido`
--
ALTER TABLE `tblproductopedido`
  ADD CONSTRAINT `TblProductoPedido_ibfk_1` FOREIGN KEY (`TblPedido_PedId`) REFERENCES `tblpedido` (`PedId`),
  ADD CONSTRAINT `TblProductoPedido_ibfk_2` FOREIGN KEY (`TblProducto_ProRef`) REFERENCES `tblproducto` (`ProRef`);

--
-- Filtros para la tabla `tbltipoproducto`
--
ALTER TABLE `tbltipoproducto`
  ADD CONSTRAINT `TblTipoProducto_ibfk_1` FOREIGN KEY (`TblEstado_EstId`) REFERENCES `tblestado` (`EstId`);

--
-- Filtros para la tabla `tblusuario`
--
ALTER TABLE `tblusuario`
  ADD CONSTRAINT `TblUsuario_ibfk_1` FOREIGN KEY (`TblRol_RolId`) REFERENCES `tblrol` (`RolId`),
  ADD CONSTRAINT `TblUsuario_ibfk_2` FOREIGN KEY (`TblEstado_EstId`) REFERENCES `tblestado` (`EstId`),
  ADD CONSTRAINT `TblUsuario_ibfk_3` FOREIGN KEY (`TblTipoIdentificacion_TipId`) REFERENCES `tbltipoidentificacion` (`TipId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-11-2020 a las 22:36:06
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
(8, '2020-11-05', 1144213155, 2),
(9, '2020-11-07', 12345678, 1),
(10, '2020-11-09', 1005934460, 1),
(11, '2020-11-09', 153621110, 1),
(12, '2020-11-10', 153621110, 1),
(13, '2020-11-10', 123456789, 1),
(14, '2020-11-11', 1006015905, 1),
(15, '2020-11-11', 1005934460, 1),
(16, '2020-11-11', 12345678, 1),
(17, '2020-11-11', -1, 1),
(18, '2020-11-11', 1144213155, 1),
(19, '2020-11-11', -1, 1),
(20, '2020-11-11', 66808379, 3),
(21, '2020-11-11', -1, 1),
(22, '2020-11-11', 1006015905, 1),
(23, '2020-11-12', 66808379, 1),
(24, '2020-11-12', 12345678, 2),
(25, '2020-11-12', -1, 1),
(26, '2020-11-12', 12345678, 1),
(27, '2020-11-12', 1006015905, 1),
(28, '2020-11-19', -1, 2),
(29, '2020-11-19', 12345678, 1),
(30, '2020-11-19', 66808379, 1),
(31, '2020-11-19', 1006015905, 1);

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
(1, 'Arroz Diana', '1298', 34, '2021-03-18', 2, 1),
(2, 'Aceite Mediano', '13000', 24, '2021-03-25', 2, 1),
(3, 'Atún VanCamps 240 gr', '15196', 15, '2022-03-14', 2, 1),
(4, 'Harina de maíz 1000 gr', '3550', 47, '2022-06-17', 2, 1),
(5, 'Galletas Saltín x6 tacos', '5512', 25, '2021-06-16', 2, 1),
(6, 'Chocolate Corona 500gr', '5200', 13, '2020-11-18', 2, 1),
(7, 'Frijol Bola roja 1000 gr', '9194', 0, '2020-12-17', 2, 1),
(8, 'Garbanzo', '3028', 26, '2021-12-14', 2, 1),
(9, 'Lenteja', '2981', 15, '2021-09-06', 2, 1),
(10, 'Pasta Rigate Monticello ', '5600', 31, '2021-08-10', 2, 1),
(11, 'Avena en Hojuelas 960g', '8788', 0, '2021-07-19', 2, 1),
(12, 'Vinagre Blanco', '2132', 16, '2021-06-16', 2, 1),
(13, 'Pasta de tomate 250g', '4150', 24, '2021-06-17', 2, 1),
(14, 'Carton Paja 1/8', '390', 37, '2050-07-17', 1, 2),
(15, 'Cartulina 180g 1/8', '624', 16, '2050-07-17', 1, 1),
(16, 'Borrador Rapid Br-20', '400', 44, '2050-07-17', 1, 1),
(17, 'Borrador de Nata x2', '2668', 11, '2050-07-17', 1, 1),
(18, 'Resma Papel Carta', '13321', 26, '2050-07-17', 1, 1),
(19, 'Carpeta Legajadora Oficio', '3500', 15, '2050-07-17', 1, 1),
(20, 'Transportador 360°', '2100', 23, '2050-07-17', 1, 1),
(21, 'Compas de Precision', '7550', 15, '2050-07-17', 1, 1),
(22, 'Cuaderno Cosido 50 Hojas', '7656', 10, '2050-07-17', 1, 1),
(23, 'Tempera Pelikan x6', '11976', 0, '2050-07-17', 1, 1),
(24, 'Pegante Colbon x225Gr', '8352', 13, '2050-07-17', 1, 1),
(25, 'Alcohol JGB x120ml', '1967', 13, '2042-07-16', 3, 1),
(26, 'Alcohol JGB x700ml', '4800', 21, '2042-07-15', 3, 1),
(27, 'Dolex Adulto x24 ', '25778', 15, '2042-12-13', 3, 1),
(28, 'Condon Today', '21000', 15, '2042-12-12', 3, 1),
(29, 'Distán Tripe Acción NF', '10304', 12, '2042-12-13', 3, 1),
(30, 'Yodopavidona MK', '10920', 12, '2042-12-14', 3, 1),
(31, 'Curitas JGB x10', '1350', 31, '2043-01-14', 3, 1),
(32, 'Ensoy Lata x1000g', '110768', 20, '2023-02-15', 3, 1),
(33, 'Bonfiest Plus Caja x32', '77700', 14, '2023-03-07', 3, 1),
(34, 'Glucerna Polvo x400g', '52360', 22, '2023-03-21', 3, 1),
(35, 'Harina Pan', '2184', 17, '2020-12-09', 2, 1),
(38, 'Miel de Mafle', '6049', 30, '2021-08-03', 2, 1),
(39, 'Chocolate Diana', '5200', 36, '2020-12-17', 2, 2),
(40, 'Panela', '1500', 33, '2020-12-10', 2, 1);

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
(4, 1, 3, 8),
(5, 3, 22, 9),
(6, 5, 9, 10),
(7, 6, 29, 10),
(8, 2, 6, 10),
(9, 1, 26, 11),
(10, 1, 28, 11),
(11, 1, 31, 11),
(12, 1, 27, 11),
(13, 1, 22, 11),
(14, 5, 1, 12),
(15, 15, 22, 13),
(16, 3, 2, 13),
(17, 4, 28, 13),
(18, 1, 23, 13),
(19, 3, 18, 13),
(20, 1, 34, 13),
(21, 1, 32, 13),
(22, 6, 30, 13),
(23, 1, 11, 14),
(24, 1, 12, 15),
(25, 1, 25, 15),
(26, 1, 9, 15),
(27, 5, 3, 16),
(28, 4, 15, 17),
(29, 1, 15, 18),
(30, 3, 15, 19),
(31, 1, 27, 19),
(32, 1, 24, 19),
(33, 3, 8, 19),
(34, 8, 35, 19),
(35, 5, 5, 19),
(36, 3, 7, 20),
(37, 3, 8, 20),
(38, 4, 9, 20),
(39, 11, 1, 20),
(40, 6, 25, 21),
(41, 1, 16, 22),
(42, 1, 14, 22),
(43, 1, 15, 22),
(44, 1, 18, 23),
(45, 34, 17, 24),
(46, 7, 38, 24),
(47, 10, 29, 24),
(48, 6, 23, 25),
(49, 3, 9, 26),
(50, 3, 7, 26),
(51, 1, 8, 27),
(52, 1, 15, 28),
(53, 3, 7, 28),
(54, 1, 3, 28),
(55, 1, 38, 28),
(56, 1, 27, 28),
(57, 4, 25, 28),
(58, 40, 11, 29),
(59, 7, 15, 30),
(60, 1, 15, 31),
(61, 8, 16, 31),
(62, 1, 17, 31),
(63, 1, 18, 31),
(64, 15, 19, 31),
(65, 1, 20, 31),
(66, 6, 21, 31),
(67, 6, 22, 31),
(68, 1, 24, 31),
(69, 5, 1, 31);

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
(3, 'Drogueria', '12', 1),
(5, 'Ropa x', '36', 2),
(6, 'Ropasss232', '11', 2);

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
(-1, 'c4ca4238a0b923820dcc509a6f75849b', 'Cliente sin ', '', 'Registrar', '', '', '', 1, 1, 3, '2020-11-11 19:57:38'),
(12345678, '827ccb0eea8a706c4c34a16891f84e7b', 'Jose', 'Freddy', 'Caicedo', 'Tenorio', '3205443265', 'joseTenorio@misena.edu.co', 1, 1, 1, '2020-11-12 04:16:44'),
(14687896, 'c4ca4238a0b923820dcc509a6f75849b', 'Miguel', '', 'Rodriguez', '', '', '', 1, 1, 3, '2020-11-12 04:15:49'),
(65987741, '827ccb0eea8a706c4c34a16891f84e7b', 'Camilo', 'xd', 'Caraballi', '', '3205282231', 'aassad@gmail.com', 1, 2, 2, '2020-11-19 19:32:31'),
(66808379, '827ccb0eea8a706c4c34a16891f84e7b', 'Nidia', '', 'Garzón', 'Morales', '3168941932', 'nidiaGarz@gmail.com', 1, 1, 3, '2020-11-12 03:26:09'),
(94417272, '827ccb0eea8a706c4c34a16891f84e7b', 'Felix', 'Humberto', 'Jimenez', '', '3145857412', 'humbertoJ@hotmail.com', 1, 1, 2, '2020-11-12 20:06:37'),
(123456789, '827ccb0eea8a706c4c34a16891f84e7b', 'Kevin', 'Alexander', 'Garcia', '', '314523654', 'nivek12@gmail.com', 1, 1, 3, '2020-11-11 16:45:44'),
(142365954, '827ccb0eea8a706c4c34a16891f84e7b', 'Luis', '', 'Orjuela', '', '', '', 2, 2, 3, '2020-11-12 03:27:06'),
(153621110, '827ccb0eea8a706c4c34a16891f84e7b', 'Paco', 'Emilio', 'Zapata', NULL, '3104123331', 'zapataEmilio564@gmail.com', 1, 1, 2, '2020-11-09 16:50:23'),
(321654478, '827ccb0eea8a706c4c34a16891f84e7b', 'Diana', 'Andrea', 'Medina', 'Zamora', '3654412536', 'sASs@gmail.com', 1, 2, 1, '2020-11-13 00:09:36'),
(789456125, '827ccb0eea8a706c4c34a16891f84e7b', 'Andrea', 'ADASA', 'Castillo', 'SDASDSD', '2313312323', '', 1, 1, 3, '2020-11-19 19:47:49'),
(987654321, '827ccb0eea8a706c4c34a16891f84e7b', 'Angel', '', 'Dominguez', '', '', '', 1, 1, 3, '2020-11-12 20:04:56'),
(1005934460, '827ccb0eea8a706c4c34a16891f84e7b', 'Julio', '', 'Ruiz', '', '3104123331', 'juliocruizt@gmail.com', 1, 1, 1, '2020-11-10 19:32:33'),
(1006015905, 'a446fa0d255397f579b2c8d99a84f9d1', 'Andres', 'Felipe', 'Jaimes', 'Diaz', '3016990885', 'andresfelipejaimesdias@gmail.com', 1, 1, 3, '2020-11-03 15:10:03'),
(1144213155, '827ccb0eea8a706c4c34a16891f84e7b', 'Franklin', 'German', 'Quihuang', 'Garzón', '3205282231', 'quihuang2017@gmail.com', 1, 1, 1, '2020-11-13 00:27:24');

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
  MODIFY `PedId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT de la tabla `tblproducto`
--
ALTER TABLE `tblproducto`
  MODIFY `ProRef` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT de la tabla `tblproductopedido`
--
ALTER TABLE `tblproductopedido`
  MODIFY `ProPedId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

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
  MODIFY `TipProId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

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
